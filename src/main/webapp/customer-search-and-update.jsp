<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!doctype html>
<!--
* Bootstrap Simple Admin Template
* Version: 2.1
* Author: Alexis Luna
* Website: https://github.com/alexis-luna/bootstrap-simple-admin-template
-->
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
            <li>
                <a href="customer"><i class="fas fa-file-alt"></i>Manage Customer</a>
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
            <div class="container">
                <div class="row">
                    <tag:if test="${message != null}">
                        <div class="alert alert-success" role="alert">
                                ${message}
                        </div>
                    </tag:if>
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-header">Customer ID Search</div>
                            <div class="card-body">
                                <form method="get" action="customer">
                                    <input required type="text" id="customerId" name="customerId" class="form-control"/>
                                    <input type="hidden" name="type" value="specific"/>
                                    <br/>
                                    <button type="submit" class="btn btn-primary">Search Customer</button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <br/>
                    <br/>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-header">Update Customer</div>
                                <div class="card-body">
                                    <form method="post" action="customer">
                                        <label for="customerId">Customer Id: </label>

                                        <input type="text" id="customerId" name="customerId" class="form-control"
                                               readonly="readonly" value="${customer.customerId}"/>

                                        <label for="customerName">Customer Name: </label>
                                        <input type="text" id="customerName" name="customerName" class="form-control"
                                               value="${customer.name}"/>

                                        <label for="dob">Customer DOB: </label>
                                        <input type="date" id="dob" name="dob" class="form-control"
                                               value="${customer.dob}"/>

                                        <label for="loanBalance">Loan Amount: </label>
                                        <input max="15000" type="number" id="loanBalance" name="loanBalance" class="form-control"
                                               value="${customer.loanBalance}"/>

                                        <label for="usedAmount">Used Amount: </label>
                                        <input max="15000" type="number" id="usedAmount" name="usedAmount" class="form-control"
                                               value="${customer.usedAmount}"/>

                                        <label for="installmentPlan">Used Amount: </label>
                                        <input max="3" type="number" id="installmentPlan" name="installmentPlan" class="form-control"
                                               value="${customer.installmentPlan}"/>

                                        <input type="hidden" name="type" value="update"/>
                                        <br/>
                                        <button type="submit" class="btn btn-warning">Update Customer</button>
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
</body>

</html>