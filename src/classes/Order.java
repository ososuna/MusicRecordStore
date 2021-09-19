package classes;

import java.util.ArrayList;

public class Order {
    
    private ArrayList<Product> products;
    private User user;
    private double totalCost;
    
    public Order(ArrayList<Product> products, User user, double totalCost) {
        this.products = products;
        this.user = user;
        this.totalCost = totalCost;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void printProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Override
    public String toString() {
        return "\nUser: " + user.getUsername() + "\nTotal Cost: $" + totalCost;
    }

}
