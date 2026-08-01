package com.hospital.service;

import com.hospital.dao.AppointmentDAO;
import com.hospital.model.Appointment;

public class AppointmentService {

    private AppointmentDAO appointmentDAO = new AppointmentDAO();

    public void bookAppointment(Appointment appointment) {

        appointmentDAO.bookAppointment(appointment);

    }
    public void viewAppointments() {

        appointmentDAO.viewAppointments();

    }
    public void searchAppointment(int id){
        appointmentDAO.searchAppointment(id);
    }

    public void updateAppointment(Appointment appointment){
        appointmentDAO.updateAppointment(appointment);
    }

    public void cancelAppointment(int id){
        appointmentDAO.cancelAppointment(id);
    }

}
