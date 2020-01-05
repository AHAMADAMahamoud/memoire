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
									<li><a href="/modifier_request?code=${requete.codeReq}">${requete.requetteFr}
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
							<form:form class="stdform" action="/ajout_nouveau_request"
								method="post">

								<c:if test="${class_info!=null}">
									<div style="margin: 20px"
										class="alert <c:out value="${class_info}" />">
										<button data-dismiss="alert" class="close" type="button">×</button>
										<strong><c:out value="${info}" /></strong>
										<c:out value="${info_suite}" />
									</div>
								</c:if>
								<p>
								<p>
									<label>${req.requetteFr}</label>
								</p>

								<article style="margin: 0px">
										<textarea id="code_src" name="code_src" >${req.requetteSql}</textarea>

								</article>
								<p class="stdformbutton">
									<a href="/tester_request?code=${req.codeReq}"
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