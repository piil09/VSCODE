public class SumberDaya {
    private String nama;
    public SumberDaya(String nama) { this.nama = nama; }
    public String getNama() { return nama; }
}

public class main {
    public static void main(String[] args) {
        SumberDaya stok = new SumberDaya("Stok Barang");
        SumberDaya kurir = new SumberDaya("Layanan Kurir");

        Thread t1 = new Thread(() -> {
            synchronized (stok) {
                System.out.println("Pembeli 1: Mengunci Stok...");
                try { Thread.sleep(100); } catch (Exception e) {}
                
                System.out.println("Pembeli 1: Menunggu Kurir...");
                synchronized (kurir) {
                    System.out.println("Pembeli 1: Berhasil dapat Kurir!");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (kurir) {
                System.out.println("Pembeli 2: Mengunci Kurir...");
                try { Thread.sleep(100); } catch (Exception e) {}
                
                System.out.println("Pembeli 2: Menunggu Stok...");
                synchronized (stok) {
                    System.out.println("Pembeli 2: Berhasil dapat Stok!");
                }
            }
        });

        t1.start();
        t2.start();
    
    }
} 