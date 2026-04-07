import java.util.Scanner;

public class Kalkulator {

    // 1. Method penjumlahan (Static)
    public static double penjumlahan(double a, double b) {
        return a + b;
    }

    // 2. Method pengurangan (Static)
    public static double pengurangan(double a, double b) {
        return a - b;
    }

    // 3. Method perkalian (Non-Static)
    public double perkalian(double a, double b) {
        return a * b;
    }

    // 4. Method pembagian (Non-Static)
    public double pembagian(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Pembagian dengan nol tidak diizinkan.");
            return 0;
        }
        return a / b;
    }

    // 5. Method menyederhanakan pecahan (Non-Static)
    public void Sederhana(int pembilang, int penyebut) {
        if (penyebut == 0) {
            System.out.println("Penyebut tidak boleh nol.");
            return;
        }
        
        // Mencari FPB (Faktor Persekutuan Terbesar)
        int fpb = 1;
        for (int i = 1; i <= pembilang && i <= Math.abs(penyebut); i++) {
            if (pembilang % i == 0 && penyebut % i == 0) {
                fpb = i;
            }
        }
        
        int hasilPembilang = pembilang / fpb;
        int hasilPenyebut = penyebut / fpb;
        System.out.println("Bentuk sederhana dari " + pembilang + "/" + penyebut + " adalah " + hasilPembilang + "/" + hasilPenyebut);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Kalkulator calc = new Kalkulator(); // Objek untuk memanggil method non-static

        System.out.println("=== Uji Coba Kalkulator ===");
        System.out.print("Masukkan nilai pertama: ");
        double nil1 = in.nextDouble();
        System.out.print("Masukkan nilai kedua: ");
        double nil2 = in.nextDouble();

        // Memanggil method static langsung dengan nama Class
        System.out.println("Hasil Penjumlahan : " + Kalkulator.penjumlahan(nil1, nil2));
        System.out.println("Hasil Pengurangan : " + Kalkulator.pengurangan(nil1, nil2));

        // Memanggil method non-static melalui objek
        System.out.println("Hasil Perkalian   : " + calc.perkalian(nil1, nil2));
        System.out.println("Hasil Pembagian   : " + calc.pembagian(nil1, nil2));

        System.out.println("\n=== Uji Coba Penyederhanaan Pecahan ===");
        System.out.print("Masukkan pembilang: ");
        int pembilang = in.nextInt();
        System.out.print("Masukkan penyebut: ");
        int penyebut = in.nextInt();
        
        calc.Sederhana(pembilang, penyebut);
    }
}