<%@include file="entete.jsp"%>



<%@include file="menu_gauche.jsp"%>

<div class="rightpanel">



	<div class="pageheader">
		<div class="pageicon">
			<span class="iconfa-pencil"></span>
		</div>
		<div class="pagetitle">
			<h5>Administration decisionnel de KomoCache</h5>
			<h1>Gestion des requêtes</h1>
		</div>
	</div>
	<!--pageheader-->

	<div class="maincontent">
					<div class="maincontentinner">
						<div class="row-fluid">
							<div class="span4 profile-left">



								<div class="widgetbox tags">
									<h4 class="widgettitle">Requêtes prétes pour reporting</h4>
									<div class="widgetcontent">
										<ul class="taglist">
										<c:forEach items="${listrequete}" var="requete"> 
											<li><a href="">${requete.requetteFr} </a></li>
											</c:forEach>
													</ul>
										<a href="" style="display: block; margin-top: 10px">Editer</a>
									</div>
								</div>

							</div>
							<!--span4-->
							<div class="span8">
								<div class="widgetbox personal-information">
									<h4 class="widgettitle">Chargment des requettes</h4>
									<div class="widgetcontent">
										<form class="stdform" action="forms.html" method="post">

											<c:if test="${class_info!=null}">
												<div style="margin: 20px"
													class="alert <c:out value="${class_info}" />">
													<button data-dismiss="alert" class="close" type="button">×</button>
													<strong><c:out value="${info}" /></strong>
													<c:out value="${info_suite}" />
												</div>
											</c:if>

											<p class="stdformbutton">
												<a href="load_default_request" class="btn btn-info">Charger
													Les requêtes pardefaut</a>
											</p>


											<p>
												<label>Ou Ajouter un nouveau requête</label> <span
													class="field"><textarea cols="80" rows="5"
														class="span5"></textarea></span>
											</p>

											<p class="stdformbutton">
												<button class="btn btn-primary">Enregistrer</button>
												<button class="btn btn-primary" disabled="disabled">Enregistrer
													et lancer la transcription</button>
											</p>

										</form>

									</div>
								</div>



							</div>
							<!--span8-->
						</div>
						<!--row-fluid-->

						



			<%@include file="pied.jsp"%>