package com.java.cis.controllers;// LoginServlet.java

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // You should validate the username and password here
        // For simplicity, we'll assume a hardcoded valid username and password
        if (username.equals("yourusername") && password.equals("yourpassword")) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("home.html");
        } else {
            response.sendRedirect("login.html");
        }
    }
}