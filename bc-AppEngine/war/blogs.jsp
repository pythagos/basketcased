<%@page isELIgnored="false"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:genericpage><jsp:body>
<script type="text/javascript" src="js/blog.js"></script>
<div class="blog-page grid-wrap">
<section class="grid col-three-quarters mq2-col-two-thirds mq3-col-full"><article class="post" id="todaysBlog"></article></section>
<aside class="grid col-one-quarter mq2-col-one-third mq3-col-full blog-sidebar">
<div class="widget"><input id="search" type="search" name="search" value="Type and hit enter to search" ></div>
<div class="widget" id="intro" ></div>
<div class="widget"><h2>Popular Post</h2><ul id="popular" ></ul></div>
<div class="widget"><h2>Categories</h2><ul id="categories" ></ul></div>
</aside>
</div>
</jsp:body>
</t:genericpage>