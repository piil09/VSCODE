import java.util.ArrayList;
import java.util.List;

public class Library {
    private String nama;
    private List<Category> kategori;

    public Library(String nama) {
        this.nama = nama;
        this.kategori = new ArrayList<>();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public List<Category> getKategori() {
        return kategori;
    }

    public void addKategori(Category kategori) {
        this.kategori.add(kategori);
    }

    public void display() {
        System.out.println("=================================================");
        System.out.println("PERPUSTAKAAN Universitas Brawijaya");
        System.out.println("=================================================");
        System.out.println("Nama :Gavril Muhammad Ghazanfar");
        System.out.println("NIM  : 255150707111022");
        System.out.println("=================================================");
        System.out.println("Jumlah Kategori: " + kategori.size());
        System.out.println();

        for (Category cat : kategori) {
            cat.display();
            System.out.println("-------------------------------------------------");
            System.out.println();
        }
    }
}