package com.hospital.model;

public class Bill {

    private int billId;
    private int appointmentId;
    private double consultationFee;
    private double medicineFee;
    private double labFee;
    private double totalAmount;
    private String paymentStatus;

    public Bill() {
    }

    public Bill(int appointmentId, double consultationFee,
                double medicineFee, double labFee,
                String paymentStatus) {

        this.appointmentId = appointmentId;
        this.consultationFee = consultationFee;
        this.medicineFee = medicineFee;
        this.labFee = labFee;
        this.totalAmount = consultationFee + medicineFee + labFee;
        this.paymentStatus = paymentStatus;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public double getMedicineFee() {
        return medicineFee;
    }

    public double getLabFee() {
        return labFee;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }
}
