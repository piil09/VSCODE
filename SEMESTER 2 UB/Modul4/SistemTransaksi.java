package Modul4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class SistemTransaksi {

    private static Map<String, Pelanggan> database = new HashMap<>();

    public static void main(String[] args) {
        inisialisasiData();

        Scanner sc = new Scanner(System.in);
        System.out.println("========================================");
        System.out.println("   SISTEM TRANSAKSI SWALAYAN TINY       ");
        System.out.println("========================================");

        boolean lanjut = true;
        while (lanjut) {
            System.out.println("\n MENU UTAMA===========================");
            System.out.println("  1. Pembelian                         ");
            System.out.println("  2. Top Up Saldo                      ");
            System.out.println("  3. Cek Info Akun                     ");
            System.out.println("  4. Keluar                            ");
            System.out.println("=======================================");
            System.out.print("Pilih menu: ");

            String pilihan = sc.nextLine().trim();

            switch (pilihan) {
                case "1" -> menuPembelian(sc);
                case "2" -> menuTopUp(sc);
                case "3" -> menuInfoAkun(sc);
                case "4" -> {
                    System.out.println("Terima kasih telah berbelanja di Swalayan Tiny!");
                    lanjut = false;
                }
                default  -> System.out.println("[!] Pilihan tidak valid.");
            }
        }
        sc.close();
    }

    private static Pelanggan cariPelanggan(Scanner sc) {
        System.out.print("Nomor Pelanggan (10 digit): ");
        String nomor = sc.nextLine().trim();

        if (!database.containsKey(nomor)) {
            System.out.println("[!] Nomor pelanggan tidak ditemukan.");
            return null;
        }
        return database.get(nomor);
    }

    private static void menuPembelian(Scanner sc) {
        System.out.println("\n=== PEMBELIAN ===");
        Pelanggan p = cariPelanggan(sc);
        if (p == null) return;

        System.out.print("Masukkan PIN: ");
        String pin = sc.nextLine().trim();

        System.out.print("Total belanja (Rp): ");
        double jumlah;
        try {
            jumlah = Double.parseDouble(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("[!] Jumlah tidak valid.");
            return;
        }

        p.beli(pin, jumlah);
    }

    private static void menuTopUp(Scanner sc) {
        System.out.println("\n=== TOP UP SALDO ===");
        Pelanggan p = cariPelanggan(sc);
        if (p == null) return;

        System.out.print("Masukkan PIN: ");
        String pin = sc.nextLine().trim();

        System.out.print("Jumlah top up (Rp): ");
        double jumlah;
        try {
            jumlah = Double.parseDouble(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("[!] Jumlah tidak valid.");
            return;
        }

        p.topUp(pin, jumlah);
    }

    private static void menuInfoAkun(Scanner sc) {
        System.out.println("\n=== INFO AKUN ===");
        Pelanggan p = cariPelanggan(sc);
        if (p == null) return;
        p.tampilInfo();
    }

    private static void inisialisasiData() {
        database.put("0380000000", new Silver  ("0380000000", "Gavril",  500_000, "1234"));
        database.put("0560000000", new Gold    ("0560000000", "Piil", 2_000_000, "5678"));
        database.put("0740000000", new Platinum("0740000000", "Paul",   5_000_000, "9999"));
    }
}
