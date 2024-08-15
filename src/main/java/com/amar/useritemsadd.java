package com.amar;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class useritemsadd extends HttpServlet {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "system";
    private static final String PASSWORD = "7799";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int PRODUCT_NUMBER = Integer.parseInt(req.getParameter("PRODUCT_NUMBER"));
        String USERNAME = req.getParameter("USERNAME");
        int QUANTITY = Integer.parseInt(req.getParameter("QUANTITY"));
        String GMAIL = req.getParameter("GMAIL");

        Connection con = null;
        PreparedStatement ps = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);

            String sql = "INSERT INTO useritems (PRODUCT_NUMBER, USERNAME, QUANTITY, GMAIL) VALUES (?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, PRODUCT_NUMBER);
            ps.setString(2, USERNAME);
            ps.setInt(3, QUANTITY);
            ps.setString(4, GMAIL);

            int rowsInserted = ps.executeUpdate();

            if (rowsInserted > 0) {
                res.getWriter().write("User items data inserted successfully");
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
