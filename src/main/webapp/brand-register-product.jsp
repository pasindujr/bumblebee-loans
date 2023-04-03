<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>kfc colombo</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
		<ul class="nav nav-tabs nav-dark">
		  <li class="nav-item">
		    <a class="nav-link" href="brand">Store</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="brand-search-and-update.jsp">Search and Update</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link active" href="#">Register Product</a>
		  </li>
		</ul>
		<br/>
		<p>${message}</p>
		<br/>
		<form method="post" action="brand">
			<label for="txtProductName">Product Name: </label>
			<input type="text" id="txtProductName" name="productName" class="form-control"/>
			<label for="txtPrice">Price: </label>
			<input type="number" id="txtPrice" name="price" class="form-control"/>
			<input type="hidden" name="type" value="add"/>
			</br>
			<button type="submit" class="btn btn-info">Register Product</button>			
		</form>		
</div>
</body>
</html>