package Modul4;

/**
 * Pelanggan Platinum (prefix nomor: 74)
 * - Pembelian > Rp1.000.000 → cashback 10%  (kembali ke saldo)
 * - Pembelian ≤ Rp1.000.000 → cashback 5%   (kembali ke saldo)
 */
public class Platinum extends Pelanggan {

    private static final double BATAS_CASHBACK         = 1_000_000;
    private static final double PERSEN_CASHBACK_ATAS   = 0.10;
    private static final double PERSEN_CASHBACK_BAWAH  = 0.05;

    public Platinum(String nomorPelanggan, String nama, double saldoAwal, String pin) {
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
        // Platinum: semua cashback kembali ke saldo
        return cashback;
    }

    @Override
    public String getJenis() {
        return "Platinum (74)";
    }
}
