<%@tag description="Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Basket Case</title>
<meta name="description"
	content="Basket Case Inc., a HTML5 / CSS3 / JSP2 / Google App Engine playground.">
<meta name="author" content="Jeremiah Bopko">
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico">
<link rel="shortcut icon" type="image/png" href="favicon.png">
<meta name="viewport" content="width=device-width">
<link type="text/css" rel="stylesheet" href="/css/style.css" />
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,400,700'
	rel='stylesheet' type='text/css' />
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript" src="js/scripts.js"></script>
<%
	com.google.appengine.api.users.UserService userService = com.google.appengine.api.users.UserServiceFactory
			.getUserService();
	com.google.appengine.api.users.User user = userService
			.getCurrentUser();
	if (user != null) {
		request.setAttribute("user", user);
	}
	request.setAttribute("loginUri",
			userService.createLoginURL(request.getRequestURI()));
	request.setAttribute("logoutUri",
			userService.createLogoutURL(request.getRequestURI()));
%>
</head>
<body>
	<div class="container">
		<header id="navtop">
			<a href="index.jsp" class="logo fleft"><img
				src="img/logo.png" alt="BasketCase Inc."></a>
			<nav class="fright">
				<ul>
					<li><a href="index.jsp" class="navactive">Home</a></li>
					<c:choose>
						<c:when test="${user != null}">
							<li><a href="${logoutUri}">Logout</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${loginUri}">Sign In</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
				<ul>
					<li><a href="works.html">Works</a></li>
					<li><a href="blog.html">Blog</a></li>
				</ul>
				<ul>
					<li><a href="contact.html">Contact</a></li>
					<li><a href="about.html">About</a></li>
					<c:if test="${user != null}">
						<li><a href="${logoutUri}">Log out</a></li>
					</c:if>
				</ul>
			</nav>
		</header>
		  <div class="blog-page main grid-wrap">

        <section class="grid col-three-quarters mq2-col-two-thirds mq3-col-full">
                    
            <article class="post">
                <h2><a href="blogpost.html" class="post-title">Blog post page!</a></h2>
                <div class="meta">
                    <p>Posted on <span class="time">November 15, 2011</span> by <a href="#" class="fn">Sylvain Lafitte</a> in <a href="#"class="cat">Other</a> with <a href="#" class="comments-link">42 comments</a>.</p>
                </div>
                <div class="entry">
                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi commodo, ipsum sed pharetra gravida, orci magna rhoncus neque, id pulvinar odio lorem non turpis. Nullam sit amet enim. Suspendisse id velit vitae ligula volutpat condimentum. Aliquam erat volutpat. Sed quis velit. Nulla facilisi. Nulla libero. Vivamus pharetra posuere sapien. Nam consectetuer. Sed aliquam, nunc eget euismod ullamcorper, lectus nunc ullamcorper orci, fermentum bibendum enim nibh eget ipsum. Donec porttitor ligula eu dolor. Maecenas vitae nulla consequat libero cursus venenatis. Nam magna enim, accumsan eu, blandit sed, blandit a, eros.</p>
                </div>
                <footer>
                    <a href="blogpost.html" class="more-link">Continue reading���</a>
                </footer>
            </article>
            
            <article class="post">
                <h2><a href="#" class="post-title">Blog post</a></h2>
                <div class="meta">
                    <p>Posted on <span class="time">November 15, 2011</span> by <a href="#" class="fn">Sylvain Lafitte</a> in <a href="#"class="cat">Other</a> with <a href="#" class="comments-link">42 comments</a>.</p>
                </div>
                <div class="entry">
                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi commodo, ipsum sed pharetra gravida, orci magna rhoncus neque, id pulvinar odio lorem non turpis. Nullam sit amet enim. Suspendisse id velit vitae ligula volutpat condimentum. Aliquam erat volutpat. Sed quis velit. Nulla facilisi. Nulla libero. Vivamus pharetra posuere sapien. Nam consectetuer. Sed aliquam, nunc eget euismod ullamcorper, lectus nunc ullamcorper orci, fermentum bibendum enim nibh eget ipsum. Donec porttitor ligula eu dolor. Maecenas vitae nulla consequat libero cursus venenatis. Nam magna enim, accumsan eu, blandit sed, blandit a, eros.</p>
                </div>
                <footer>
                    <a href="#" class="more-link">Continue reading���</a>
                </footer>
            </article>
            
            <article class="post">
                <h2><a href="#" class="post-title">Blog post</a></h2>
                <div class="meta">
                    <p>Posted on <span class="time">November 15, 2011</span> by <a href="#" class="fn">Sylvain Lafitte</a> in <a href="#"class="cat">Other</a> with <a href="#" class="comments-link">42 comments</a>.</p>
                </div>
                <div class="entry">
                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi commodo, ipsum sed pharetra gravida, orci magna rhoncus neque, id pulvinar odio lorem non turpis. Nullam sit amet enim. Suspendisse id velit vitae ligula volutpat condimentum. Aliquam erat volutpat. Sed quis velit. Nulla facilisi. Nulla libero. Vivamus pharetra posuere sapien. Nam consectetuer. Sed aliquam, nunc eget euismod ullamcorper, lectus nunc ullamcorper orci, fermentum bibendum enim nibh eget ipsum. Donec porttitor ligula eu dolor. Maecenas vitae nulla consequat libero cursus venenatis. Nam magna enim, accumsan eu, blandit sed, blandit a, eros.</p>
                </div>
                <footer>
                    <a href="#" class="more-link">Continue reading���</a>
                </footer>
            </article>
            
            <article class="post">
                <h2><a href="#" class="post-title">Blog post</a></h2>
                <div class="meta">
                    <p>Posted on <span class="time">November 15, 2011</span> by <a href="#" class="fn">Sylvain Lafitte</a> in <a href="#"class="cat">Other</a> with <a href="#" class="comments-link">42 comments</a>.</p>
                </div>
                <div class="entry">
                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi commodo, ipsum sed pharetra gravida, orci magna rhoncus neque, id pulvinar odio lorem non turpis. Nullam sit amet enim. Suspendisse id velit vitae ligula volutpat condimentum. Aliquam erat volutpat. Sed quis velit. Nulla facilisi. Nulla libero. Vivamus pharetra posuere sapien. Nam consectetuer. Sed aliquam, nunc eget euismod ullamcorper, lectus nunc ullamcorper orci, fermentum bibendum enim nibh eget ipsum. Donec porttitor ligula eu dolor. Maecenas vitae nulla consequat libero cursus venenatis. Nam magna enim, accumsan eu, blandit sed, blandit a, eros.</p>
                </div>
                <footer>
                    <a href="#" class="more-link">Continue reading���</a>
                </footer>
            </article>
            
            <article class="post">
                <h2><a href="#" class="post-title">Blog post</a></h2>
                <div class="meta">
                    <p>Posted on <span class="time">November 15, 2011</span> by <a href="#" class="fn">Sylvain Lafitte</a> in <a href="#"class="cat">Other</a> with <a href="#" class="comments-link">42 comments</a>.</p>
                </div>
                <div class="entry">
                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi commodo, ipsum sed pharetra gravida, orci magna rhoncus neque, id pulvinar odio lorem non turpis. Nullam sit amet enim. Suspendisse id velit vitae ligula volutpat condimentum. Aliquam erat volutpat. Sed quis velit. Nulla facilisi. Nulla libero. Vivamus pharetra posuere sapien. Nam consectetuer. Sed aliquam, nunc eget euismod ullamcorper, lectus nunc ullamcorper orci, fermentum bibendum enim nibh eget ipsum. Donec porttitor ligula eu dolor. Maecenas vitae nulla consequat libero cursus venenatis. Nam magna enim, accumsan eu, blandit sed, blandit a, eros.</p>
                </div>
                <footer>
                    <a href="#" class="more-link">Continue reading���</a>
                </footer>
            </article>          
        
            <ul class="page-numbers">
                <li><a href="#">Prev</a></li>
                <li><a href="#" class="current">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">Next</a></li>
            </ul>
        
        </section>

        <aside class="grid col-one-quarter mq2-col-one-third mq3-col-full blog-sidebar">
                
            <div class="widget">
                <input id="search" type="search" name="search" value="Type and hit enter to search" >
            </div>
            
            <div class="widget">
            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi commodo, ipsum sed pharetra gravida, orci magna rhoncus neque, id pulvinar odio lorem non turpis. Nullam sit amet enim.</p>
            </div>
            
            <div class="widget">
            <h2>Popular Posts</h2>
            <ul>
                <li><a href="#" title="">Nullam porttitor elementum ligula</a></li>
                <li><a href="#" title="">Vestibulum interdum</a></li>   
                <li><a href="#" title="">Quisque venenatis ante sit amet dolor</a></li>     
                <li><a href="#" title="">Aliquam adipiscing libero vitae leo</a></li>       
                <li><a href="#" title="">Sed accumsan quam ac tellus</a></li>   
            </ul>
            </div>
            
            <div class="widget">
            <h2>Categories</h2>
            <ul>
                <li><a href="http://">Design (99+)</a></li>
                <li><a href="http://">Web (53)</a></li>
                <li><a href="http://">Other (12)</a></li>
                <li><a href="http://">Weird (4)</a></li>
            </ul>
            </div>
        
            <div class="widget">
            <h2>Meta</h2>
            <ul>
                <li><a href="">Entries (RSS)</a></li>
                <li><a href="">Comments (RSS)</a></li>
            </ul>
            </div>
        </aside>

        
        
        
    </div> <!--main-->

		<div class="divide-top">
			<footer class="grid-wrap">
				<ul class="grid col-one-third social">
					<li><a href="#">Facebook</a></li>
					<li><a href="#">Twitter</a></li>
					<li><a href="#">Google+</a></li>
					<li><a href="#">RSS</a></li>
					<li><a href="#">Flickr</a></li>
				</ul>
				<div class="up grid col-one-third ">
					<a href="#navtop" title="Go back up">&uarr;</a>
				</div>
				<nav class="grid col-one-third ">
					<ul>
						<li><a href="index.jsp">Home</a></li>
						<li><a href="works.jsp">Works</a></li>
						<li><a href="blog.jsp">Blog</a></li>
						<li><a href="contact.jsp">Contact</a></li>
						<li><a href="about.jsp">About</a></li>
					</ul>
				</nav>
				<p>
					<br />nickname: ${user.nickname}<br />Domain: ${user.authDomain}<br />Email:
					${user.email}<br />FedId: ${user.federatedIdentity}<br />UserId:
					${user.userId}
				</p>
			</footer>
		</div>
	</div>
</body>
</html>








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
            <h4>Drop us a message</h4>
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