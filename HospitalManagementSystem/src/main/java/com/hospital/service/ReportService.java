package com.hospital.service;

import com.hospital.dao.ReportDAO;

public class ReportService {

    private ReportDAO reportDAO = new ReportDAO();

    public void showReports() {

        System.out.println("\n====================================");
        System.out.println("      HOSPITAL REPORTS");
        System.out.println("====================================");

        System.out.println("Total Patients       : " + reportDAO.getTotalPatients());

        System.out.println("Total Doctors        : " + reportDAO.getTotalDoctors());

        System.out.println("Total Appointments   : " + reportDAO.getTotalAppointments());

        System.out.println("Today's Appointments : " + reportDAO.getTodayAppointments());

        System.out.println("Total Revenue        : ₹" + reportDAO.getTotalRevenue());

        System.out.println("====================================");

    }

}
