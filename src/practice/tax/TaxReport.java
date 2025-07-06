package practice.tax;

public class TaxReport {
    private TaxCalculator calculator;

    // public TaxReport(TaxCalculator calculator) {     //Constructor Injection
    //     this.calculator = calculator;
    // }

    public void show(TaxCalculator calculator) {        //Method Injection : Injecting in method parameter
        var tax = calculator.calculateTax();
        System.out.println(tax);
    }

    // public void setCalculator(TaxCalculator calculator) {    //Setter Injection
    //     this.calculator = calculator;
    // }

}
