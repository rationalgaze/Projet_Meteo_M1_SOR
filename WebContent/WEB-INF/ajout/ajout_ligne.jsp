<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="v" class="validation.Validation" scope="request" />
<jsp:useBean id="msg" class="java.lang.String" scope="request" />

<div class="row justify-content-md-center">
    <c:if test="${msg == '0'}">
      <div class="alert alert-success" role="alert">
        Les données ont été bien inseré dans la Base De Données 
        <button type="button" class="close ml-1" data-dismiss="alert" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
    </c:if>
    
    <c:if test="${msg == '1'}">
      <div class="alert alert-danger" role="alert">
        Les données n'ont pas été inseré dans la Base De Données. La ligne déjà existe. 
        <button type="button" class="close ml-1" data-dismiss="alert" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
    </c:if>
  <div class="col-md-6">
		<h2 class="mb-4">Ajout Ligne</h2>
				
		<form method="POST" action="AjoutLigne" class="needs-validation p-4 border rounded" novalidate>
      <div class="form-row">
			  <div class="col-md-6 mb-3">
		      <label for="date">Date</label>
		      <input type="text" class="form-control" name="date" id="date" placeholder="aaaa-mm-jj" value="${v.valeurs['d']}" required>
		      <div class="invalid-feedback">Saisissez la date en format aaaa-mm-jj s'il vous plaît.</div>
		      <div class="text-danger mt-2">${v.erreurs['d']}</div>
		    </div>
		    <div class="col-md-6 mb-3">
          <label for="date">Lieu</label>
          <input type="text" class="form-control" name="location" id="location" placeholder="Lieu" value="${v.valeurs['location']}" required>
          <div class="invalid-feedback">Saisissez un lieu s'il vous plaît.</div>
          <div class="text-danger mt-2">${v.erreurs['location']}</div>
        </div>
	    </div>
	    <div class="form-row">
		    <div class="col-md-4 mb-3">
	        <label for="min">Tmin</label>
	        <input type="text" class="form-control" name="min" id="min" placeholder="0.0" value="${v.valeurs['temp_min']}" required>
	        <div class="invalid-feedback">
	          Saisissez la temperature minimale s'il vous plaît.
	        </div>
	        <div class="text-danger mt-2">${v.erreurs['temp_min']}</div>
	      </div>
	      <div class="col-md-4 mb-3">
	        <label for="max">Tmax</label>
	        <input type="text" class="form-control" name="max" id="max" placeholder="0.0" value="${v.valeurs['temp_max']}" required>
	        <div class="invalid-feedback">
	          Saisissez la temperature maximale s'il vous plaît.
	        </div>
	        <div class="text-danger mt-2">${v.erreurs['temp_max']}</div>
	      </div>
	      <div class="col-md-4 mb-3">
	        <label for="moy">Tmoy</label>
	        <input type="text" class="form-control" name="moy" id="moy" placeholder="0.0" value="${v.valeurs['temp_moy']}" required>
	        <div class="invalid-feedback">
	          Saisissez la temperature moyenne s'il vous plaît.
	        </div>
	        <div class="text-danger mt-2">${v.erreurs['temp_moy']}</div>
	      </div>
      </div>
      <div class="form-row">
        <div class="col-md-4 mb-3">
	        <label for="rain">Pluie</label>
	        <input type="text" class="form-control" name="rain" id="rain" placeholder="0.0" value="${v.valeurs['rain']}" required>
	        <div class="invalid-feedback">
	          Saisissez le niveau de pluie s'il vous plaît.
	        </div>
	        <div class="text-danger mt-2">${v.erreurs['rain']}</div>
	      </div>
	      <div class="col-md-4 mb-3">
	        <label for="sun">Soleil</label>
	        <input type="text" class="form-control" name="sun" id="sun" placeholder="0.0" value="${v.valeurs['sun']}" required>
	        <div class="invalid-feedback">
	          Saisissez le niveau du soleil s'il vous plaît.
	        </div>
	        <div class="text-danger mt-2">${v.erreurs['sun']}</div>
	      </div>
	      <div class="col-md-4 mb-3">
	        <label for="wind">Vent</label>
	        <input type="text" class="form-control" name="wind" id="wind" placeholder="0.0" value="${v.valeurs['wind']}" required>
	        <div class="invalid-feedback">
	          Saisissez le niveau du vent s'il vous plaît.
	        </div>
	        <div class="text-danger mt-2">${v.erreurs['wind']}</div>
	      </div>
     </div>
     <div class="form-row">
        <div class="col-md-6 mb-3">
	        <label for="raf">Rafale</label>
	        <input type="text" class="form-control" name="raf" id="raf" placeholder="0.0" value="${v.valeurs['rafale']}" required>
	        <div class="invalid-feedback">
	          Saisissez la vitesse des rafales s'il vous plaît.
	        </div>
	        <div class="text-danger mt-2">${v.erreurs['rafale']}</div>
	      </div>
	      <div class="col-md-6 mb-3">
	        <label for="dir">Direction</label>null
	        <select class="custom-select" name="dir" id="dir" required>
					  <option value="${v.valeurs['direction']}" selected>${v.valeurs['direction']}</option>
					  <option value="n">n &darr;</option>
					  <option value="s">s &uarr;</option>
					  <option value="e">e &rarr;</option>
					  <option value="o">o &larr;</option>
					  <option value="no">no &#8600;</option>
					  <option value="ne">ne &#8601;</option>
					  <option value="so">so &#8599;</option>
					  <option value="se">se &#8598;</option>
					  <option value="nne">nne</option>
					  <option value="nno">nno</option>
					  <option value="sso">sso</option>
					  <option value="sse">sse</option>
					  <option value="ono">ono</option>
					  <option value="ene">ene</option>
					  <option value="oso">oso</option>
					  <option value="ese">ese</option>
					</select>
	        <div class="invalid-feedback">
	          Saisissez la direction du vent s'il vous plaît.
	        </div>
	        <div class="text-danger mt-2">${v.erreurs['direction']}</div>
	      </div>
      </div>
		  <button type="submit" class="btn btn-primary btn-block my-4">Envoyer</button>
		</form>
	</div>
</div>