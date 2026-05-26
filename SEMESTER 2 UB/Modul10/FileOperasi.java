import java.io.File;
import java.text.DecimalFormat;

public class FileOperasi {
    public static void main(String[] args) {
        String targetFile = "output.txt";
        String directoryPath = "sample_dir";

        printFileSize(targetFile);
        listFilesInDirectory(directoryPath);
        deleteDirectoryFiles(directoryPath);
    }

    public static void printFileSize(String filePath) {
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            System.out.println("File tidak ditemukan atau bukan file: " + filePath);
            return;
        }

        long bytes = file.length();
        double kilobytes = bytes / 1024.0;
        double megabytes = bytes / (1024.0 * 1024.0);
        DecimalFormat df = new DecimalFormat("#.##");

        if (bytes < 1024 * 1024) {
            System.out.println("Ukuran file: " + df.format(kilobytes) + " KB");
        } else {
            System.out.println("Ukuran file: " + df.format(megabytes) + " MB");
        }
    }

    public static void listFilesInDirectory(String dirPath) {
        File dir = new File(dirPath);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Direktori tidak ditemukan: " + dirPath);
            return;
        }

        System.out.println("Daftar file di direktori: " + dirPath);
        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("Gagal membaca isi direktori atau direktori kosong.");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("- " + file.getName());
            }
        }
    }

    public static void deleteDirectoryFiles(String dirPath) {
        File dir = new File(dirPath);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Direktori tidak ditemukan: " + dirPath);
            return;
        }

        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("Gagal membaca isi direktori atau direktori kosong.");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                if (file.delete()) {
                    System.out.println("File dihapus: " + file.getName());
                } else {
                    System.out.println("Gagal menghapus file: " + file.getName());
                }
            }
        }

        System.out.println("Penghapusan selesai untuk direktori: " + dirPath);
    }
}
