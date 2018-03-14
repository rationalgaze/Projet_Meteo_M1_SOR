<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="row justify-content-md-center">
  <div class="col-md-6">
		<h2 class="mb-4">Ajout archive</h2>
		
		<form class="needs-validation p-4 border rounded" novalidate>

			  <div class="custom-file">
			    <input type="file" class="custom-file-input" id="zip" lang="fr" required>
			    <label class="custom-file-label" for="zip">Choisir un fichier</label>
			    <div class="invalid-feedback">
	          Choisissez un fichier s'il vous plaît.
	        </div>
			  </div>

		  <button type="submit" class="btn btn-primary btn-block my-4">Envoyer</button>
		</form>
	</div>
</div>