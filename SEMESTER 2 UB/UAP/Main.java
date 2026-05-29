import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GoDriveSystem system = new GoDriveSystem();
        Scanner UAP = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("====== MENU GO DRIVE RENTAL SYSTEM ======");
            System.out.println("1. Tambah Kendaraan");
            System.out.println("2. Tampilkan Daftar Armada");
            System.out.println("3. Sewa Kendaraan");
            System.out.println("4. Kembalikan Kendaraan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            try {
                int pilihan = UAP.nextInt();
                UAP.nextLine(); 
                switch (pilihan) {
                    case 1:
                        tambahKendaraan(system, UAP);
                        break;
                    case 2:
                        system.tampilkanDaftarKendaraan();
                        break;
                    case 3:
                        sewaKendaraan(system, UAP);
                        break;
                    case 4:
                        kembalikanKendaraan(system, UAP);
                        break;
                    case 5:
                        running = false;
                        System.out.println("Terima kasih sudah menggunakan GoDrive.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih angka 1 sampai 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Masukkan angka yang benar.");
                UAP.nextLine();
            }
            System.out.println();
        }
        UAP.close();
    }

    private static void tambahKendaraan(GoDriveSystem system, Scanner UAP) {
        System.out.println("-- Tambah Kendaraan --");
        System.out.println("1. Mobil");
        System.out.println("2. Motor");
        System.out.print("Pilih tipe kendaraan (1-2): ");

        try {
            int tipe = UAP.nextInt();
            UAP.nextLine();
            System.out.print("Kode Kendaraan : ");
            String kode = UAP.nextLine().trim();
            System.out.print("Nama Kendaraan : ");
            String nama = UAP.nextLine().trim();
            System.out.print("Harga Sewa per Hari: ");
            double harga = UAP.nextDouble();
            UAP.nextLine();

            if (kode.isEmpty() || nama.isEmpty() || harga <= 0) {
                System.out.println("Data tidak valid. Kode, nama, dan harga sewa harus diisi dengan benar.");
                return;
            }

            switch (tipe) {
                case 1:
                    System.out.print("Jumlah Kursi   : ");
                    int kursi = UAP.nextInt();
                    UAP.nextLine();
                    if (kursi <= 0) {
                        System.out.println("Jumlah kursi harus lebih besar dari 0.");
                        return;
                    }
                    system.tambahKendaraan(new Mobil(kode, nama, harga, kursi));
                    break;
                case 2:
                    System.out.print("Jenis Transmisi (Manual/Matik): ");
                    String transmisi = UAP.nextLine().trim();
                    if (transmisi.isEmpty()) {
                        System.out.println("Jenis transmisi harus diisi.");
                        return;
                    }
                    system.tambahKendaraan(new Motor(kode, nama, harga, transmisi));
                    break;
                default:
                    System.out.println("Tipe kendaraan tidak valid.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Pastikan format angka dan teks benar.");
            UAP.nextLine();
        }
    }

    private static void sewaKendaraan(GoDriveSystem system, Scanner UAP) {
        System.out.println("-- Sewa Kendaraan --");
        System.out.print("Masukkan kode kendaraan yang ingin disewa: ");
        String kode = UAP.nextLine().trim();

        try {
            System.out.print("Masukkan durasi sewa (dalam hari): ");
            int lamaSewa = UAP.nextInt();
            UAP.nextLine();

            if (lamaSewa <= 0) {
                System.out.println("Lama sewa harus lebih dari 0.");
                return;
            }

            System.out.print("Apakah Anda Member VIP? (y/n): ");
            String jawaban = UAP.nextLine().trim();
            boolean vip = jawaban.equalsIgnoreCase("y");

            system.sewaKendaraan(kode, lamaSewa, vip);
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Masukkan angka untuk lama sewa.");
            UAP.nextLine();
        } catch (KendaraanTidakTersedia e) {
            e.printStackTrace();
        }
    }

    private static void kembalikanKendaraan(GoDriveSystem system, Scanner scanner) {
        System.out.println("-- Kembalikan Kendaraan --");
        System.out.print("Masukkan kode kendaraan: ");
        String kode = scanner.nextLine().trim();
        system.kembalikanKendaraan(kode);
    }
}
