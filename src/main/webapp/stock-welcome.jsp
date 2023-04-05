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
    <!-- end of navbar navigation -->
    <div class="content">
        <div class="container">
            <div class="row">
                <div class="col-md-12 page-header">
                    <div class="page-pretitle">Overview</div>
                    <h2 class="page-title">Dashboard</h2>
                </div>
            </div>
            <div class="row">
                <ul class="nav nav-tabs nav-dark">
                    <form method="get" action="stock">
                        <input type="hidden" name="type" value="loadStockCreateForm"/>
                        <button type="submit" class="btn btn-primary">New Stock
                        </button>
                    </form>
                </ul>
                <p>${message}</p>
                <br/>
                <div class="col-md-12 col-lg-12">
                    <div class="card">
                        <div class="card-header">Stock Table</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>Stock ID</th>
                                        <th>Product</th>
                                        <th>Quantity</th>
                                        <th>Actions</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tag:forEach var="stock" items="${stockList}">
                                        <tr>
                                            <td>${stock.stockId}</td>
                                            <td>${stock.product}</td>
                                            <td>${stock.quantity}</td>
                                            <td>
                                                <form method="get" action="stock">
                                                    <input type="hidden" name="stockId"
                                                           value="${stock.stockId}"/>
                                                    <input type="hidden" name="type" value="specific"/>
                                                    <button type="submit" class="btn btn-warning">Edit
                                                    </button>
                                                </form>
                                                <form method="post" action="stock">
                                                    <input type="hidden" name="stockId"
                                                           value="${stock.stockId}"/>
                                                    <input type="hidden" name="type" value="delete"/>
                                                    <button type="submit" class="btn btn-danger">Delete
                                                    </button>
                                                </form>
                                            </td>
                                        </tr>
                                    </tag:forEach>
                                    </tbody>
                                </table>
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
</body>

</html>