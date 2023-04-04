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
    <nav id="sidebar" class="active">
        <div class="sidebar-header">
            <img src="assets/img/bootstraper-logo.png" alt="bootraper logo" class="app-logo">
        </div>
        <ul class="list-unstyled components text-secondary">
            <li>
                <a href="dashboard.html"><i class="fas fa-home"></i> Dashboard</a>
            </li>
            <li>
                <a href="brand"><i class="fas fa-file-alt"></i>Manage Brand</a>
            </li>
            <li>
                <a href="category"><i class="fas fa-file-alt"></i>Manage Category</a>
            </li>

            <li>
                <a href="product"><i class="fas fa-file-alt"></i>Manage Product</a>
            </li>
            <li>
                <a href="stock"><i class="fas fa-file-alt"></i>Manage Stock</a>
            </li>

        </ul>
    </nav>
    <div id="body" class="active">
        <!-- navbar navigation component -->
        <nav class="navbar navbar-expand-lg navbar-white bg-white">
            <button type="button" id="sidebarCollapse" class="btn btn-light">
                <i class="fas fa-bars"></i><span></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="nav navbar-nav ms-auto">
                    <li class="nav-item dropdown">
                        <div class="nav-dropdown">

                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <div class="nav-dropdown">
                            <a href="#" id="nav2" class="nav-item nav-link dropdown-toggle text-secondary"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                <i class="fas fa-user"></i> <span>John Doe</span> <i style="font-size: .8em;"
                                                                                     class="fas fa-caret-down"></i>
                            </a>
                            <div class="dropdown-menu dropdown-menu-end nav-link-menu">
                                <ul class="nav-list">

                                    <li><a href="" class="dropdown-item"><i class="fas fa-sign-out-alt"></i> Logout</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
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