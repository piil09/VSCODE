public class Probstat {
    public double hitungNilaiAkhir(double tugas, double kuis, double uts, double uas) {
        double max = Math.max(Math.max(tugas, kuis), Math.max(uts, uas));
        double rata = (tugas + kuis + uts + uas) / 4;
        return max * 0.5 + rata * 0.5;
    }
}
