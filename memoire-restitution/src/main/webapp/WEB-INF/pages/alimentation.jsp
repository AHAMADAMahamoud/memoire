<%@include file="entete.jsp"%>
<title>Alimentation</title>

<c:url value="/ressources/css/alimentation/design.css" var="designeCSS" />
<c:url value="/ressources/css/alimentation/alimenter.css"
	var="alimenterCSS" />

<link href="${designeCSS}" rel="stylesheet" />
<link href="${alimenterCSS}" rel="stylesheet" />

<script type="text/javascript">
	function checkForm(form) // Submit button clicked
	{
		form.btsubmit.disabled = true;
		form.btsubmit.value = "Veuillez patienter pendant le traitement ETL ...";
		showImage();
		return true;
	}
	function showImage() {
		var img = document.getElementById('imgload');
		img.style.visibility = 'visible';
	}
</script>
<div class="container">
	<h1 align="center">
		<u><c:out value="${msg}" /></u>
	</h1>

	<c:url var="addAction" value="/run_etl"></c:url>

	<form:form action="${addAction}" modelAttribute="temp"
		onsubmit="return checkForm(this);" class="form-signin">
		<table>
			<tr>
				<p>
					Le chemin vers le répertoire des fichiers(<font color="magenta">.sql</font>,
					<font color="magenta"> .xls</font> et <font color="magenta">
						.csv</font>) :
					<c:out value="${dossier}" />
				</p>
				<p>
					<input type="text" id="file" name="directory" class="form-control"
						value="<c:out value="${dossier}" />" readonly="readonly" />
				</p>
			</tr>

			<tr>
				<td><input type="submit" name="btsubmit"
					class="btn-lg btn-primary btn-block" value="< spring:message text=" Charger"/>"
					/></td>
				<td><div id="imgload" style="visibility: hidden;">
						<img alt="Loading"
							src="http://preloaders.net/preloaders/15/No%20trespassing.gif">
					</div></td>
			</tr>
		</table>
	</form:form>
	<h5 align="center">
		<font color="red"><c:out value="${info}" /></font>
	</h5>

</div>
<!-- /container -->
<br>
<br>
<br>
<%@include file="pied.jsp"%>