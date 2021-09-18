package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    
    public static Users users = Users.instance(new ArrayList<User>());

    public static int option;
    public static Scanner scanner = new Scanner(System.in);

    public Menu() {
        loginMenu();
    }

    public static void loginMenu() {
        do {
            System.out.println("\nMENU");
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

}
