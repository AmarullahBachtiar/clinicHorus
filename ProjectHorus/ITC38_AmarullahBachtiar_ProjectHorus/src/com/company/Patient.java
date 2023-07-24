package com.company;

import java.time.LocalDate;
import java.util.LinkedList;

public class Patient {
    private String idPatient;
    private String nama;
    private LocalDate tanggalLahir;
    private LinkedList<Penyakit> listPenyakit = new LinkedList<>();
    private LinkedList<TreatmentSchedule> listJadwal = new LinkedList<>();

    public Patient(String id, String nama, LocalDate tanggalLahir) {
        this.idPatient = id;
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
    }

    public Patient(String id, String nama, LocalDate tanggalLahir, LinkedList<Penyakit> listPenyakit) {
        this.idPatient = id;
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.listPenyakit = listPenyakit;

    }


    public String getNama() {
        return this.nama;
    }

    public LocalDate getTanggalLahir() {
        return this.tanggalLahir;
    }

    public String getIdPatient() {
        return this.idPatient;
    }

    public void setIdPatient(String idPatient) {
        this.idPatient = idPatient;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setTanggalLahir(LocalDate tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }


    public LinkedList<Penyakit> getListPenyakit() {
        return listPenyakit;
    }

    public void setListPenyakit(LinkedList<Penyakit> listPenyakit) {
        this.listPenyakit = listPenyakit;
    }

    public LinkedList<TreatmentSchedule> getListJadwal() {
        return listJadwal;
    }

    public void setListJadwal(TreatmentSchedule listJadwal) {
        this.listJadwal.add(listJadwal);

    }

    public void printPatient() {
        System.out.println(String.format("ID : %s, Name : %s, Birth Date : %s , Age : %s", this.getIdPatient(), this.getNama(),
                Helper.FormatTanggal(this.getTanggalLahir()), Helper.hitungUsia(this.getTanggalLahir())));
        LinkedList<Penyakit> listPenyakit = this.getListPenyakit();
        if (!listPenyakit.isEmpty()) {
            for (Penyakit pen : listPenyakit) {
                System.out.println(String.format("Name : %s, Deskription %s", pen.getNamaPenyakit(), pen.getDeskripsi()));
            }
        }
        System.out.println("==========================================================");


    }
}
