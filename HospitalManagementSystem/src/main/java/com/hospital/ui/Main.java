package com.hospital.ui;

import com.hospital.model.Patient;
import com.hospital.service.PatientService;
import com.hospital.model.Doctor;
import com.hospital.service.DoctorService;
import com.hospital.service.AppointmentService;
import com.hospital.model.Appointment;
import com.hospital.service.BillService;
import com.hospital.model.Bill;
import com.hospital.service.UserService;
import com.hospital.model.User;
import com.hospital.service.ReportService;
import com.hospital.util.ValidationUtil;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
        AppointmentService appointmentService = new AppointmentService();
        BillService billService = new BillService();
        UserService userService = new UserService();
        ReportService reportService = new ReportService();
        while (true) {

            System.out.println("\n====================================");
            System.out.println("   HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("====================================");

            System.out.print("Username : ");
            String username = sc.nextLine();

            System.out.print("Password : ");
            String password = sc.nextLine();

            User user = new User(username, password);

            if (!userService.login(user)) {

                System.out.println("\nInvalid Username or Password.");

                return;

            }

            System.out.println("\nLogin Successful.\n");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient By ID");
            System.out.println("4. Update Patient");
            System.out.println("5. Delete Patient");
            System.out.println("6. Add Doctor");
            System.out.println("7. View Doctors");
            System.out.println("8. Search Doctor");
            System.out.println("9. Update Doctor");
            System.out.println("10. Delete Doctor");
            System.out.println("11. Book Appointment");
            System.out.println("12. View Appointments");
            System.out.println("13. Search Appointment");
            System.out.println("14. Update Appointment");
            System.out.println("15. Cancel Appointment");
            System.out.println("16. Generate Bill");
            System.out.println("17 View Bills");
            System.out.println("18 Search Bill");
            System.out.println("19 Update Bill");
            System.out.println("20 Delete Bill");
            System.out.println("21 View Reports");
            System.out.println("22 Exit");


            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine();


            switch (choice) {

                case 1:

                    System.out.print("Enter Patient Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Gender: ");
                    String gender = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();

                    System.out.print("Enter Blood Group: ");
                    String bloodGroup = sc.nextLine();
                    if (!ValidationUtil.isValidName(name)) {
                        System.out.println("Invalid Name.");
                        break;
                    }

                    if (!ValidationUtil.isValidAge(age)) {
                        System.out.println("Invalid Age.");
                        break;
                    }

                    if (!ValidationUtil.isValidPhone(phone)) {
                        System.out.println("Phone number must contain exactly 10 digits.");
                        break;
                    }

                    if (!ValidationUtil.isValidBloodGroup(bloodGroup)) {
                        System.out.println("Invalid Blood Group.");
                        break;
                    }

                    Patient patient = new Patient(
                            name,
                            age,
                            gender,
                            phone,
                            address,
                            bloodGroup
                    );

                    patientService.addPatient(patient);

                    break;

                case 2:

                    patientService.viewPatients();

                    break;
                case 3:

                    System.out.print("Enter Patient ID: ");

                    int id = sc.nextInt();

                    patientService.searchPatientById(id);

                    break;
                case 4:

                    System.out.print("Enter Patient ID: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Gender: ");
                    String newGender = sc.nextLine();

                    System.out.print("Enter New Phone: ");
                    String newPhone = sc.nextLine();

                    System.out.print("Enter New Address: ");
                    String newAddress = sc.nextLine();

                    System.out.print("Enter New Blood Group: ");
                    String newBloodGroup = sc.nextLine();

                    Patient updatedPatient = new Patient(
                            newName,
                            newAge,
                            newGender,
                            newPhone,
                            newAddress,
                            newBloodGroup
                    );

                    updatedPatient.setPatientId(updateId);

                    patientService.updatePatient(updatedPatient);

                    break;
                case 5:

                    System.out.print("Enter Patient ID to Delete: ");

                    int deleteId = sc.nextInt();

                    patientService.deletePatient(deleteId);

                    break;
                case 6:

                    System.out.print("Doctor Name : ");
                    String dName = sc.nextLine();

                    System.out.print("Specialization : ");
                    String specialization = sc.nextLine();

                    System.out.print("Phone : ");
                    String dPhone = sc.nextLine();

                    System.out.print("Experience (Years): ");
                    int experience = sc.nextInt();
                    sc.nextLine();
                    if (!ValidationUtil.isValidName(dName)) {
                        System.out.println("Invalid Doctor Name.");
                        break;
                    }

                    if (!ValidationUtil.isValidPhone(dPhone)) {
                        System.out.println("Invalid Phone Number.");
                        break;
                    }

                    if (experience < 0) {
                        System.out.println("Experience cannot be negative.");
                        break;
                    }

                    Doctor doctor = new Doctor(
                            dName,
                            specialization,
                            dPhone,
                            experience
                    );

                    doctorService.addDoctor(doctor);

                    break;
                case 7:

                    doctorService.viewDoctors();

                    break;
                case 8:

                    System.out.print("Enter Doctor ID: ");

                    int doctorId = sc.nextInt();

                    doctorService.searchDoctor(doctorId);

                    break;
                case 9:

                    System.out.print("Doctor ID: ");
                    int updateDoctorId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String doctorName = sc.nextLine();

                    System.out.print("Specialization: ");
                    String specializations = sc.nextLine();

                    System.out.print("Phone: ");
                    String phones = sc.nextLine();

                    System.out.print("Experience: ");
                    int experiences = sc.nextInt();

                    Doctor updateDoctor = new Doctor(
                            doctorName,
                            specializations,
                            phones,
                            experiences
                    );

                    updateDoctor.setDoctorId(updateDoctorId);

                    doctorService.updateDoctor(updateDoctor);

                    break;
                case 10:

                    System.out.print("Enter Doctor ID: ");

                    int deleteDoctorId = sc.nextInt();

                    doctorService.deleteDoctor(deleteDoctorId);

                    break;
                case 11:

                    System.out.print("Patient ID: ");
                    int patientId = sc.nextInt();

                    System.out.print("Doctor ID: ");
                    int doctorIds = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Appointment Date (YYYY-MM-DD): ");
                    String date = sc.nextLine();

                    System.out.print("Appointment Time (HH:MM:SS): ");
                    String time = sc.nextLine();

                    Appointment appointment = new Appointment(
                            patientId,
                            doctorIds,
                            java.sql.Date.valueOf(date),
                            java.sql.Time.valueOf(time),
                            "Scheduled"
                    );

                    appointmentService.bookAppointment(appointment);

                    break;
                case 12:

                    appointmentService.viewAppointments();

                    break;
                case 13:

                    System.out.print("Enter Appointment ID: ");
                    int searchId = sc.nextInt();

                    appointmentService.searchAppointment(searchId);

                    break;
                case 14:

                    System.out.print("Appointment ID: ");
                    int appointmentId = sc.nextInt();

                    System.out.print("Patient ID: ");
                    int patientIds = sc.nextInt();

                    System.out.print("Doctor ID: ");
                    int doctorIdss = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Date (YYYY-MM-DD): ");
                    String dates = sc.nextLine();

                    System.out.print("Time (HH:MM:SS): ");
                    String times = sc.nextLine();

                    Appointment appointments = new Appointment(
                            patientIds,
                            doctorIdss,
                            java.sql.Date.valueOf(dates),
                            java.sql.Time.valueOf(times),
                            "Scheduled"
                    );

                    appointments.setAppointmentId(appointmentId);

                    appointmentService.updateAppointment(appointments);

                    break;
                case 15:

                    System.out.print("Enter Appointment ID: ");

                    int cancelId = sc.nextInt();

                    appointmentService.cancelAppointment(cancelId);

                    break;
                case 16:

                    System.out.print("Appointment ID: ");
                    int appointmentIds = sc.nextInt();

                    System.out.print("Consultation Fee: ");
                    double consultationFee = sc.nextDouble();

                    System.out.print("Medicine Fee: ");
                    double medicineFee = sc.nextDouble();

                    System.out.print("Lab Fee: ");
                    double labFee = sc.nextDouble();

                    sc.nextLine();

                    System.out.print("Payment Status (Paid/Pending): ");
                    String paymentStatus = sc.nextLine();

                    Bill bill = new Bill(
                            appointmentIds,
                            consultationFee,
                            medicineFee,
                            labFee,
                            paymentStatus
                    );

                    billService.generateBill(bill);

                    break;
                case 17:

                    billService.viewBills();

                    break;
                case 18:

                    System.out.print("Bill ID : ");

                    int billId=sc.nextInt();

                    billService.searchBill(billId);

                    break;
                case 19:

                    System.out.print("Bill ID : ");
                    int updateBillId=sc.nextInt();

                    System.out.print("Consultation Fee : ");
                    double consultation=sc.nextDouble();

                    System.out.print("Medicine Fee : ");
                    double medicine=sc.nextDouble();

                    System.out.print("Lab Fee : ");
                    double lab=sc.nextDouble();

                    sc.nextLine();

                    System.out.print("Payment Status : ");
                    String payment=sc.nextLine();

                    Bill updateBill=new Bill(
                            0,
                            consultation,
                            medicine,
                            lab,
                            payment
                    );

                    updateBill.setBillId(updateBillId);

                    billService.updateBill(updateBill);

                    break;
                case 20:

                    System.out.print("Bill ID : ");

                    int deleteBill=sc.nextInt();

                    billService.deleteBill(deleteBill);

                    break;
                case 21:

                    reportService.showReports();

                    break;
                case 22:

                    System.out.println("Thank You...");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice.");

            }

        }

    }

}