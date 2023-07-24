package com.company.Pelayanan;

import com.company.Helper;
import com.company.Patient;
import com.company.TreatmentSchedule;

import java.time.LocalDateTime;

public class Therapy extends TreatmentSchedule {
    private String treatment;
    private String therapist;

    public Therapy(Patient patient, int durasi, LocalDateTime stratDate, String treatment, String therapist) {
        super(patient, durasi, stratDate);
        this.therapist = therapist;
        this.treatment = treatment;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getTherapist() {
        return therapist;
    }

    public void setTherapist(String therapist) {
        this.therapist = therapist;
    }

    @Override
    public void cetakScedule() {
        System.out.println(String.format("""
                %s - %s Patient %s
                [Therapy] - Treatment : %s, Therapist %s""",
                Helper.FormatTanggalWaktu(this.getStratDate()),Helper.FormatTanggalWaktu(this.getEndDate()),
                this.getPatient().getNama(),this.treatment,getTherapist()));

    }
}
