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
<c:url value="/css/app.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<title>KomoCash</title>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center align-items-center" style="height:80vh">
    <div class="col-sm-6 col-md-4">
   <div class="card text-center">
        <div class="card-header">
            <h5 class="text-center">Authentification</h5>
        </div>
        <div class="card-body">
           <form class="form-signin" method="post" action="accueil_login" >
            <input type="text" class="form-control mb-2" placeholder="Nom d'utilisateur" name="username" required autofocus >
            <input type="password" class="form-control mb-2" placeholder="Mot de passe" name="password" required >
            <input class="btn btn-lg btn-primary btn-block mb-1" type="submit"  value="Se connecter"/>
           
            <a href="/app" class="float-right">Besoin d'aide?</a>
           
          </form>
        </div>
      </div>
   
    </div>
  </div>
	</div>
	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>

</html>
