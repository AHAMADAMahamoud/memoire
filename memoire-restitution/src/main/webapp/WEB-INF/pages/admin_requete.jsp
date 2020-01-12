<%@include file="entete.jsp"%>


<%@include file="menu_gauche.jsp"%>

<div class="rightpanel">



	<div class="pageheader">
		<div class="pageicon">
			<span class="iconfa-pencil"></span>
		</div>
		<div class="pagetitle">
			<h5>Administration decisionnel de KomoCache</h5>
			<h1>${msg}</h1>
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
									<li><a href="/editer_request?code=${requete.codeReq}">${requete.requetteFr}
									</a></li>
								</c:forEach>
							</ul>
						</div>
					</div>

				</div>
				<!--span4-->
				<div class="span8">
					<div class="widgetbox personal-information">
						<h4 class="widgettitle">Outils d'edition</h4>
						<div class="widgetcontent">
							<p>
								Requête : <b>${req.requetteFr}</b>&nbsp;&nbsp; | &nbsp;&nbsp;
								Envoyé le :<span class="text-error">${req.dateInsert}</span>
								&nbsp;&nbsp; | &nbsp;&nbsp; Statut :<span class="text-info">${req.etatReq}</span>
							<p>
								<form:form class="stdform" action="/ajout_request_traduit"
									method="post">

									<c:if test="${class_info!=null}">
										<div style="margin: 20px"
											class="alert <c:out value="${class_info}" />">
											<button data-dismiss="alert" class="close" type="button">×</button>
											<strong><c:out value="${info}" /></strong>
											<c:out value="${info_suite}" />
										</div>
									</c:if>


									<article style="margin: 0px;">
										<textarea id="code_src" name="code_src">${req.requetteSql}</textarea>

									</article>
									<span class="label">ISO/CEI 9075:2008 SQL:2008</span>
									<p>
										<label>Graphe du resultat</label> <select name="resultat_graph">
											<option value="bargraphe">Bar graphe</option>
											<option value="courbegraphe">Courbe graphe</option>
										</select>
										<input type="hidden" class="span2"  name="idr"value="${req.id}"/>
									</p>
									<p class="stdformbutton">
										<a href="/tester_request?idr=${req.id}"
											class="btn btn-info">Tester</a>
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


			<script>
				CodeMirror.commands.save = function() {
					var elt = editor.getWrapperElement();
					elt.style.background = "#def";
					setTimeout(function() {
						elt.style.background = "";
					}, 300);
				};
				var editor = CodeMirror.fromTextArea(document
						.getElementById("code_src"), {
					lineNumbers : true,
					mode : "text/x-csrc",
					matchBrackets : true,
					keyMap : "emacs"
				});
			</script>


			<%@include file="pied.jsp"%>