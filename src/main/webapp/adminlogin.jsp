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
    <style>
        html,
        body {
            height: 100%
        }
    </style>
</head>

<body>
<tag:if test="${message != null}">
    <div class="alert alert-success" role="alert">
            ${message}
    </div>
</tag:if>
<div class="h-100 d-flex align-items-center justify-content-center">

    <div class="card col-5">
        <div class="card-header">Login as admin</div>
        <div class="card-body">
            <form method="post" action="adminlogin">
                <label for="adminEmail">Email: </label>
                <input type="text" id="adminEmail" name="adminEmail" class="form-control"/>
                <label for="adminPassword">Password: </label>
                <input type="password" id="adminPassword" name="adminPassword" class="form-control"/>
                <input type="hidden" name="type" value="add"/>
                </br>
                <button type="submit" class="btn btn-info">Login</button>
            </form>
        </div>
    </div>
</div>
<div class="wrapper">

</div>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/script.js"></script>
</body>

</html>