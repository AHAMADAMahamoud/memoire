<%@include file="entete.jsp"%>


<script type="text/javascript">
	function checkForm(form) // Submit button clicked
	{
		form.btsubmit.disabled = true;
		form.btsubmit.value = "Veuillez patienter pendant le traitement ETL ...";
		showImage();
		return true;
	}
	function showImage() {
		var img = document.getElementById('imgload');
		img.style.visibility = 'visible';
	}
</script>





  <%@include file="menu_gauche.jsp"%>
    
    <div class="rightpanel">
        
        
        
        <div class="pageheader">
             <div class="pageicon"><span class="iconfa-laptop"></span></div>
            <div class="pagetitle">
                <h5>Administration decisionnel de KomoCache</h5>
                <h1>Chargement des données (ETL)</h1>
            </div>
        </div><!--pageheader-->
        
     <div class="maincontent">
            <div class="maincontentinner">
      
                    <div class="clearfix"></div><br /><br />
              
                  
                    <div id="wizard2" class="wizard wizard-inverse">
                    	<br />
                        <ul class="hormenu">
                            <li>
                            	<a href="#wiz2step1">
                                	<span class="h2">Etape 1</span>
                                    <span class="label"><c:out value="${msg}" /></span>
                                </a>
                            </li>
                            <li>
                            	<a href="#wiz2step2">
                                	<span class="h2">Etape 2</span>
                                    <span class="label">Chargement des faits</span>
                                </a>
                            </li>
                            <li>
                            	<a href="#wiz2step3">
                                	<span class="h2">Etape 3</span>
                                    <span class="label">Validation du chargement</span>
                                </a>
                            </li>
                        </ul>
                                                	
                        <div id="wiz2step1" class="formwiz">
                        	<h4 class="widgettitle">Etape 1: chargement et Netoyage des données des dimensions</h4>
							
							<c:url var="addAction_dim" value="/run_dimension"></c:url>

								<form:form action="${addAction_dim}" modelAttribute="temp"
									onsubmit="return checkForm(this);" class="form-signin">
								<c:if test="${class_info!=null}">
								<div style="margin: 20px" class="alert <c:out value="${class_info}" />">
	                              <button data-dismiss="alert" class="close" type="button">×</button>
	                              <strong><c:out value="${info}" /></strong>  <c:out value="${info_suite}" />
	  							</div>
 							 </c:if>
								<table>
									<tr>
										<p style="padding: 20px" align="center">
											Les extensions des fichiers de données authorisées sont :<font color="magenta">.sql</font>,
											<font color="magenta"> .xls</font> et <font color="magenta">
												.csv</font> 
												
												<input type="text" name="directory" class="input-block-level" value="<c:out value="${dossier}" />" readonly="readonly">
						
								<button class="btn btn-primary" name="btsubmit">Lancer le chargement</button> <button class="btn">Annuler</button>
										<div id="imgload" style="visibility: hidden;" align="center">
												<img alt="Loading"
													src="http://preloaders.net/preloaders/15/No%20trespassing.gif">
											</div>
						                            
						   				</p>                         
												</tr>
								</table>
							</form:form>
	
                            
                        </div><!--#wiz1step1-->
                        
                        <div id="wiz2step2" class="formwiz">
                        	<h4 class="widgettitle">Etape 2: Recherche des clé de substitution et chargement de la table de fait</h4>
                              <div style="margin: 20px" class="alert alert-infos">
	                              <button data-dismiss="alert" class="close" type="button">×</button>
	                              <strong>Information: </strong> Cette etape prend beacoup de temps selon la taille des donnée en entré
	  							</div>
	  							
                               <c:url var="addAction_fait" value="/run_fact"></c:url>

								<form:form action="${addAction_fait}" modelAttribute="temp"
									onsubmit="return checkForm(this);" class="form-signin">
								<c:if test="${class_info!=null}">
								<div style="margin: 20px" class="alert <c:out value="${class_info}" />">
	                              <button data-dismiss="alert" class="close" type="button">×</button>
	                              <strong><c:out value="${info}" /></strong>  <c:out value="${info_suite}" />
	  							</div>
 							 </c:if>
								<table>
									<tr>
										<p style="padding: 20px" align="center">
											Les extensions des fichiers de données authorisées sont :<font color="magenta">.sql</font>,
											<font color="magenta"> .xls</font>, <font color="magenta"> .xlsx</font> et <font color="magenta">
												.csv</font> 
												
												<input type="text" name="directory" class="input-block-level" value="<c:out value="${dossier}" />" readonly="readonly">
						
								<button class="btn btn-primary" name="btsubmit">Lancer le chargement</button> <button class="btn">Annuler</button>
										<div id="imgload" style="visibility: hidden;" align="center">
												<img alt="Loading"
													src="http://preloaders.net/preloaders/15/No%20trespassing.gif">
											</div>
						                            
						   				</p>                         
												</tr>
								</table>
							</form:form>
                               
                                                                                               
                        </div><!--#wiz1step2-->
                        
                        <div id="wiz2step3">
                        	<h4 class="widgettitle">Step 3: Terms of Agreement</h4>
                            <div class="par terms" style="padding: 0 20px;">
                                <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.</p>
                                <p>Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?</p>
                                <p><input type="checkbox"  /> I agree with the terms and agreement...</p>
                            </div>
                        </div><!--#wiz1step3-->
                        
                    </div><!--#wizard-->
         
                    
 <%@include file="pied.jsp"%>