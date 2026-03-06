import java.util.ArrayList;
import java.util.List;

public class Book {
    private String judul;
    private Category kategori;
    private List<Author> penulis;

    public Book(String judul, Category kategori) {
        this.judul = judul;
        this.kategori = kategori;
        this.penulis = new ArrayList<>();
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public Category getKategori() {
        return kategori;
    }

    public void setKategori(Category kategori) {
        this.kategori = kategori;
    }

    public List<Author> getPenulis() {
        return penulis;
    }

    public void addPenulis(Author penulis) {
        this.penulis.add(penulis);
    }

    public void display() {
        System.out.println("  Judul: " + judul);
        System.out.println("  Kategori: " + kategori.getNama());
        System.out.print("  Penulis: ");
        for (int i = 0; i < penulis.size(); i++) {
            System.out.print(penulis.get(i).getNama());
            if (i < penulis.size() - 1) {
                System.out.print(", ");
            }
        }
        
        System.out.println();
        System.out.println();
    }
}