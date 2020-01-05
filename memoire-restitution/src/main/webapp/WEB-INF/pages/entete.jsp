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



<script type="text/javascript" src="/ressources/editor/lib/codemirror.js"></script>
<script type="text/javascript" src="/ressources/editor/mode/clike/clike.js"></script>
<script type="text/javascript" src="/ressources/editor/keymap/emacs.js"></script>


<link rel="stylesheet" href="/ressources/editor/lib/codemirror.css">


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

		<div class="header">
			<div class="logo">
				<a href="dashboard.html"><img src="${imglogo}" alt="" /></a>
			</div>
			<div class="headerinner">
				<ul class="headmenu">
					<li class="right">
						<div class="userloggedinfo">
							<img src="${thumb1}" alt="" />
							<div class="userinfo">
								<h5>${loggedinuser}</h5>
								<ul>
									<li><a href="list">Mon Profile</a></li>
									<li><a href="logout">Déconnecter</a></li>
								</ul>
							</div>
						</div>
					</li>
				</ul>
				<!--headmenu-->
			</div>
		</div>