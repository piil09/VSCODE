package Modul4;

/**
 * Pelanggan Gold (prefix nomor: 56)
 * - Pembelian > Rp1.000.000 → cashback 7%  (kembali ke saldo)
 * - Pembelian ≤ Rp1.000.000 → cashback 2%  (kembali ke saldo)
 */
public class Gold extends Pelanggan {

    private static final double BATAS_CASHBACK         = 1_000_000;
    private static final double PERSEN_CASHBACK_ATAS   = 0.07;
    private static final double PERSEN_CASHBACK_BAWAH  = 0.02;

    public Gold(String nomorPelanggan, String nama, double saldoAwal, String pin) {
        super(nomorPelanggan, nama, saldoAwal, pin);
    }

    @Override
    public double hitungCashback(double jumlahBelanja) {
        if (jumlahBelanja > BATAS_CASHBACK) {
            return jumlahBelanja * PERSEN_CASHBACK_ATAS;
        }
        return jumlahBelanja * PERSEN_CASHBACK_BAWAH;
    }

    @Override
    public double getKashbackKeSaldo(double cashback) {
        // Gold: semua cashback kembali ke saldo
        return cashback;
    }

    @Override
    public String getJenis() {
        return "Gold (56)";
    }
}
