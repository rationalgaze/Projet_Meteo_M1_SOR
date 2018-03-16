<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="manager" class="manager.Manager" scope="session" />

<h2>Meteo du jour</h2>
<div class="table-responsive">
  <table class="table table-striped">
    <thead>
	    <tr>
	      <th scope="col">Date</th>
	      <th scope="col">Location</th>
	      <th scope="col">T-min</th>
	      <th scope="col">T-max</th>
	      <th scope="col">T-moy</th>
	      <th scope="col">Pluie</th>
	      <th scope="col">Soleil</th>
	      <th scope="col">Vent</th>
	      <th scope="col">Rafales</th>
	      <th scope="col">Direction</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:set var = "meteo" scope = "session" value = "${manager.meteoDuJour()}"/>
	    <tr>
	      <td scope="row">${meteo[0]}</td>
	      <td>${meteo[1]}</td>
	      <td>${meteo[2]}</td>
	      <td>${meteo[3]}</td>
	      <td>${meteo[4]}</td>
	      <td>${meteo[5]}</td>
	      <td>${meteo[6]}</td>
	      <td>${meteo[7]}</td>
	      <td>${meteo[8]}</td>
	      <td>${meteo[9]}</td>
	    </tr>
	  </tbody>
  </table>
</div> 
<h2>Meteo du mois</h2>
<div class="table-responsive">
  <table class="table table-striped">
    <thead>
      <tr>
        <th scope="col">Date</th>
        <th scope="col">Location</th>
        <th scope="col">T-min</th>
        <th scope="col">T-max</th>
        <th scope="col">T-moy</th>
        <th scope="col">Pluie</th>
        <th scope="col">Soleil</th>
        <th scope="col">Vent</th>
        <th scope="col">Rafales</th>
        <th scope="col">Direction</th>
      </tr>
    </thead>
    <tbody>
	    <c:set var = "meteoMois" scope = "session" value = "${manager.meteoMensuelle()}"/>
	    <c:forEach var="line" items="${meteoMois}">
	      <tr>
	        <td scope="row">${line[0]}</td>
	        <td>${line[1]}</td>
	        <td>${line[2]}</td>
	        <td>${line[3]}</td>
	        <td>${line[4]}</td>
	        <td>${line[5]}</td>
	        <td>${line[6]}</td>
	        <td>${line[7]}</td>
	        <td>${line[8]}</td>
	        <td>${line[9]}</td>
	      </tr>
	    </c:forEach>
    </tbody>
  </table>
</div>