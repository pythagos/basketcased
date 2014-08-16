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
	content="Basket Case Inc.(Project Number: 1024283163339), a HTML5 / CSS3 / JSP2 / Google App Engine playground.">
<meta name="author" content="Jeremiah Bopko">
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
<link rel="shortcut icon" type="image/png" href="img/favicon.png">
<meta name="viewport" content="width=device-width">
<link type="text/css" rel="stylesheet" href="/css/style.css" />
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,400,700'
	rel='stylesheet' type='text/css' />
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="js/scripts.js"></script>
<%
	com.google.appengine.api.users.UserService userService = com.google.appengine.api.users.UserServiceFactory
			.getUserService();
	com.google.appengine.api.users.User user = userService
			.getCurrentUser();
	if (user != null) {
		request.setAttribute("user", user);
	}
	request.setAttribute("loginUri", userService.createLoginURL(request.getRequestURI()));
	request.setAttribute("logoutUri", userService.createLogoutURL(request.getRequestURI()));
    request.setAttribute("userIp", request.getRemoteAddr());
%>
</head>
<body>
	<div class="container">
		<header id="navtop">
			<a href="index.jsp" class="logo fleft"><img
				src="img/logo.png" alt="BasketCase Inc."></a>
			<nav class="fright">
				<ul>
                    <li><a href="works.jsp">Projects</a></li>
                    <li><a href="blogs.jsp">Blog</a></li>
				</ul>
				<ul>
					<li><a href="guest.jsp">Contact</a></li>
                    <c:choose>
                        <c:when test="${user != null}">
                            <li><a href="account.jsp">${user.nickname}</a></li><li><a href="${logoutUri}">Logout</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="${loginUri}">Sign In</a></li>
                        </c:otherwise>
                    </c:choose>
					<li><a href="guest.jsp">About</a></li>
				</ul>
			</nav>
		</header>
		<div class="main"><jsp:doBody /></div>
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
						<li><a href="blogs.jsp">Blog</a></li>
						<li><a href="guest.jsp">Contact</a></li>
						<li><a href="guest.jsp">About</a></li>
					</ul>
				</nav>
				<p class="hidden">
					<br />nickname: ${user.nickname}<br />Domain: ${user.authDomain}<br />Email:
					${user.email}<br />FedId: ${user.federatedIdentity}<br />UserId:
					${user.userId}<br />User IP: ${pageContext.request.remoteAddr}<br />Current: ${pageContext.request.requestURL}
					<br />Context: ${pageContext.request.contextPath}
				</p>
			</footer>
		</div>
	</div>
</body>
</html>