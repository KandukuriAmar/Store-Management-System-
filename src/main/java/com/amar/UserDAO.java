//package com.amar;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class UserDAO {
//
//    public boolean validateUser(User user) throws SQLException, ClassNotFoundException {
//        boolean isValid = false;
//        Connection con = null;
//        PreparedStatement st = null;
//        ResultSet rs = null;
//        try {
//            String query = "SELECT * FROM SDP WHERE USERNAME = ? AND PASSWORD = ?";
//            con = DatabaseUtil.getConnection();
//            st = con.prepareStatement(query);
//            st.setString(1, user.getUsername());
//            st.setString(2, user.getPassword());
//            rs = st.executeQuery();
//            if (rs.next()) {
//                isValid = true;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return isValid;
//    }
//}

package com.amar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public boolean validateUser(User user) throws SQLException, ClassNotFoundException {
        boolean isValid = false;
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM SDP WHERE USERNAME = ? AND PASSWORD = ?";
            con = DatabaseUtil.getConnection();
            st = con.prepareStatement(query);
            st.setString(1, user.getUsername().trim());
            st.setString(2, user.getPassword().trim());
            rs = st.executeQuery();
            if (rs.next()) {
                isValid = true;
                System.out.println("Database validation successful for user: " + user.getUsername());
            } else {
                System.out.println("Database validation failed for user: " + user.getUsername());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (con != null) con.close();
        }
        return isValid;
    }
}

