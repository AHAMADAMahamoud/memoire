<%@include file="entete.jsp"%>
    
  <%@include file="menu_gauche.jsp"%>
    
    <div class="rightpanel">
        
        <div class="pageheader">
            <div class="pageicon"><span class="iconfa-laptop"></span></div>
            <div class="pagetitle">
                <h5>Administration decisionnel de KomoCache</h5>
                <h1>Tableau de bord</h1>
            </div>
        </div><!--pageheader-->
        
        <div class="maincontent">
            <div class="maincontentinner">
                <div class="row-fluid">
                    <div id="dashboard-left" class="span8">
                        
                        <h5 class="subtitle">Demandes plus courantes</h5>
                        <ul class="shortcuts">
                            <li class="events">
                                <a href="open_chiffredaffaire">
                                    <span class="shortcuts-icon iconsi-event"></span>
                                    <span class="shortcuts-label" style="text-align: center;">CA / Ans</span>
                                </a>
                            </li>
                            <li class="products">
                                <a href="open_produits">
                                    <span class="shortcuts-icon iconsi-cart"></span>
                                    <span class="shortcuts-label" style="text-align: center;">Produits</span>
                                </a>
                            </li>
                            <li class="archive">
                                <a href="open_ventes">
                                    <span class="shortcuts-icon iconsi-archive"></span>
                                    <span class="shortcuts-label" style="text-align: center;">Ventes</span>
                                </a>
                            </li>
                            <li class="help">
                                <a href="open_recettes">
                                    <span class="shortcuts-icon iconsi-help"></span>
                                    <span class="shortcuts-label" style="text-align: center;">Recettes</span>
                                </a>
                            </li>
                            
                        </ul>
                        
                        <br />
                        
                        <h5 class="subtitle">Ventes du mois en cours par île</h5><br />
                        <div id="chartplace" style="height:300px;"></div>
                        
                        <div class="divider30"></div>
                        
                        <table class="table table-bordered responsive">
                            <thead>
                                <tr>
                                    <th class="head1">Rendering engine</th>
                                    <th class="head0">Browser</th>
                                    <th class="head1">Platform(s)</th>
                                    <th class="head0">Engine version</th>
                                    <th class="head1">CSS grade</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Trident</td>
                                    <td>Internet  Explorer 5.5</td>
                                    <td>Win 95+</td>
                                    <td class="center">5.5</td>
                                    <td class="center">A</td>
                                </tr>
                                <tr>
                                    <td>Trident</td>
                                    <td>Internet Explorer 6</td>
                                    <td>Win 98+</td>
                                    <td class="center">6</td>
                                    <td class="center">A</td>
                                </tr>
                                <tr>
                                    <td>Trident</td>
                                    <td>Internet Explorer 7</td>
                                    <td>Win XP SP2+</td>
                                    <td class="center">7</td>
                                    <td class="center">A</td>
                                </tr>
                            </tbody>
                        </table>
                        
                        <br />
                     
                    </div><!--span8-->
                    
                    <div id="dashboard-right" class="span4">
                        
                        <h5 class="subtitle">Announcements</h5>
                        
                        <div class="divider15"></div>
                        
                        <div class="alert alert-block">
                              <button data-dismiss="alert" class="close" type="button">&times;</button>
                              <h4>Warning!</h4>
                              <p style="margin: 8px 0">Best check yo self, you're not looking too good. Nulla vitae elit libero, a pharetra augue. Praesent commodo cursus magna.</p>
                        </div><!--alert-->
                        
                        <br />
                        
                        <h4 class="widgettitle">Calendarier</h4>
                        <div class="widgetcontent nopadding">
                            <div id="datepicker"></div>
                        </div>
                        
                     <br>
                                                
                    </div><!--span4-->
                </div><!--row-fluid-->
                
                <!-- <div class="footer">
                    <div class="footer-left">
                        <span>&copy; 2016. KM-Panel Comoressoft All Rights Reserved.</span>
                    </div>
                    <div class="footer-right">
                      
                    </div>
                </div>footer -->
                
            </div><!--maincontentinner-->
        </div><!--maincontent-->
        
    </div><!--rightpanel-->
   <%@include file="accueil_pied.jsp"%>