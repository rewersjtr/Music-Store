import java.util.ArrayList;
import java.util.Scanner;

class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}

class Cart {
    private ArrayList<Item> cartItems;

    public Cart() {
        cartItems = new ArrayList<>();
    }

    public void addItem(Item item) {
        cartItems.add(item);
    }

    public void showCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            for (Item item : cartItems) {
                System.out.println(item);
            }
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Item item : cartItems) {
            total += item.getPrice();
        }
        return total;
    }
}

class MusicStore {
    private ArrayList<Item> availableItems;

    public MusicStore() {
        availableItems = new ArrayList<>();
        availableItems.add(new Item("Guitar - Electric", 199.99));
        availableItems.add(new Item("Piano - Acoustic", 499.99));
        availableItems.add(new Item("Drum Set", 799.99));
        availableItems.add(new Item("Pop Album", 14.99));
        availableItems.add(new Item("Rock Album", 19.99));
        availableItems.add(new Item("Classical Album", 12.99));
    }

    public void showItems() {
        for (int i = 0; i < availableItems.size(); i++) {
            System.out.println((i + 1) + ". " + availableItems.get(i));
        }
    }

    public Item getItem(int index) {
        if (index >= 1 && index <= availableItems.size()) {
            return availableItems.get(index - 1);
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicStore store = new MusicStore();
        Cart cart = new Cart();

        while (true) {
            store.showItems();
            System.out.println("Enter item number to add to cart (0 to checkout):");
            int choice = scanner.nextInt();

            if (choice == 0) {
                cart.showCart();
                System.out.println("Total: $" + cart.calculateTotal());
                break;
            } else {
                Item selectedItem = store.getItem(choice);
                if (selectedItem != null) {
                    cart.addItem(selectedItem);
                    System.out.println("Added: " + selectedItem.getName());
                } else {
                    System.out.println("Invalid choice.");
                }
            }
        }

        scanner.close();
    }
}

