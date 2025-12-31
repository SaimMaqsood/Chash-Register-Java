public class CashRegister
{
    /**
     Constructs a cash register with no money in it.
    */
    public CashRegister()
    {
        purchase = 0;
        payment = 0;
    }

    /**
     Records the sale of an item.
     @param amount the price of the item
    */
    public void recordPurchase(double amount)
    {
        if (amount > 0) {
            double newTotal = purchase + amount;
            purchase = newTotal;
        } else {
            System.out.println("Invalid purchase amount (must be positive).");
        }
    }

    /**
     Enters the payment received from the customer; should be called once
     for each coin type.
     @param coinCount the number of coins
     @param coinType the type of the coins in the payment
    */
    public void enterPayment(int coinCount, Coin coinType)
    {
        if (coinCount > 0) {
            payment = payment + coinCount * coinType.getValue();
        } else {
            System.out.println("Number of coins must be positive.");
        }
    }

    /**
     Computes the change due and resets the machine for the next customer.
     @return the change due to the customer
    */
    public double giveChange()
    {
        if (payment < purchase) {
            System.out.printf("Insufficient payment! Still owed: $%.2f%n", (purchase - payment));
            return 0; // Don't reset until fully paid
        }

        double change = payment - purchase;

        // Print receipt summary
        System.out.println("\n--- Receipt ---");
        System.out.printf("Purchase total: $%.2f%n", purchase);
        System.out.printf("Amount paid:    $%.2f%n", payment);
        System.out.printf("Change due:     $%.2f%n", change);
        System.out.println("---------------");

        purchase = 0;
        payment = 0;
        return change;
    }

    // Added for better debugging/output if needed
    @Override
    public String toString()
    {
        return String.format("CashRegister [purchase=%.2f, payment=%.2f]", purchase, payment);
    }

    private double purchase;
    private double payment;
}
