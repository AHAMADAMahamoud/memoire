<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<c:url value="/ressources/css/accueil/design.css" var="designeCSS" />
<c:url value="/ressources/css/accueil/export.css"
	var="enteteCSS" />
<link href="${designeCSS}" rel="stylesheet" />
<link href="${enteteCSS}" rel="stylesheet" />

<html>
<head>
<style type="text/CSS">
ul {
	padding: 0;
	margin: 0;
	list-style-type: none;
}

li {
	margin-left: 4px;
	float: left; /*pour IE*/
}

ul li a {
	display: block;
	float: left;
	width: 120px;
	background-color:background;
	color: white;
	text-decoration: none;
	text-align: center;
	padding: 5px;
	border-width: 2px;
	border-style: solid;
	border-color: #DCDCDC #696969 #696969 #DCDCDC;
	/*pour avoir un effet "outset" avec IE*/
}

ul li a:hover {
	border-color: #696969 #DCDCDC #DCDCDC #696969;
}

.clear {
	clear: both;
}
</style>
</head>
<body>
	<h1>LE PROJET KOMOCASH</h1>
	<p>
		<c:out value="${date}" />
	</p>
	<p>
		<c:out value="${test}" />
	</p>
	<ul>
		<li><a href="open_etl_dimension">MODULE ALIMENTATION</a></li>
		<li><a href="open_accueil_requette">MODULE REQUETAGE</a></li>
		<li><a href="open_accueil_restitution">MODULE RESTITUTION</a></li>
	</ul>
<div class="clear"></div>
