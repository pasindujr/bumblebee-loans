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
                <a href="tables.html"><i class="fas fa-table"></i> Tables</a>
            </li>
            <li>
                <a href="charts.html"><i class="fas fa-chart-bar"></i> Charts</a>
            </li>
            <li>
                <a href="icons.html"><i class="fas fa-icons"></i> Icons</a>
            </li>
            <li>
                <a href="#uielementsmenu" data-bs-toggle="collapse" aria-expanded="false"
                   class="dropdown-toggle no-caret-down"><i class="fas fa-layer-group"></i> UI Elements</a>
                <ul class="collapse list-unstyled" id="uielementsmenu">
                    <li>
                        <a href="ui-buttons.html"><i class="fas fa-angle-right"></i> Buttons</a>
                    </li>
                    <li>
                        <a href="ui-badges.html"><i class="fas fa-angle-right"></i> Badges</a>
                    </li>
                    <li>
                        <a href="ui-cards.html"><i class="fas fa-angle-right"></i> Cards</a>
                    </li>
                    <li>
                        <a href="ui-alerts.html"><i class="fas fa-angle-right"></i> Alerts</a>
                    </li>
                    <li>
                        <a href="ui-tabs.html"><i class="fas fa-angle-right"></i> Tabs</a>
                    </li>
                    <li>
                        <a href="ui-date-time-picker.html"><i class="fas fa-angle-right"></i> Date & Time Picker</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#authmenu" data-bs-toggle="collapse" aria-expanded="false"
                   class="dropdown-toggle no-caret-down"><i class="fas fa-user-shield"></i> Authentication</a>
                <ul class="collapse list-unstyled" id="authmenu">
                    <li>
                        <a href="login.html"><i class="fas fa-lock"></i> Login</a>
                    </li>
                    <li>
                        <a href="signup.html"><i class="fas fa-user-plus"></i> Signup</a>
                    </li>
                    <li>
                        <a href="forgot-password.html"><i class="fas fa-user-lock"></i> Forgot password</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#pagesmenu" data-bs-toggle="collapse" aria-expanded="false"
                   class="dropdown-toggle no-caret-down"><i class="fas fa-copy"></i> Pages</a>
                <ul class="collapse list-unstyled" id="pagesmenu">
                    <li>
                        <a href="blank.html"><i class="fas fa-file"></i> Blank page</a>
                    </li>
                    <li>
                        <a href="404.html"><i class="fas fa-info-circle"></i> 404 Error page</a>
                    </li>
                    <li>
                        <a href="500.html"><i class="fas fa-info-circle"></i> 500 Error page</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="users.html"><i class="fas fa-user-friends"></i>Users</a>
            </li>
            <li>
                <a href="settings.html"><i class="fas fa-cog"></i>Settings</a>
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
                            <a href="#" id="nav1" class="nav-item nav-link dropdown-toggle text-secondary"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                <i class="fas fa-link"></i> <span>Quick Links</span> <i style="font-size: .8em;"
                                                                                        class="fas fa-caret-down"></i>
                            </a>
                            <div class="dropdown-menu dropdown-menu-end nav-link-menu" aria-labelledby="nav1">
                                <ul class="nav-list">
                                    <li><a href="" class="dropdown-item"><i class="fas fa-list"></i> Access Logs</a>
                                    </li>
                                    <div class="dropdown-divider"></div>
                                    <li><a href="" class="dropdown-item"><i class="fas fa-database"></i> Back ups</a>
                                    </li>
                                    <div class="dropdown-divider"></div>
                                    <li><a href="" class="dropdown-item"><i class="fas fa-cloud-download-alt"></i>
                                        Updates</a></li>
                                    <div class="dropdown-divider"></div>
                                    <li><a href="" class="dropdown-item"><i class="fas fa-user-shield"></i> Roles</a>
                                    </li>
                                </ul>
                            </div>
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
                                    <li><a href="" class="dropdown-item"><i class="fas fa-address-card"></i> Profile</a>
                                    </li>
                                    <li><a href="" class="dropdown-item"><i class="fas fa-envelope"></i> Messages</a>
                                    </li>
                                    <li><a href="" class="dropdown-item"><i class="fas fa-cog"></i> Settings</a></li>
                                    <div class="dropdown-divider"></div>
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
                                <div class="card-header">Update Product</div>
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
        <script src="assets/vendor/jquery/jquery.min.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/chartsjs/Chart.min.js"></script>
        <script src="assets/js/dashboard-charts.js"></script>
        <script src="assets/js/script.js"></script>
</body>

</html>