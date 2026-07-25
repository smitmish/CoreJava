// 1. The Return Type Hierarchy
class Receipt {
    void printSummary() {
        System.out.println("--- Standard Transaction Receipt ---");
    }
}

// GoldReceipt is a subclass of Receipt
class GoldReceipt extends Receipt {
    int rewardPointsEarned = 50;

    @Override
    void printSummary() {
        System.out.println("--- GOLD TRANSACTION RECEIPT ---");
    }

    void printRewards() {
        System.out.println("Bonus Points Earned Today: " + rewardPointsEarned);
    }
}

class BankAccount {
    double balance = 1000.0;

    // 1. Basic Deposit (Just an amount)
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited Cash: $" + amount);
    }

    // 2. Overloaded: Deposit via Check (Amount + Check Number)
    void deposit(double amount, String checkNumber) {
        balance += amount;
        System.out.println("Deposited Check #" + checkNumber + ": $" + amount);
    }

    // 3. Overloaded: Deposit via Account Transfer (Amount + Source Account)
    void deposit(double amount, BankAccount sourceAccount) {
        sourceAccount.balance -= amount;
        this.balance += amount;
        System.out.println("Transferred $" + amount + " from another account.");
    }

    // Standard withdrawal with no extra rules
    void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrew: $" + amount + ". New Balance: $" + balance);
    }

    // Parent method returns generic Receipt
    public Receipt processTransaction(double amount) {
        System.out.println("Processing standard transaction of $" + amount);
        return new Receipt();
    }
}

// Child Class 1: Savings Account
class SavingsAccount extends BankAccount {
    // OVERRIDING: Savings accounts might restrict withdrawals if balance falls too low
    @Override
    void withdraw(double amount) {
        if (balance - amount < 100) {
            System.out.println("Transaction Denied: Must maintain $100 minimum balance.");
        } else {
            super.withdraw(amount); // Calls the parent class withdraw logic
        }
    }
}

// Child Class 2: Current Account (Business)
class CurrentAccount extends BankAccount {
    double overdraftLimit = 500.0;

    // OVERRIDING: Business accounts allow withdrawing more than the balance (overdraft)
    @Override
    void withdraw(double amount) {
        if (amount <= (balance + overdraftLimit)) {
            balance -= amount;
            System.out.println("Business Overdraft Used. New Balance: $" + balance);
        } else {
            System.out.println("Transaction Denied: Overdraft limit exceeded.");
        }
    }
}

// Child Class 3: Gold Account (VIP)
class GoldAccount extends BankAccount {
    // VALID OVERRIDING: GoldReceipt is a covariant return type of Receipt
    @Override
    public GoldReceipt processTransaction(double amount) {
        System.out.println("Processing VIP premium transaction of $" + amount);
        return new GoldReceipt(); 
    }
}



public class Main {
    public static void main(String[] args) {
        // --- Testing Overloading ---
        BankAccount basicAcc = new BankAccount();
        basicAcc.deposit(50.0);                    // Calls version 1
        basicAcc.deposit(200.0, "CHK10023");       // Calls version 2

        System.out.println("-------------------------");

        // --- Testing Overriding (Polymorphism) ---
        BankAccount myAccount;

        // Polymorphism actively decides which method to run at runtime
        myAccount = new SavingsAccount(); 
        myAccount.withdraw(950.0); // Triggers the SavingsAccount minimum balance restriction

        myAccount = new CurrentAccount();
        myAccount.withdraw(1200.0); // Triggers the CurrentAccount overdraft logic

        Receipt receipt = myAccount.processTransaction(15); // Still returns Receipt, not GoldReceipt
        receipt.printSummary(); // Calls the overridden method in CurrentAccount

        GoldAccount vipUser = new GoldAccount();
        
        // Direct assignment! No parent-to-child type casting required
        GoldReceipt myReceipt = vipUser.processTransaction(500.0);
        
        // You can immediately call Gold-specific methods directly
        myReceipt.printSummary();
        myReceipt.printRewards(); 
    }
}

