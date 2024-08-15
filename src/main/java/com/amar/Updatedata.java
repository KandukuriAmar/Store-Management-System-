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

public class Updatedata extends HttpServlet {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "system";
    private static final String PASSWORD = "7799";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String proname = req.getParameter("proname");
        String protitle = req.getParameter("protitle");
        String probody = req.getParameter("probody");

        Connection con = null;
        PreparedStatement ps = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);

            String sql = "UPDATE products SET protitle=?, probody=? WHERE proname=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, protitle);
            ps.setString(2, probody);
            ps.setString(3, proname);

            int valid = ps.executeUpdate();

            if (valid > 0) {
                res.getWriter().write("Data successfully updated");
            } else {
                res.getWriter().write("No matching product found to update");
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
