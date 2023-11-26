package entities;

public class TaxPayer {

    private double salaryIncome;
    private double serviceIncome;
    private double capitalIncome;
    private double healthSpending;
    private double educationSpending;

    public TaxPayer() {
    }

    public TaxPayer(double salaryIncome, double serviceIncome, double capitalIncome, double healthSpending, double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.serviceIncome = serviceIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    public double getSalaryIncome() {
        return salaryIncome;
    }

    public void setSalaryIncome(double salaryIncome) {
        this.salaryIncome = salaryIncome;
    }

    public double getServiceIncome() {
        return serviceIncome;
    }

    public void setServiceIncome(double serviceIncome) {
        this.serviceIncome = serviceIncome;
    }

    public double getCapitalIncome() {
        return capitalIncome;
    }

    public void setCapitalIncome(double capitalIncome) {
        this.capitalIncome = capitalIncome;
    }

    public double getHealthSpending() {
        return healthSpending;
    }

    public void setHealthSpending(double healthSpending) {
        this.healthSpending = healthSpending;
    }

    public double getEducationSpending() {
        return educationSpending;
    }

    public void setEducationSpending(double educationSpending) {
        this.educationSpending = educationSpending;
    }

    public double salaryTax() {
        double monthSalary = this.salaryIncome / 12;
        if (monthSalary < 3000.0) {
            return 0.0;
        } else if (monthSalary >= 3000.0 && monthSalary < 5000.0) {
            return this.salaryIncome * 0.10;
        } else {
            return this.salaryIncome * 0.20;
        }
    }

    public double serviceTax() {
        if (this.serviceIncome > 0) {
            return this.serviceIncome * 0.15;
        }
        return 0.0;
    }

    public double capitalTax() {
        if (this.capitalIncome > 0) {
            return this.capitalIncome * 0.20;
        }
        return 0.0;
    }

    public double taxRebate() {
        double totalSpending = this.educationSpending + this.healthSpending;
        double taxPercentAboutGrossTax = this.grossTax() * 0.30;

        if (totalSpending < taxPercentAboutGrossTax) {
            return totalSpending;
        }
        return this.grossTax() * 0.30;
    }

    public double grossTax() {
        return this.serviceTax() + this.salaryTax() + this.capitalTax();
    }

    public double netTax() {
        return this.grossTax() - this.taxRebate();
    }

    @Override
    public String toString() {
        return "Imposto bruto total: " + String.format("%.2f%n", this.grossTax())
                + "Abatimento: " + String.format("%.2f%n", this.taxRebate())
                + "Imposto devido: " + String.format("%.2f%n", this.netTax());
    }
}
