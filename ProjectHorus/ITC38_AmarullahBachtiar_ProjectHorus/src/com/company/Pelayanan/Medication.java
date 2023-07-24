package com.company.Pelayanan;

import com.company.Helper;
import com.company.Patient;
import com.company.TreatmentSchedule;

import java.time.LocalDateTime;

public class Medication extends TreatmentSchedule {
    private String medicine;
    private int quantity;

    public Medication(Patient patient, int durasi, LocalDateTime stratDate, String medicine, int quantity) {
        super(patient, durasi, stratDate);
        this.medicine = medicine;
        this.quantity = quantity;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String namaDokter) {
        this.medicine = namaDokter;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void cetakScedule() {
        System.out.println(String.format("""
                %s - %s Patient %s
                [Medication] - Medicine : %s, Quantity %s""",
                Helper.FormatTanggalWaktu(this.getStratDate()),Helper.FormatTanggalWaktu(this.getEndDate()),this.getPatient().getNama(),this.getMedicine(),this.getQuantity()));

    }
}
