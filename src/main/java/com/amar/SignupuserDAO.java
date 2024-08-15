package com.amar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignupuserDAO {

    public boolean validateUser(SignupUser signupUser) {
        boolean isValid = false;
        String query = "SELECT * FROM sdp WHERE email = ?";

        try (Connection con = DatabaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, signupUser.getEmail());

            ResultSet rs = ps.executeQuery();
            isValid = rs.next();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return isValid;
    }

    public void insertUser(SignupUser signupUser) {
        String query = "INSERT INTO sdp (username, email, password) VALUES (?, ?, ?)";

        try (Connection con = DatabaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, signupUser.getUsername());
            ps.setString(2, signupUser.getEmail());
            ps.setString(3, signupUser.getPassword());

            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
