import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class GoDriveSystem {
    private ArrayList<Kendaraan> daftarKendaraan;

    public GoDriveSystem() {
        daftarKendaraan = new ArrayList<>();
    }

    public void tambahKendaraan(Kendaraan k) {
        daftarKendaraan.add(k);
        System.out.println("Kendaraan berhasil ditambahkan: " + k.getNamaKendaraan());
    }

    public void tampilkanDaftarKendaraan() {
        if (daftarKendaraan.isEmpty()) {
            System.out.println("Belum ada kendaraan di daftar.");
            return;
        }

        System.out.println("=== Daftar Kendaraan GoDrive ===");
        for (Kendaraan k : daftarKendaraan) {
            k.tampilInfo();
        }
    }

    public void sewaKendaraan(String kode, int lamaSewa) throws KendaraanTidakTersedia {
        sewaKendaraan(kode, lamaSewa, false);
    }

    public void sewaKendaraan(String kode, int lamaSewa, boolean vip) throws KendaraanTidakTersedia {
        Kendaraan kendaraan = cariKendaraan(kode);
        if (kendaraan == null || !kendaraan.isTersedia()) {
            throw new KendaraanTidakTersedia("Kendaraan dengan kode " + kode + " gagal disewa. Alasan: Kendaraan sedang disewa atau tidak ditemukan!");
        }
        kendaraan.setTersedia(false);

        double biayaDasar = kendaraan.hitungBiayaDasar(lamaSewa);
        double diskon = 0;
        if (lamaSewa > 7) {
            diskon += 0.10 * biayaDasar; 
        }
        if (vip) {
            diskon += 0.05 * biayaDasar;
        }
        double totalBiaya = biayaDasar - diskon;
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

        System.out.println("=== Detail Transaksi Penyewaan ===");
        System.out.println("Kode Kendaraan    : " + kendaraan.getKodeKendaraan());
        System.out.println("Nama Kendaraan    : " + kendaraan.getNamaKendaraan());
        System.out.println("Lama Sewa         : " + lamaSewa + " hari");
        System.out.println("Biaya Dasar       : " + formatRupiah.format(biayaDasar));
        if (diskon > 0) {
            System.out.println("Diskon            : " + formatRupiah.format(diskon));
        }
        System.out.println("Total Biaya       : " + formatRupiah.format(totalBiaya));
        System.out.println("Status Kendaraan  : Tidak tersedia");
        System.out.println("===============================\n");
    }

    public void kembalikanKendaraan(String kode) {
        Kendaraan kendaraan = cariKendaraan(kode);
        if (kendaraan == null) {
            System.out.println("Kendaraan dengan kode " + kode + " tidak ditemukan.");
            return;
        }
        kendaraan.setTersedia(true);
        System.out.println("Kendaraan " + kendaraan.getNamaKendaraan() + " berhasil dikembalikan dan sekarang tersedia lagi.");
    }

    private Kendaraan cariKendaraan(String kode) {
        for (Kendaraan k : daftarKendaraan) {
            if (k.getKodeKendaraan().equalsIgnoreCase(kode)) {
                return k;
            }
        }
        return null;
    }
}
