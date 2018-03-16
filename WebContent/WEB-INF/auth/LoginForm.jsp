<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="m" class="manager.Manager" scope="request" />
<jsp:useBean id="v" class="validation.Validation" scope="request" />
<jsp:useBean id="msg" class="java.lang.String" scope="request" />

<div class="row justify-content-md-center">
  <div class="col-md-5">
		<h1 class="mb-4">Connection</h1>
		
     <c:if test="${msg != ''}">
      <div class="alert alert-danger" role="alert">
        ${msg}
      </div>
		 </c:if>
		
		<form class="needs-validation p-4 border rounded"  method="POST" action="Connection" novalidate>
		  <div class="form-group">
		    <label for="login">Adresse mail</label>
		    <input type="email" class="form-control" id="login" name="login" placeholder="@mail" value="${v.valeurs['mail']}" required>
		    <div class="invalid-feedback">
          Saisissez votre e-mail s'il vous plaît.
        </div>
        <div class="text-danger mt-2">${v.erreurs['mail']}</div>
		  </div>
		  <div class="form-group">
		    <label for="mdp">Password</label>
		    <input type="password" class="form-control" id="mdp" name="mdp" placeholder="Mot de passe" value="${v.valeurs['password']}" required>
		    <div class="invalid-feedback">
          Saisissez votre mot de passe s'il vous plaît.
        </div>
        <div class="text-danger mt-2">${v.erreurs['password']}</div>
		  </div>
		 
		  <button type="submit" class="btn btn-primary btn-block my-4">Se connecter</button>
		</form>
	</div>
</div>
