public class Invoice implements Payable {
    private String namaBarang;
    private Integer jumlahBeli;
    private Integer hargaSatuan;

    public Invoice(String namaBarang, Integer jumlahBeli, Integer hargaSatuan) {
        this.namaBarang = namaBarang;
        this.jumlahBeli = jumlahBeli;
        this.hargaSatuan = hargaSatuan;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public Integer getJumlahBeli() {
        return jumlahBeli;
    }

    public Integer getHargaSatuan() {
        return hargaSatuan;
    }

    @Override
    public Integer hitungTotalBayar() {
        return jumlahBeli * hargaSatuan;
    }

    @Override
    public String toString() {
        // Mengubah format output agar tidak sama dengan aslinya
        return String.format(
            "    > %-20s [Qty: %d, Harga: Rp%,d] -> Subtotal: Rp%,d",
            namaBarang, jumlahBeli, hargaSatuan, hitungTotalBayar()
        );
    }

    @Override
    public Integer getPayableAmount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}