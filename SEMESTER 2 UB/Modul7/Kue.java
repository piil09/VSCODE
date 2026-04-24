public abstract class Kue {
    private String nama;
    private double harga;

    public Kue(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public abstract double hitungHarga();

    @Override
    public String toString() {
        return String.format("Nama Kue: %-15s | Harga Dasar: Rp%,10.2f", nama, harga);
    }
}
