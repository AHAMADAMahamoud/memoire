<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />

<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>
<div class="container">
	
	
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
  <div class="container">
   <a class="navbar-brand" href="#">ComoresSoft : </a>
   
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item active">
          <a class="nav-link" href="#">${username}
                <span class="sr-only">(current)</span>
              </a>
        </li>
        
      </ul>
    </div>
  </div>
</nav>

	

<div class="leftmenu">
		<ul class="nav nav-tabs nav-stacked">
			<li class="nav-header">Navigation</li>
			<li class="active"><a href="<%= request.getContextPath() %>/accueil"><span
					class="iconfa-laptop"></span> Accueil</a></li>
			<li><a href="open_etl_dimension"><span
					class="iconfa-briefcase"></span> Alimentation de l'entrepot</a></li>
			<li><a href="open_accueil_requette"><span
					class="iconfa-th-list"></span> Gestion des requêtes</a></li>
			<li><a href="open_accueil_restitution"><span
					class="iconfa-signal"></span> Reporting Managment</a></li>
			<li><a href="open_parametre"><span class="iconfa-book"></span>
					Parametrages</a></li>
		</ul>
	</div>



	</div>
	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>

</html>
