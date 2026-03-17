import java.util.ArrayList;
import java.util.List;

public class Category {
    private String nama;
    private List<Book> buku;

    public Category(String nama) {
        this.nama = nama;
        this.buku = new ArrayList<>();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public List<Book> getBuku() {
        return buku;
    }

    public void addBuku(Book buku) {
        this.buku.add(buku);
    }

    public void display() {
        System.out.println("Kategori: " + nama);
        System.out.println("Jumlah Buku: " + buku.size());
        System.out.println("Daftar Buku:");
        for (Book b : buku) {
            b.display();
        }
    }
}