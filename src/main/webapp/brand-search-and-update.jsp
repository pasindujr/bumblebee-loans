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
                        <div class="card-header">Brand ID Search</div>
                        <div class="card-body">
                            <form method="get" action="brand">
                                <input required type="text" id="brandId" name="brandId" class="form-control"/>
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
                            <div class="card-header">Update Brand</div>
                            <div class="card-body">
                                <form method="post" action="brand">
                                    <label for="brandId">Brand Id: </label>
                                    <input type="text" id="brandId" name="brandId" class="form-control"
                                           readonly="readonly" value="${brand.brandId}"/>
                                    <label for="brandName">Product Name: </label>
                                    <input type="text" id="brandName" name="brandName" class="form-control"
                                           value="${brand.name}"/>
                                    <input type="hidden" name="type" value="update"/>
                                    <br/>
                                    <button type="submit" class="btn btn-warning">Update Brand</button>
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