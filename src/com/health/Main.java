import javax.swing.*;
import java.awt.*;

public class Main {
    private JFrame frame;  // Frame utama aplikasi
    private JTextField tfBeratBadan, tfTinggiBadan, tfHasilBMI;  // Input untuk berat badan, tinggi badan, dan hasil BMI
    private JButton btnHitung, btnUlang;  // Tombol untuk hitung dan ulang
    private JTextArea taStatus;  // Area untuk menampilkan status (hasil/error)
    private BMI bmi;  // Objek untuk menghitung BMI

    public Main() {
        // Setup frame
        frame = new JFrame("Kalkulator BMI");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());  // Layout untuk penataan komponen
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Jarak antar komponen

        // Label dan input untuk Berat Badan
        JLabel lblBeratBadan = new JLabel("Berat Badan (kg):");
        tfBeratBadan = new JTextField(10);
        gbc.gridx = 0; gbc.gridy = 0;
        frame.add(lblBeratBadan, gbc);
        gbc.gridx = 1;
        frame.add(tfBeratBadan, gbc);

        // Label dan input untuk Tinggi Badan
        JLabel lblTinggiBadan = new JLabel("Tinggi Badan (cm):");
        tfTinggiBadan = new JTextField(10);
        gbc.gridx = 0; gbc.gridy = 1;
        frame.add(lblTinggiBadan, gbc);
        gbc.gridx = 1;
        frame.add(tfTinggiBadan, gbc);

        // Panel untuk tombol operasi
        btnHitung = new JButton("Hitung BMI");
        btnUlang = new JButton("Ulang");
        gbc.gridx = 0; gbc.gridy = 2;
        frame.add(btnHitung, gbc);
        gbc.gridx = 1;
        frame.add(btnUlang, gbc);

        // Label dan TextField untuk hasil BMI
        JLabel lblHasilBMI = new JLabel("Hasil BMI:");
        tfHasilBMI = new JTextField(15);
        tfHasilBMI.setEditable(false);
        gbc.gridx = 0; gbc.gridy = 3;
        frame.add(lblHasilBMI, gbc);
        gbc.gridx = 1;
        frame.add(tfHasilBMI, gbc);

        // status box
        taStatus = new JTextArea(3, 20);
        taStatus.setEditable(false);
        taStatus.setLineWrap(true);
        taStatus.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(taStatus);
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        frame.add(scrollPane, gbc);

        // Event untuk menghitung BMI
        btnHitung.addActionListener(e -> {
            try {
                double beratBadan = Double.parseDouble(tfBeratBadan.getText());
                double tinggiBadan = Double.parseDouble(tfTinggiBadan.getText()) / 100;

                // Validasi input agar lebih dari 0
                if (beratBadan <= 0 || tinggiBadan <= 0) {
                    taStatus.setText("Input tidak valid! Berat dan tinggi badan harus lebih dari 0.");
                    return;  // Menghentikan jika input tidak valid
                }

                bmi = new BMI(beratBadan, tinggiBadan);  // Menghitung BMI
                tfHasilBMI.setText(String.format("%.2f", bmi.getBmi()));  // Menampilkan hasil BMI
                taStatus.setText("Kategori BMI: " + bmi.kategoriBMI());  // Menampilkan kategori BMI
            } catch (NumberFormatException ex) {
                taStatus.setText("Input tidak valid! Pastikan angka dimasukkan.");  // Error jika input bukan angka
            }
        });

        // Event untuk mengulang perhitungan
        btnUlang.addActionListener(e -> {
            tfBeratBadan.setText("");  // Reset input berat badan
            tfTinggiBadan.setText("");  // Reset input tinggi badan
            tfHasilBMI.setText("");  // Reset hasil BMI
            taStatus.setText("");  // Reset status
        });

        frame.setVisible(true);  // Menampilkan frame
    }

    public static void main(String[] args) {
        new Main();  // Membuat objek Main dan menampilkan kalkulator
    }
}
