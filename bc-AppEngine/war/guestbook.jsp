<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.google.appengine.api.users.User"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ page import="com.google.appengine.api.datastore.DatastoreService" %>
<%@ page import="com.google.appengine.api.datastore.DatastoreServiceFactory" %>
<%@ page import="com.google.appengine.api.datastore.Key" %>
<%@ page import="com.google.appengine.api.datastore.KeyFactory" %>
<%@ page import="com.google.appengine.api.datastore.Query" %>
<%@ page import="com.google.appengine.api.datastore.Entity" %>
<%@ page import="com.google.appengine.api.datastore.FetchOptions" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link type="text/css" rel="stylesheet" href="/css/style.css" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script language="JavaScript" type="text/javascript" src="js/guestbook.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Guestbook</title>
</head>
<body>
<%
String guestbookName = request.getParameter("guestbookName");
UserService userService = UserServiceFactory.getUserService();
User user = userService.getCurrentUser();

if (guestbookName == null){	guestbookName = "default";}
if (user != null){pageContext.setAttribute("user", user);}

pageContext.setAttribute("guestbookName", guestbookName);
%>

<script> var guestbName = "${guestbookName}"</script>
  
<div id="wrapper">


<form action="/sign" method="post" id="my_form">
<%
if (user != null) 
{%>
    <h1>Hello, ${fn:escapeXml(user.nickname)}!</h1>
<%}
else 
{%>
    <p>Please <a href="<%= userService.createLoginURL(request.getRequestURI()) %>">Sign in<a/> to leave a message in the GuestBook.</p>
<%}%>

<div id="main" style="display:inline-block;">
    <% if (user != null) 
    {   %>
        
        <div class="greetingNew">Leave a Message
            <textarea name="content" rows="3" cols="30" id="the_greeting"></textarea><br />
            <input type="submit" value="OK" />
            <input type="hidden" name="guestbookName" value="${fn:escapeXml(guestbookName)}"/>
        </div>
  <%}
    else
    {%>
    	<div id="dialog" title="Basic dialog">
    	  <p>This is the default dialog which is useful for displaying information. The dialog window can be moved, resized and closed with the 'x' icon.</p>
    	</div>
    <%}%>
</div>

<div id="greetings">
<%
DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
Key guestbookKey = KeyFactory.createKey("Guestbook", guestbookName);
Query query = new Query("Greeting", guestbookKey).addSort("date", Query.SortDirection.DESCENDING);
List <Entity> greetings = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(5));

if (greetings.isEmpty())
{%>
    <p>Guestbook '${fn:escapeXml(guestbookName)}' has no messages.</p><%
} 
else 
{%>
    Past Greetings<%
    for (Entity greeting : greetings) 
    {%>
    	<div class="greeting"><%
    	pageContext.setAttribute("greeting_content",greeting.getProperty("content"));
    	pageContext.setAttribute("greeting_user",greeting.getProperty("user"));%>
    	   <b>${fn:escapeXml(greeting_user.nickname)}</b>:${fn:escapeXml(greeting_content)}
        </div><%
    }
}%>
</div>
<div id='querydetails' />
</form>
        
<!-- Results will be placed into the following container. -->
<div id="results" />
<div id="footer" >
    <% if (user != null) 
    {%>
        You can <a href="<%= userService.createLogoutURL(request.getRequestURI()) %>">Sign out<a/>
    <%}%>
</div>
</div>
    </body>
</html>