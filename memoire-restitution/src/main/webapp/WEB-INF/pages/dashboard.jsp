<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:url value="/ressources/css/style.default.css" var="css1" />
<c:url value="/ressources/css/responsive-tables.css" var="css2" />

<c:url value="/ressources/js/jquery-1.9.1.min.js" var="js1" />
<c:url value="/ressources/js/jquery-migrate-1.1.1.min.js" var="js2" />
<c:url value="/ressources/js/jquery-ui-1.9.2.min.js" var="js3" />
<c:url value="/ressources/js/modernizr.min.js" var="js4" />
<c:url value="/ressources/js/bootstrap.min.js" var="js5" />
<c:url value="/ressources/js/jquery.cookie.js" var="js6" />
<c:url value="/ressources/js/jquery.uniform.min.js" var="js7" />
<c:url value="/ressources/js/flot/jquery.flot.min.js" var="js8" />
<c:url value="/ressources/js/flot/jquery.flot.resize.min.js" var="js9" />
<c:url value="/ressources/js/responsive-tables.js" var="js10" />
<c:url value="/ressources/js/custom.js" var="js11" />
<c:url value="/ressources/js/jquery.smartWizard.min.js" var="js12" /> 


<%@ page session="false"%>
<title>KomoCash</title>

<link rel="stylesheet" href="${css1}" type="text/css" />
<link rel="stylesheet" href="${css2}"  type="text/css">
<c:url value="/ressources/images/logo1.png" var="imglogo" />
<c:url value="/ressources/images/loaders/loader27.gif" var="imgload" />
<c:url value="/ressources/images/photos/thumb1.png" var="thumb1" />

<script type="text/javascript" src="${js1}"></script>
<script type="text/javascript" src="${js2}"></script>
<script type="text/javascript" src="${js3}"></script>
<script type="text/javascript" src="${js4}"></script>
<script type="text/javascript" src="${js5}"></script>
<script type="text/javascript" src="${js6}"></script>
<script type="text/javascript" src="${js7}"></script>
<script type="text/javascript" src="${js7}"></script>
<script type="text/javascript" src="${js8}"></script>
<script type="text/javascript" src="${js9}"></script>
<script type="text/javascript" src="${js10}"></script>

<script type="text/javascript" src="${js11}"></script>
<script type="text/javascript" src="${js12}"></script>
<script type="text/javascript" src="${js13}"></script>
<script type="text/javascript">
	jQuery(document).ready(function() {

		// Smart Wizard 	
		jQuery('#wizard').smartWizard({
			onFinish : onFinishCallback
		});
		jQuery('#wizard2').smartWizard({
			onFinish : onFinishCallback
		});
		jQuery('#wizard3').smartWizard({
			onFinish : onFinishCallback
		});

		function onFinishCallback() {
			alert('Finish Clicked');
		}

		jQuery('select, input:checkbox').uniform();

	});
</script>

<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/excanvas.min.js"></script><![endif]-->
</head>


<body>

<div class="mainwrapper">
    <div class="leftpanel">
          
    </div><!-- leftpanel -->
    
    <div class="rightpanel">
        
        <ul class="breadcrumbs">
            <li><a href="dashboard.html"><i class="iconfa-home"></i></a> <span class="separator"></span></li>
            <li>Dashboard</li>
            <li class="right">
                    <a href="" data-toggle="dropdown" class="dropdown-toggle"><i class="icon-tint"></i> Color Skins</a>
                    <ul class="dropdown-menu pull-right skin-color">
                        <li><a href="default">Default</a></li>
                        <li><a href="navyblue">Navy Blue</a></li>
                        <li><a href="palegreen">Pale Green</a></li>
                        <li><a href="red">Red</a></li>
                        <li><a href="green">Green</a></li>
                        <li><a href="brown">Brown</a></li>
                    </ul>
            </li>
        </ul>
        
        <div class="pageheader">
            <form action="results.html" method="post" class="searchbar">
                <input type="text" name="keyword" placeholder="To search type and hit enter..." />
            </form>
            <div class="pageicon"><span class="iconfa-laptop"></span></div>
            <div class="pagetitle">
                <h5>All Features Summary</h5>
                <h1>Dashboard</h1>
            </div>
        </div><!--pageheader-->
        
        <div class="maincontent">
            <div class="maincontentinner">
                <div class="row-fluid">
                    <div id="dashboard-left" class="span6">
                        
                       
                           
                        <table class="table table-bordered responsive">
                            <thead>
                                <tr>
                                    <th class="head1">Rendering engine</th>
                                    <th class="head0">Browser</th>
                                    <th class="head1">Platform(s)</th>
                                    <th class="head0">Engine version</th>
                                    <th class="head1">CSS grade</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Trident</td>
                                    <td>Internet  Explorer 5.5</td>
                                    <td>Win 95+</td>
                                    <td class="center">5.5</td>
                                    <td class="center">A</td>
                                </tr>
                                <tr>
                                    <td>Trident</td>
                                    <td>Internet Explorer 6</td>
                                    <td>Win 98+</td>
                                    <td class="center">6</td>
                                    <td class="center">A</td>
                                </tr>
                                <tr>
                                    <td>Trident</td>
                                    <td>Internet Explorer 7</td>
                                    <td>Win XP SP2+</td>
                                    <td class="center">7</td>
                                    <td class="center">A</td>
                                </tr>
                            </tbody>
                        </table>
                        
                      
                        <br />
                        
                        
                    </div><!--span8-->
                    
                    <div id="dashboard-right" class="span5">
                        
                          <h5 class="subtitle">Daily Statistics</h5><br />
                        <div id="chartplace" style="height:300px;">
                        
                        </div>
                        
                      <h4 class="widgettitle">Bar Chart</h4>
                        <div class="widgetcontent">
                            <div id="bargraph" style="height:300px;"></div>
                        </div><!--widgetcontent-->
                          
                        
                                         
                    </div><!--span4-->
                </div><!--row-fluid-->
                
                <div class="footer">
                    <div class="footer-left">
                        <span>&copy; 2013. Shamcey Admin Template. All Rights Reserved.</span>
                    </div>
                    <div class="footer-right">
                        <span>Designed by: <a href="http://themepixels.com/">ThemePixels</a></span>
                    </div>
                </div><!--footer-->
                
            </div><!--maincontentinner-->
        </div><!--maincontent-->
        
    </div><!--rightpanel-->
    
