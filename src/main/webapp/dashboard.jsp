<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>

<%response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");%>
<%@page import="com.pasindujr.bumblebeeloans.dao.DashboardManager"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
    HttpSession httpSession = (HttpSession) request.getSession();
    String user = (String) httpSession.getAttribute("loggedUser");
    String role = (String) httpSession.getAttribute("role");
    if (role != null && role.equals("ADMIN")) {
        Connection con;
        DashboardManager db = new DashboardManager();
        con = db.getConnection();
        Statement st = con.createStatement();

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
        <div class="row">
            <div class="col-lg-12">
                <!-- MAIN CARDS STARTS HERE -->
                <div class="main__cards">
                    <div class="card">
                        <i
                                class="fa fa-user-o fa-2x text-lightblue"
                                aria-hidden="true"
                        ></i>
                        <div class="card_inner">
                            <p class="text-primary-p">Number of Registered users</p>
                            <%
                                //String query = "SELECT COUNT(*) FROM user";
                                //ResultSet r = st.executeQuery(query);
                                //r.next();
                            %>
                            <span class="font-bold text-title"><%%></span>
                        </div>
                    </div>


                <div class="card">
                    <div class="card-header">Cards</div>
                    <div class="card-body">
                        test cards
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