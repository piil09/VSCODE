import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Player {
    String team;
    int height;
    int weight;

    Player(String team, int height, int weight) {
        this.team = team;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("Tim %s | Tinggi: %d cm | Berat: %d kg", team, height, weight);
    }
}

public class Modul11 {
    public static void main(String[] args) {
        ArrayList<Player> timA = new ArrayList<>();
        ArrayList<Player> timB = new ArrayList<>();

        timA.add(new Player("A", 168, 50));
        timA.add(new Player("A", 170, 60));
        timA.add(new Player("A", 165, 56));
        timA.add(new Player("A", 168, 55));
        timA.add(new Player("A", 172, 60));
        timA.add(new Player("A", 170, 70));
        timA.add(new Player("A", 169, 66));
        timA.add(new Player("A", 165, 56));
        timA.add(new Player("A", 171, 72));
        timA.add(new Player("A", 166, 56));

        timB.add(new Player("B", 170, 66));
        timB.add(new Player("B", 167, 60));
        timB.add(new Player("B", 165, 59));
        timB.add(new Player("B", 166, 58));
        timB.add(new Player("B", 168, 58));
        timB.add(new Player("B", 175, 71));
        timB.add(new Player("B", 172, 68));
        timB.add(new Player("B", 171, 68));
        timB.add(new Player("B", 168, 65));
        timB.add(new Player("B", 169, 60));

        ArrayList<Player> semuaPemain = new ArrayList<>();
        semuaPemain.addAll(timA);
        semuaPemain.addAll(timB);

        System.out.println("--- TUGAS PRAKTIKUM - SORTING & SEARCHING ---");

        System.out.println("\n--- 1a. Tinggi badan ASCENDING ---");
        ArrayList<Player> urutTinggiAsc = new ArrayList<>(semuaPemain);
        urutTinggiAsc.sort(Comparator.comparingInt(p -> p.height));
        printList(urutTinggiAsc);

        System.out.println("\n--- 1a. Tinggi badan DESCENDING ---");
        ArrayList<Player> urutTinggiDesc = new ArrayList<>(semuaPemain);
        urutTinggiDesc.sort((p1, p2) -> p2.height - p1.height);
        printList(urutTinggiDesc);

        System.out.println("\n--- 1b. Berat badan ASCENDING ---");
        ArrayList<Player> urutBeratAsc = new ArrayList<>(semuaPemain);
        urutBeratAsc.sort(Comparator.comparingInt(p -> p.weight));
        printList(urutBeratAsc);

        System.out.println("\n--- 1b. Berat badan DESCENDING ---");
        ArrayList<Player> urutBeratDesc = new ArrayList<>(semuaPemain);
        urutBeratDesc.sort((p1, p2) -> p2.weight - p1.weight);
        printList(urutBeratDesc);

        System.out.println("\n--- 1c. Nilai MAX dan MIN per tim ---");
        printMinMax(timA, "Tim A");
        printMinMax(timB, "Tim B");

        System.out.println("\n--- 1d. Copy seluruh anggota Tim B ke Tim C ---");
        ArrayList<Player> timC = new ArrayList<>();
        for (Player p : timB) {
            timC.add(new Player("C", p.height, p.weight));
        }
        printList(timC);

        System.out.println("\n--- Format ukuran file ---");
        System.out.println("512000 byte -> " + formatFileSize(512000));
        System.out.println("2500000 byte -> " + formatFileSize(2500000));

        ArrayList<Integer> tinggiA = new ArrayList<>();
        ArrayList<Integer> beratA = new ArrayList<>();
        for (Player p : timA) {
            tinggiA.add(p.height);
            beratA.add(p.weight);
        }

        ArrayList<Integer> tinggiB = new ArrayList<>();
        ArrayList<Integer> beratB = new ArrayList<>();
        for (Player p : timB) {
            tinggiB.add(p.height);
            beratB.add(p.weight);
        }

        System.out.println("\n--- 2a. Data ArrayList Terpisah ---");
        System.out.println("Tinggi Tim A : " + tinggiA);
        System.out.println("Berat Tim A  : " + beratA);
        System.out.println("Tinggi Tim B : " + tinggiB);
        System.out.println("Berat Tim B  : " + beratB);

        Collections.sort(tinggiB);
        Collections.sort(beratA);

        System.out.println("\n--- 2b. Frekuensi tinggi Tim B ---");
        System.out.println("Tinggi 168 cm : " + countOccurrences(tinggiB, 168) + " pemain");
        System.out.println("Tinggi 160 cm : " + countOccurrences(tinggiB, 160) + " pemain");

        System.out.println("\n--- 2c. Frekuensi berat Tim A ---");
        System.out.println("Berat 56 kg : " + countOccurrences(beratA, 56) + " pemain");
        System.out.println("Berat 53 kg : " + countOccurrences(beratA, 53) + " pemain");

        Collections.sort(tinggiA);
        Collections.sort(beratB);
        boolean samaTinggi = hasAnyMatch(tinggiA, tinggiB);
        boolean samaBerat = hasAnyMatch(beratA, beratB);

        System.out.println("\n--- 2d. Kesamaan Tinggi/Berat antar Tim ---");
        System.out.println("Ada pemain Tim A dengan tinggi yang sama di Tim B? " + (samaTinggi ? "Ya" : "Tidak"));
        System.out.println("Ada pemain Tim A dengan berat yang sama di Tim B? " + (samaBerat ? "Ya" : "Tidak"));

        System.out.println("\n--- Indeks Binary Search ---");
        System.out.println("Tinggi 168 di Tim B (sorted) : " + binarySearch(tinggiB, 168));
        System.out.println("Tinggi 160 di Tim B (sorted) : " + binarySearch(tinggiB, 160));
        System.out.println("Berat 56 di Tim A (sorted)  : " + binarySearch(beratA, 56));
        System.out.println("Berat 53 di Tim A (sorted)  : " + binarySearch(beratA, 53));
    }

