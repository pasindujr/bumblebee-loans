<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Dashboard | Bootstrap Simple Admin Template</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/master.css" rel="stylesheet">
</head>

<body>
<div class="wrapper">
    <jsp:include page="nav.jsp"/>
    <br/>
    <br/>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <tag:if test="${message != null}">
                    <div class="alert alert-success" role="alert">
                            ${message}
                    </div>
                </tag:if>

                <div class="card">
                    <div class="card-header">Create New Stock</div>
                    <div class="card-body">
                        <form method="post" action="stock">

                            <label for="product" class="form-label">Select a product</label>
                            <select id="product" name="product" class="form-select" required>
                                <option value="" selected>Choose...</option>
                                <tag:forEach var="product" items="${productList}">
                                    <option value="${product.productId}">${product.name}</option>
                                </tag:forEach>
                            </select>

                            <label for="quantity">Quantity: </label>
                            <input type="text" id="quantity" name="quantity" class="form-control"/>

                            <input type="hidden" name="type" value="add"/>
                            </br>
                            <button type="submit" class="btn btn-info">Save Quantity</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/script.js"></script>
</body>

</html>