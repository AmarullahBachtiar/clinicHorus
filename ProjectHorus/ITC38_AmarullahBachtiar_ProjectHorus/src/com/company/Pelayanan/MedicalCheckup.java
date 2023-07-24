package com.company.Pelayanan;

import com.company.Helper;
import com.company.KumpulanEnum.EnumMedicalCheckup;
import com.company.Patient;
import com.company.TreatmentSchedule;

import java.time.LocalDateTime;

public class MedicalCheckup extends TreatmentSchedule {
    private String namaDokter;
    private EnumMedicalCheckup enumMedical;

    public MedicalCheckup(Patient patient, Integer durasi, LocalDateTime stratDate, String namaDokter, EnumMedicalCheckup enumMedical) {
        super(patient, durasi, stratDate);
        this.namaDokter = namaDokter;
        this.enumMedical = enumMedical;
    }

    public String getNamaDokter() {
        return namaDokter;
    }

    public void setNamaDokter(String namaDokter) {
        this.namaDokter = namaDokter;
    }

    public EnumMedicalCheckup getEnumMedical() {
        return enumMedical;
    }

    public void setEnumMedical(EnumMedicalCheckup enumMedical) {
        this.enumMedical = enumMedical;
    }
    public void cetakScedule(){
        System.out.println(String.format("""
                %s - %s Patient %s
                [Medical CheckUp] - Method : %s, DOkter %s""",
                Helper.FormatTanggalWaktu(this.getStratDate()),Helper.FormatTanggalWaktu(this.getEndDate()),this.getPatient().getNama(),this.getEnumMedical().getNama(), this.getNamaDokter()));
    }
}
