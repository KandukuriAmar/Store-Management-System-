package com.amar;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Deletedata extends HttpServlet {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "system";
    private static final String PASSWORD = "7799";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String proname = req.getParameter("proname");

        // Debugging statement
        System.out.println("Received proname for deletion: " + proname);

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);

            // Check if the product exists
            String checkSql = "SELECT * FROM products WHERE proname = ?";
            ps = con.prepareStatement(checkSql);
            ps.setString(1, proname);
            rs = ps.executeQuery();

            if (rs.next()) {
                // Product exists, proceed with deletion
                String deleteSql = "DELETE FROM products WHERE proname = ?";
                ps = con.prepareStatement(deleteSql);
                ps.setString(1, proname);

                int rowsDeleted = ps.executeUpdate();

                if (rowsDeleted > 0) {
                    res.getWriter().write("Product deleted successfully");
                } else {
                    res.getWriter().write("Failed to delete product");
                }
            } else {
                // Product does not exist
                res.getWriter().write("No matching product found to delete");
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.getWriter().write("An error occurred: " + e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
