<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="v" class="validation.Validation" scope="request" />

<div class="row justify-content-md-center">
  <div class="col-md-5">
		<h1 class="mb-4">Connection</h1>
		
		<form class="needs-validation p-4 border rounded"  method="POST" action="Connection" novalidate>
		  <div class="form-group">
		    <label for="login">Email address</label>
		    <input type="email" class="form-control" id="login" name="login" placeholder="@mail" required>
		    <div class="invalid-feedback">
          Saisissez votre e-mail s'il vous plaît.
        </div>
        <div class="text-danger mt-2">${v.erreurs['mail']}</div>
		  </div>
		  <div class="form-group">
		    <label for="mdp">Password</label>
		    <input type="password" class="form-control" id="mdp" name="mdp" placeholder="Mot de passe" required>
		    <div class="invalid-feedback">
          Saisissez votre mot de passe s'il vous plaît.
        </div>
        <div class="text-danger mt-2">${v.erreurs['password']}</div>
		  </div>
		 
		  <button type="submit" class="btn btn-primary btn-block my-4">Se connecter</button>
		</form>
		<div class="text-danger mt-2"> 
		  <c:if test="${not v.valide}">
		    Le mot de passe ou login ne sont pas correctes.
		  </c:if>
		 </div>
	</div>
</div>
