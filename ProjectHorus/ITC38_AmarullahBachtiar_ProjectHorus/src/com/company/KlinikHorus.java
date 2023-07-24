package com.company;

import com.company.KumpulanEnum.EnumMedicalCheckup;
import com.company.Pelayanan.MedicalCheckup;
import com.company.Pelayanan.Medication;
import com.company.Pelayanan.Therapy;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class KlinikHorus {
    private static HashMap<String, Patient> listPatient = new HashMap<>();
    public static LinkedList<ListDokter>listDokter = new LinkedList<>();
    public static void Main() {
        setData();
        MainMenu();
    }
    public static void setData(){
        ListDokter dokterBoyke = new ListDokter("Boyke");
        ListDokter dokterRudi = new ListDokter("rudi");
        ListDokter dokterCahya = new ListDokter("cahya");
        listDokter.add(dokterBoyke);
        listDokter.add(dokterRudi);
        listDokter.add(dokterCahya);
    }

    public static void MainMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        boolean cek = false;

        do {
            System.out.println("""
                Pilih salah satu angka menu :
                1.Tambah patient
                2.Daftar Medical Checkup
                3.Daftar Medication
                4.Daftar Therapy
                5.Treatment Schedule
                6.Exit Application
                """);
            try {
                pilihan = Integer.parseInt(scanner.nextLine().trim());
                switch (pilihan) {
                    case 1:
                        TambahPatient();
                        MainMenu();
                        break;
                    case 2:
                        MedicalCheckUp();
                        MainMenu();
                        break;
                    case 3:
                        Medication();
                        MainMenu();
                        break;
                    case 4:
                        Therapy();
                        MainMenu();
                        break;
                    case 5:
                        treatmentSchedule();
                        MainMenu();
                        break;
                    case 6:
                        System.out.println("Keluar dari aplikasi , terima kasih......");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Harus masukan angka 1 - 6, silahkan coba lagi!");
                        MainMenu();
                        break;

                }
            } catch (Exception ex) {
                System.out.println("Harus masukan angka 1 - 6, silahkan coba lagi!");
            }
        } while (!cek);
    }


    public static void TambahPatient() {
        Scanner scanner = new Scanner(System.in);
        String id , nama, namaPenyakit, deskripsiPenyakit;
        LocalDate tanggalLahir = null;
        boolean cek = false;
        if (listPatient.isEmpty()) {
            System.out.println("Tidak ada patient");
        } else {
            for (Patient pas : listPatient.values()) {
                pas.printPatient();
            }
        }

        Patient newPatien;
        System.out.println("Input patient id (Patient id harus unik,menginput id yang sama akan me-replace patient sebelumnya)");
        id = scanner.nextLine().trim();
        if (listPatient.containsKey(id)) {
            System.out.println("Input nama patient :");
            nama = scanner.nextLine().trim();
            do {
                try {
                    System.out.println("Input tanggal lahir patient (dd/MM/yyyy)");
                    tanggalLahir = LocalDate.parse(scanner.nextLine(), Helper.formatInputTanggal());
                    cek = true;
                } catch (Exception ex) {
                    System.out.println("Input tanggal tidak dalam format yang benar, coba lagi");
                }
            } while (!cek);
            newPatien = new Patient(id, nama, tanggalLahir);

            newPatien.setNama(nama);
            newPatien.setTanggalLahir(tanggalLahir);
            listPatient.put(newPatien.getIdPatient(), newPatien);
        } else {
            System.out.println("Input nama patient :");
            nama = scanner.nextLine().trim();
            do {
                try {
                    System.out.println("Input tanggal lahir patient (dd/MM/yyyy)");
                    tanggalLahir = LocalDate.parse(scanner.nextLine().trim(), Helper.formatInputTanggal());
                    cek = true;
                } catch (Exception ex) {
                    System.out.println("Input tanggal tidak dalam format yang benar, coba lagi");
                }
            } while (!cek);
            newPatien = new Patient(id, nama, tanggalLahir);
            newPatien.setIdPatient(id);
            newPatien.setNama(nama);
            newPatien.setTanggalLahir(tanggalLahir);
            listPatient.put(newPatien.getIdPatient(), newPatien);
        }
        if (Helper.hitungUsia(tanggalLahir) > 65) {
            do {
                System.out.println("Apakah patient memiliki penyakit kornis? (Y/N)");
                String konfirmasi = scanner.nextLine();
                if (konfirmasi.equalsIgnoreCase("Y")) {
                    System.out.println("Nama Penyakit :");
                    namaPenyakit = scanner.nextLine();
                    System.out.println("Keterangan :");
                    deskripsiPenyakit = scanner.nextLine();
//                Patient newPaitent = listPatient.get(id);
                    Penyakit penyakit = new Penyakit(namaPenyakit, deskripsiPenyakit);
                    LinkedList<Penyakit> penyakitLinkedList = newPatien.getListPenyakit();
                    penyakitLinkedList.add(penyakit);
                    newPatien.setListPenyakit(penyakitLinkedList);
                    cek = false;
                } else {
                    cek = true;
                }
            } while (!cek);
            System.out.println("================Entry selesai===============");
        }
    }

    public static void MedicalCheckUp() {
        Scanner scanner = new Scanner(System.in);
        Patient patient;
        String namaDokter;
        Integer durasi = 0;
        LocalDateTime startDate = null;
        LocalDateTime endtDate = null;
        boolean cek = false;
        if (listPatient.isEmpty()) {
            System.out.println("Tidak ada patient");
        } else {
            for (Patient pas : listPatient.values()) {
                pas.printPatient();
            }

        }
        do {
            System.out.println("Pilih satu patient dengan meng-input ID-nya :");
            String idPatient = scanner.nextLine();
            patient = listPatient.get(idPatient);
            if (listPatient.containsKey(idPatient)) {
                do {
                    try {
                        System.out.println("input durasi dalam menit :");
                        durasi = Integer.parseInt(scanner.nextLine().trim());
                        if (durasi < 1) {
                            System.out.println("tidak boleh dibawah nol!");

                        } else {
                            cek = true;
                        }
                    } catch (Exception ex) {
                        System.out.println("input dalam menit");
                    }
                } while (!cek);
                cek = false;
                do {
                    try {
                        System.out.println("Input tanggal dan jam treatment (dd/MM/yyyy HH:mm)");
                        startDate = LocalDateTime.parse(scanner.nextLine(), Helper.FormatTanggalWaktu());
                        if (startDate.isBefore(LocalDateTime.now())) {
                        }else if (jadwalSama(startDate, durasi)) {
                            System.out.println("Waktu mulai tidak available, silahkan masukan waktu lainnya");
                        } else {
                            cek = true;
                        }
                    } catch (Exception ex) {
                        System.out.println("Input tanggal dan jam tidak dalam format yang benar,coba lagi ");
                    }
                } while (!cek);
                for (ListDokter dokter: listDokter) {
                    System.out.println(String.format("Nama Dokter : %s", dokter.getNamaDokter()));
                }
                cek= false;
                do {
                    System.out.println("Input nama dokter :");
                    namaDokter = scanner.nextLine().trim();
                    for (ListDokter dokter : listDokter) {
                            if (dokter.equals(namaDokter)){
                                cek=true;
                            }


                    }

                    if (!cek){
                        System.out.println("dokter tidak ada ");
                    }
                } while (!cek);
                for (EnumMedicalCheckup enumMedical : EnumMedicalCheckup.values()
                ) {
                    System.out.println(String.format("Code : %s, Name : %s ", enumMedical.getCode(), enumMedical.getNama()));
                }
                do {
                    try {
                        System.out.println("Input code checkup method yang tersedia di atas. ");
                        String code = scanner.nextLine().trim().toUpperCase();
                        EnumMedicalCheckup codeCheckUp = EnumMedicalCheckup.valueOf(code);
                        patient.setListJadwal(new MedicalCheckup(patient, durasi, startDate, namaDokter, codeCheckUp));

                        cek = true;

                    } catch (Exception ex) {

                        System.out.println("Method code tidak tersedia. ");
                        cek = false;
                    }
                } while (!cek);
            } else {
                System.out.println("Pasien tidak ditemukan, silahkan coba lagi");
            }
        } while (!cek);

    }

    public static void Medication() {
        Scanner scanner = new Scanner(System.in);
        Patient patient;
        Integer durasi = 0;
        String nameMedication;
        LocalDateTime startDate = null;
        LocalDateTime endDate = null;
        Integer quantity = 0;
        boolean cek = false;
        if (listPatient.isEmpty()) {
            System.out.println("Tidak ada patient");
        } else {
            for (Patient pas : listPatient.values()) {
                pas.printPatient();
            }

        }
        do {
            System.out.println("Pilih satu patient dengan meng-input ID-nya :");
            String idPatient = scanner.nextLine();
            patient = listPatient.get(idPatient);
            if (listPatient.containsKey(idPatient)) {
                do {
                    try {
                        System.out.println("input durasi dalam menit (Menit) :");
                        durasi = Integer.parseInt(scanner.nextLine().trim());
                        if (durasi < 1) {
                            System.out.println("tidak boleh dibawah nol");
                        } else {
                            cek = true;
                        }
                    } catch (Exception ex) {
                        System.out.println("input dalam menit");
                    }
                } while (!cek);

                cek = false;
                do {
                    try {
                        System.out.println("Input tanggal dan jam treatment (dd/MM/yyyy HH:mm)");
                        startDate = LocalDateTime.parse(scanner.nextLine(), Helper.FormatTanggalWaktu());
                        if (startDate.isBefore(LocalDateTime.now())) {
                        }else if (jadwalSama(startDate, durasi)) {
                            System.out.println("Waktu mulai tidak available, silahkan masukan waktu lainnya");
                        } else {
                            cek = true;
                        }
                    } catch (Exception ex) {
                        System.out.println("Input tanggal dan jam tidak dalam format yang benar,coba lagi ");
                    }
                } while (!cek);
                do {
                    System.out.println("Input nama medication :");
                    nameMedication = scanner.nextLine();
                } while (!cek);
                cek = false;
                do {
                    try {
                        System.out.println("input quantity :");
                        quantity = Integer.parseInt(scanner.nextLine().trim());
                        if (quantity < 1) {
                            System.out.println("tidak boleh dibawah nol");
                        } else {
                            cek = true;
                        }
                    } catch (Exception ex) {
                        System.out.println("invalid format!");
                    }
                } while (!cek);
                patient.setListJadwal(new Medication(patient, durasi, startDate, nameMedication, quantity));
            } else {
                System.out.println("Pasien tidak ditemukan, silahkan coba lagi");
            }
        } while (!cek);

    }
    public static void Therapy() {
        Scanner scanner = new Scanner(System.in);
        Patient patient;
        Integer durasi = 0;
        String nameTreatment;
        LocalDateTime startDate = null;
        LocalDateTime endDate = null;
        String nameTherapist;
        boolean cek = false;
        if (listPatient.isEmpty()) {
            System.out.println("Tidak ada patient");
        } else {
            for (Patient pas : listPatient.values()) {
                pas.printPatient();
            }

        }
        do {
            System.out.println("Pilih satu patient dengan meng-input ID-nya :");
            String idPatient = scanner.nextLine();
            patient = listPatient.get(idPatient);
            if (listPatient.containsKey(idPatient)) {
                do {
                    try {
                        System.out.println("input durasi dalam menit :");
                        durasi = Integer.parseInt(scanner.nextLine().trim());
                        if (durasi < 1) {
                            System.out.println("tidak boleh dibawah nol");

                        } else {
                            cek = true;
                        }
                    } catch (Exception ex) {
                        System.out.println("input dalam menit");
                    }
                } while (!cek);

                cek = false;
                do {
                    try {
                        System.out.println("Input tanggal dan jam treatment (dd/MM/yyyy HH:mm)");
                        startDate = LocalDateTime.parse(scanner.nextLine(), Helper.FormatTanggalWaktu());
                        if (startDate.isBefore(LocalDateTime.now())) {
                        }else if (jadwalSama(startDate, durasi)) {
                            System.out.println("Waktu mulai tidak available, silahkan masukan waktu lainnya");
                            cek = false;
                        } else {
                            cek = true;
                        }
                    } catch (Exception ex) {
                        System.out.println("Input tanggal dan jam tidak dalam format yang benar,coba lagi ");
                    }
                } while (!cek);
                cek = false;
                do {
                    System.out.println("Input nama treatment :");
                    nameTreatment = scanner.nextLine();
                    cek = true;
                } while (!cek);
                cek = false;
                do {
                    System.out.println("Input nama therapist : ");
                    nameTherapist = scanner.nextLine().trim();
                    cek = true;
                } while (!cek);
                patient.setListJadwal(new Therapy(patient, durasi, startDate,nameTreatment, nameTherapist));
            } else {
                System.out.println("Pasien tidak ditemukan, silahkan coba lagi");
            }
        } while (!cek);

    }

    private static boolean jadwalSama(LocalDateTime startDate, Integer durasi) {
        LinkedList<TreatmentSchedule> jadwalLinkedList = new LinkedList<>();
        for (Patient pas : listPatient.values()) {
            for (TreatmentSchedule jad : pas.getListJadwal()) {
                jadwalLinkedList.add(jad);
            }
        }
        for (TreatmentSchedule jadwal : jadwalLinkedList) {
            LocalDateTime JadwaMulai = jadwal.getStratDate();
            LocalDateTime JadwalSelesai = jadwal.getEndDate();
            LocalDateTime JadwalSelesaiBaru = startDate.plusMinutes(durasi);
            if (startDate.isBefore(JadwalSelesai) && JadwalSelesaiBaru.isAfter(JadwaMulai)) {
                return true; // Jadwal bentrok

            }
        }
        return false;
    }

    public static void treatmentSchedule() {
        for (Patient patient : listPatient.values()) {
            for (TreatmentSchedule jadwal : patient.getListJadwal()) {
                jadwal.cetakScedule();
                System.out.println("=============================================================");
            }
        }
    }
}
