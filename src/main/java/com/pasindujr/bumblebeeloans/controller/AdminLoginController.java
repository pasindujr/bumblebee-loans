package com.pasindujr.bumblebeeloans.controller;

import com.pasindujr.bumblebeeloans.model.Admin;
import com.pasindujr.bumblebeeloans.service.AdminService;
import com.pasindujr.bumblebeeloans.service.AdminServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class AdminLoginController extends HttpServlet {
    private final AdminService service;
    public AdminLoginController(){
        this.service= AdminServiceImpl.getAdminServiceInstance();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminEmail = request.getParameter("adminEmail");
        String adminPassword = request.getParameter("adminPassword");
        String message="";

        try {
            Admin admin =service.verifyLogin(adminEmail,adminPassword);
            if (admin!=null)
            {
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("loggedUser",admin.getName());
                httpSession.setAttribute("role","ADMIN");
                RequestDispatcher rd=request.getRequestDispatcher("dashboard.jsp");
                rd.forward(request, response);
            }
            else {
                message="Incorrect username or password, please try again";
            }
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
            message=e.getMessage();
        }

        request.setAttribute("message", message);
        RequestDispatcher rd=request.getRequestDispatcher("adminlogin.jsp");
        rd.forward(request, response);
    }
}
