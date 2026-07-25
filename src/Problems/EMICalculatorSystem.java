package Problems;
import java.math.BigDecimal;
import java.math.RoundingMode;

// 1. Loan Request Entity
class LoanRequest {
    private String loanId;
    private BigDecimal principal;
    private BigDecimal annualRate; // e.g., 8.5 for 8.5%
    private int timeInYears;

    public LoanRequest(String loanId, BigDecimal principal, BigDecimal annualRate, int timeInYears) {
        this.loanId = loanId;
        this.principal = principal;
        this.annualRate = annualRate;
        this.timeInYears = timeInYears;
    }

    public String getLoanId() { return loanId; }
    public BigDecimal getPrincipal() { return principal; }
    public BigDecimal getAnnualRate() { return annualRate; }
    public int getTimeInYears() { return timeInYears; }
}

// 2. Centralized Calculation Orchestrator
class FinancialProcessor {
    private static final BigDecimal HUNDRED = new BigDecimal("100");

    public static BigDecimal calculateSimpleInterest(LoanRequest loan, int scale) {
        if (loan == null) {
            throw new IllegalArgumentException("Loan details cannot be null");
        }

        // Step A: Principal * Rate * Time
        BigDecimal numerator = loan.getPrincipal()
                .multiply(loan.getAnnualRate())
                .multiply(new BigDecimal(loan.getTimeInYears()));

        // Step B: Divide by 100 and apply currency scaling and rounding
        return numerator.divide(HUNDRED, scale, RoundingMode.HALF_UP);
    }
}

// 3. Main System Runner
public class EMICalculatorSystem {
    public static void main(String[] args) {
        // Example: Principal = 5,00,000, Rate = 8.75%, Time = 5 Years
        LoanRequest clientLoan = new LoanRequest(
                "L9001", 
                new BigDecimal("500000.00"), 
                new BigDecimal("8.75"), 
                5
        );

        int currencyScale = 2; // Currency standard precision
        BigDecimal finalInterest = FinancialProcessor.calculateSimpleInterest(clientLoan, currencyScale);

        System.out.println("Loan ID: " + clientLoan.getLoanId());
        System.out.println("Total Accrued Interest: INR " + finalInterest);
    }
}