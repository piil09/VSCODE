public class Main {
    public static void main(String[] args) {

        Invoice[] belanjaanPekerja1 = {
            new Invoice("Beras 5kg", 2, 65000),
            new Invoice("Minyak Goreng 2L", 3, 28000),
            new Invoice("Gula Pasir 1kg", 4, 15000)
        };
        Employee pekerja1 = new Employee(1001, "Budi Santoso", 5000000, belanjaanPekerja1);

        Invoice[] belanjaanPekerja2 = {
            new Invoice("Susu UHT 1L", 5, 18000),
            new Invoice("Sabun Mandi", 3, 12000),
            new Invoice("Detergen 1kg", 2, 22000),
            new Invoice("Teh Celup", 2, 10000)
        };
        Employee pekerja2 = new Employee(1002, "Siti Rahayu", 4500000, belanjaanPekerja2);

        Payable[] listTanggungan = { pekerja1, pekerja2 };

        System.out.println("**************************************************");
        System.out.println("*      REKAP GAJI & POTONGAN KOPERASI PEGAWAI    *");
        System.out.println("*                   NV. MENEER                   *");
        System.out.println("**************************************************");

        for (Payable tanggungan : listTanggungan) {
            Employee pekerja = (Employee) tanggungan;

            System.out.println("\n[#] DATA PEGAWAI");
            System.out.printf("    ID Pegawai   : %d%n", pekerja.getNoInduk());
            System.out.printf("    Nama Lengkap : %s%n", pekerja.getNamaPegawai());
            System.out.printf("    Gaji Pokok   : Rp%,d%n", pekerja.getGajiBulanan());

            System.out.println("\n    --- Rincian Transaksi Koperasi ---");
            for (Payable notaBeli : pekerja.getDaftarBelanja()) {
                System.out.println(notaBeli); 
            }
            System.out.println("    ----------------------------------");
            System.out.printf("    Akumulasi Potongan : Rp%,d%n", pekerja.hitungTotalBelanja());
            System.out.println("    ==================================");
            System.out.printf("    TAKE HOME PAY      : Rp%,d%n", pekerja.hitungTotalBayar());
            System.out.println("**************************************************");
        }

        System.out.println("\n+++ TOTAL PEMBAYARAN GAJI BERSIH +++");
        for (Payable tanggungan : listTanggungan) {
            Employee pekerja = (Employee) tanggungan;
            System.out.printf(" -> %-15s : Rp%,d%n",
                    pekerja.getNamaPegawai(),
                    pekerja.hitungTotalBayar());
        }
        System.out.println("++++++++++++++++++++++++++++++++++++");
    }
}