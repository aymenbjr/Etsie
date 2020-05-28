<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!--  Des alerts bootstrap -->
<c:if test="${succes != null }">
	<div class="alert alert-success" role="alert">
  		<c:out value=" ${succes} "></c:out>
	</div>
</c:if>
<c:if test="${erreur != null }">
	<div class="alert alert-danger" role="alert">
  		<c:out value=" ${erreur} "></c:out>
	</div>
</c:if>

<br/>


<form class="form-horizontal" method="post" action="ajoutProd" >
<fieldset>

<!-- Form Name -->
<legend>Ajouter un Produit</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="titre">prix</label>  
  <div class="col-md-4">
  	<input id="product_id" name="prix" placeholder="prix" class="form-control input-md" required="" type="text">    
  </div>
</div>
 

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="available_quantity">nom</label>  
  <div class="col-md-4">
  <input id="available_quantity" name="nom" placeholder="nom" class="form-control input-md" required="" type="text">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="available_quantity">famille</label>  
  <div class="col-md-4">
  <input id="available_quantity" name="famille" placeholder="famille" class="form-control input-md" required="" type="text">
    
  </div>
</div>  


<!-- Button-->
  <button type="submit" class="btn btn-primary">Ajouter</button>

</fieldset>
</form>
