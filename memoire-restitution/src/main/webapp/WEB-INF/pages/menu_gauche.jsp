<div class="leftpanel">

	<div class="leftmenu">
		<ul class="nav nav-tabs nav-stacked">
			<li class="nav-header">Navigation</li>
			<li class="${active_home}"><a
				href="<%=request.getContextPath()%>/accueil"><span
					class="iconfa-laptop"></span> Accueil</a></li>
			<li class="${active_req}"><a href="open_accueil_requette"><span
					class="iconfa-th-list"></span> Gestion des requ�tes</a></li>
			<li class="${active_rest}"><a href="open_accueil_restitution"><span
					class="iconfa-signal"></span> Reporting Managment</a></li>
		
			<li class="dropdown ${active_param}"><a href="open_parametre"><span class="iconfa-book"></span>Parametrages</a>
				<ul>
					<li><a href="admin_requete">Outil d'administration des requ�tes</a></li>
					<li><a href="">Mes messages</a></li>
				</ul></li>
		</ul>
	</div>
	<!--leftmenu-->

</div>
<!-- leftpanel -->