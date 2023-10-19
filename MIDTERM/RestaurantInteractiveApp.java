import java.util.Scanner;

public class RestaurantInteractiveApp{
    // The items and their corresponding prices are stored in separate arrays.
    private static double[] menuPrices = {100.0, 150.0, 200.0};
    private static double[] addonPrices = {35.0, 50.0};
    private static String[] menuItems = {"c1", "c2", "c3"};
    private static String[] addonItems = {"r1", "r2"};

    public static void main(String[] args) {
        displayMenu();
        int[] orderDetails = getOrderDetails();

        double totalCost = calculateTotalCost(orderDetails);
        double totalCostInDollars = convertToDollars(totalCost);

        displayOrderSummary(orderDetails, totalCost, totalCostInDollars);
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println(menuItems[i] + " - Php " + menuPrices[i]);
        }
        System.out.println("\nAdd Ons:");
        for (int i = 0; i < addonItems.length; i++) {
            System.out.println(addonItems[i] + " - Php " + addonPrices[i]);
        }
    }

    private static int[] getOrderDetails() {
        // Allows the user to input the number of items they want to order,
        // and prompts for each item and its quantity one by one.
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the number of items: ");
        int numItems = scanner.nextInt();
        scanner.nextLine();

        int[] orderDetails = new int[numItems];

        for (int i = 0; i < numItems; i++) {
            System.out.print("Enter item " + (i + 1) + ": ");
            String item = scanner.nextLine();

            while (!isValidItem(item)) {
                System.out.println("Invalid item! Please choose a valid item.");
                System.out.print("Enter item " + (i + 1) + ": ");
                item = scanner.nextLine();
            }

            System.out.print("Enter quantity for " + item + ": ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            while (quantity <= 0) {
                System.out.println("Invalid quantity! Please enter a positive quantity.");
                System.out.print("Enter quantity for " + item + ": ");
                quantity = scanner.nextInt();
                scanner.nextLine();
            }

            orderDetails[i] = quantity;
        }

        return orderDetails;
    }

    private static boolean isValidItem(String item) {
        // Checks whether the entered item matches the valid options by comparing against the specific item strings.
        return item.equalsIgnoreCase("C1") || item.equalsIgnoreCase("C2") ||
                item.equalsIgnoreCase("C3") || item.equalsIgnoreCase("R1") ||
                item.equalsIgnoreCase("R2");
    }

    private static double calculateTotalCost(int[] orderDetails) {
        double totalCost = 0.0;

        for (int i = 0; i < orderDetails.length; i++) {
            double itemPrice = 0.0;

            if (i < menuPrices.length) {
                itemPrice = menuPrices[i];
            } else {
                itemPrice = addonPrices[i - menuPrices.length];
            }

            totalCost += itemPrice * orderDetails[i];
        }

        return totalCost;
    }

    private static double convertToDollars(double totalCost) {
        // Assuming 1 PHP = 0.02 USD
        return totalCost * 0.02;
    }

    private static void displayOrderSummary(int[] orderDetails, double totalCost,
                                            double totalCostInDollars) {
        System.out.println("\nOrder Summary:");
        System.out.println("Qty\tItem\t\tPrice");

        for (int i = 0; i < orderDetails.length; i++) {
            String item = "";
            if (i < menuPrices.length) {
                item = "C" + (i + 1);
            } else {
                item = "R" + (i - menuPrices.length + 1);
            }

            System.out.println(orderDetails[i] + "\t" + item + "\t\tPhp " + menuPrices[i] * orderDetails[i]);
        }

        System.out.println("---------------------------");
        System.out.println("Total Price:\t\tPhp " + totalCost);
        System.out.println("Total Price in USD:\t$" + totalCostInDollars);
    }
}