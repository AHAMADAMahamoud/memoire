<%@include file="entete.jsp"%>

<c:url value="/ressources/js/jquery.1.10.2.min.js" var="jqueryJS" />
<c:url value="/ressources/js/jquery.autocomplete.min.js"
	var="autocompletJS" />
<script type="text/javascript" src="${jqueryJS}"></script>
<script type="text/javascript" src="${autocompletJS}"></script>

<c:url value="/ressources/css/requetage/design.css" var="designeCSS" />
<c:url value="/ressources/css/requetage/requete.css"
	var="requeteCSS" />
<link href="${designeCSS}" rel="stylesheet" />
<link href="${requeteCSS}" rel="stylesheet" />
<style>
.autocomplete-suggestions {
	border: 1px solid #999;
	background: #FFF;
	overflow: auto;
}

.autocomplete-suggestions {
	padding: 5px 5px;
	white-space: nowrap;
	overflow: hidden;
	font-size: 22px
}

.autocomplete-selected {
	background: #F0F0F0;
}

.autocomplete-suggestions strong {
	font-weight: bold;
	color: #3399FF;
}
</style>
<h1 align="center" >
	<u><c:out value="${msg}" /></u>
</h1>

<div class="container">
	<form class="form">
		<h2 class="form-signin-heading">Veiller saisir une requ�te:</h2>
		<input type="text" id="inputRequete" class="form-control"
			placeholder="Une requ�te � saisir" required="" autofocus=""
			style="font-size: 18px;">
	</form>

	<form class="form-signin">
		<button class="btn-lg btn-primary btn-block" type="submit">Envoyer</button>
	</form>

</div>
<!-- /container -->

<script>
	$(document).ready(function() {
		$('#inputRequete').autocomplete({
			serviceUrl : '${pageContext.request.contextPath}/getRequettes',
			paramName : "requetteFr",
			delimiter : ",",
			transformResult : function(response) {

				return {

					suggestions : $.map($.parseJSON(response), function(item) {
						return {
							value : item.requetteFr
						};
					})

				};

			}

		});

	});
</script>
<%@include file="pied.jsp"%>