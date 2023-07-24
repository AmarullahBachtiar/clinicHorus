package com.company;

public class Penyakit {
    private Patient patient;
    private String namaPenyakit;
    private String deskripsi;

    public Penyakit( String namaPenyakit, String deskripsi){

        this.namaPenyakit = namaPenyakit;
        this.deskripsi =deskripsi;
    }


    public String getNamaPenyakit() {
        return namaPenyakit;
    }

    public String getDeskripsi() {
        return deskripsi;
    }


    public void setNamaPenyakit(String namaPenyakit) {
        this.namaPenyakit = namaPenyakit;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

}
