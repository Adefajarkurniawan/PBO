public class BMI {
    private double beratBadan;
    private double tinggiBadan;
    private double bmi;

    // Konstruktor untuk inisialisasi berat badan dan tinggi badan
    public BMI(double beratBadan, double tinggiBadan) {
        this.beratBadan = beratBadan;
        this.tinggiBadan = tinggiBadan;
        this.bmi = hitungBMI();
    }

    // Getter untuk mengambil nilai berat badan
    public double getBeratBadan() {
        return beratBadan;
    }

    // Setter untuk mengubah nilai berat badan dan menghitung BMI baru
    public void setBeratBadan(double beratBadan) {
        this.beratBadan = beratBadan;
        this.bmi = hitungBMI();
    }

    // Getter untuk mengambil nilai tinggi badan
    public double getTinggiBadan() {
        return tinggiBadan;
    }
    
    // Setter untuk mengubah nilai tinggi badan dan menghitung BMI baru
    public void setTinggiBadan(double tinggiBadan) {
        this.tinggiBadan = tinggiBadan;
        this.bmi = hitungBMI();
    }

    // Getter untuk mengambil nilai BMI yang dihitung
    public double getBmi() {
        return bmi;
    }

    // Method untuk menghitung BMI berdasarkan rumus: berat / (tinggi * tinggi)
    private double hitungBMI() {
        return beratBadan / (tinggiBadan * tinggiBadan);
    }

    // Method untuk mengkategorikan BMI (Kurus, Normal, Gemuk, Obesitas)
    public String kategoriBMI() {
        if (bmi < 18.5) {
            return "Kurus";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Normal";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Gemuk";
        } else {
            return "Obesitas";
        }
    }
}
