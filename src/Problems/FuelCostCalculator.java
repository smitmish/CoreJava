package Problems;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FuelCostCalculator {

    public static BigDecimal calculateTotalFuelCost(BigDecimal liters, BigDecimal pricePerLiter, int scale) {
        if (liters == null || pricePerLiter == null) {
            throw new IllegalArgumentException("Inputs cannot be null");
        }
        
        // Step 1: Perform multiplication using the .multiply() method
        BigDecimal rawTotal = liters.multiply(pricePerLiter);
        
        // Step 2: Set the scale and rounding mode (Accenture tests usually specify HALF_UP or HALF_EVEN)
        return rawTotal.setScale(scale, RoundingMode.HALF_UP);
    }

    public static void main(String[] args) {
        BigDecimal fuelLiters = new BigDecimal("45.553");  // Precise quantity
        BigDecimal price = new BigDecimal("96.75");         // Price per unit
        int requiredScale = 2;                             // Round to 2 decimal places

        BigDecimal finalCost = calculateTotalFuelCost(fuelLiters, price, requiredScale);
        System.out.println("Total Rounded Fuel Cost: INR " + finalCost); 
        // Output will be precisely rounded without floating point drops
    }
}
