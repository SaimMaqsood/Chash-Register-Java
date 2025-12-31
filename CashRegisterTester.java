import java.util.Scanner;
/**
This program tests the CashRegister class.
*/
public class CashRegisterTester
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        // Expanded coin values (added penny and dollar)
        final double PENNY_VALUE   = 0.01;
        final double NICKEL_VALUE  = 0.05;
        final double DIME_VALUE    = 0.10;
        final double QUARTER_VALUE = 0.25;
        final double DOLLAR_VALUE  = 1.00;

        CashRegister myRegister = new CashRegister();

        // Allow multiple purchases (more realistic)
        System.out.println("Welcome to the Cash Register Simulator");
        boolean shoppingDone = false;

        while (!shoppingDone) {
            System.out.print("Enter price of item (0 to finish shopping): $");
            double price = in.nextDouble();
            in.nextLine(); // consume newline

            if (price <= 0) {
                shoppingDone = true;
            } else {
                myRegister.recordPurchase(price);
                System.out.printf("Added $%.2f. Current total: $%.2f%n", price, myRegister.purchase); // access via toString or getter if added
            }
        }

        if (myRegister.purchase == 0) {
            System.out.println("No purchases made. Goodbye!");
            return;
        }

        System.out.println("\nHow are you going to pay for it?");

        boolean paymentDone = false;
        while (!paymentDone)
        {
            System.out.println("\nEnter coin name (penny, nickel, dime, quarter, dollar) or F to finish:");
            String input = in.nextLine().trim().toLowerCase();

            if (input.equalsIgnoreCase("F")) {
                paymentDone = true;
            } else {
                double value = 0;
                String coinName = input;

                switch (coinName) {
                    case "penny"   -> value = PENNY_VALUE;
                    case "nickel"  -> value = NICKEL_VALUE;
                    case "dime"    -> value = DIME_VALUE;
                    case "quarter" -> value = QUARTER_VALUE;
                    case "dollar"  -> value = DOLLAR_VALUE;
                    default        -> {
                        System.out.println("Unknown coin. Try: penny, nickel, dime, quarter, dollar");
                        continue;
                    }
                }

                System.out.printf("Enter number of %ss: ", input);
                if (!in.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    in.next(); // clear bad input
                    continue;
                }
                int count = in.nextInt();
                in.nextLine(); // consume newline after int

                if (count <= 0) {
                    System.out.println("Number must be positive.");
                    continue;
                }

                Coin c = new Coin(value, input);
                myRegister.enterPayment(count, c);
                System.out.printf("Added %d %s(s) ($%.2f each). Paid so far: $%.2f%n",
                        count, input, value, myRegister.payment);
            }
        }

        double myChange = myRegister.giveChange();
        if (myChange > 0) {
            System.out.printf("Thank you! Your change is $%.2f%n", myChange);
        }

        System.out.println("Transaction complete. Goodbye!");
        in.close();
    }
}
