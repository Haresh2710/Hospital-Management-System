package com.hospital.dao;
import java.sql.ResultSet;
import com.hospital.model.Appointment;
import com.hospital.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AppointmentDAO {

    public void bookAppointment(Appointment appointment) {

        String query = "INSERT INTO appointments(patient_id, doctor_id, appointment_date, appointment_time, status) VALUES(?,?,?,?,?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, appointment.getPatientId());
            ps.setInt(2, appointment.getDoctorId());
            ps.setDate(3, appointment.getAppointmentDate());
            ps.setTime(4, appointment.getAppointmentTime());
            ps.setString(5, appointment.getStatus());

            int rows = ps.executeUpdate();

            if(rows > 0)
                System.out.println("\nAppointment Booked Successfully.");

            ps.close();
            con.close();

        } catch(Exception e){
            e.printStackTrace();
        }

    }
    public void viewAppointments() {

        String query =
                "SELECT a.appointment_id, " +
                        "p.name AS patient_name, " +
                        "d.name AS doctor_name, " +
                        "d.specialization, " +
                        "a.appointment_date, " +
                        "a.appointment_time, " +
                        "a.status " +
                        "FROM appointments a " +
                        "JOIN patients p ON a.patient_id = p.patient_id " +
                        "JOIN doctors d ON a.doctor_id = d.doctor_id";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("-------------------------------------------");

                System.out.println("Appointment ID : " + rs.getInt("appointment_id"));
                System.out.println("Patient Name   : " + rs.getString("patient_name"));
                System.out.println("Doctor Name    : " + rs.getString("doctor_name"));
                System.out.println("Specialization : " + rs.getString("specialization"));
                System.out.println("Date           : " + rs.getDate("appointment_date"));
                System.out.println("Time           : " + rs.getTime("appointment_time"));
                System.out.println("Status         : " + rs.getString("status"));
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void searchAppointment(int appointmentId) {

        String query =
                "SELECT a.appointment_id, " +
                        "p.name AS patient_name, " +
                        "d.name AS doctor_name, " +
                        "d.specialization, " +
                        "a.appointment_date, " +
                        "a.appointment_time, " +
                        "a.status " +
                        "FROM appointments a " +
                        "JOIN patients p ON a.patient_id = p.patient_id " +
                        "JOIN doctors d ON a.doctor_id = d.doctor_id " +
                        "WHERE a.appointment_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, appointmentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\nAppointment ID : " + rs.getInt("appointment_id"));
                System.out.println("Patient Name   : " + rs.getString("patient_name"));
                System.out.println("Doctor Name    : " + rs.getString("doctor_name"));
                System.out.println("Specialization : " + rs.getString("specialization"));
                System.out.println("Date           : " + rs.getDate("appointment_date"));
                System.out.println("Time           : " + rs.getTime("appointment_time"));
                System.out.println("Status         : " + rs.getString("status"));

            } else {

                System.out.println("\nAppointment Not Found.");

            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateAppointment(Appointment appointment) {

        String query =
                "UPDATE appointments SET patient_id=?, doctor_id=?, appointment_date=?, appointment_time=?, status=? WHERE appointment_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, appointment.getPatientId());
            ps.setInt(2, appointment.getDoctorId());
            ps.setDate(3, appointment.getAppointmentDate());
            ps.setTime(4, appointment.getAppointmentTime());
            ps.setString(5, appointment.getStatus());
            ps.setInt(6, appointment.getAppointmentId());

            int rows = ps.executeUpdate();

            if(rows>0)
                System.out.println("Appointment Updated Successfully.");
            else
                System.out.println("Appointment Not Found.");

            ps.close();
            con.close();

        } catch(Exception e){
            e.printStackTrace();
        }

    }
    public void cancelAppointment(int appointmentId){

        String query="UPDATE appointments SET status='Cancelled' WHERE appointment_id=?";

        try{

            Connection con=DBConnection.getConnection();

            PreparedStatement ps=con.prepareStatement(query);

            ps.setInt(1,appointmentId);

            int rows=ps.executeUpdate();

            if(rows>0)
                System.out.println("Appointment Cancelled Successfully.");
            else
                System.out.println("Appointment Not Found.");

            ps.close();
            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

}