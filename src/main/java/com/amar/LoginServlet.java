package com.amar;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("Received Username: " + username); 
        System.out.println("Received Password: " + password); 

        if("admin".equals(username.trim()) && "admin".equals(password.trim())) {
            System.out.println("Admin login successful");
            RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
            rd.forward(request, response);
        } else {
            User user = new User(username, password);
            UserDAO userDAO = new UserDAO();
            try {
                if (userDAO.validateUser(user)) {
                    System.out.println("User login successful");
                    RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                    rd.forward(request, response);
                } else {
                    System.out.println("Invalid credentials for user: " + username);
                    request.setAttribute("errorMessage", "Invalid Credentials");
                    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                    rd.forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
