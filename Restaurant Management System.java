import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;


public class Customer {
    private HashMap<String, Integer> menu = new HashMap<>();
    private Scanner sc = new Scanner(System.in);
    private String username = "admin";
    private String password = "password";


    // Method to authenticate user
    private boolean authenticate() {
        System.out.print("Enter username: ");
        String userInput = sc.next();
        System.out.print("Enter password: ");
        String passInput = sc.next();
        return userInput.equals(username) && passInput.equals(password);
    }


    // Method to set menu
    void setMenu() {
        System.out.print("Enter the name of item: ");
        String item = sc.next();
        System.out.print("Enter the price: ");
        int price = sc.nextInt();
        menu.put(item, price);
    }


    // Method to view menu
    void viewMenu() {
        if (menu.isEmpty()) {
            System.out.println("Menu is empty.");
            return;
        }
        System.out.println("Menu:");
        for (String item : menu.keySet()) {
            System.out.println(item + ": $" + menu.get(item));
        }
    }


    // Method to update menu
    void updateMenu() {
        System.out.print("Which item do you want to update? ");
        String item = sc.next();
        if (menu.containsKey(item)) {
            System.out.print("Enter the new price: ");
            int newPrice = sc.nextInt();
            menu.put(item, newPrice);
            System.out.println("Item updated successfully.");
        } else {
            System.out.println("Item not found.");
        }
    }


    // Method to remove an item from the menu
    void removeMenu() {
        System.out.print("Which item do you want to remove? ");
        String item = sc.next();
        if (menu.remove(item) != null) {
            System.out.println("Item removed successfully.");
        } else {
            System.out.println("Item not found.");
        }
    }


    // Method to place an order
    void placeOrder() {
        System.out.print("Enter the item you want to order: ");
        String item = sc.next();
        if (menu.containsKey(item)) {
            System.out.println("Order placed for " + item + " at $" + menu.get(item));
        } else {
            System.out.println("Item not found.");
        }
    }


    // Method to cancel an order (simulated here)
    void cancelOrder() {
        System.out.print("Enter the item you want to cancel: ");
        String item = sc.next();
        if (menu.containsKey(item)) {
            System.out.println("Order for " + item + " has been canceled.");
        } else {
            System.out.println("Item not found.");
        }
    }


    public static void main(String[] args) {
        Customer c = new Customer();


        if (c.authenticate()) {
            boolean running = true;
            while (running) {
                System.out.println("1. Set Menu\n2. View Menu\n3. Update Menu\n4. Remove Menu\n5. Place Order\n6. Cancel Order\n7. Exit");
                System.out.print("Choose an option: ");
                int choice = c.sc.nextInt();
                switch (choice) {
                    case 1:
                        c.setMenu();
                        break;
                    case 2:
                        c.viewMenu();
                        break;
                    case 3:
                        c.updateMenu();
                        break;
                    case 4:
                        c.removeMenu();
                        break;
                    case 5:
                        c.placeOrder();
                        break;
                    case 6:
                        c.cancelOrder();
                        break;
                    case 7:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } else {
            System.out.println("Authentication failed.");
        }
    }
}