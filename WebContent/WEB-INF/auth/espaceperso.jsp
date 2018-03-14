<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="manager" class="manager.Manager" scope="session" />
<jsp:useBean id="content" class="java.lang.String" scope="request"/>

<div class="row">
  <div class="col-md-12">
    <h1 class="mb-4">Bonjour, ${manager.ident}</h1>

		<c:if test="${not manager.identifie}">
		  Lídentification n'a pas été effectuée
		</c:if>
		      
    <c:if test="${manager.identifie}">    
			<div class="row">
			  <div class="col-md-3 bd-right">
					<div class="nav flex-column nav-pills my-3" id="" aria-orientation="vertical">
					  <a class="nav-link npill bg-primary text-white"  href="EscpacePersonnel">Meteo</a>
			      <a class="nav-link npill bg-primary text-white"  href="AjoutZip">AjoutZip</a>
			      <a class="nav-link npill bg-primary text-white"  href="AjoutLigne">AjoutLigne</a>
			      <a class="nav-link npill bg-primary text-white"  href="AjoutPhoto">Ajouter un photo</a>
			      <a class="nav-link npill bg-primary text-white"  href="#">Modification d'une donnée</a>
			      <a class="nav-link npill bg-danger text-white"  href="Deconnection">
			       <i class="material-icons">exit_to_app</i> 
			       <span>Se déconnecter</span>
			      </a>
					</div>
				</div>
				<div class="col-md-9">
				 <jsp:include page="${content}" />
				</div>
			</div>
    </c:if>
  </div>
</div>