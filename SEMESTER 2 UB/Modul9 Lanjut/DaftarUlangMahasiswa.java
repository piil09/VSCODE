import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DaftarUlangMahasiswa extends JFrame {
    private JTextField namaField;
    private JTextField tanggalField;
    private JTextField noPendaftaranField;
    private JTextField noTelpField;
    private JTextArea alamatArea;
    private JTextField emailField;

    public DaftarUlangMahasiswa() {
        setTitle("Form Daftar Ulang Mahasiswa Baru");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 380);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
        contentPane.setBackground(new Color(245, 245, 245));
        setContentPane(contentPane);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                new EmptyBorder(16, 16, 16, 16)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel namaLabel = new JLabel("Nama Lengkap:");
        namaField = new JTextField();
        addLine(formPanel, gbc, 0, namaLabel, namaField);

        JLabel tanggalLabel = new JLabel("Tanggal Lahir:");
        tanggalField = new JTextField();
        addLine(formPanel, gbc, 1, tanggalLabel, tanggalField);

        JLabel noPendaftaranLabel = new JLabel("Nomor Pendaftaran:");
        noPendaftaranField = new JTextField();
        addLine(formPanel, gbc, 2, noPendaftaranLabel, noPendaftaranField);

        JLabel noTelpLabel = new JLabel("No. Telp:");
        noTelpField = new JTextField();
        addLine(formPanel, gbc, 3, noTelpLabel, noTelpField);

        JLabel alamatLabel = new JLabel("Alamat:");
        alamatArea = new JTextArea(4, 20);
        alamatArea.setLineWrap(true);
        alamatArea.setWrapStyleWord(true);
        JScrollPane scrollAlamat = new JScrollPane(alamatArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        formPanel.add(alamatLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        formPanel.add(scrollAlamat, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;

        JLabel emailLabel = new JLabel("E-mail:");
        emailField = new JTextField();
        addLine(formPanel, gbc, 5, emailLabel, emailField);

        contentPane.add(formPanel, BorderLayout.CENTER);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitAction());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(245, 245, 245));
        buttonPanel.add(submitButton);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        JLabel titleLabel = new JLabel("Form Pendaftaran Ulang Mahasiswa Baru");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        titleLabel.setBorder(new EmptyBorder(0, 0, 10, 0));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(titleLabel, BorderLayout.NORTH);
    }

    private void addLine(JPanel panel, GridBagConstraints gbc, int row, JLabel label, Component field) {
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(label, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.weightx = 1;
        gbc.gridwidth = 2;
        panel.add(field, gbc);

        gbc.gridwidth = 1;
    }

    private class SubmitAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!isFormValid()) {
                JOptionPane.showMessageDialog(DaftarUlangMahasiswa.this,
                        "Semua kolom harus terisi sebelum melanjutkan.",
                        "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int answer = JOptionPane.showConfirmDialog(DaftarUlangMahasiswa.this,
                    "Apakah Anda yakin data yang Anda isi sudah benar?",
                    "Konfirmasi", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (answer == JOptionPane.OK_OPTION) {
                showResultWindow();
            }
        }
    }

    private boolean isFormValid() {
        return !namaField.getText().trim().isEmpty()
                && !tanggalField.getText().trim().isEmpty()
                && !noPendaftaranField.getText().trim().isEmpty()
                && !noTelpField.getText().trim().isEmpty()
                && !alamatArea.getText().trim().isEmpty()
                && !emailField.getText().trim().isEmpty();
    }

    private void showResultWindow() {
        JFrame resultFrame = new JFrame("Data Mahasiswa");
        resultFrame.setSize(420, 320);
        resultFrame.setLocationRelativeTo(this);
        resultFrame.setResizable(false);

        JPanel content = new JPanel(new BorderLayout());
        content.setBorder(new EmptyBorder(15, 15, 15, 15));
        content.setBackground(new Color(230, 240, 255));

        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        resultArea.setBackground(Color.WHITE);
        resultArea.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(150, 170, 200)),
                new EmptyBorder(12, 12, 12, 12)
        ));

        StringBuilder sb = new StringBuilder();
        sb.append("Nama            : ").append(namaField.getText().trim()).append("\n");
        sb.append("Tanggal Lahir   : ").append(tanggalField.getText().trim()).append("\n");
        sb.append("No. Pendaftaran : ").append(noPendaftaranField.getText().trim()).append("\n");
        sb.append("No. Telp        : ").append(noTelpField.getText().trim()).append("\n");
        sb.append("Alamat          : ").append(alamatArea.getText().trim()).append("\n");
        sb.append("E-mail          : ").append(emailField.getText().trim()).append("\n");

        resultArea.setText(sb.toString());
        content.add(resultArea, BorderLayout.CENTER);

        resultFrame.setContentPane(content);
        resultFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DaftarUlangMahasiswa frame = new DaftarUlangMahasiswa();
            frame.setVisible(true);
        });
    }
}
