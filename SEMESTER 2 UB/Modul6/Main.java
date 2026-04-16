import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== TEST CASE 1: MANUSIA ===");
        Manusia m1 = new Manusia("Budi", "111", true, true);
        System.out.println("Laki-laki telah menikah:");
        System.out.println(m1);
        System.out.println();

        Manusia m2 = new Manusia("Siti", "222", false, true);
        System.out.println("Perempuan telah menikah:");
        System.out.println(m2);
        System.out.println();

        Manusia m3 = new Manusia("Andi", "333", true, false);
        System.out.println("Belum menikah:");
        System.out.println(m3);
        System.out.println();

        System.out.println("\n=== TEST CASE 2: MAHASISWAFILKOM ===");
        MahasiswaFILKOM mah1 = new MahasiswaFILKOM("Eko", "444", true, false, "205150601111001", 2.8);
        System.out.println("IPK < 3:");
        System.out.println(mah1);
        System.out.println();

        MahasiswaFILKOM mah2 = new MahasiswaFILKOM("Dwi", "555", false, false, "215150701111001", 3.2);
        System.out.println("IPK 3.0 - 3.5:");
        System.out.println(mah2);
        System.out.println();

        MahasiswaFILKOM mah3 = new MahasiswaFILKOM("Tri", "666", true, false, "225150401111001", 3.8);
        System.out.println("IPK 3.5 - 4.0:");
        System.out.println(mah3);
        System.out.println();

        System.out.println("\n=== TEST CASE 3: PEKERJA ===");
        Pekerja p1 = new Pekerja("Joko", "777", true, true, 1000, LocalDate.now().minusYears(2), 2);
        System.out.println("Lama bekerja 2 tahun, anak 2:");
        System.out.println(p1);
        System.out.println();

        Pekerja p2 = new Pekerja("Ani", "888", false, true, 1000, LocalDate.now().minusYears(9), 0);
        System.out.println("Lama bekerja 9 tahun:");
        System.out.println(p2);
        System.out.println();

        Pekerja p3 = new Pekerja("Santo", "999", true, true, 1000, LocalDate.now().minusYears(20), 10);
        System.out.println("Lama bekerja 20 tahun, anak 10:");
        System.out.println(p3);
        System.out.println();

        System.out.println("\n=== TEST CASE 4: MANAGER ===");
        Manager man1 = new Manager("Bos", "000", true, true, 7500, LocalDate.now().minusYears(15), 0, "IT");
        System.out.println("Manager lama bekerja 15 tahun, gaji $7500:");
        System.out.println(man1);
    }
}
