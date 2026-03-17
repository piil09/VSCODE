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

    public void bacaFile(String pathFile) {
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(pathFile))) {
            String line = br.readLine();
            if (line != null) {
                String[] data = line.split(";");
                if (data.length >= 1) this.judul = data[0].trim();
                if (data.length >= 2) {
                    this.penulis.clear();
                    String[] arrPenulis = data[1].split(",");
                    for (String p : arrPenulis) {
                        this.penulis.add(new Author(p.trim()));
                    }
                }
                if (data.length >= 3 && data[2] != null && !data[2].trim().isEmpty()) {
                    this.kategori = new Category(data[2].trim());
                }
                if (data.length >= 4) {
                    this.sinopsis = data[3].trim();
                }
            }
            System.out.println("Berhasil membaca file: " + pathFile);
        } catch (java.io.IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
        }
    }

    public void simpanFile(String namaFile) {
        try (java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.FileWriter(namaFile))) {
            StringBuilder penulisStr = new StringBuilder();
            if (penulis != null) {
                for (int i = 0; i < penulis.size(); i++) {
                    penulisStr.append(penulis.get(i).getNama());
                    if (i < penulis.size() - 1) penulisStr.append(",");
                }
            }
            String katNama = (kategori != null && kategori.getNama() != null) ? kategori.getNama() : "";
            String sinopStr = (sinopsis != null) ? sinopsis : "";
            String judStr = (judul != null) ? judul : "";
            
            bw.write(judStr + ";" + penulisStr.toString() + ";" + katNama + ";" + sinopStr);
            System.out.println("Berhasil menyimpan ke file: " + namaFile);
        } catch (java.io.IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan file: " + e.getMessage());
        }
    }

    public double hitungRoyalti(double harga) {
        return harga * 0.10;
    }

    public double hitungRoyalti(double harga, double persen) {
        return harga * (persen / 100.0);
    }
}