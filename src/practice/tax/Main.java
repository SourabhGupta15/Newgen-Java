package practice.tax;

public class Main {
    public static void main(String[] args) {
        var calculator = new TaxCalculator2023(100_000);
        var report = new TaxReport();
        report.show(calculator);

        // report.setCalculator(new TaxCalculator2024());
        report.show(new TaxCalculator2024());
    }
}