    static void printList(List<Player> list) {
        for (Player p : list) {
            System.out.println(p);
        }
    }

    static void printMinMax(List<Player> list, String label) {
        int minHeight = Integer.MAX_VALUE;
        int maxHeight = Integer.MIN_VALUE;
        int minWeight = Integer.MAX_VALUE;
        int maxWeight = Integer.MIN_VALUE;
        for (Player p : list) {
            minHeight = Math.min(minHeight, p.height);
            maxHeight = Math.max(maxHeight, p.height);
            minWeight = Math.min(minWeight, p.weight);
            maxWeight = Math.max(maxWeight, p.weight);
        }
        System.out.println(label + ": Tinggi min=" + minHeight + " cm, Tinggi max=" + maxHeight + " cm");
        System.out.println(label + ": Berat min=" + minWeight + " kg, Berat max=" + maxWeight + " kg");
    }

    static String formatFileSize(long sizeInBytes) {
        if (sizeInBytes < 1024 * 1024) {
            double kb = sizeInBytes / 1024.0;
            return String.format("%.2f KB", kb);
        }
        double mb = sizeInBytes / (1024.0 * 1024.0);
        return String.format("%.2f MB", mb);
    }

    static int binarySearch(List<Integer> sortedList, int target) {
        int low = 0;
        int high = sortedList.size() - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int value = sortedList.get(mid);
            if (value == target) {
                return mid;
            }
            if (value < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    static int countOccurrences(List<Integer> sortedList, int target) {
        int idx = binarySearch(sortedList, target);
        if (idx < 0) {
            return 0;
        }
        int count = 1;
        int left = idx - 1;
        while (left >= 0 && sortedList.get(left) == target) {
            count++;
            left--;
        }
        int right = idx + 1;
        while (right < sortedList.size() && sortedList.get(right) == target) {
            count++;
            right++;
        }
        return count;
    }

    static boolean hasAnyMatch(List<Integer> listA, List<Integer> listB) {
        for (int value : listA) {
            if (binarySearch(listB, value) >= 0) {
                return true;
            }
        }
        return false;
    }
}
