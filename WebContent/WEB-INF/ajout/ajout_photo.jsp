<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="v" class="validation.Validation" scope="request" />
<jsp:useBean id="msg" class="java.lang.String" scope="request" />

<div class="row justify-content-md-center">
  <div class="col-md-6">
		<h2 class="mb-4">Ajout d'un Photo</h2>
		    
    <c:if test="${msg != ''}">
      <div class="alert alert-success" role="alert">
        ${msg}
      </div>
    </c:if>
		
		<form method="POST" action="AjoutPhoto" class="needs-validation p-4 border rounded" enctype="multipart/form-data" novalidate>
      <div class="form-row">
			  <div class="col-md-12 mb-3">
		      <label for="date">Date</label>
		      <input type="text" class="form-control" name="date" id="date" placeholder="aaaa-mm-jj" required>
		      <div class="invalid-feedback">Saisissez la date en format aaaa-mm-jj s'il vous plaît.</div>
		      <div class="text-danger mt-2">${v.erreurs['date']}</div>
		    </div>
	    </div>
	    <div class="form-row">
		    <div class="col-md-12 mb-3">
	        <div class="custom-file">
	          <input type="file" class="custom-file-input" name="zip" id="zip" lang="fr" accept=".jpg, .jpeg, .png" required>
	          <label class="custom-file-label" for="zip">Choisir un fichier</label>
	          <div class="invalid-feedback">
	            Choisissez un fichier s'il vous plaît.
	          </div>
	        </div>
	      </div>
      </div>      
		  <button type="submit" class="btn btn-primary btn-block my-4">Envoyer</button>
		</form>
	</div>
</div>