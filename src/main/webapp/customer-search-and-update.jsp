<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>

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
                                    <input max="15000" type="number" id="loanBalance" name="loanBalance"
                                           class="form-control"
                                           value="${customer.loanBalance}"/>

                                    <label for="usedAmount">Used Amount: </label>
                                    <input max="15000" type="number" id="usedAmount" name="usedAmount"
                                           class="form-control"
                                           value="${customer.usedAmount}"/>

                                    <label for="installmentPlan">Used Amount: </label>
                                    <input max="3" type="number" id="installmentPlan" name="installmentPlan"
                                           class="form-control"
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
<%
    } else {
        String redirectURL = "/bumblebee-loans/401.jsp";
        response.sendRedirect(redirectURL);
    }
%>
</body>

</html>