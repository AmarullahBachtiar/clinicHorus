package com.company.KumpulanEnum;

public enum EnumMedicalCheckup {
    CT("CT","CT Scan"),
    MRI("MRI","Magnetic Resonance Imaging"),
    BP("BP","Blood Pressure"),
    LAB("LAB","Laboratory Test"),
    ECG("ECG","Electrocardiogram");

    private String code;
    private String nama;

    EnumMedicalCheckup(String code, String nama){
        this.code = code;
        this.nama = nama;
    }

    public String getCode() {
        return code;
    }

    public String getNama() {
        return this.nama;
    }
}
