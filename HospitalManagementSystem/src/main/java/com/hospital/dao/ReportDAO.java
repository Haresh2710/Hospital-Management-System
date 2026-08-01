package com.hospital.dao;

import com.hospital.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReportDAO {

    public int getTotalPatients() {

        String query = "SELECT COUNT(*) FROM patients";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            if (rs.next())
                return rs.getInt(1);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return 0;

    }

    public int getTotalDoctors() {

        String query = "SELECT COUNT(*) FROM doctors";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            if (rs.next())
                return rs.getInt(1);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return 0;

    }

    public int getTotalAppointments() {

        String query = "SELECT COUNT(*) FROM appointments";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            if (rs.next())
                return rs.getInt(1);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return 0;

    }

    public int getTodayAppointments() {

        String query =
                "SELECT COUNT(*) FROM appointments WHERE appointment_date = CURDATE()";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            if (rs.next())
                return rs.getInt(1);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return 0;

    }

    public double getTotalRevenue() {

        String query =
                "SELECT IFNULL(SUM(total_amount),0) FROM bills WHERE payment_status='Paid'";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            if (rs.next())
                return rs.getDouble(1);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return 0;

    }

}
