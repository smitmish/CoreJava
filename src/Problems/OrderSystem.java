// // Inventory / Shopping Cart System: 
// // 3 Classes: Product (id, price, stock), Cart (list of products, add/remove, calculate total), 
// // and OrderSystem (main logic processing checkout and reducing stock).

// class Product {
//     private String id;
//     private String name;
//     private BigDecimal price;
//     private int stock;

//     public Product(String id, String name, BigDecimal price, int stock) {
//         this.id = id;
//         this.name = name;
//         this.price = price;
//         this.stock = stock;
//     }

//     public String getId() { return id; }
//     public String getName() { return name; }
//     public BigDecimal getPrice() { return price; }
//     public int getStock() { return stock; }

//     public void reduceStock(int quantity) {
//         if (quantity > stock) {
//             throw new IllegalArgumentException("Not enough stock available");
//         }
//         stock -= quantity;
//     }
// }

// class Cart {
//     private List<Product> products;

//     public Cart() {
//         this.products = new ArrayList<>();
//     }

//     public void addProduct(Product product) {
//         products.add(product);
//     }

//     public void removeProduct(Product product) {
//         products.remove(product);
//     }

//     public BigDecimal calculateTotal() {
//         BigDecimal total = BigDecimal.ZERO;
//         for (Product product : products) {
//             total = total.add(product.getPrice());
//         }
//         return total;
//     }
// }

// class OrderSystem {
//     public static void main(String[] args) {
//         Product product1 = new Product("P001", "Laptop", new BigDecimal("75000.00"), 10);
//         Product product2 = new Product("P002", "Smartphone", new BigDecimal("15000.00"), 20);

//         Cart cart = new Cart();
//         cart.addProduct(product1);
//         cart.addProduct(product2);

//         System.out.println("Total Cart Value: INR " + cart.calculateTotal());

//         // Simulate checkout
//         product1.reduceStock(1); // Reduce stock for Laptop
//         product2.reduceStock(2); // Reduce stock for Smartphone

//         System.out.println("Remaining Stock for Laptop: " + product1.getStock());
//         System.out.println("Remaining Stock for Smartphone: " + product2.getStock());
//     }
// }
package Problems;
// // Inventory / Shopping Cart System: 
// // 3 Classes: Product (id, price, stock), Cart (list of products, add/remove, calculate total), 
// // and OrderSystem (main logic processing checkout and reducing stock).

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// 1. Product Entity
class Product {
    private String id;
    private String name;
    private BigDecimal price;
    private int stock;

    public Product(String id, String name, BigDecimal price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public BigDecimal getPrice() { return price; }
    public int getStock() { return stock; }

    public void reduceStock(int quantity) {
        if (quantity > stock) {
            throw new IllegalArgumentException("Not enough stock available for " + name);
        }
        this.stock -= quantity;
    }
}

// 2. Cart Entity (Tracks a user's chosen items and quantities)
class Cart {
    // Using a Map is much more realistic than a simple List! 
    // It maps a Product to the specific Quantity a user wants to buy.
    private Map<Product, Integer> items;

    public Cart() {
        this.items = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public void removeProduct(Product product) {
        items.remove(product);
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            BigDecimal itemPrice = entry.getKey().getPrice();
            BigDecimal quantity = new BigDecimal(entry.getValue());
            // Using BigDecimal.multiply for precise calculation!
            total = total.add(itemPrice.multiply(quantity));
        }
        
        return total;
        // Stream over the map entries, multiply price by quantity, and sum them up
        // return items.entrySet().stream()
        //         .map(entry -> entry.getKey().getPrice().multiply(new BigDecimal(entry.getValue())))
        //         .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

// 3. Centralized Orchestrator (Manages system-wide items and checkout validation)
class Inventory {
    private List<Product> centralStock = new ArrayList<>();

    public void registerProduct(Product product) {
        centralStock.add(product);
    }

    // High-level business logic: Checks stocks and fulfills the order safely
    public boolean processCheckout(Cart cart) {
        System.out.println("--- Initiating System Validation ---");
        
        // Step A: Pre-check phase. Ensure EVERYTHING in the cart is available before touching stock.
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product targetProduct = entry.getKey();
            int requestedQty = entry.getValue();

            if (targetProduct.getStock() < requestedQty) {
                System.out.println("Checkout Failed: Insufficient stock for " + targetProduct.getName());
                return false; 
            }
        }
        // boolean allItemsAvailable = cart.getItems().entrySet().stream()
        //         .allMatch(entry -> entry.getKey().getStock() >= entry.getValue());

        // if (!allItemsAvailable) {
        //     System.out.println("Checkout Failed: One or more items do not have enough stock.");
        //     return false;
        // }

        // another way to check the product 
        // // 1. Find the FIRST entry where stock is insufficient
        // Optional<Map.Entry<Product, Integer>> failedEntry = cart.getItems().entrySet().stream()
        //         .filter(entry -> entry.getKey().getStock() < entry.getValue())
        //         .findFirst(); // Stops searching the second it finds one failure

        // // 2. If a failed entry is present, print its exact name and exit
        // if (failedEntry.isPresent()) {
        //     Product missingProduct = failedEntry.get().getKey();
        //     System.out.println("Checkout Failed: Insufficient stock for " + missingProduct.getName());
        //     return false;
        // }

        // Step B: Execution phase. If all checks pass, safely deduct quantities.
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product targetProduct = entry.getKey();
            int requestedQty = entry.getValue();
            
            targetProduct.reduceStock(requestedQty);
            System.out.println("Dispatched " + requestedQty + "x " + targetProduct.getName());
        }

        // cart.getItems().forEach((product, requestedQty) -> {
        //     product.reduceStock(requestedQty);
        //     System.out.println("Dispatched " + requestedQty + "x " + product.getName());
        // });

        System.out.println("Order Processed successfully! Total Charged: INR " + cart.calculateTotal());
        return true;
    }
}

// 4. Clean Executable Main System Runner
public class OrderSystem {
    public static void main(String[] args) {
        // Initialize the central store manager
        Inventory storeInventory = new Inventory();

        // Stock up the store
        Product laptop = new Product("P001", "Laptop", new BigDecimal("75000.00"), 10);
        Product phone = new Product("P002", "Smartphone", new BigDecimal("15000.00"), 20);
        storeInventory.registerProduct(laptop);
        storeInventory.registerProduct(phone);

        // User fills their shopping cart
        Cart userCart = new Cart();
        userCart.addProduct(laptop, 1);  // Wants 1 Laptop
        userCart.addProduct(phone, 2);   // Wants 2 Smartphones

        System.out.println("Current Cart Subtotal: INR " + userCart.calculateTotal());

        // Delegate the checkout responsibility completely to the Inventory manager
        boolean transactionStatus = storeInventory.processCheckout(userCart);

        // Verify state changes safely
        System.out.println("Updated Stock Metrics:"+transactionStatus);
        System.out.println("Laptop Remaining: " + laptop.getStock());
        System.out.println("Smartphone Remaining: " + phone.getStock());
    }
}