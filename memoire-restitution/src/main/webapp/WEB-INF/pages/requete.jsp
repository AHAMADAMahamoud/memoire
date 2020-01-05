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
											<li><a href="/modifier_request?code=${requete.codeReq}">${requete.requetteFr} </a></li>
											</c:forEach>
													</ul>
									</div>
								</div>

							</div>
							<!--span4-->
							<div class="span8">
								<div class="widgetbox personal-information">
									<h4 class="widgettitle">Chargment des requettes</h4>
									<div class="widgetcontent">
										<form:form class="stdform" action="/ajout_nouveau_request" method="post">

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
												<label>Ou <c:if test="${req==null}">ajouter un nouveau</c:if><c:if test="${req!=null}">mettre à jour la</c:if>  requête</label> 
												<span class="field"><textarea cols="80" rows="5" class="span5" name="requet">${req.requetteFr}</textarea></span>
											
												<label>Code requête</label> <span class="field"><input type="text" class="span2"  name="code"value="${req.codeReq}"/></span>
											</p>

											<p class="stdformbutton">
												<button class="btn btn-primary">Enregistrer</button>
												<a href="open_accueil_requette" class="btn btn-info">Annuler</a>
											</p>

										</form:form>

									</div>
								</div>



							</div>
							<!--span8-->
						</div>
						<!--row-fluid-->

						



			<%@include file="pied.jsp"%>