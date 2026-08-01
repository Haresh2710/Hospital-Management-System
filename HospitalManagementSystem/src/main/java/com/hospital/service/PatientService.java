package com.hospital.service;

import com.hospital.dao.PatientDAO;
import com.hospital.model.Patient;

public class PatientService {

    private PatientDAO patientDAO = new PatientDAO();

    public void addPatient(Patient patient) {
        patientDAO.addPatient(patient);
    }

    public void viewPatients() {
        patientDAO.viewPatients();
    }

    public void searchPatientById(int id) {
        patientDAO.searchPatientById(id);
    }
    public void updatePatient(Patient patient) {
        patientDAO.updatePatient(patient);
    }
    public void deletePatient(int patientId) {

        patientDAO.deletePatient(patientId);

    }
}