</div><!--mainwrapper-->


<script type="text/javascript">


    jQuery(document).ready(function() {
        
      // simple chart
		var flash = [[0, 11], [1, 9], [2,12], [3, 8], [4, 7], [5, 3], [6, 1]];
		var html5 = [[0, 5], [1, 4], [2,4], [3, 1], [4, 9], [5, 10], [6, 13]];
      var css3 = [[0, 6], [1, 1], [2,9], [3, 12], [4, 10], [5, 12], [6, 11]];
			
		function showTooltip(x, y, contents) {
			jQuery('<div id="tooltip" class="tooltipflot">' + contents + '</div>').css( {
				position: 'absolute',
				display: 'none',
				top: y + 5,
				left: x + 5
			}).appendTo("body").fadeIn(200);
		}
	
			
		var plot = jQuery.plot(jQuery("#chartplace"),
			   [ { data: flash, label: "Flash(x)", color: "#6fad04"},
              { data: html5, label: "HTML5(x)", color: "#06c"},
              { data: css3, label: "CSS3", color: "#666"} ], {
				   series: {
					   lines: { show: true, fill: true, fillColor: { colors: [ { opacity: 0.05 }, { opacity: 0.15 } ] } },
					   points: { show: true }
				   },
				   legend: { position: 'nw'},
				   grid: { hoverable: true, clickable: true, borderColor: '#666', borderWidth: 2, labelMargin: 10 },
				   yaxis: { min: 0, max: 15 }
				 });
		
		var previousPoint = null;
		jQuery("#chartplace").bind("plothover", function (event, pos, item) {
			jQuery("#x").text(pos.x.toFixed(2));
			jQuery("#y").text(pos.y.toFixed(2));
			
			if(item) {
				if (previousPoint != item.dataIndex) {
					previousPoint = item.dataIndex;
						
					jQuery("#tooltip").remove();
					var x = item.datapoint[0].toFixed(2),
					y = item.datapoint[1].toFixed(2);
						
					showTooltip(item.pageX, item.pageY,
									item.series.label + " of " + x + " = " + y);
				}
			
			} else {
			   jQuery("#tooltip").remove();
			   previousPoint = null;            
			}
		
		});
		
		jQuery("#chartplace").bind("plotclick", function (event, pos, item) {
			if (item) {
				jQuery("#clickdata").text("You clicked point " + item.dataIndex + " in " + item.series.label + ".");
				plot.highlight(item.series, item.datapoint);
			}
		});
    
        
		
		
		

		/*****BAR GRAPH*****/
		var d2 = [];
		for (var i = 0; i <= 10; i += 1)
			d2.push([i, parseInt(Math.random() * 30)]);
			
		var stack = 0, bars = true, lines = false, steps = false;
		jQuery.plot(jQuery("#bargraph"), [ d2 ], {
			series: {
				stack: stack,
				lines: { show: lines, fill: true, steps: steps },
				bars: { show: bars, barWidth: 0.6 }
			},
			grid: { hoverable: true, clickable: true, borderColor: '#666', borderWidth: 2, labelMargin: 10 },
			colors: ["#666"]
		});
		
		
		
		
		
		
		
        //datepicker
        jQuery('#datepicker').datepicker();
        
        // tabbed widget
        jQuery('.tabbedwidget').tabs();
        
        
    
    });
</script>
</body>
</html>
