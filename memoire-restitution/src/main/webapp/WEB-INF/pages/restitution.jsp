<%@include file="entete.jsp"%>

<%@include file="menu_gauche.jsp"%>

<div class="rightpanel">

	<div class="pageheader">
            <form action="results.html" method="post" class="searchbar">
                <input type="text" name="keyword" placeholder="To search type and hit enter..." />
            </form>
            <div class="pageicon"><span class="iconfa-table"></span></div>
            <div class="pagetitle">
               <h5>Administration decisionnel de KomoCache</h5>
			<h1>Gestion des rapports</h1>
            </div>
        </div><!--pageheader-->

	<div class="maincontent">
					<div class="maincontentinner">
					
					
					  <h4 class="widgettitle">Liste rapports disponibles</h4>
                <table class="table responsive">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Date Ajout</th>
                            <th>Requête Standard</th>
                           <!--   <th>Requête SQL</th>-->
                            <th>Dernière rapport</th>
                            <th>Etat</th>
                            <th></th>
                        </tr>
                    </thead>
                      <tbody>
                     <c:forEach items="${listrequete}" var="requete"> 
                     <!-- <c:set var = "sqlQ" value = "${requete.requetteSql}"/>-->
                        <tr>
                            <td></td>
                            <td>${requete.dateInsert}</td>
                            <td>${requete.requetteFr}</td>
                            <!--  <td>${fn:substring(sqlQ, 0, 100)}...</td>-->
                            <td>${requete.dateExecution}</td>
                            <td>${requete.etatReq}</td>
                             <td><a class="btn btn-info alertinfo" href="open_restitution?req_id=${requete.id}"><small>Afficher le rapport</small></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                
                <div class="divider15"></div>

			<%@include file="pied.jsp"%>