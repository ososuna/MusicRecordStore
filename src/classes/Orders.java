package classes;

import java.util.ArrayList;

public class Orders {
    
    private ArrayList<Order> orders;

    static private Orders _instance = null;

    private Orders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public Order findOrdersByUser(User user) {
        for (Order order : orders) {
            if (order.getUser() == user) {
                return order;
            }
        }
        return null;
    }

    static public Orders instance(ArrayList<Order> orders) {
        if (_instance == null) {
            _instance = new Orders(orders);
        }
        return _instance;
    }

    @Override
    public String toString() {
        return "Orders [orders=" + orders + "]";
    }

}
