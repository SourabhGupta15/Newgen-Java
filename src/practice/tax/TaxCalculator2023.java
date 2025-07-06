package practice.tax;

public class TaxCalculator2023 extends AbstractTaxCalculator {
    private double taxableIncome;

    public TaxCalculator2023(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    @Override
    public double calculateTax() {
        // taxableIncome = getTaxableIncome(150_000, 50_000);
        return taxableIncome * 0.3;     //30% of taxable income.
    }
}
