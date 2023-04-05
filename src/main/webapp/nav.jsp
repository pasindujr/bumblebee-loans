<%
    HttpSession httpSession = (HttpSession) request.getSession();
    String user = (String) httpSession.getAttribute("loggedUser");
%>
<nav id="sidebar" class="active">
    <div class="sidebar-header">
        <img src="assets/img/bootstraper-logo.png" alt="bootraper logo" class="app-logo">
    </div>
    <ul class="list-unstyled components text-secondary">
        <li>
            <a href="dashboard.jsp"><i class="fas fa-home"></i> Dashboard</a>
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
                            <i class="fas fa-user"></i> <span><%=user%></span> <i style="font-size: .8em;"
                                                                                  class="fas fa-caret-down"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-end nav-link-menu">
                            <ul class="nav-list">

                                <li><a href="logout" class="dropdown-item"><i class="fas fa-sign-out-alt"></i>
                                    Logout</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
