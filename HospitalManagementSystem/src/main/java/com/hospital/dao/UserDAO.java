package com.hospital.dao;

import com.hospital.model.User;
import com.hospital.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public boolean login(User user) {

        String query =
                "SELECT * FROM users WHERE username=? AND password=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            ResultSet rs = ps.executeQuery();

            boolean found = rs.next();

            rs.close();
            ps.close();
            con.close();

            return found;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;

    }

}
