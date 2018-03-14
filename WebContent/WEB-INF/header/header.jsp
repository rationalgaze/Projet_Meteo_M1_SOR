<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="contenu" class="java.lang.String" scope="request"/>
<jsp:useBean id="manager" class="manager.Manager" scope="session" />
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Projet Meteo</title>

  <script type="text/javascript" src="js/jquery/jquery-3.2.1.min.js"></script>
  
  <link rel="stylesheet" href="js/bootstrap/css/bootstrap.min.css">
  <script type="text/javascript" src="js/bootstrap/js/bootstrap.min.js"></script>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link rel="stylesheet" href="styles/styles.css" />
</head>

<body>
  <header class="site-nav navbar flex-column flex-md-row sticky-top py-2">
    <div class="container">
      <a class="py-2 navbar-brand" href="Accueil">
        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="d-block mx-auto"><circle cx="12" cy="12" r="10"></circle><line x1="14.31" y1="8" x2="20.05" y2="17.94"></line><line x1="9.69" y1="8" x2="21.17" y2="8"></line><line x1="7.38" y1="12" x2="13.12" y2="2.06"></line><line x1="9.69" y1="16" x2="3.95" y2="6.06"></line><line x1="14.31" y1="16" x2="2.83" y2="16"></line><line x1="16.62" y1="12" x2="10.88" y2="21.94"></line></svg>
      </a>
      <ul class="nav justify-content-center">
        <c:if test="${manager.identifie}">
		      <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${manager.ident}</a>
	          <div class="dropdown-menu">
	            <a class="dropdown-item text-secondary" href="EscpacePersonnel">Mon compte</a>
              <a class="dropdown-item text-secondary" href="Deconnection">Se déconnecter</a>
            </div>
	        </li>
		    </c:if>
		    <c:if test="${not manager.identifie}">
				  <li class="nav-item">
				    <a class="nav-link" href="Connection">Se connecter</a>
				  </li>
				</c:if>
			</ul>
    </div>
  </header>
  
  <main class="py-4">
	  <div class="container">
	    <!-- deb page normale -->
	    <div class="row">
	      <div class="col">
	        <div id="text_contenu" class="text contenu">
	          <!-- contenu  -->
            <jsp:include page="${contenu}" />
	        </div>
	      </div>
	    </div>
	  </div>
  </main>
  <!-- <script type="text/javascript" src="js/main.js"></script> -->
</body>
</html>