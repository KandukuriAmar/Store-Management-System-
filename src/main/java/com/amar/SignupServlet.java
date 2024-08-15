//package com.amar;
//
//import java.io.IOException;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class SignupServlet extends HttpServlet {
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//
//        SignupUser signupuser = new SignupUser(username, email, password);
//        SignupuserDAO signupuserDAO = new SignupuserDAO();
//
//        if (signupuserDAO.validateUser(signupuser)) {
//            request.setAttribute("errorMessage", "Account already created by this email or just try to login");
//            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
//            rd.forward(request, response);
//        } else {
//            request.setAttribute("Message", "Account succesfully created on this email");
//            signupuserDAO.insertUser(signupuser);
//            request.setAttribute("username", username);
//            request.setAttribute("email", email);
//            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
//            rd.forward(request, response);
//        }
//    }
//}
package com.amar;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Check if the input fields are not empty
        if (username == null || username.isEmpty() || email == null || email.isEmpty() || password == null || password.isEmpty()) {
            request.setAttribute("errorMessage", "All fields are required.");
            RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
            rd.forward(request, response);
            return;
        }

        SignupUser signupUser = new SignupUser(username, email, password);
        SignupuserDAO signupUserDAO = new SignupuserDAO();

        if (signupUserDAO.validateUser(signupUser)) {
            request.setAttribute("errorMessage", "Account already created with this email. Please try to login.");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("message", "Account successfully created with this email.");
            signupUserDAO.insertUser(signupUser);
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
    }
}
