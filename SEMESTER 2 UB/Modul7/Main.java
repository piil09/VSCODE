public class Main {
    public static void main(String[] args) {
        Kue[] daftarKue = new Kue[20];

        daftarKue[0] = new KuePesanan("Bolu Gulung", 50000, 1.5);
        daftarKue[1] = new KueJadi("Lapis Legit", 100000, 2);
        daftarKue[2] = new KuePesanan("Brownies", 75000, 0.8);
        daftarKue[3] = new KueJadi("Nastar", 150000, 3);
        daftarKue[4] = new KuePesanan("Kue Cubit", 20000, 2.0);
        daftarKue[5] = new KueJadi("Kue Lumpur", 5000, 10);
        daftarKue[6] = new KuePesanan("Kue Cucur", 3000, 5.0);
        daftarKue[7] = new KueJadi("Kue Putu", 4000, 15);
        daftarKue[8] = new KuePesanan("Kue Klepon", 2000, 4.0);
        daftarKue[9] = new KueJadi("Onde-onde", 2500, 20);
        daftarKue[10] = new KuePesanan("Bika Ambon", 60000, 1.2);
        daftarKue[11] = new KueJadi("Donat", 8000, 12);
        daftarKue[12] = new KuePesanan("Lumpia", 15000, 3.5);
        daftarKue[13] = new KueJadi("Roti Bakar", 15000, 5);
        daftarKue[14] = new KuePesanan("Kue Sus", 10000, 2.5);
        daftarKue[15] = new KueJadi("Martabak Manis", 45000, 2);
        daftarKue[16] = new KuePesanan("Kue Pancong", 12000, 1.8);
        daftarKue[17] = new KueJadi("Kue Serabi", 7000, 8);
        daftarKue[18] = new KuePesanan("Kue Ape", 5000, 10.0);
        daftarKue[19] = new KueJadi("Kue Pukis", 3000, 25);

        System.out.println("=== DAFTAR SEMUA KUE ===");
        for (Kue kue : daftarKue) {
            System.out.println(kue);
        }

        double totalHargaSemua = 0;
        for (Kue kue : daftarKue) {
            totalHargaSemua += kue.hitungHarga();
        }
        System.out.println("\nTotal Harga Semua Kue: Rp" + String.format("%,.2f", totalHargaSemua));

        double totalHargaPesanan = 0;
        double totalBeratPesanan = 0;
        for (Kue kue : daftarKue) {
            if (kue instanceof KuePesanan) {
                totalHargaPesanan += kue.hitungHarga();
                totalBeratPesanan += ((KuePesanan) kue).getBerat();
            }
        }
        System.out.println("\n[Kue Pesanan]");
        System.out.println("Total Harga: Rp" + String.format("%,.2f", totalHargaPesanan));
        System.out.println("Total Berat: " + totalBeratPesanan + " kg");

        double totalHargaJadi = 0;
        double totalJumlahJadi = 0;
        for (Kue kue : daftarKue) {
            if (kue instanceof KueJadi) {
                totalHargaJadi += kue.hitungHarga();
                totalJumlahJadi += ((KueJadi) kue).getJumlah();
            }
        }
        System.out.println("\n[Kue Jadi]");
        System.out.println("Total Harga : Rp" + String.format("%,.2f", totalHargaJadi));
        System.out.println("Total Jumlah: " + (int)totalJumlahJadi + " pcs");

        Kue kueTermahal = daftarKue[0];
        for (int i = 1; i < daftarKue.length; i++) {
            if (daftarKue[i].hitungHarga() > kueTermahal.hitungHarga()) {
                kueTermahal = daftarKue[i];
            }
        }
        System.out.println("\n=== KUE DENGAN HARGA TERBESAR ===");
        System.out.println(kueTermahal);
    }
}
