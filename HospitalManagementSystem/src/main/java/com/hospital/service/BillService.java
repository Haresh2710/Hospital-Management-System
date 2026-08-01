package com.hospital.service;

import com.hospital.dao.BillDAO;
import com.hospital.model.Bill;

public class BillService {

    private BillDAO billDAO = new BillDAO();

    public void generateBill(Bill bill) {
        billDAO.generateBill(bill);
    }
    public void viewBills(){
        billDAO.viewBills();
    }

    public void searchBill(int id){
        billDAO.searchBill(id);
    }

    public void updateBill(Bill bill){
        billDAO.updateBill(bill);
    }

    public void deleteBill(int id){
        billDAO.deleteBill(id);
    }
}
