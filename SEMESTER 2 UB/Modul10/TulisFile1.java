import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TulisFile1 {
    public static void main(String[] args) {
        File file = new File("output.txt");

        try (FileWriter writer = new FileWriter(file, true)) { 
            writer.write("Semoga Gavril Dapat nilai A dan nilai 100 aamiin...\n");
            System.out.println("Menulis ke file: " + file.getAbsolutePath());
            System.out.println("Mode append = true => teks sudah ditambahkan boss.");
        } catch (IOException e) {
            System.err.println("Gagal menulis file boss: " + e.getMessage());
        }
    }
}
