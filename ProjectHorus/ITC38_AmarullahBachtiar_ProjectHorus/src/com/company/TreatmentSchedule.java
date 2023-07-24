package com.company;

import java.time.LocalDateTime;

public abstract class TreatmentSchedule {
    private Patient patient;
//    private Integer durasi;
    private LocalDateTime stratDate;
    private LocalDateTime endDate;


    public TreatmentSchedule(Patient patient, Integer durasi, LocalDateTime stratDate) {
        this.patient = patient;
//        this.durasi = durasi;
        this.stratDate = stratDate;
        this.endDate = stratDate.plusMinutes(durasi);
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
    //    public Integer getDurasi() {
//        return durasi;
//    }

    public LocalDateTime getStratDate() {
        return stratDate;
    }

    public abstract void cetakScedule();
}
