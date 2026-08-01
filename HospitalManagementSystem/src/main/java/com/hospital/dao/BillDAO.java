package com.hospital.dao;

import com.hospital.model.Bill;
import com.hospital.util.DBConnection;

import java.sql.*;

public class BillDAO {

    // Generate Bill
    public void generateBill(Bill bill) {

        String query = "INSERT INTO bills(appointment_id,consultation_fee,medicine_fee,lab_fee,total_amount,payment_status) VALUES(?,?,?,?,?,?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1,bill.getAppointmentId());
            ps.setDouble(2,bill.getConsultationFee());
            ps.setDouble(3,bill.getMedicineFee());
            ps.setDouble(4,bill.getLabFee());
            ps.setDouble(5,bill.getTotalAmount());
            ps.setString(6,bill.getPaymentStatus());

            int rows=ps.executeUpdate();

            if(rows>0)
                System.out.println("Bill Generated Successfully.");

            ps.close();
            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    // View Bills
    public void viewBills(){

        String query=
                "SELECT b.bill_id,p.name patient,d.name doctor,b.consultation_fee,b.medicine_fee,b.lab_fee,b.total_amount,b.payment_status " +
                        "FROM bills b " +
                        "JOIN appointments a ON b.appointment_id=a.appointment_id " +
                        "JOIN patients p ON a.patient_id=p.patient_id " +
                        "JOIN doctors d ON a.doctor_id=d.doctor_id";

        try{

            Connection con=DBConnection.getConnection();

            PreparedStatement ps=con.prepareStatement(query);

            ResultSet rs=ps.executeQuery();

            while(rs.next()){

                System.out.println("-----------------------------------");
                System.out.println("Bill ID : "+rs.getInt("bill_id"));
                System.out.println("Patient : "+rs.getString("patient"));
                System.out.println("Doctor  : "+rs.getString("doctor"));
                System.out.println("Consultation : "+rs.getDouble("consultation_fee"));
                System.out.println("Medicine : "+rs.getDouble("medicine_fee"));
                System.out.println("Lab : "+rs.getDouble("lab_fee"));
                System.out.println("Total : "+rs.getDouble("total_amount"));
                System.out.println("Status : "+rs.getString("payment_status"));

            }

            rs.close();
            ps.close();
            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    // Search Bill
    public void searchBill(int id){

        String query="SELECT * FROM bills WHERE bill_id=?";

        try{

            Connection con=DBConnection.getConnection();

            PreparedStatement ps=con.prepareStatement(query);

            ps.setInt(1,id);

            ResultSet rs=ps.executeQuery();

            if(rs.next()){

                System.out.println("Bill ID : "+rs.getInt("bill_id"));
                System.out.println("Appointment : "+rs.getInt("appointment_id"));
                System.out.println("Consultation : "+rs.getDouble("consultation_fee"));
                System.out.println("Medicine : "+rs.getDouble("medicine_fee"));
                System.out.println("Lab : "+rs.getDouble("lab_fee"));
                System.out.println("Total : "+rs.getDouble("total_amount"));
                System.out.println("Status : "+rs.getString("payment_status"));

            }else{

                System.out.println("Bill Not Found.");

            }

            rs.close();
            ps.close();
            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    // Update Bill
    public void updateBill(Bill bill){

        String query="UPDATE bills SET consultation_fee=?,medicine_fee=?,lab_fee=?,total_amount=?,payment_status=? WHERE bill_id=?";

        try{

            Connection con=DBConnection.getConnection();

            PreparedStatement ps=con.prepareStatement(query);

            ps.setDouble(1,bill.getConsultationFee());
            ps.setDouble(2,bill.getMedicineFee());
            ps.setDouble(3,bill.getLabFee());
            ps.setDouble(4,bill.getTotalAmount());
            ps.setString(5,bill.getPaymentStatus());
            ps.setInt(6,bill.getBillId());

            int rows=ps.executeUpdate();

            if(rows>0)
                System.out.println("Bill Updated Successfully.");
            else
                System.out.println("Bill Not Found.");

            ps.close();
            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    // Delete Bill
    public void deleteBill(int id){

        String query="DELETE FROM bills WHERE bill_id=?";

        try{

            Connection con=DBConnection.getConnection();

            PreparedStatement ps=con.prepareStatement(query);

            ps.setInt(1,id);

            int rows=ps.executeUpdate();

            if(rows>0)
                System.out.println("Bill Deleted Successfully.");
            else
                System.out.println("Bill Not Found.");

            ps.close();
            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

}