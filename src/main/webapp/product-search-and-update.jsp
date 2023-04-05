<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>

<%response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");%>

<%
    HttpSession httpSession = (HttpSession) request.getSession();
    String user = (String) httpSession.getAttribute("loggedUser");
    String role = (String) httpSession.getAttribute("role");
    if (role != null && role.equals("ADMIN")) {

%>
<!doctype html>

<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Bumble Bee Loans</title>
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
        <div class="container">
            <div class="row">
                <tag:if test="${message != null}">
                    <div class="alert alert-success" role="alert">
                            ${message}
                    </div>
                </tag:if>

                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-header">Product ID Search</div>
                        <div class="card-body">
                            <form method="get" action="product">
                                <input required type="text" id="productId" name="productId" class="form-control"/>
                                <input type="hidden" name="type" value="specific"/>
                                <br/>
                                <button type="submit" class="btn btn-primary">Search the Product</button>
                            </form>
                        </div>
                    </div>
                </div>
                <br/>
                <br/>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-header">Update Product</div>
                            <div class="card-body">
                                <form method="post" action="product">
                                    <label for="productId">Product Id: </label>
                                    <input type="text" id="productId" name="productId" class="form-control"
                                           readonly="readonly" value="${product.productId}"/>

                                    <label for="productName">Product Name: </label>
                                    <input type="text" id="productName" name="productName" class="form-control"
                                           value="${product.name}"/>

                                    <label for="productName">Product Price: </label>
                                    <input type="text" id="price" name="price" class="form-control"
                                           value="${product.price}"/>

                                    <label for="category" class="form-label">Select a category</label>
                                    <select id="category" name="category" class="form-select" required>
                                        <tag:forEach var="category" items="${categoryList}">
                                            <option
                                                    <tag:if test="${category.categoryId == product.category}">
                                                        selected="selected"
                                                    </tag:if>
                                                    value="${category.categoryId}">${category.name}</option>
                                        </tag:forEach>
                                    </select>

                                    <label for="brand" class="form-label">Select a brand</label>
                                    <select id="brand" name="brand" class="form-select" required>
                                        <tag:forEach var="brand" items="${brandList}">
                                            <option
                                                    <tag:if test="${brand.brandId == product.brand}">
                                                        selected
                                                    </tag:if>
                                                    value="${brand.brandId}">${brand.name}</option>
                                        </tag:forEach>
                                    </select>

                                    <input type="hidden" name="type" value="update"/>
                                    <br/>
                                    <button type="submit" class="btn btn-warning">Update Product</button>
                                </form>
                            </div>
                        </div>
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
<%
    } else {
        String redirectURL = "/bumblebee-loans/401.jsp";
        response.sendRedirect(redirectURL);
    }
%>
</body>

</html>