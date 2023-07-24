package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Helper{
    public static String FormatTanggal(LocalDate value){
        Locale indo = new Locale("id","ID");
        String hasil = value == null ? "" : DateTimeFormatter.ofPattern("dd-MM-yyyy",indo).format(value);
        return hasil;
    }
    public static String FormatTanggalWaktu(LocalDateTime value){
        Locale indo = new Locale("id","ID");
        String hasil = value == null ? "" : DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm",indo).format(value);
        return hasil;
    }
    public static Long hitungUsia (LocalDate tanggalLahir){
        long usia = ChronoUnit.DAYS.between(tanggalLahir,LocalDate.now())/365;
        String.format("%s Tahun",usia);
        return usia;
    }
    public static DateTimeFormatter formatInputTanggal(){
        Locale formatIndo = new Locale("id", "ID");
        DateTimeFormatter formatTanggal = DateTimeFormatter.ofPattern("dd/MM/yyyy", formatIndo);
        return formatTanggal;
    }
    public static DateTimeFormatter FormatTanggalWaktu(){
        Locale indo = new Locale("id","ID");
        DateTimeFormatter formatwaktu = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm",indo);
        return formatwaktu;
    }

}
