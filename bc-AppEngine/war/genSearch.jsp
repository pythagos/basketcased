<%@page isELIgnored="false" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ page import="com.bc.search.AzureClient"%>
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

<t:genericpage><jsp:body>
	<script type="text/javascript" src="/js/search.js"></script>
	<script src="/js/jquery.viewport.js" type="text/javascript"></script>


<link rel="stylesheet" type="text/css" media="all" href="/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" media="all" href="/css/jgallery.min.css?v=1.3.2" />
    <script type="text/javascript" src="/js/tinycolor-0.9.16.min.js"></script>
    <script type="text/javascript" src="/js/jgallery.min.js?v=1.3.2"></script>
    	
<section class="grid-wrap">
	<div class="grid col-one-third mq2-col-full">
		<form id="my_form">
          <div id="main" style="display:inline-block;">
        <label for="query">Query</label>
        <input id="query" name="query" type="text" size="30" placeholder="${query}" onclick="search()" /><br /><br />
        
    	<p >
            <a href="#" class="button" id="bt_search">Search</a>
            <a href="#" class="button" id="bt_clear" >Clear</a>
            <a href="#" class="button" id="bt_graball" >Grab</a>
        </p>
        
        <div>
            <small>Search Type</small><br />
            <input name="service_op" type="radio" value="image" CHECKED /> Image
            <input name="service_op" type="radio" value="video" /> Video
            <input name="service_op" type="radio" value="web" /> Web
        </div>
        <div id="Parameters" style="display:inline-block; vertical-align: top;">
	        <div id="ImageParameters"><small>Size</small><br /><select id="imagesize"><option value="icon"> Icon </option><option value="small"> Small </option><option value="medium|large"> Medium </option><option value="xxlarge|xlarge" selected>Large </option><option value="huge"> Huge </option><option value=""> All </option></select></div>
	        <div id="WebParameters"></div>
	        <div id="VideoParameters"></div>
    	</div>
    </div>
    <div id='querydetails'></div><!-- <div><input id="bt_crawl" name="bt_crawl" type="submit" value="Crawl" /></div> -->
    <input type="hidden" id="userIp" name="userIp" value="${userIp}" />
</form>
<br />
    
</div>
</section>
<section>
<div id="gallery">
	<div class="album" data-jgallery-album-title="Album 1">
		<h1>Album 1</h1>
		<div id="resultsImage" ><a href="img/psl.jpg"><img src="img/psl.jpg" alt="BasketCase" /></a>
		</div><!-- more albums -->
	</div><!-- more images -->
</div>
</section>
<section class="grid-wrap">
<article id="navtabs">
    <ul class="tabs clearfix"><li><a href="#tab1">Web</a></li><li><a href="#tab2">Image</a></li><li><a href="#tab3">Video</a></li></ul>
    <div class="tab_container">
	    <article id="tab1" class="tab_content">
	        <ul class="blocks blocks-four-up thumbs thumbs_popover"><li><section id="resultsWeb" ></section></li></ul>
	    </article>
	    <article id="tab2" class="tab_content">
	        <ul class="blocks blocks-three-up section_blocks"><li>
	        </li>
	        </ul>
	    </article>
	    <article id="tab3" class="tab_content">
	        <ul class="blocks blocks-three-up section_blocks"><li><section id="resultsVideo" ></section></li></ul>
	    </article>
    </div>
</article>
</div>
</section>
</jsp:body>
</t:genericpage>