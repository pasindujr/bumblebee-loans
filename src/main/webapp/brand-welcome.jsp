<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<meta charset="ISO-8859-1">
	<title>kfc colombo</title>
</head>
<body>
	<div class="container">
		<ul class="nav nav-tabs nav-dark">
		  <li class="nav-item">
		    <a class="nav-link active" href="#">Store</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="brand-search-and-update.jsp">Search and Update</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="brand-register-product.jsp">Register Product</a>
		  </li>
		</ul>
		<br/>
		<p>${message}</p>
		<br/>

		<table class="table">
			<thead>
				<tr class="table-dark">
					<th>Product Code</th>
					<th>Product Name</th>
					<th>Price</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<tag:forEach var ="product" items="${productList}">
					<tr>
						<td>${product.productCode}</td>
						<td>${product.name}</td>
						<td>${product.price}</td>
						<td>
							<form method="get" action="brand">
								<input type="hidden" name="productCode" value = "${product.productCode}"/>
								<input type="hidden" name="type" value="specific"/>
								<button type="submit" class="btn btn-warning">Edit the Product</button>
							</form>
							<form method="post" action="brand">
								<input type="hidden" name="productCode" value = "${product.productCode}"/>
								<input type="hidden" name="type" value="delete"/>
								<button type="submit" class="btn btn-danger">Delete the Product</button>
							</form>
						</td>
					</tr>
				</tag:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>