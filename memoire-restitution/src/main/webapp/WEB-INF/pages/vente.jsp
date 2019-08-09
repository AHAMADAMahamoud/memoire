<%@include file="entete.jsp"%>

<%@include file="menu_gauche.jsp"%>

<div class="rightpanel">

	<div class="pageheader">
		<div class="pageicon">
			<span class="iconfa-pencil"></span>
		</div>
		<div class="pagetitle">
			<h5>Administration decisionnel de KomoCache</h5>
			<h1>
				<c:out value="${msg}" />
			</h1>
		</div>
	</div>
	<!--pageheader-->
	
	<h4 class="widgettitle">Liste des ventes disponibles</h4>

	<div class="maincontent">
		<div class="maincontentinner">
			<div class="row-fluid">
				<div class="span4 profile-left"></div>
				<!--span4-->

			</div>
			<!--row-fluid-->

			<%@include file="pied.jsp"%>