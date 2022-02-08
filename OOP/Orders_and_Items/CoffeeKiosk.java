import java.util.ArrayList;

public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> order;
    
    public CoffeeKiosk() {
        this.menu = new ArrayList<Item>();
        this.order = new ArrayList<Order>();
    }

    public void addMenuItem(String name, double price) {
        menu.add(new Item(menu.size(), name, price));
    }

    public void displayMenu() {
        for (Item item : this.menu ) {
            System.out.print(item.getIndex() + " " + item.getName() + " -- $" + item.getPrice() + "\n");
        }
    }

    public void newOrder() {
    
    // Shows the user a message prompt and then sets their input to a variable, name
    System.out.println("Please enter customer name for new order:");
    String name = System.console().readLine();
    // Create a new order with the given input string
    Order newOrder = new Order(name);
    this.order.add(newOrder);
    // Show the user the menu, so they can choose items to add.
    this.displayMenu();
    // Prompts the user to enter an item number
    System.out.println("Please enter a menu item index or q to quit:");
    String itemNumber = System.console().readLine();
    newOrder.addItem(this.menu.get(Integer.parseInt(itemNumber)));
    // Write a while loop to collect all user's order items
    while(!itemNumber.equals("q")) {
          // Get the item object from the menu, and add the item to the order
        int i = Integer.parseInt(itemNumber);
        if(i < this.menu.size()){
            Item orderItem = menu.get(i);
            newOrder.addItem(orderItem);
        }
        else {
            System.out.println("Requested product not found");
        }
          // Ask them to enter a new item index or q again, and take their input
        System.out.println("Please enter a menu item index or q to quit:");
        itemNumber = System.console().readLine();
    }
    // After you have collected their order, print the order details 
    // as the example below. You may use the order's display method.
    newOrder.display();

    this.order.add(newOrder);
    }
}