package classes;

import java.util.ArrayList;

public class ShoppingCart {
    
    private ArrayList<Product> products;

    static private ShoppingCart _instance = null;

    public ShoppingCart(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(String id) {
        // TODO: removeProduct method
    }

    static public ShoppingCart instance(ArrayList<Product> products) {
        if (_instance == null) {
            _instance = new ShoppingCart(products);
        }
        return _instance;
    }
}
