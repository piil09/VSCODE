public class KueJadi extends Kue {
    private double jumlah;

    public KueJadi(String nama, double harga, double jumlah) {
        super(nama, harga);
        this.jumlah = jumlah;
    }

    public double getJumlah() {
        return jumlah;
    }

    @Override
    public double hitungHarga() {
        return getHarga() * jumlah * 2;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Jumlah: %5.0f    | Total: Rp%,10.2f (Jadi)", jumlah, hitungHarga());
    }
}
