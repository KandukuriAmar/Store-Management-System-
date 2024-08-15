package com.amar;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class adddata extends GenericServlet {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "system";
    private static final String PASSWORD = "7799";

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String proname = req.getParameter("proname");
        String protitle = req.getParameter("protitle");
        String probody = req.getParameter("probody");

        // Debugging statements
        System.out.println("Received proname: " + proname);
        System.out.println("Received protitle: " + protitle);
        System.out.println("Received probody: " + probody);

        Connection con = null;
        PreparedStatement ps = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);

            String sql = "INSERT INTO products (proname, protitle, probody) VALUES (?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, proname);
            ps.setString(2, protitle);
            ps.setString(3, probody);

            int rowsInserted = ps.executeUpdate();

            if (rowsInserted > 0) {
                res.getWriter().write("Data inserted successfully");
            } else {
                res.getWriter().write("Failed to insert data");
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.getWriter().write("An error occurred: " + e.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
