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
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<link type="text/css" rel="stylesheet" href="/css/style.css" />
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
<link rel="shortcut icon" type="image/png" href="favicon.png" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,400,700' rel='stylesheet' type='text/css' />

<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script language="JavaScript" type="text/javascript" src="js/guestbook.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width" />
<meta name="description" content="BasketCase guestbook" />
<meta name="author" content="Jeremiah Bopko, basket case Inc." />

<title>Guestbook</title>
</head>
<body>

<div class="container">
    <header id="navtop">
        <a href="index.html" class="logo fleft">
            <img src="img/logo.png" alt="BasketCased Studio">
        </a>
        
        <nav class="fright">
            <ul>
                <li><a href="index.html">Home</a></li>
                <li><a href="about.html">Sign In</a></li>
            </ul>
            <ul>
                <li><a href="works.html">Works</a></li>
                <li><a href="services.html">Services</a></li>
            </ul>
            <ul>
                <li><a href="blog.html">Blog</a></li>
                <li><a href="contact.html">Contact</a></li>
                <li><a href="about.html">About</a></li>
                <li><a href="gb.jsp" class="navactive">Guestbook</a></li>
            </ul>
        </nav>
    </header>


    <div class="about-page main grid-wrap">

        <header class="grid col-full"><hr><p class="fleft">About</p></header>        
        
        <aside class="grid col-one-quarter mq2-col-full">
            <p class="mbottom">Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi commodo, ipsum sed pharetra gravida, orci magna rhoncus neque, id pulvinar odio lorem non turpis.
            </p>
        </aside>
        
        <section class="grid col-three-quarters mq2-col-full">
            <img src="img/team.jpg" alt="" >
            
            <article id="navteam">
            <h2>Our team</h2>
            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi commodo, ipsum sed pharetra gravida, orci magna rhoncus neque, id pulvinar odio lorem non turpis. Nullam sit amet enim. Suspendisse id velit vitae ligula volutpat condimentum. Aliquam erat volutpat. Sed quis velit.</p>
            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi commodo, ipsum sed pharetra gravida, orci magna rhoncus neque, id pulvinar odio lorem non turpis. Nullam sit amet enim. Suspendisse id velit vitae ligula volutpat condimentum. Aliquam erat volutpat. Sed quis velit.</p>
            </article>
        </section>
    </div> <!--main-->

<div class="divide-top">
<footer class="grid-wrap">
    <ul class="grid col-one-third social">
        <li><a href="#">RSS</a></li>
        <li><a href="#">Facebook</a></li>
        <li><a href="#">Twitter</a></li>
        <li><a href="#">Google+</a></li>
        <li><a href="#">Flickr</a></li>
    </ul>

    <div class="up grid col-one-third ">
        <a href="#navtop" title="Go back up">&uarr;</a>
    </div>
    
    <nav class="grid col-one-third ">
        <ul>
            <li><a href="index.html">Home</a></li>
            <li><a href="about.html">About</a></li>
            <li><a href="works.html">Works</a></li>
            <li><a href="services.html">Services</a></li>
            <li><a href="blog.html">Blog</a></li>
            <li><a href="contact.html">Contact</a></li>
        </ul>
    </nav>
</footer>
</div>

</div>
<script src="http://code.jquery.com/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="js/jquery-1.9.0.min.js"><\/script>')</script>
<script src="js/scripts.js"></script>

<!-- Asynchronous Google Analytics snippet. Change UA-XXXXX-X to be your site's ID. -->
<script>
  var _gaq=[['_setAccount','UA-XXXXX-X'],['_trackPageview']];
  (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
  g.src=('https:'==location.protocol?'//ssl':'//www')+'.google-analytics.com/ga.js';
  s.parentNode.insertBefore(g,s)}(document,'script'));
</script>
</body>
</html>