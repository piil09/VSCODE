public class Employee implements Payable {
    private Integer noInduk;
    private String namaPegawai;
    private Integer gajiBulanan;
    private Invoice[] daftarBelanja; 

    public Employee(Integer noInduk, String namaPegawai, Integer gajiBulanan, Invoice[] daftarBelanja) {
        this.noInduk = noInduk;
        this.namaPegawai = namaPegawai;
        this.gajiBulanan = gajiBulanan;
        this.daftarBelanja = daftarBelanja;
    }

    public Invoice[] getDaftarBelanja() {
        return daftarBelanja;
    }

    public Integer hitungTotalBelanja() {
        int total = 0;
        for (Invoice nota : daftarBelanja) {
            total += nota.hitungTotalBayar();
        }
        return total;
    }

    @Override
    public Integer hitungTotalBayar() {
        return gajiBulanan - hitungTotalBelanja();
    }

    public Integer getNoInduk() { return noInduk; }
    public String getNamaPegawai() { return namaPegawai; }
    public Integer getGajiBulanan() { return gajiBulanan; }

    @Override
    public Integer getPayableAmount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}