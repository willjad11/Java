import java.util.ArrayList;

class Order {
    private String name;
    private boolean ready;
    private ArrayList<Item> items = new ArrayList<Item>();;
    
    public Order() {
        this.name = "Guest";
    }

    public Order(String name) {
        this.name = name;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public String getStatusMessage() {
        if (this.ready) {
            System.out.print("Your order is ready." + "\n");
            return "Your order is ready.";
        }
        else {
            System.out.print("Thank you for waiting. Your order will be ready soon." + "\n");
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }

    public double getOrderTotal() {
        double output = 0;
        for (Item item : this.items ) {
            output += item.getPrice();
        }
        return output;
    }

    public void display() {
        System.out.print("Customer Name: " + this.name + "\n");
        for (Item item : this.items ) {
            System.out.print(item.getName() + " - $" + item.getPrice() + "\n");
        }
        System.out.print("Total: $" + this.getOrderTotal() + "\n");
    }
}