import java.text.NumberFormat;
import java.util.Locale;


public class Mobil extends Kendaraan {
    private int jumlahKursi;

    public Mobil(String kode, String nama, double hargaSewa, int jumlahKursi) {
        super(kode, nama, hargaSewa);
        this.jumlahKursi = jumlahKursi;
    }

    public int getJumlahKursi() {
        return jumlahKursi;
    }

    public void setJumlahKursi(int jumlahKursi) {
        this.jumlahKursi = jumlahKursi;
    }

    @Override
    public void tampilInfo() {
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        System.out.println("[Mobil]");
        System.out.println("Kode Kendaraan   : " + getKodeKendaraan());
        System.out.println("Nama Kendaraan   : " + getNamaKendaraan());
        System.out.println("Harga Sewa/Hari  : " + formatRupiah.format(getHargaSewaPerHari()));
        System.out.println("Jumlah Kursi     : " + jumlahKursi);
        System.out.println("Status           : " + (isTersedia() ? "Tersedia" : "Tidak tersedia"));
        System.out.println("-------------------------------");
    }

    @Override
    public double hitungBiayaDasar(int lamaSewa) {
        double biayaDasar = lamaSewa * getHargaSewaPerHari();
        if (jumlahKursi > 5) {
            biayaDasar += 50000; 
        }
        return biayaDasar;
    }
}
