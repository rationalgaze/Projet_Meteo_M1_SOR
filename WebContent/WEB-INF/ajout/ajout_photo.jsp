<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="v" class="validation.Validation" scope="request" />

<div class="row justify-content-md-center">
  <div class="col-md-6">
		<h2 class="mb-4">Ajout d'un Photo</h2>
		
		<form method="POST" action="" class="needs-validation p-4 border rounded" novalidate>
      <div class="form-row">
			  <div class="col-md-12 mb-3">
		      <label for="date">Date</label>
		      <input type="text" class="form-control" name="date" id="date" placeholder="jj/mm/aaaa" required>
		      <div class="invalid-feedback">Saisissez la date en format jj/mm/aaaa s'il vous plaît.</div>
		      <div class="text-danger mt-2">${v.erreurs['date']}</div>
		    </div>
	    </div>
	    <div class="form-row">
		    <div class="col-md-12 mb-3">
	        <div class="custom-file">
	          <input type="file" class="custom-file-input" id="zip" lang="fr" required>
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