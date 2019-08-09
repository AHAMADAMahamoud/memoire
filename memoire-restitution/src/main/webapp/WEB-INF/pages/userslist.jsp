<%@include file="entete.jsp"%>
    
  <%@include file="menu_gauche.jsp"%>
    
    <div class="rightpanel">
        
        <div class="pageheader">
            <div class="pageicon"><span class="iconfa-laptop"></span></div>
            <div class="pagetitle">
                <h5>Administration decisionnel de KomoCache</h5>
                <h1>Gestion des utilisateurs</h1>
            </div>
        </div><!--pageheader-->
        
        <div class="maincontent">
            <div class="maincontentinner">
		  <h4 class="widgettitle">Liste des utilisateur de l'application</h4>
			<table class="table responsive">
	    		<thead>
		      		<tr>
				        <th>Firstname</th>
				        <th>Lastname</th>
				        <th>Email</th>
				        <th>SSO ID</th>
				        <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
				        	<th width="100"></th>
				        </sec:authorize>
				        <sec:authorize access="hasRole('ADMIN')">
				        	<th width="100"></th>
				        </sec:authorize>
				        
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.email}</td>
						<td>${user.ssoId}</td>
					    <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
							<td><a href="<c:url value='/edit-user-${user.ssoId}' />" class="btn btn-success custom-width">edit</a></td>
				        </sec:authorize>
				        <sec:authorize access="hasRole('ADMIN')">
							<td><a href="<c:url value='/delete-user-${user.ssoId}' />" class="btn btn-danger custom-width">delete</a></td>
        				</sec:authorize>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
	
		<sec:authorize access="hasRole('ADMIN')">
		 	<div class="well">
		 		<a class="btn btn-inverse alertinverse" href="<c:url value='/newuser' />">
		 		<small>Ajouter un utilisateur</small></a>
		 	</div>
	 	</sec:authorize>
	 	</div>
        </div><!--maincontent-->
        
    </div><!--rightpanel-->
   <%@include file="accueil_pied.jsp"%>