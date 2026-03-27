package Modul4;

public abstract class Pelanggan {
    // Informasi akun tidak bisa diubah langsung (private + encapsulation)
    private String nomorPelanggan;  // 10 digit, 2 digit awal = jenis rekening
    private String nama;
    private double saldo;
    private String pin;
    private boolean diblokir;
    private int percobaan; // hitung kesalahan PIN

    private static final double SALDO_MINIMUM = 10_000;

    // Constructor
    public Pelanggan(String nomorPelanggan, String nama, double saldoAwal, String pin) {
        this.nomorPelanggan = nomorPelanggan;
        this.nama = nama;
        this.saldo = saldoAwal;
        this.pin = pin;
        this.diblokir = false;
        this.percobaan = 0;
    }

    // ─── Getter (read-only oleh pelanggan) ──────────────────────────────────
    public String getNomorPelanggan() { return nomorPelanggan; }
    public String getNama()           { return nama; }
    public double getSaldo()          { return saldo; }
    public boolean isDiblokir()       { return diblokir; }
    public int getPercobaan()         { return percobaan; }

    // ─── Autentikasi PIN ────────────────────────────────────────────────────
    /**
     * Memverifikasi PIN yang dimasukkan.
     * Jika 3x salah, akun diblokir.
     * @return true jika PIN benar
     */
    public boolean verifikasiPin(String inputPin) {
        if (diblokir) {
            System.out.println("[!] Akun Anda telah diblokir. Hubungi customer service.");
            return false;
        }
        if (pin.equals(inputPin)) {
            percobaan = 0; // reset counter jika benar
            return true;
        } else {
            percobaan++;
            System.out.println("[!] PIN salah. Percobaan ke-" + percobaan + "/3.");
            if (percobaan >= 3) {
                diblokir = true;
                System.out.println("[!] Akun diblokir karena 3x kesalahan PIN.");
            }
            return false;
        }
    }

    // ─── Top Up ─────────────────────────────────────────────────────────────
    /**
     * Top up saldo menggunakan PIN.
     */
    public void topUp(String inputPin, double jumlah) {
        if (!verifikasiPin(inputPin)) return;
        if (jumlah <= 0) {
            System.out.println("[!] Jumlah top up harus lebih dari 0.");
            return;
        }
        saldo += jumlah;
        System.out.printf("[√] Top up berhasil. Saldo sekarang: Rp%.2f%n", saldo);
    }

    // ─── Pembelian (abstrak – subclass yang hitung cashback) ─────────────────
    /**
     * Template method: tiap subclass mengimplementasi hitungCashback().
     */
    public void beli(String inputPin, double jumlahBelanja) {
        if (!verifikasiPin(inputPin)) return;
        if (jumlahBelanja <= 0) {
            System.out.println("[!] Jumlah belanja harus lebih dari 0.");
            return;
        }

        double cashback = hitungCashback(jumlahBelanja);
        double biayaEfektif = jumlahBelanja - cashback;
        double saldoSetelah = saldo - biayaEfektif;

        if (saldoSetelah < SALDO_MINIMUM) {
            System.out.printf("[!] Transaksi gagal. Saldo tidak mencukupi (minimal Rp%.2f).%n", SALDO_MINIMUM);
            System.out.printf("    Saldo saat ini : Rp%.2f%n", saldo);
            System.out.printf("    Biaya efektif  : Rp%.2f%n", biayaEfektif);
            return;
        }

        saldo = saldoSetelah + getKashbackKeSaldo(cashback); // cashback tertentu kembali ke saldo
        System.out.printf("[√] Pembelian berhasil!%n");
        System.out.printf("    Total belanja  : Rp%.2f%n", jumlahBelanja);
        System.out.printf("    Cashback       : Rp%.2f%n", cashback);
        System.out.printf("    Cashback ke saldo: Rp%.2f%n", getKashbackKeSaldo(cashback));
        System.out.printf("    Saldo sekarang : Rp%.2f%n", saldo);
    }

    // ─── Info Akun ──────────────────────────────────────────────────────────
    public void tampilInfo() {
        System.out.println("==============================");
        System.out.println("  Nomor Pelanggan : " + nomorPelanggan);
        System.out.println("  Nama            : " + nama);
        System.out.printf ("  Saldo           : Rp%.2f%n", saldo);
        System.out.println("  Jenis           : " + getJenis());
        System.out.println("  Status          : " + (diblokir ? "DIBLOKIR" : "Aktif"));
        System.out.println("==============================");
    }

    // ─── Abstract methods (wajib diimplementasi subclass) ───────────────────
    /** Hitung total cashback berdasarkan jumlah belanja */
    public abstract double hitungCashback(double jumlahBelanja);

    /** Porsi cashback yang kembali ke saldo (berbeda tiap tier) */
    public abstract double getKashbackKeSaldo(double cashback);

    /** Label jenis pelanggan */
    public abstract String getJenis();
}
