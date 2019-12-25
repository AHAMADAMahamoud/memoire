<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>KomoCash</title>
<link rel="stylesheet" href="<c:url value="ressources/css/style.default.css" />" type="text/css" />
<link rel="stylesheet" href="<c:url value="ressources/css/style.shinyblue.css" />" type="text/css" />
<c:url value="/ressources/images/logo1.png" var="imglogo" />

<script type="text/javascript" src="/ressources/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/ressources/js/jquery-migrate-1.1.1.min.js"></script>
<script type="text/javascript" src="/ressources/js/jquery-ui-1.9.2.min.js"></script>
<script type="text/javascript" src="/ressources/js/modernizr.min.js"></script>
<script type="text/javascript" src="/ressources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/ressources/js/jquery.cookie.js"></script>
<script type="text/javascript" src="/ressources/js/custom.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function() {
		jQuery('#login').submit(function() {
			var u = jQuery('#username').val();
			var p = jQuery('#password').val();
			if (u == '' && p == '') {
				jQuery('.login-alert').fadeIn();
				return false;
			}
		});
	});
</script>
</head>

<body class="loginpage">

	<div class="loginpanel" id="mainWrapper">
		<div class="loginpanelinner">
			<div class="logo animate0 bounceIn">
				<img src="${imglogo}" alt="" />
			</div>
			
			<c:url var="_login_" value="/login"></c:url>
			<form:form action="${_login_}" id="login" method="post"
				class="form-horizontal">
				<div class="inputwrapper animate5 bounceIn">
					<c:if test="${param.error != null}">
						<div class="alert alert-error">Nom d'utilisateur ou mot de
							passe incorrect</div>
					</c:if>
					<c:if test="${param.logout != null}">
						<div class="alert alert-success">
							<p>Vous êtes déconnectés</p>
						</div>
					</c:if>
				</div>
				<div class="inputwrapper animate1 bounceIn">
					<input type="text" name="ssoId" id="username"
						placeholder="Nom d'utilisateur" />
				</div>
				<div class="inputwrapper animate2 bounceIn">
					<input type="password" name="password" id="password"
						placeholder="Mot de passe" />
				</div>
				<div class="inputwrapper animate3 bounceIn">
					<button name="submit" type="submit">Se connecter</button>
				</div>
				<div class="inputwrapper animate4 bounceIn">
					<div class="checkbox">
						<label><input type="checkbox" id="rememberme"
							name="remember-me" class="remember"> Se rappeler de moi</label>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />

				</div>

			</form:form>
		</div>
		<!--loginpanelinner-->
	</div>
	<!--loginpanel-->

	<div class="loginfooter">
		<p>&copy; 2019. KM-Panel KomoCash All Rights Reserved.</p>
	</div>

</body>
</html>
