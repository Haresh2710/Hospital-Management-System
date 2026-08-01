package com.hospital.service;

import com.hospital.dao.DoctorDAO;
import com.hospital.model.Doctor;

public class DoctorService {

    private DoctorDAO doctorDAO = new DoctorDAO();

    public void addDoctor(Doctor doctor) {
        doctorDAO.addDoctor(doctor);
    }

    public void viewDoctors() {
        doctorDAO.viewDoctors();
    }

    public void searchDoctor(int id) {
        doctorDAO.searchDoctor(id);
    }

    public void updateDoctor(Doctor doctor) {
        doctorDAO.updateDoctor(doctor);
    }

    public void deleteDoctor(int id) {
        doctorDAO.deleteDoctor(id);
    }

}