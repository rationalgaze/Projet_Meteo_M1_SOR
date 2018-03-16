<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="msg" class="java.lang.String" scope="request" />

<div class="row justify-content-md-center">
<h2 class="mb-4">Ajouter des données à partir d'un fichier</h2>
  <div class="col-md-6">
				
		<c:if test="${msg == '1'}">
      <div class="alert alert-success" role="alert">
        Les données ont été bien modifié dans la Base De Données
      </div>
    </c:if>
    
    <c:if test="${msg == '0'}">
      <div class="alert alert-danger" role="alert">
        Les données n'ont pas été inseré dans la Base De Données:
        les données déjà existent
      </div>
    </c:if>
    
		<form method="POST" action="AjoutMany" class="needs-validation p-4 border rounded" enctype="multipart/form-data" novalidate>

		  <div class="custom-file">
		    <input type="file" class="custom-file-input" id="zip" name="zip" lang="fr" accept=".txt, .doc" required>
		    <label class="custom-file-label" for="zip">Choisir un fichier</label>
		    <div class="invalid-feedback">
          Choisissez un fichier s'il vous plaît.
        </div>
		  </div>

		  <button type="submit" class="btn btn-primary btn-block my-4">Envoyer</button>
		</form>
	</div>
</div>