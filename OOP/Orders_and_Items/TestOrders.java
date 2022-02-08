import java.util.ArrayList;
import java.util.Arrays;
public class TestOrders {
    public static void main(String[] args) {

        Item item1 = new Item("Mocha", 9.99);
        Item item2 = new Item("Drip Coffee", 5.99);
        Item item3 = new Item("Capuccino", 2.99);
        Item item4 = new Item("Decaf", 1.99);

        Order order1 = new Order();
        Order order2 = new Order();

        Order order3 = new Order("Todd");
        Order order4 = new Order("Henry");
        Order order5 = new Order("Jason");

        order1.addItem(item1);
        order1.addItem(item4);

        order2.addItem(item2);
        order2.addItem(item3);

        order3.addItem(item1);
        order3.addItem(item4);

        order4.addItem(item2);
        order4.addItem(item3);

        order5.addItem(item1);
        order5.addItem(item4);

        order1.setReady(true);
        order1.getStatusMessage();

        order2.getStatusMessage();

        order3.setReady(true);
        order3.getStatusMessage();

        order4.getStatusMessage();

        order5.setReady(true);
        order5.getStatusMessage();

        System.out.println(order1.getOrderTotal());
        System.out.println(order2.getOrderTotal());
        System.out.println(order3.getOrderTotal());
        System.out.println(order4.getOrderTotal());
        System.out.println(order5.getOrderTotal());

        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();
    }
}
