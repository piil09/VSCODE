
public class Praktikum {
    public static void main(String[] args) {
        Library perpustakaan = new Library("Perpustakaan Kampus X");

        Category teknologi = new Category("Teknologi");
        Category filsafat = new Category("Filsafat");
        Category sejarah = new Category("Sejarah");
        Category agama = new Category("Agama");
        Category psikologi = new Category("Psikologi");
        Category politik = new Category("Politik");
        Category fiksi = new Category("Fiksi");

        Author penulis1 = new Author("John Doe");
        Author penulis2 = new Author("Jane Smith");
        Author penulis3 = new Author("Ahmad Rahman");
        Author penulis4 = new Author("Siti Nurhaliza");
        Author penulis5 = new Author("Budi Santoso");
        Author penulis6 = new Author("Maria Garcia");
        Author penulis7 = new Author("David Lee");
        Author penulis8 = new Author("Sarah Johnson");

        Book buku1 = new Book("Pemrograman Java untuk Pemula", teknologi);
        buku1.addPenulis(penulis1);
        teknologi.addBuku(buku1);

        Book buku2 = new Book("Pengembangan Web Modern", teknologi);
        buku2.addPenulis(penulis2);
        buku2.addPenulis(penulis3);
        teknologi.addBuku(buku2);

        Book buku3 = new Book("Machine Learning Dasar", teknologi);
        buku3.addPenulis(penulis4);
        teknologi.addBuku(buku3);

        Book buku4 = new Book("Cybersecurity Handbook", teknologi);
        buku4.addPenulis(penulis5);
        buku4.addPenulis(penulis6);
        teknologi.addBuku(buku4);

        Book buku5 = new Book("Cloud Computing Essentials", teknologi);
        buku5.addPenulis(penulis7);
        teknologi.addBuku(buku5);

        Book buku6 = new Book("Filsafat Barat Klasik", filsafat);
        buku6.addPenulis(penulis1);
        filsafat.addBuku(buku6);

        Book buku7 = new Book("Etika dan Moralitas", filsafat);
        buku7.addPenulis(penulis2);
        filsafat.addBuku(buku7);

        Book buku8 = new Book("Filsafat Islam", filsafat);
        buku8.addPenulis(penulis3);
        buku8.addPenulis(penulis4);
        filsafat.addBuku(buku8);

        Book buku9 = new Book("Logika dan Penalaran", filsafat);
        buku9.addPenulis(penulis5);
        filsafat.addBuku(buku9);

        Book buku10 = new Book("Metafisika Modern", filsafat);
        buku10.addPenulis(penulis6);
        filsafat.addBuku(buku10);

        Book buku11 = new Book("Sejarah Indonesia Merdeka", sejarah);
        buku11.addPenulis(penulis3);
        sejarah.addBuku(buku11);

        Book buku12 = new Book("Perang Dunia II", sejarah);
        buku12.addPenulis(penulis7);
        buku12.addPenulis(penulis8);
        sejarah.addBuku(buku12);

        Book buku13 = new Book("Sejarah Peradaban Islam", sejarah);
        buku13.addPenulis(penulis4);
        sejarah.addBuku(buku13);

        Book buku14 = new Book("Revolusi Industri", sejarah);
        buku14.addPenulis(penulis1);
        sejarah.addBuku(buku14);

        Book buku15 = new Book("Sejarah Asia Tenggara", sejarah);
        buku15.addPenulis(penulis2);
        sejarah.addBuku(buku15);

        Book buku16 = new Book("Tafsir Al-Quran", agama);
        buku16.addPenulis(penulis3);
        agama.addBuku(buku16);

        Book buku17 = new Book("Hadits dan Sunnah", agama);
        buku17.addPenulis(penulis4);
        agama.addBuku(buku17);

        Book buku18 = new Book("Fiqh Kontemporer", agama);
        buku18.addPenulis(penulis3);
        buku18.addPenulis(penulis4);
        agama.addBuku(buku18);

        Book buku19 = new Book("Akidah Islam", agama);
        buku19.addPenulis(penulis5);
        agama.addBuku(buku19);

        Book buku20 = new Book("Sejarah Nabi Muhammad", agama);
        buku20.addPenulis(penulis4);
        agama.addBuku(buku20);

        Book buku21 = new Book("Psikologi Perkembangan", psikologi);
        buku21.addPenulis(penulis6);
        psikologi.addBuku(buku21);

        Book buku22 = new Book("Psikologi Kognitif", psikologi);
        buku22.addPenulis(penulis7);
        psikologi.addBuku(buku22);

        Book buku23 = new Book("Psikologi Sosial", psikologi);
        buku23.addPenulis(penulis8);
        buku23.addPenulis(penulis6);
        psikologi.addBuku(buku23);

        Book buku24 = new Book("Abnormal Psychology", psikologi);
        buku24.addPenulis(penulis1);
        psikologi.addBuku(buku24);

        Book buku25 = new Book("Psikologi Pendidikan", psikologi);
        buku25.addPenulis(penulis2);
        psikologi.addBuku(buku25);

        Book buku26 = new Book("Sistem Politik Indonesia", politik);
        buku26.addPenulis(penulis5);
        politik.addBuku(buku26);

        Book buku27 = new Book("Demokrasi dan HAM", politik);
        buku27.addPenulis(penulis6);
        politik.addBuku(buku27);

        Book buku28 = new Book("Teori Politik Modern", politik);
        buku28.addPenulis(penulis7);
        buku28.addPenulis(penulis8);
        politik.addBuku(buku28);

        Book buku29 = new Book("Kebijakan Publik", politik);
        buku29.addPenulis(penulis1);
        politik.addBuku(buku29);

        Book buku30 = new Book("Hubungan Internasional", politik);
        buku30.addPenulis(penulis2);
        politik.addBuku(buku30);

        Book buku31 = new Book("Petualangan di Hutan", fiksi);
        buku31.addPenulis(penulis8);
        fiksi.addBuku(buku31);

        Book buku32 = new Book("Misteri Kota Tua", fiksi);
        buku32.addPenulis(penulis1);
        buku32.addPenulis(penulis2);
        fiksi.addBuku(buku32);

        Book buku33 = new Book("Romansa di Musim Hujan", fiksi);
        buku33.addPenulis(penulis3);
        fiksi.addBuku(buku33);

        Book buku34 = new Book("Sains Fiksi 2050", fiksi);
        buku34.addPenulis(penulis4);
        fiksi.addBuku(buku34);

        Book buku35 = new Book("Legenda Nusantara", fiksi);
        buku35.addPenulis(penulis5);
        fiksi.addBuku(buku35);

        perpustakaan.addKategori(teknologi);
        perpustakaan.addKategori(filsafat);
        perpustakaan.addKategori(sejarah);
        perpustakaan.addKategori(agama);
        perpustakaan.addKategori(psikologi);
        perpustakaan.addKategori(politik);
        perpustakaan.addKategori(fiksi);

        perpustakaan.display();
    }
}