<%@page isELIgnored="false" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

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

<%
String guestbookName = request.getParameter("guestbookName");
if (guestbookName == null){ guestbookName = "default";}

Key guestbookKey = KeyFactory.createKey("Guestbook", guestbookName);
pageContext.setAttribute("guestbookName", guestbookName);

DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
Query query = new Query("Greeting", guestbookKey).addSort("date", Query.SortDirection.DESCENDING);
List <Entity> greetings = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(5));

User greeting_user = null;
String content = "";
String result = "";

for (Entity greeting : greetings) 
{
    content = (String)greeting.getProperty("content");
    greeting_user = (User)greeting.getProperty("user");
    result = result + "<div class=greeting><b>" + greeting_user.getNickname() + "</b>: <br />" + content + "</div>";
}

pageContext.setAttribute("greetings", result);
%>

<t:genericpage>
<jsp:body>
        
<section class="grid-wrap" >
	<aside class="grid col-one-quarter mq2-col-one-third mq3-col-full">
	    <address class="mbottom"><h5>Basket Case Inc.</h5>123 Erick St. <br />Boston, MA<br /><a href="http://maps.google.com">Get directions</a></address>
	    <p class="mbottom">617 909 0909<br />781 606 0825</p>
	    <p class="mbottom"><a href="#">admin@basketcase.com</a><br /><a href="#">Basket Case on Facebook</a><br /><a href="#">@basketcase on Twitter</a><br /></p>
	    <br /><h6>Business hours: </h6>Monday to Friday<br />9-5 EST
	</aside>
        
    <section class="grid col-one-half mq2-col-one-third mq3-col-full">
<c:choose><c:when test="${user != null}">
            <h4>Sign the Guest book</h4>
            <form action="/sign" method="post" id="my_form">
                <ul>
                    <li><label for="name">Your name:</label><input type="text" name="name" id="name" required class="required" value="${user.nickname}" ></li>
                    <li><label for="email">Email:</label><input type="email" name="email" id="email" required value="${user.email}" class="required email"></li>
                    <li><label for="message">Message:</label><textarea name="message" id="message" cols="30" rows="6" required  class="required" ></textarea></li>
                    <li><button type="submit" id="submit" name="submit" class="button fright">Send it</button></li>
                </ul>
<input type="hidden" name="nickname" id="nickname" value="${user.nickname}">
<input type="hidden" name="email2" id="email2" value="${user.email}">
<input type="hidden" name="domain" id="domain" value="${user.authDomain}">
<input type="hidden" name="federatedIdentity" id="federatedIdentity" value="${user.federatedIdentity}">
<input type="hidden" name="userId" id="userId" value="${user.userId}">
            </form>
</c:when><c:otherwise><h4>Please sign in to leave a message</h4></c:otherwise>
</c:choose>

</section>
        <section class="grid col-one-quarter mq2-col-one-third mq3-col-full"><h5>Past Greetings</h5><br />${greetings}</section></section>
        </jsp:body>
</t:genericpage>