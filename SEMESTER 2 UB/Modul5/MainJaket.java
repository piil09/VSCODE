import java.util.Scanner;

class Jaket {
    private final int HARGA_A = 100000;
    private final int HARGA_B = 125000;
    private final int HARGA_C = 175000;

    public void hitungTotal(int jmlA, int jmlB, int jmlC) {
        int totalA = (jmlA > 100) ? jmlA * 95000 : jmlA * HARGA_A;
        int totalB = (jmlB > 100) ? jmlB * 120000 : jmlB * HARGA_B;
        int totalC = (jmlC > 100) ? jmlC * 160000 : jmlC * HARGA_C;

        System.out.println("\n--- Detail Pembayaran ---");
        System.out.println("Total Jaket A: Rp " + totalA);
        System.out.println("Total Jaket B: Rp " + totalB);
        System.out.println("Total Jaket C: Rp " + totalC);
        System.out.println("-------------------------");
        System.out.println("Grand Total  : Rp " + (totalA + totalB + totalC));
    }
}

public class MainJaket {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Jaket toko = new Jaket();

        System.out.print("Masukkan jumlah Jaket A: ");
        int a = in.nextInt();
        System.out.print("Masukkan jumlah Jaket B: ");
        int b = in.nextInt();
        System.out.print("Masukkan jumlah Jaket C: ");
        int c = in.nextInt();

        toko.hitungTotal(a, b, c);
    }
}