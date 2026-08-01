package com.hospital.dao;

import com.hospital.model.Doctor;
import com.hospital.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DoctorDAO {

    // Add Doctor
    public void addDoctor(Doctor doctor) {

        String query = "INSERT INTO doctors(name,specialization,phone,experience) VALUES(?,?,?,?)";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getSpecialization());
            ps.setString(3, doctor.getPhone());
            ps.setInt(4, doctor.getExperience());

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("\nDoctor Added Successfully.");

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View Doctors
    public void viewDoctors() {

        String query = "SELECT * FROM doctors";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("----------------------------------");
                System.out.println("Doctor ID       : " + rs.getInt("doctor_id"));
                System.out.println("Name            : " + rs.getString("name"));
                System.out.println("Specialization  : " + rs.getString("specialization"));
                System.out.println("Phone           : " + rs.getString("phone"));
                System.out.println("Experience      : " + rs.getInt("experience") + " Years");

            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Search Doctor
    public void searchDoctor(int id) {

        String query = "SELECT * FROM doctors WHERE doctor_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\nDoctor ID      : " + rs.getInt("doctor_id"));
                System.out.println("Name           : " + rs.getString("name"));
                System.out.println("Specialization : " + rs.getString("specialization"));
                System.out.println("Phone          : " + rs.getString("phone"));
                System.out.println("Experience     : " + rs.getInt("experience"));

            } else {

                System.out.println("\nDoctor Not Found.");

            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Update Doctor
    public void updateDoctor(Doctor doctor) {

        String query = "UPDATE doctors SET name=?, specialization=?, phone=?, experience=? WHERE doctor_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getSpecialization());
            ps.setString(3, doctor.getPhone());
            ps.setInt(4, doctor.getExperience());
            ps.setInt(5, doctor.getDoctorId());

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("\nDoctor Updated Successfully.");
            else
                System.out.println("\nDoctor Not Found.");

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Delete Doctor
    public void deleteDoctor(int doctorId) {

        String query = "DELETE FROM doctors WHERE doctor_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, doctorId);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("\nDoctor Deleted Successfully.");
            else
                System.out.println("\nDoctor Not Found.");

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}