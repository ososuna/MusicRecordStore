package classes;

import java.util.ArrayList;

public class Users {
    
    private ArrayList<User> users;

    static private Users _instance = null;

    private Users(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void removeUser(String username) {
        // TODO: removeUser method
    }

    public User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    static public Users instance(ArrayList<User> users) {
        if (_instance == null) {
            _instance = new Users(users);
        }
        return _instance;
    }

    @Override
    public String toString() {
        return "Users [users=" + users + "]";
    }

}
