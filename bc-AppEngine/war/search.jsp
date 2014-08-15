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

<t:genericpage><jsp:body><script type="text/javascript" src="js/search.js"></script><script src="js/jquery.viewport.js" type="text/javascript">
   </script>
		<section class="grid-wrap">
 <div class="grid col-one-third mq2-col-full"><form id="my_form">
            <div id="main" style="display:inline-block;">
                <label for="query">Query</label>
                <input id="query" name="query" type="text" size="30" placeholder="${query}"/><br /><br />
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
<!--                 <div>
                    <small>Filter</small><br />
                    <input name="safesearch" type="radio" value="safe=off" CHECKED /> Off
                    <input name="safesearch" type="radio" value="safe=moderate" /> Moderate
                    <input name="safesearch" type="radio" value="safe=active" /> Active
                </div>
 -->                
                
            <div id="Parameters" style="display:inline-block; vertical-align: top;">
                <div id="ImageParameters">
                        <small>Size</small><br />
                        <input name="imagesize" type="radio" value="icon" /> Icon
                        <input name="imagesize" type="radio" value="small" /> Small
                        <input name="imagesize" type="radio" value="medium|large" /> Medium<br />
                        <input name="imagesize" type="radio" value="xxlarge|xlarge" CHECKED /> Large
                        <input name="imagesize" type="radio" value="huge" /> Huge
                        <input name="imagesize" type="radio" value="" /> All
                </div>
                <div id="WebParameters"></div>
                <div id="VideoParameters"></div>
                <br />
            </div></div>
            <div id='querydetails'></div><!-- <div><input id="bt_crawl" name="bt_crawl" type="submit" value="Crawl" /></div> -->
            <input type="hidden" id="userIp" name="userIp" value="${userIp}" />
            
        </form>
        
 <br />
    
</div><div class="grid col-two-thirds mq2-col-full">
<article id="navtabs">
    <ul class="tabs clearfix"><li><a href="#tab1">Web</a></li><li><a href="#tab2">Image</a></li><li><a href="#tab3">Video</a></li></ul>
    <div class="tab_container">
	    <article id="tab1" class="tab_content">
	        <ul class="blocks blocks-four-up thumbs thumbs_popover"><li><section id="resultsWeb" ></section></li></ul>
	    </article>
	    <article id="tab2" class="tab_content">
	        <ul class="blocks blocks-three-up section_blocks"><li><section id="resultsImage" ></section></li></ul>
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
            
            
            
            
            
            
