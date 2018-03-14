<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Meteo</h2>
<div class="table-responsive">
  <table class="table table-striped">
    <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">T-min</th>
	      <th scope="col">T-max</th>
	      <th scope="col">T-moy</th>
	      <th scope="col">Soleil</th>
	      <th scope="col">Pluie</th>
	      <th scope="col">Vent</th>
	      <th scope="col">Rafales</th>
	      <th scope="col">Direction</th>
	    </tr>
	  </thead>
	  <tbody>
	    <tr>
	      <th scope="row">1</th>
	      <td>Mark</td>
	      <td>Otto</td>
	      <td>@mdo</td>
	      <td></td>
	      <td></td>
	      <td></td>
	      <td></td>
	      <td></td>
	    </tr>
	    <tr>
	      <th scope="row">2</th>
	      <td>Jacob</td>
	      <td>Thornton</td>
	      <td>@fat</td>
	      <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
	    </tr>
	    <tr>
	      <th scope="row">3</th>
	      <td>Larry</td>
	      <td>the Bird</td>
	      <td>@twitter</td>
	      <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
	    </tr>

			<%-- <c:forEach var="line" items="${meteo}">
				 <tr>
	        <th scope="row">3</th>
	        <td>${line.temp_min}</td>
	        <td>${line.temp_max}</td>
	        <td>${line.temp_moy}</td>
	        <td>${line.temp_min}</td>
	        <td>${line.temp_min}</td>
	        <td>${line.temp_min}</td>
	        <td>${line.temp_min}</td>
	        <td>${line.temp_min}</td>
	      </tr>
			</c:forEach> --%>

	  </tbody>
  </table>
</div>