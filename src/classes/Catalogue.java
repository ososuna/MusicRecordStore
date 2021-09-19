package classes;

import java.util.ArrayList;

public class Catalogue {
    
    private ArrayList<Product> products;

    static private Catalogue _instance = null;

    public Catalogue(ArrayList<Product> products) {
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
        Product product;
        product = findProductById(id);
        if (product == null){
            System.out.println("This product is not in your catalogue :(");
            return;
        }
        products.remove(product);
    }
    
    public Product findProductById(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    static public Catalogue instance(ArrayList<Product> products) {
        if (_instance == null) {
            _instance = new Catalogue(products);
        }
        return _instance;
    }
}
