import java.text.NumberFormat;
import java.util.Locale;


public class Motor extends Kendaraan {
    private String jenisTransmisi;

    public Motor(String kode, String nama, double hargaSewa, String jenisTransmisi) {
        super(kode, nama, hargaSewa);
        this.jenisTransmisi = jenisTransmisi;
    }

    public String getJenisTransmisi() {
        return jenisTransmisi;
    }

    public void setJenisTransmisi(String jenisTransmisi) {
        this.jenisTransmisi = jenisTransmisi;
    }

    @Override
    public void tampilInfo() {
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        System.out.println("[Motor]");
        System.out.println("Kode Kendaraan   : " + getKodeKendaraan());
        System.out.println("Nama Kendaraan   : " + getNamaKendaraan());
        System.out.println("Harga Sewa/Hari  : " + formatRupiah.format(getHargaSewaPerHari()));
        System.out.println("Jenis Transmisi  : " + jenisTransmisi);
        System.out.println("Status           : " + (isTersedia() ? "Tersedia" : "Tidak tersedia"));
        System.out.println("-------------------------------");
    }

    @Override
    public double hitungBiayaDasar(int lamaSewa) {
        double biayaDasar = lamaSewa * getHargaSewaPerHari();
        if ("Matik".equalsIgnoreCase(jenisTransmisi)) {
            biayaDasar += 10000 * lamaSewa; 
        }
        return biayaDasar;
    }
}
