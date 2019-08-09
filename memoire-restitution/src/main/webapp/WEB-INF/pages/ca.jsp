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
	
	<h4 class="widgettitle">Liste chiffre d'affaire disponibles</h4>

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

	<div class="row-fluid">
		<div class="span4 profile-left"></div>
		<!--span4-->

	</div>
	<!--row-fluid-->

	<%@include file="pied.jsp"%>