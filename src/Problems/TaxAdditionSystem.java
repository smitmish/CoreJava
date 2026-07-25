package Problems;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

// 1. Invoice Item Entity
class InvoiceItem {
    private String itemId;
    private String name;
    private BigDecimal basePrice;
    private BigDecimal taxRate; // e.g., 0.18 for 18% GST

    public InvoiceItem(String itemId, String name, BigDecimal basePrice, BigDecimal taxRate) {
        this.itemId = itemId;
        this.name = name;
        this.basePrice = basePrice;
        this.taxRate = taxRate;
    }

    public String getItemId() { return itemId; }
    public String getName() { return name; }
    public BigDecimal getBasePrice() { return basePrice; }
    public BigDecimal getTaxRate() { return taxRate; }
}

// 2. Centralized Billing Orchestrator using Streams
class BillingSystem {
    private List<InvoiceItem> items = new ArrayList<>();

    public void addItem(InvoiceItem item) {
        items.add(item);
    }

    // Modern Stream implementation to calculate total gross value
    public BigDecimal calculateTotalInvoiceAmount(int scale) {
        return items.stream()
                .map(item -> {
                    // Step A: Calculate Tax Amount = Base Price * Tax Rate
                    BigDecimal taxAmount = item.getBasePrice().multiply(item.getTaxRate());
                    
                    // Step B: Gross Price = Base Price + Tax Amount
                    return item.getBasePrice().add(taxAmount);
                })
                // Step C: Set individual scale before summing to avoid floating point anomalies
                .map(grossAmount -> grossAmount.setScale(scale, RoundingMode.HALF_UP))
                // Step D: Sum everything up using reduce
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

// 3. Main System Runner
public class TaxAdditionSystem {
    public static void main(String[] args) {
        BillingSystem counter = new BillingSystem();

        // Adding items with different tax categories
        counter.addItem(new InvoiceItem("I501", "Office Chair", new BigDecimal("4500.00"), new BigDecimal("0.18"))); // 18% GST
        counter.addItem(new InvoiceItem("I502", "Wireless Mouse", new BigDecimal("1250.50"), new BigDecimal("0.12"))); // 12% GST

        int currencyScale = 2;
        BigDecimal totalBill = counter.calculateTotalInvoiceAmount(currencyScale);

        System.out.println("Final Gross Invoice Bill (Tax Inclusive): INR " + totalBill);
    }
}
