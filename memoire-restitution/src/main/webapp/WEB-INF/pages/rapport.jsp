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
			<div class="row-fluid">
				<div id="dashboard-left" class="span6">

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
						class="btn btn-primary btn-rounded"> Enregistrer PDF</a> <a
						href="" class="btn btn-primary btn-rounded"> Enregistrer EXCEL</a>
					<br />
				</div>
				<!--span8-->

				<div id="dashboard-right" class="span5">
					<c:if test="${graphe=='chartplace' }">
						<div id="chartplace" style="height: 300px;"></div>
					</c:if>
					<c:if test="${graphe=='bargraph' }">
						<div id="bargraph" style="height: 300px;"></div>
					</c:if>
					<!--widgetcontent-->



				</div>
				<!--span4-->
			</div>
			<!--row-fluid-->


			<script type="text/javascript">
				jQuery(document)
						.ready(
								function() {

									// simple chart
									var flash = [ [ 0, 11 ], [ 1, 9 ],
											[ 2, 12 ], [ 3, 8 ], [ 4, 7 ],
											[ 5, 3 ], [ 6, 1 ] ];
									var html5 = [ [ 0, 5 ], [ 1, 4 ], [ 2, 4 ],
											[ 3, 1 ], [ 4, 9 ], [ 5, 10 ],
											[ 6, 13 ] ];
									var css3 = [ [ 0, 6 ], [ 1, 1 ], [ 2, 9 ],
											[ 3, 12 ], [ 4, 10 ], [ 5, 12 ],
											[ 6, 11 ] ];

									function showTooltip(x, y, contents) {
										jQuery(
												'<div id="tooltip" class="tooltipflot">'
														+ contents + '</div>')
												.css({
													position : 'absolute',
													display : 'none',
													top : y + 5,
													left : x + 5
												}).appendTo("body").fadeIn(200);
									}

									var plot = jQuery.plot(
											jQuery("#chartplace"), [ {
												data : flash,
												label : "Flash(x)",
												color : "#6fad04"
											}, {
												data : html5,
												label : "HTML5(x)",
												color : "#06c"
											}, {
												data : css3,
												label : "CSS3",
												color : "#666"
											} ], {
												series : {
													lines : {
														show : true,
														fill : true,
														fillColor : {
															colors : [ {
																opacity : 0.05
															}, {
																opacity : 0.15
															} ]
														}
													},
													points : {
														show : true
													}
												},
												legend : {
													position : 'nw'
												},
												grid : {
													hoverable : true,
													clickable : true,
													borderColor : '#666',
													borderWidth : 2,
													labelMargin : 10
												},
												yaxis : {
													min : 0,
													max : 15
												}
											});

									var previousPoint = null;
									jQuery("#chartplace")
											.bind(
													"plothover",
													function(event, pos, item) {
														jQuery("#x")
																.text(
																		pos.x
																				.toFixed(2));
														jQuery("#y")
																.text(
																		pos.y
																				.toFixed(2));

														if (item) {
															if (previousPoint != item.dataIndex) {
																previousPoint = item.dataIndex;

																jQuery(
																		"#tooltip")
																		.remove();
																var x = item.datapoint[0]
																		.toFixed(2), y = item.datapoint[1]
																		.toFixed(2);

																showTooltip(
																		item.pageX,
																		item.pageY,
																		item.series.label
																				+ " of "
																				+ x
																				+ " = "
																				+ y);
															}

														} else {
															jQuery("#tooltip")
																	.remove();
															previousPoint = null;
														}

													});

									jQuery("#chartplace")
											.bind(
													"plotclick",
													function(event, pos, item) {
														if (item) {
															jQuery("#clickdata")
																	.text(
																			"You clicked point "
																					+ item.dataIndex
																					+ " in "
																					+ item.series.label
																					+ ".");
															plot
																	.highlight(
																			item.series,
																			item.datapoint);
														}
													});

									/*****BAR GRAPH*****/
									var d2 = [];
									for (var i = 0; i <= 10; i += 1)
										d2.push([ i,
												parseInt(Math.random() * 30) ]);

									var stack = 0, bars = true, lines = false, steps = false;
									jQuery.plot(jQuery("#bargraph"), [ d2 ], {
										series : {
											stack : stack,
											lines : {
												show : lines,
												fill : true,
												steps : steps
											},
											bars : {
												show : bars,
												barWidth : 0.6
											}
										},
										grid : {
											hoverable : true,
											clickable : true,
											borderColor : '#666',
											borderWidth : 2,
											labelMargin : 10
										},
										colors : [ "#666" ]
									});

									//datepicker
									jQuery('#datepicker').datepicker();

									// tabbed widget
									jQuery('.tabbedwidget').tabs();

								});
			</script>


			<%@include file="pied.jsp"%>