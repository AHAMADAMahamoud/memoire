<%@include file="entete.jsp"%>


<%@include file="menu_gauche.jsp"%>

<
<style>
<!--
-->
.reset-this {
	animation: none;
	animation-delay: 0;
	animation-direction: normal;
	animation-duration: 0;
	animation-fill-mode: none;
	animation-iteration-count: 1;
	animation-name: none;
	animation-play-state: running;
	animation-timing-function: ease;
	backface-visibility: visible;
	background: 0;
	background-attachment: scroll;
	background-clip: border-box;
	background-color: transparent;
	background-image: none;
	background-origin: padding-box;
	background-position: 0 0;
	background-position-x: 0;
	background-position-y: 0;
	background-repeat: repeat;
	background-size: auto auto;
	border: 0;
	border-style: none;
	border-width: medium;
	border-color: inherit;
	border-bottom: 0;
	border-bottom-color: inherit;
	border-bottom-left-radius: 0;
	border-bottom-right-radius: 0;
	border-bottom-style: none;
	border-bottom-width: medium;
	border-collapse: separate;
	border-image: none;
	border-left: 0;
	border-left-color: inherit;
	border-left-style: none;
	border-left-width: medium;
	border-radius: 0;
	border-right: 0;
	border-right-color: inherit;
	border-right-style: none;
	border-right-width: medium;
	border-spacing: 0;
	border-top: 0;
	border-top-color: inherit;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
	border-top-style: none;
	border-top-width: medium;
	bottom: auto;
	box-shadow: none;
	box-sizing: content-box;
	caption-side: top;
	clear: none;
	clip: auto;
	color: inherit;
	columns: auto;
	column-count: auto;
	column-fill: balance;
	column-gap: normal;
	column-rule: medium none currentColor;
	column-rule-color: currentColor;
	column-rule-style: none;
	column-rule-width: none;
	column-span: 1;
	column-width: auto;
	content: normal;
	counter-increment: none;
	counter-reset: none;
	cursor: auto;
	direction: ltr;
	display: inline;
	empty-cells: show;
	float: none;
	font: normal;
	font-family: inherit;
	font-size: medium;
	font-style: normal;
	font-variant: normal;
	font-weight: normal;
	height: auto;
	hyphens: none;
	left: auto;
	letter-spacing: normal;
	line-height: normal;
	list-style: none;
	list-style-image: none;
	list-style-position: outside;
	list-style-type: disc;
	margin: 0;
	margin-bottom: 0;
	margin-left: 0;
	margin-right: 0;
	margin-top: 0;
	max-height: none;
	max-width: none;
	min-height: 0;
	min-width: 0;
	opacity: 1;
	orphans: 0;
	outline: 0;
	outline-color: invert;
	outline-style: none;
	outline-width: medium;
	overflow: visible;
	overflow-x: visible;
	overflow-y: visible;
	padding: 0;
	padding-bottom: 0;
	padding-left: 0;
	padding-right: 0;
	padding-top: 0;
	page-break-after: auto;
	page-break-before: auto;
	page-break-inside: auto;
	perspective: none;
	perspective-origin: 50% 50%;
	position: static;
	/* May need to alter quotes for different locales (e.g fr) */
	quotes: '\201C' '\201D' '\2018' '\2019';
	right: auto;
	tab-size: 8;
	table-layout: auto;
	text-align: inherit;
	text-align-last: auto;
	text-decoration: none;
	text-decoration-color: inherit;
	text-decoration-line: none;
	text-decoration-style: solid;
	text-indent: 0;
	text-shadow: none;
	text-transform: none;
	top: auto;
	transform: none;
	transform-style: flat;
	transition: none;
	transition-delay: 0s;
	transition-duration: 0s;
	transition-property: none;
	transition-timing-function: ease;
	unicode-bidi: normal;
	vertical-align: baseline;
	visibility: visible;
	white-space: normal;
	widows: 0;
	width: auto;
	word-spacing: normal;
	z-index: auto;
	/* basic modern patch */
	all: initial;
	all: unset;
}
</style>
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
						<p> Requête : <b>${req.requetteFr}</b>&nbsp;&nbsp; | &nbsp;&nbsp; Envoyé le :<span class="text-error">${req.dateInsert}</span> &nbsp;&nbsp; | &nbsp;&nbsp; Statut :<span class="text-info">${req.etatReq}</span><p>
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


									<article style="margin: 0px;">
										<textarea id="code_src" name="code_src">${req.requetteSql}</textarea>

									</article>
							<span class="label">ISO/CEI 9075:2008	SQL:2008</span>
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