import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Book {
    private String judul;
    private Category kategori;
    private List<Author> penulis;
    private String sinopsis;
    private int jumlahTerjual; // jumlah buku terjual bulan ini

    public Book(String judul, Category kategori, String sinopsis) {
        this.judul = judul;
        this.kategori = kategori;
        this.sinopsis = sinopsis;
        this.penulis = new ArrayList<>();
        this.jumlahTerjual = 0;
    }

    public Book(String judul, Category kategori, String sinopsis, List<Author> penulis) {
        this.judul = judul;
        this.kategori = kategori;
        this.sinopsis = sinopsis;
        this.penulis = new ArrayList<>(penulis);
        this.jumlahTerjual = 0;
    }

    public String getJudul() { return judul; }
    public void setJudul(String judul) { this.judul = judul; }

    public Category getKategori() { return kategori; }
    public void setKategori(Category kategori) { this.kategori = kategori; }

    public List<Author> getPenulis() { return penulis; }
    public void addPenulis(Author penulis) { this.penulis.add(penulis); }

    public String getSinopsis() { return sinopsis; }
    public void setSinopsis(String sinopsis) { this.sinopsis = sinopsis; }

    public int getJumlahTerjual() { return jumlahTerjual; }
    public void setJumlahTerjual(int jumlahTerjual) { this.jumlahTerjual = jumlahTerjual; }

    // ============================================================
    // Method 1: bacaFile(pathFile)
    // Membaca judul dan penulis dari file txt (format: judul;nama_penulis)
    // ============================================================
    public void bacaFile(String pathFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
            String baris = br.readLine();
            if (baris != null) {
                String[] bagian = baris.split(";");
                if (bagian.length >= 1) {
                    this.judul = bagian[0].trim();
                }
                if (bagian.length >= 2) {
                    this.penulis.clear();
                    this.penulis.add(new Author(bagian[1].trim()));
                }
            }
            System.out.println("[bacaFile] Berhasil membaca file: " + pathFile);
            System.out.println("           Judul   : " + this.judul);
            System.out.println("           Penulis : " + (this.penulis.isEmpty() ? "-" : this.penulis.get(0).getNama()));
        } catch (IOException e) {
            System.out.println("[bacaFile] Gagal membaca file: " + e.getMessage());
        }
    }

    public void simpanFile(String namaFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(namaFile))) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.judul);
            if (!this.penulis.isEmpty()) {
                sb.append(";").append(this.penulis.get(0).getNama());
            }
            bw.write(sb.toString());
            System.out.println("[simpanFile] Berhasil menyimpan ke file: " + namaFile);
            System.out.println("             Isi file : " + sb.toString());
        } catch (IOException e) {
            System.out.println("[simpanFile] Gagal menyimpan file: " + e.getMessage());
        }
    }

    public double hitungRoyalti(double harga) {
        double totalPenjualan = harga * this.jumlahTerjual;
        return totalPenjualan * 0.10;
    }

    public double hitungRoyalti(double harga, double persen) {
        double totalPenjualan = harga * this.jumlahTerjual;
        return totalPenjualan * (persen / 100.0);
    }

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
