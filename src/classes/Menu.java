package classes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Menu {
    
    public static Users users = Users.instance(new ArrayList<User>());
    public static Session session;
    public static ShoppingCart shoppingCart = ShoppingCart.instance(new ArrayList<Product>());
    
    public static Catalogue catalogue = Catalogue.instance(
        new ArrayList<Product>() {
            {
                add(new Product("01", "Ok Computer", "Radiohead", "Alternative Rock", 1997, 199));
                add(new Product("02", "Demon Days", "Gorillaz", "Alternative Rock", 2005, 299));
                add(new Product("03", "Favourite Worst Nightmare", "Arctic Monkeys", "Indie Rock", 2007, 149));
                add(new Product("04", "Trench", "Twenty One Pilots", "Indie Pop", 2018, 249));
                add(new Product("05", "Help!", "The Beatles", "Folk Rock", 1965, 99));
                add(new Product("06", "Disco de Oro", "Little Jesus", "Alternative Rock", 2019, 159));
            }
        }    
    );

    public static Date date;
    public static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static int option;
    public static Scanner scanner = new Scanner(System.in);

    public Menu() {
        loginMenu();
    }

    public static void loginMenu() {
        do {
            System.out.println("\nMUSIC RECORD STORE");
            System.out.println("1. Log in");
            System.out.println("2. Sign in");
            System.out.println("3. Get out");
            System.out.print("Enter an option: ");
            option = scanner.nextInt();
            
            switch (option) {
                case 1:
                    logIn();
                    break;
                case 2:
                    signIn();
                    break;
                default:
                    System.out.println("\nSee you!\n");
                    return;
            }
        } while (option>= 1 && option <= 2);
    }

    public static void mainMenu() {
        do {

            date = new Date();

            System.out.println("\nMUSIC RECORD STORE");
            System.out.println("\nWelcome, " + session.getUsername() + "!");
            System.out.println(formatter.format(date));
            System.out.println("\n1. Add product to shopping cart");
            System.out.println("2. Remove product in shopping cart");
            System.out.println("3. Show shopping cart");
            System.out.println("4. Create order");
            System.out.println("5. My shopping cart");
            System.out.println("6. My orders");
            System.out.println("7. Catalogue");
            System.out.println("8. Logout");
            System.out.println("9. Get out");
            System.out.print("Enter an option: ");
            option = scanner.nextInt();
            
            switch (option) {
                case 1:
                    addProductToShoppingCart();
                    break;
                case 2:
                    removeProductInShoppingCart();
                    break;
                case 3:
                    // TODO
                    break;
                case 4:
                    // TODO
                    break;
                case 5:
                    System.out.println("\nMY SHOPPING CART");
                    myShoppingCart();
                    break;
                case 6:
                    // TODO
                    break;
                case 7:
                    System.out.println("\nCATALOGUE");
                    showCatalogue();
                    break;
                case 8:
                    // TODO
                    break;
                default:
                    System.out.println("\nSee you!\n");
                    return;
            }
        } while (option>= 1 && option <= 8);
    }

    public static void logIn() {
        
        String username; 
        String password;
        User user;

        System.out.println("\nLOGIN");

        scanner.nextLine();

        System.out.print("Enter username: ");
        username = scanner.nextLine();
        System.out.print("Enter password: ");
        password = scanner.nextLine();

        user = users.findUserByUsername(username); 

        if(user == null) {
            System.out.println("\nInvalid username or password :(");
            return;
        }

        if (!password.equals(user.getPassword())) {
            System.out.println("\nInvalid username or password :(");
            return;
        }

        System.out.println("\nLogin successful :)");

        session = Session.instance(user.getUsername());

        mainMenu();

    }
    
    public static void signIn() {
        
        String username; 
        String password;
        
        System.out.println("\nSIGNIN");

        scanner.nextLine();

        System.out.print("Enter username: ");
        username = scanner.nextLine();
        
        if (users.findUserByUsername(username) != null) {
            System.out.println("\nThis username already exists :(");
            return;
        }        

        System.out.print("Enter password: ");
        password = scanner.nextLine();

        users.addUser(new User(username, password));

        System.out.println("\nYour account have been registered :)");

    }

    public static void addProductToShoppingCart() {
        
        String id;
        Product product;
        
        System.out.println("\nADD PRODUCT TO SHOPPING CART");
        
        showCatalogue();

        scanner.nextLine();

        System.out.print("\nEnter id: ");
        id = scanner.nextLine();

        product = catalogue.findProductById(id);

        if (product == null) {
            System.out.println("\nThere is no product with this id :(");
            return;
        }

        shoppingCart.addProduct(product);

        System.out.println("\nProduct added successfully :)");

    }
    
    public static void removeProductInShoppingCart() {
        
        String id;
        Product product;
        
        System.out.println("\nREMOVE PRODUCT IN SHOPPING CART");
        
        showShoppingCart();
        
        scanner.nextLine();

        System.out.print("\nEnter id: ");
        id = scanner.nextLine();

        product = shoppingCart.findProductById(id);

        if (product == null) {
            System.out.println("\nThere is no product with this id :(");
            return;
        }

        shoppingCart.removeProduct(product);

        System.out.println("\nProduct removed successfully :)");

    }

    public static void showShoppingCart() {
        for (Product product : shoppingCart.getProducts()) {
            System.out.println(product);
        }
    }

    public static void createOrder() {
        // TODO: menu method
    }

    public static void myShoppingCart() {
    
        if (shoppingCart.getProducts().size() == 0) {
            System.out.println("\nYour shopping cart is empty :(");   
            return;
        }

        for (Product product : shoppingCart.getProducts()) {
            System.out.println(product);
        }

    }
    
    public static void myOrders() {
        // TODO: menu method
    }

    public static void showCatalogue() {
        for (Product product : catalogue.getProducts()) {
            System.out.println(product);
        }
    }

    public static void logOut() {
        // TODO: menu method
    }

}
