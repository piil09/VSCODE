import java.awt.*;
import java.awt.event.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class NilaiFramePraktikum extends Frame {
    Label lbJudul, lbTugas, lbKuis, lbUTS, lbUAS, lbHasil;
    TextField txtTugas, txtKuis, txtUTS, txtUAS, txtHasil;
    CheckboxGroup cbg;
    Checkbox cbPemlan, cbASD, cbMatkomlan, cbProbstat;
    Button btnHitung, btnTampil;
    TextArea taHasil;
    Map<String, Double> nilaiAkhir = new LinkedHashMap<>();

    public NilaiFramePraktikum() {
        setLayout(null);

        lbJudul = new Label("Hitung Nilai Akhir");
        lbJudul.setFont(new Font("Arial", Font.BOLD, 14));
        add(lbJudul);
        lbJudul.setBounds(160, 20, 180, 20);

        cbg = new CheckboxGroup();

        cbPemlan = new Checkbox("Pemlan", cbg, true);
        add(cbPemlan);
        cbPemlan.setBounds(150, 60, 80, 20);

        cbASD = new Checkbox("ASD", cbg, false);
        add(cbASD);
        cbASD.setBounds(60, 60, 80, 20);

        cbMatkomlan = new Checkbox("Matkomlan", cbg, false);
        add(cbMatkomlan);
        cbMatkomlan.setBounds(250, 60, 100, 20);

        cbProbstat = new Checkbox("Probstat", cbg, false);
        add(cbProbstat);
        cbProbstat.setBounds(350, 60, 100, 20);

        lbTugas = new Label("Tugas : ");
        add(lbTugas);
        lbTugas.setBounds(50, 90, 70, 20);

        lbKuis = new Label("Kuis : ");
        add(lbKuis);
        lbKuis.setBounds(50, 120, 70, 20);

        lbUTS = new Label("UTS : ");
        add(lbUTS);
        lbUTS.setBounds(50, 150, 70, 20);

        lbUAS = new Label("UAS : ");
        add(lbUAS);
        lbUAS.setBounds(50, 180, 70, 20);

        lbHasil = new Label("Hasil : ");
        add(lbHasil);
        lbHasil.setBounds(50, 210, 70, 20);

        txtTugas = new TextField("");
        add(txtTugas);
        txtTugas.setBounds(150, 90, 60, 20);

        txtKuis = new TextField("");
        add(txtKuis);
        txtKuis.setBounds(150, 120, 60, 20);

        txtUTS = new TextField("");
        add(txtUTS);
        txtUTS.setBounds(150, 150, 60, 20);

        txtUAS = new TextField("");
        add(txtUAS);
        txtUAS.setBounds(150, 180, 60, 20);

        txtHasil = new TextField("");
        txtHasil.setEditable(false);
        add(txtHasil);
        txtHasil.setBounds(150, 210, 60, 20);

        btnHitung = new Button("HITUNG");
        add(btnHitung);
        btnHitung.setBounds(170, 245, 100, 25);

        taHasil = new TextArea("HASIL NILAI SEMUA MATA KULIAH\n", 8, 40, TextArea.SCROLLBARS_VERTICAL_ONLY);
        taHasil.setEditable(false);
        add(taHasil);
        taHasil.setBounds(50, 280, 400, 150);

        btnTampil = new Button("Tampilkan nilai semua matkul");
        add(btnTampil);
        btnTampil.setBounds(50, 440, 400, 30);

        ItemListener itemListener = new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                txtTugas.setText("");
                txtKuis.setText("");
                txtUTS.setText("");
                txtUAS.setText("");
                txtHasil.setText("");
            }
        };

        cbPemlan.addItemListener(itemListener);
        cbASD.addItemListener(itemListener);
        cbMatkomlan.addItemListener(itemListener);
        cbProbstat.addItemListener(itemListener);

        btnHitung.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double tugas = Double.parseDouble(txtTugas.getText().trim());
                    double kuis = Double.parseDouble(txtKuis.getText().trim());
                    double uts = Double.parseDouble(txtUTS.getText().trim());
                    double uas = Double.parseDouble(txtUAS.getText().trim());

                    String mataKuliah = "";
                    double hasil = 0;

                    if (cbPemlan.getState()) {
                        mataKuliah = "Pemlan";
                        Pemlan pemlan = new Pemlan();
                        hasil = pemlan.hitungNilaiAkhir(tugas, kuis, uts, uas);
                    } else if (cbASD.getState()) {
                        mataKuliah = "ASD";
                        ASD asd = new ASD();
                        hasil = asd.hitungNilaiAkhir(tugas, kuis, uts, uas);
                    } else if (cbMatkomlan.getState()) {
                        mataKuliah = "Matkomlan";
                        Matkomlan matkomlan = new Matkomlan();
                        hasil = matkomlan.hitungNilaiAkhir(tugas, kuis, uts, uas);
                    } else if (cbProbstat.getState()) {
                        mataKuliah = "Probstat";
                        Probstat probstat = new Probstat();
                        hasil = probstat.hitungNilaiAkhir(tugas, kuis, uts, uas);
                    } else {
                        return;
                    }

                    txtHasil.setText(String.format("%.1f", hasil));
                    nilaiAkhir.put(mataKuliah, hasil);
                    tampilkanNilaiAkhir();
                } catch (NumberFormatException ex) {
                    txtHasil.setText("Error");
                }
            }
        });

        btnTampil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tampilkanNilaiAkhir();
            }
        });
    }

    private void tampilkanNilaiAkhir() {
        taHasil.setText("HASIL NILAI SEMUA MATA KULIAH\n");
        for (Map.Entry<String, Double> entry : nilaiAkhir.entrySet()) {
            taHasil.append(entry.getKey() + " : " + String.format("%.1f", entry.getValue()) + "\n");
        }
    }
}