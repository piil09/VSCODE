import java.util.ArrayList;
import java.util.List;

public class Book {
    private String judul;
    private Category kategori;
    private List<Author> penulis;
    private String sinopsis; 

    public Book(String judul, Category kategori, String sinopsis) {
        this.judul = judul;
        this.kategori = kategori;
        this.sinopsis = sinopsis;
        this.penulis = new ArrayList<>();
    }

    public Book(String judul, Category kategori, String sinopsis, List<Author> penulis) {
        this.judul = judul;
        this.kategori = kategori;
        this.sinopsis = sinopsis;
        this.penulis = new ArrayList<>(penulis); 
    }

    public String getJudul() { return judul; }
    public void setJudul(String judul) { this.judul = judul; }

    public Category getKategori() { return kategori; }
    public void setKategori(Category kategori) { this.kategori = kategori; }

    public List<Author> getPenulis() { return penulis; }
    public void addPenulis(Author penulis) { this.penulis.add(penulis); }

    public String getSinopsis() { return sinopsis; }
    public void setSinopsis(String sinopsis) { this.sinopsis = sinopsis; }

    public int hitungKataSinopsis() {
        if (sinopsis == null || sinopsis.trim().isEmpty()) {
            return 0;
        }
        String[] kata = sinopsis.trim().split("\\s+");
        return kata.length;
    }

    public double cekTingkatKesamaan(Book other) {
        if (other == null) return 0.0;

        int totalAtribut = 4; 
        int jumlahSama = 0;

        if (this.judul.equals(other.getJudul())) jumlahSama++;
        if (this.kategori.getNama().equals(other.getKategori().getNama())) jumlahSama++;
        if (this.sinopsis.equals(other.getSinopsis())) jumlahSama++;
        
        if (this.penulis.size() == other.getPenulis().size()) {
            boolean penulisSama = true;
            for (int i = 0; i < this.penulis.size(); i++) {
                if (!this.penulis.get(i).getNama().equals(other.getPenulis().get(i).getNama())) {
                    penulisSama = false;
                    break;
                }
            }
            if (penulisSama) jumlahSama++;
        }

        return ((double) jumlahSama / totalAtribut) * 100.0;
    }

    public Book copy() {
        return new Book(this.judul, this.kategori, this.sinopsis, this.penulis);
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
        System.out.println("\n  Sinopsis: " + sinopsis);
        System.out.println("  Jumlah Kata: " + hitungKataSinopsis() + " kata");
        System.out.println();
    }
}