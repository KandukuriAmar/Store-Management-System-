package com.amar;

import java.io.*;
import java.sql.*;
import javax.servlet.*;

public class TableCreation extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        Connection con = null;
        Statement st = null;
        PrintWriter pw = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "7799");
            st = con.createStatement();
            st.execute("CREATE TABLE Credentials (username VARCHAR(25), password VARCHAR(10), pin INT)");
            res.setContentType("text/html");
            pw = res.getWriter();
            pw.println("<h1>Table Created successfully</h1>");
            
            st.execute("INSERT INTO Credentials (username, password, pin) VALUES ('amar7799', 'amar@123', 1111)");
            st.execute("INSERT INTO Credentials (username, password, pin) VALUES ('teja7799', 'teja@123', 2222)");
            st.execute("INSERT INTO Credentials (username, password, pin) VALUES ('rama7799', 'rama@123', 3333)");
            st.execute("INSERT INTO Credentials (username, password, pin) VALUES ('balu7799', 'balu@123', 4444)");

            pw.println("<h1>Data Inserted successfully</h1>");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new ServletException("JDBC Driver not found", e);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("SQL Error", e);
        } finally {
            if (st != null) {
                try {
                    st.close();
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
            if (pw != null) {
                pw.close();
            }
        }
    }
}
