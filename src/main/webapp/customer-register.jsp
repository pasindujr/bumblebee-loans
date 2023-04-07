<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="row">
            <div class="col-lg-12">
                <tag:if test="${message != null}">
                    <div class="alert alert-success" role="alert">
                            ${message}
                    </div>
                </tag:if>

                <div class="card">
                    <div class="card-header">Create New Product</div>
                    <div class="card-body">
                        <form method="post" action="customer">
                            <label for="customerName">Customer Name: </label>
                            <input type="text" id="customerName" name="customerName" class="form-control"/>

                            <label for="dob">Customer DOB: </label>
                            <input type="date" id="dob" name="dob" class="form-control"/>

                            <label for="age">Customer Age: </label>
                            <input min="18" type="number" id="age" name="age" class="form-control"/>

                            <label for="loanBalance">Loan Required: </label>
                            <input max="15000" type="number" id="loanBalance" name="loanBalance" class="form-control"/>

                            <label for="installmentPlan">Installment Plan: </label>
                            <input max="3" type="number" id="installmentPlan" name="installmentPlan"
                                   class="form-control"/>

                            <input type="hidden" name="type" value="add"/>
                            </br>
                            <button type="submit" class="btn btn-info">Register Customer</button>
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