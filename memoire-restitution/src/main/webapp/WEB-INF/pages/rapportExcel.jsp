<%@include file="entete.jsp"%>


<c:url value="/ressources/js/jquery.dataTables.min.js" var="js13_d" />
<script type="text/javascript" src="${js13_d}"></script>
<script type="text/javascript">
	jQuery(document).ready(function() {
		// dynamic table
		jQuery('#dyntable').dataTable({
			"sPaginationType" : "full_numbers",
			"aaSortingFixed" : [ [ 0, 'asc' ] ],
			"fnDrawCallback" : function(oSettings) {
				jQuery.uniform.update();
			}
		});

	});
</script>

<%@include file="menu_gauche.jsp"%>

<div class="rightpanel">

	<div class="pageheader">

		<div class="pageicon">
			<span class="iconfa-table"></span>
		</div>
		<div class="pagetitle">
			<h5>Administration decisionnel de KomoCache</h5>
			<h1>Gestion des rapports : ${info_req}</h1>
		</div>
	</div>

	<!--page header-->
	<div class="maincontent">
		<div class="maincontentinner">

			<c:forEach items="${listresultat}" var="requete">
			</c:forEach>

			<table id="dyntable" class="table table-bordered responsive">
				<thead>
					<tr>
						<th>ID</th>
						<c:forEach begin="0" end="${culumn_size}" step="1" var="index">
							<th class="head0"><c:out value="${item[index]}" /></th>
						</c:forEach>

					</tr>
				</thead>
				<tbody>

					<c:forEach var="item" items="${listresultat}">

						<tr class="gradeX">
							<td></td>
							<c:forEach begin="0" end="${culumn_size}" step="1" var="index">
								<td><c:out value="${item[index]}" /></td>
							</c:forEach>
						</tr>

					</c:forEach>

				</tbody>
			</table>
			<br> <a href="open_restitution_pdf"
				class="btn btn-primary btn-rounded"> Enregistrer PDF</a> 
				<a href="open_restitution_Excel"
				class="btn btn-primary btn-rounded"> Enregistrer EXCEL</a> <br />

			<%@include file="pied.jsp"%>