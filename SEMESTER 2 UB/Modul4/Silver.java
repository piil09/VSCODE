package Modul4;

/**
 * Pelanggan Silver (prefix nomor: 38)
 * - Pembelian > Rp1.000.000 → cashback 5%
 * - Cashback TIDAK kembali ke saldo
 */
public class Silver extends Pelanggan {

    private static final double BATAS_CASHBACK   = 1_000_000;
    private static final double PERSEN_CASHBACK  = 0.05;

    public Silver(String nomorPelanggan, String nama, double saldoAwal, String pin) {
        super(nomorPelanggan, nama, saldoAwal, pin);
    }

    @Override
    public double hitungCashback(double jumlahBelanja) {
        if (jumlahBelanja > BATAS_CASHBACK) {
            return jumlahBelanja * PERSEN_CASHBACK;
        }
        return 0;
    }

    @Override
    public double getKashbackKeSaldo(double cashback) {
        // Silver: cashback hanya mengurangi tagihan, tidak kembali ke saldo
        return 0;
    }

    @Override
    public String getJenis() {
        return "Silver (38)";
    }
}
