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
				<a class="navbar-brand" href="#">ComoresSoft </a>


				<div class="collapse navbar-collapse" id="navbarResponsive">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item active"><a class="nav-link" href="#">User
								: ${username} <span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item active"><a class="nav-link" href="#">Logout</a>
						</li>

					</ul>
				</div>
			</div>
		</nav>



<br><br>



		<div class="row">
			<div class="col-sm-4">
				<div class="list-group">
					<a href="#" class="list-group-item list-group-item-action active">
						Navigation </a> <a href="#"
						class="list-group-item list-group-item-action">Alimentation de
						l'entrepot</a> <a href="#"
						class="list-group-item list-group-item-action">Gestion des
						requêtes</a> <a href="#"
						class="list-group-item list-group-item-action">Reporting
						Managment</a> <a href="#"
						class="list-group-item list-group-item-action disabled">Vestibulum
						at eros</a>
				</div>
			</div>
			<div class="col-sm-8">col-sm-8</div>

		</div>




	</div>
	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>

</html>
