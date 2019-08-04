<%@include file="entete.jsp"%>

<c:url value="/ressources/css/restitution/design.css" var="designeCSS" />
<c:url value="/ressources/css/restitution/export.css"
	var="restitutionCSS" />
<link href="${designeCSS}" rel="stylesheet" />
<link href="${restitutionCSS}" rel="stylesheet" />

<h1 align="center">
	<u><c:out value="${msg}" /></u>
</h1>

<%@include file="pied.jsp"%>