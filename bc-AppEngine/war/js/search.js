$(function () {
    window.globalPageSize = 8;
    window.globalIndex = 0;
    window.lastTop = 0;

    window.isSearching = -1;

    // initial config of ui elements
    $('#bt_graball').hide();
    $('#ImageParameters').show(5000);
    $('#navtabs').hide();
    $('input[name=query]', '#my_form').focus();
    
    $('#query').keypress(function (e) {
    	  if (e.which == 13) {
    		  e.preventDefault();
    	        globalIndex = 0;
    	        $('#resultsWeb').empty();
    	        $('#resultsImage').empty();
    	        $('#resultsVideo').empty();
    	        $('#querydetails').empty();
    	        $('#bt_graball').hide();
    	        
    	        if ($('#query').val()) {search();}
    	    return false;
    	  }
    	});
    
    // SEARCH
    $('#bt_search').click(function (e) {
        e.preventDefault();
        globalIndex = 0;
        $('#resultsWeb').empty();
        $('#resultsImage').empty();
        $('#resultsVideo').empty();
        $('#querydetails').empty();
        $('#bt_graball').hide();
        
        if ($('#query').val()) {search();}
    });
    // CRAWL
    $('#bt_crawl').click(function (e) {
        e.preventDefault();
        globalIndex = 0;
        if ($('#query').val()) {;}
    });
    // CLEAR
    $('#bt_clear').click(function (e) {
        e.preventDefault();
        $('#resultsWeb').empty();
        $('#resultsImage').empty();
        $('#resultsVideo').empty();
        $('#querydetails').empty();
        $('#query').val('');
        $('#bt_graball').hide();
        $('#navtabs').hide();
        updateUI();
    });
    // GRAB ALL
    $('#bt_graball').click(function (e) {
        e.preventDefault();
        $('#bt_graball').hide();
        $('#resultsImage a[href]').each(function (index) {
            if ($(this)[0]) {
                $(this)[0].click();
                pausecomp(500);
            }
        });
    });

    // Event handler for changes by the user
    $('input', '#my_form').change(function () { updateUI(); });
    $(window).scroll(function() {
    	if (($(window).scrollTop() > lastTop) && (isSearching < 0)) {
        	if ($('.lastResult') && $('.lastResult').length > 0) {
    			var offset = $('.lastResult').offset();
        		if ( ($(window).scrollTop() + window.innerHeight) > offset.top){
                    setTimeout(function(){if ($('#query').val()) {search();}});
    			}
            }
    	}
    	lastTop = $(window).scrollTop();
    });

    function displayGallery() {
    	$( '#gallery' ).jGallery( {
            mode: 'standard', // [ full-screen, standard, slider ]
            width: '100%', // (only for standard or slider mode)
            height: '750px', // (only for standard or slider mode)
            autostart: false, // (only for full-screen mode)
            autostartAtImage: 1,
            autostartAtAlbum: 1,
            canClose: true, // (only for full-screen mode)
            canResize: true,
            draggableZoom: true,
            canChangeMode: false,
            backgroundColor: '#dfdfdf',
            textColor: '#787878',
            browserHistory: false,
            thumbnails: true,
            thumbnailsFullScreen: true,
            thumbType: 'image', // [ image | square | number ]
            thumbnailsPosition: 'bottom', // [ top | bottom | left | right ]
            reloadThumbnails: true, //Reload thumbnails when function jGallery() is called again for the same item
            thumbWidth: 100, //px
            thumbHeight: 100, //px
            thumbWidthOnFullScreen: 100, //px
            thumbHeightOnFullScreen: 100, //px
            canMinimalizeThumbnails: true,
            hideThumbnailsOnInit: true,
            transition: 'moveToRight_moveFromLeft', // http://jgallery.jakubkowalczyk.pl/customize
            transitionBackward: 'moveToLeft_moveFromRight', // http://jgallery.jakubkowalczyk.pl/customize
            transitionWaveDirection: 'forward', // [ forward | backward ]
            transitionCols: 1,
            transitionRows: 5,
            showTimingFunction: 'linear', // [ linear | ease | ease-in | ease-out | ease-in-out | cubic-bezier(n,n,n,n) ]
            hideTimingFunction: 'linear', // [ linear | ease | ease-in | ease-out | ease-in-out | cubic-bezier(n,n,n,n) ]
            transitionDuration: '0.4s',
            zoomSize: 'fit', // [ fit | original | fill ] (only for full-screen or standard mode)
            title: true,
            slideshow: true,
            slideshowAutostart: false,
            slideshowCanRandom: true,
            slideshowRandom: false,
            slideshowRandomAutostart: false,
            slideshowInterval: '8s',
            preloadAll: false,
            appendTo: 'body', // selector (only for full-screen mode)
            disabledOnIE8AndOlder: true,
            initGallery: function() {},
            showPhoto: function() {},
            beforeLoadPhoto: function() {},
            afterLoadPhoto: function() {},
            showGallery: function() {},
            closeGallery: function() {}
        } );

//$( "#gallery" ).jGallery( {
//            "transition":"moveToRight_moveFromLeft",
//            "transitionBackward":"moveToLeft_moveFromRight",
//            "transitionCols":"1",
//            "transitionRows":"5",
//            "thumbnailsPosition":"bottom",
//            "thumbType":"image",
//            "backgroundColor":"#000",
//            "textColor":"#fff",
//            "mode":"standard"
//        } );
    }

    function search() {
    	if (isSearching > 0) {
    		return;
    	}
    	
		isSearching = 1;
    	var data = getQueryData();
    	var service = $('input[name=service_op]:checked', '#my_form').val();

    	$('#navtabs').show();
    	$('#resultsImage > a').removeClass('lastResult');
    	
    	$.getJSON('search/web', data, function(result){
    		if (result && result.responseData) {
        		var results = result.responseData.results;
        		$.each(results, function(i, field){showWebResult(field);});
        		setTimeout(function (){$('#resultsWeb > a:last-child').addClass('lastResult');}, 500);
    		}
    	});

    	$.getJSON('search/image', data, function(result){
    		if (result && result.responseData) {
        		var results = result.responseData.results;
        		globalIndex += results.length;
        		$.each(results, function(i, field){showImageResult(field);});
        		setTimeout(function (){$('#resultsImage > a:last-child').addClass('lastResult');displayGallery();}, 500);
    		}
    	});

    	$.getJSON('search/video', data, function(result){
    		if (result && result.responseData) {
        		var results = result.responseData.results;
        		$.each(results, function(i, field){showVideoResult(field);});
        		setTimeout(function (){$('#resultsVideo > a:last-child').addClass('lastResult');}, 500);
    		}
    	});
    	setTimeout(function (){isSearching = -1;}, 3000);
    }

    function searchBAK() {
    	var data = getQueryData();
    	var service = $('input[name=service_op]:checked', '#my_form').val();

    	$('#navtabs').show();
    	$('#resultsImage > a').removeClass('lastResult');
    	
    	$.getJSON('search/' + service, getQueryData(), function(result){
    		if (result) {
        		var results = result.responseData.results;
        		globalIndex += results.length;

        		$.each(results, function(i, field){
        			if (service === 'image'){
            			showImageResult(field);
        			} else if (service === 'video'){
            			showVideoResult(field);
        			} else if (service === 'web'){
            			showWebResult(field);
        			}
        		});
        		setTimeout(function (){$('#resultsImage > a:last-child').addClass('lastResult');}, 500);
    		} else {
    			// display error message or repeat
    			setTimeout(function(){if ($('#query').val()) {search();}}, 2000);
    		}
    	});
    }

    // Performs the search.
    function searchImage() {
        
        $.getJSON('search', getQueryData(), function(result){
    		var results = result.responseData.results;
    		globalIndex += results.length;

    		$.each(results, function(i, field){
    			showImageResult(field);
    		});			    
    	});
        $('#bt_graball').show();
        setTimeout(function (){$('#resultsImage > a:last-child').addClass('lastResult');}, 500);
    }
    function getQueryData() {
        var query = "q=" + encodeURIComponent($('#query').val());
        var service = $('input[name=service_op]:checked', '#my_form').val();
        var safeSearch = $('input[name=safesearch]:checked', '#my_form').val();
        var userIp = 'userip=' + $('input[name=userIp]', '#my_form').val();
        var filter = '';

        if (service == "image") {filter = getImageFilter();}
        //else if (service == "Video") {filter = getVideoFilter();}

        var data = {
            searchType: service,
            hostLanguage: 'hl=en',
            familyFilter: safeSearch,
            q: query,
            filter: filter,
            index: 'start=' + globalIndex,
            userIp: userIp
        };
        return data;
    }
	// Shows one item of Image result.
    function showVideoResult(item) {
        var a = document.createElement('a');

        a.href = item.url;
        a.download = item.playUrl;
        
        var i = document.createElement('img');
        i.src = item.tbUrl;
        // Make the object that the user clicks the thumbnail image.
        $(a).append(i);
        // Append the anchor tag and paragraph with the title to the results div.
        $('#resultsVideo').append(a);
    }

	// Shows one item of Image result.
    function showImageResult(item) {
        var a = document.createElement('a');

        a.href = item.url;
        a.download = getFilename(item.url);
        var i = document.createElement('img');
        i.src = item.tbUrl;
        
        var att=document.createAttribute("data-jgallery-bg-color");
        att.value="#DFDFDF";
        i.setAttributeNode(att);
        
        var at2=document.createAttribute("data-jgallery-text-color");
        at2.value="#787878";
        i.setAttributeNode(at2);
        
        
        // Make the object that the user clicks the thumbnail image.
        $(a).append(i);
        // Append the anchor tag and paragraph with the title to the results div.
        $('#resultsImage').append(a);
    }

    function getImageFilter() {
        var imageFilter = undefined;
        var imageSize = $('#imagesize option:selected', '#my_form').val();
        var imageAspect = $('input[name=imageaspect]:checked', '#my_form').val();

        if (imageSize == "Size:All")
            imageSize = undefined;
        if (imageAspect == "Aspect Ratio:All")
            imageAspect = undefined;

        if (imageSize || imageAspect) {
            if (imageSize) {
                imageFilter = imageSize;
                if (imageAspect) {imageFilter += "+" + imageAspect;}
            } else {imageFilter = imageAspect;}
        }
        return 'imgsz=' + encodeURIComponent(imageFilter);
    }

    function getVideoFilter() {

        var videoFilter = '';
        var videoSize = $('input[name=videoduration]:checked', '#my_form').val();
        var videoAspect = $('input[name=videoaspect]:checked', '#my_form').val();
        var videoResolution = $('input[name=videoresolution]:checked', '#my_form').val();

        if (videoSize == "Size:All")
            videoSize = undefined;

        if (videoAspect == "Aspect Ratio:All")
            videoAspect = undefined;

        if (videoResolution == "Resolution:All")
            videoResolution = undefined;

        if (videoSize) {
            videoFilter = videoSize;
        }
        if (videoAspect) {
            if (videoSize) {
                videoFilter += "+";
            }
            videoFilter += videoAspect;
        }
        if (videoResolution) {
            if (videoSize || videoAspect) {
                videoFilter += "+";
            }
            videoFilter += videoResolution;
        }
        return videoFilter;
    }

    // Shows one item of Web result.
    function showWebResult(item) {
        var p = document.createElement('p');
        var a = document.createElement('a');
        a.href = item.url;

        $(a).append(item.title);
        $(p).append(item.content);

        // Append the anchor tag and paragraph with the description to the results div.
        $('#resultsWeb').append(a, p);
    }
    
    function updateUI() {
        var query = $('#query').val();
        var serviceOp = $('input[name=service_op]:checked', '#my_form').val();
        var safeSearch = $('input[name=safesearch]:checked', '#my_form').val();
        var detail = undefined;

        if (serviceOp == "Image") {
            $('#ImageParameters').show();
            $('#WebParameters').hide();
            $('#VideoParameters').hide();

            var imageSize = $('#imagesize option:selected', '#my_form').val();
            var imageAspect = $('input[name=imageaspect]:checked', '#my_form').val();
            detail = "Search for <b>" + serviceOp + "</b> related to \"<b>" + query + "</b>\"<br /><p>Content Filtering Set To <b>" + safeSearch + "</b><br />" + imageSize + "<br />" + imageAspect + "</p>";

        } else if (serviceOp == "Video") {
            $('#ImageParameters').hide();
            $('#WebParameters').hide();
            $('#VideoParameters').show();

            var videoSize = $('input[name=videoduration]:checked', '#my_form').val();
            var videoAspect = $('input[name=videoaspect]:checked', '#my_form').val();
            var videoResolution = $('input[name=videoresolution]:checked', '#my_form').val();
            detail = "Search for <b>" + serviceOp + "</b> related to \"<b>" + query + "</b>\"<br /><p>Content Filtering Set To <b>" + safeSearch + "</b><br />" + videoSize + "<br />" + videoAspect + "<br />" + videoResolution + "</p>";

        } else if (serviceOp == "Web") {
            $('#ImageParameters').hide();
            $('#WebParameters').show();
            $('#VideoParameters').hide();
            detail = "Search for <b>" + serviceOp + "</b> related to \"<b>" + query + "</b>\"<br /><p>Content Filtering Set To <b>" + safeSearch + "</b></p>";
        }
        if (query) {
            $('#querydetails').html(detail);
            $('#querydetails').show();
        } else {
            $('#querydetails').hide();
        }
    }
    
    function addZero(x, n) {
        if (x.toString().length < n) {x = "0" + x;}
        return x;
    }

    function getFilename(uri) {
        pausecomp(10);
        var d = new Date();
        var beg;
        var strExt;
        var strAsp;
        var query = $('#query').val();
        var imageAspect = "Aspect:Wide";

        var pageIndex = 99;
        
        beg = uri.lastIndexOf(".");
        strExt = uri.substring(beg);

        if (strExt.length > 5) {
            strExt = ".jpg";
        }

        beg = imageAspect.lastIndexOf(":");
        strAsp = imageAspect.substring(beg + 1);

        return strAsp + "_" + addZero(d.getMonth(), 2) + addZero(d.getDate(), 2) + "_" + addZero(d.getHours(), 2) + addZero(d.getMinutes(), 2) + addZero(d.getSeconds(), 2) + "_" + addZero(d.getMilliseconds(), 3) + "_" + pageIndex + strExt;
    }
    function pausecomp(millis) {
        var date = new Date();
        var curDate = null;
        do { curDate = new Date(); }
        while (curDate - date < millis);
    }
});