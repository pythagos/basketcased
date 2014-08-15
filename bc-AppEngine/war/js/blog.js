$(document).ready(function() {
	$.get( "blog/today.html", function( data ) {
		$( "#todaysBlog" ).html( data );
	});
	$.getJSON("blog/meta.json",function(result){
		var popular = result.popular;
		var categories = result.categories;
		
		$("div#intro").append(result.intro);
		
		$.each(popular, function(i, field){
			$("ul#popular").append("<li><a href='" + field.href +"' title=''>" + field.title + "</a></li>");					
		});			    

		$.each(categories, function(i, field){
			$("ul#categories").append("<li><a href=''>" + field.category + " (" + field.count +")</a></li>");					
		});
	});
//	$.get("blog/pop.xml", function(xml){
//       var box = $("div#popxml");
//       var xmldoc = $($.parseXML(xml));
//       console.log(xml.firstChild.innerHTML);
//       box.append(xml.firstChild.innerHTML);
//    });

});