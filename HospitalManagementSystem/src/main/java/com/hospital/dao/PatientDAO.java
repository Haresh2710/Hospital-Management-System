package com.hospital.dao;

import com.hospital.model.Patient;
import com.hospital.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PatientDAO {

    // Add Patient
    public void addPatient(Patient patient) {

        String query = "INSERT INTO patients(name, age, gender, phone, address, blood_group) VALUES (?, ?, ?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, patient.getName());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getGender());
            ps.setString(4, patient.getPhone());
            ps.setString(5, patient.getAddress());
            ps.setString(6, patient.getBloodGroup());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("\nPatient Added Successfully.");
            } else {
                System.out.println("\nFailed to Add Patient.");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View All Patients
    public void viewPatients() {

        String query = "SELECT * FROM patients";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("-----------------------------------");
                System.out.println("Patient ID : " + rs.getInt("patient_id"));
                System.out.println("Name       : " + rs.getString("name"));
                System.out.println("Age        : " + rs.getInt("age"));
                System.out.println("Gender     : " + rs.getString("gender"));
                System.out.println("Phone      : " + rs.getString("phone"));
                System.out.println("Address    : " + rs.getString("address"));
                System.out.println("BloodGroup : " + rs.getString("blood_group"));
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Search Patient By ID
    public void searchPatientById(int id) {

        String query = "SELECT * FROM patients WHERE patient_id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\n========== PATIENT DETAILS ==========");
                System.out.println("Patient ID : " + rs.getInt("patient_id"));
                System.out.println("Name       : " + rs.getString("name"));
                System.out.println("Age        : " + rs.getInt("age"));
                System.out.println("Gender     : " + rs.getString("gender"));
                System.out.println("Phone      : " + rs.getString("phone"));
                System.out.println("Address    : " + rs.getString("address"));
                System.out.println("BloodGroup : " + rs.getString("blood_group"));

            } else {

                System.out.println("\nPatient Not Found.");

            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        }
    public void updatePatient(Patient patient) {

        String query = "UPDATE patients SET name=?, age=?, gender=?, phone=?, address=?, blood_group=? WHERE patient_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, patient.getName());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getGender());
            ps.setString(4, patient.getPhone());
            ps.setString(5, patient.getAddress());
            ps.setString(6, patient.getBloodGroup());
            ps.setInt(7, patient.getPatientId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("\nPatient Updated Successfully.");
            } else {
                System.out.println("\nPatient Not Found.");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deletePatient(int patientId) {

        String query = "DELETE FROM patients WHERE patient_id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, patientId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("\nPatient Deleted Successfully.");
            } else {
                System.out.println("\nPatient Not Found.");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}