package classes;

public class Session {

    private String username;

    static private Session _instance = null;

    private Session(String username) {
        this.username = username;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    static public Session instance(String username) {
        if (_instance == null) {
            _instance = new Session(username);
        }
        return _instance;
    }

    @Override
    public String toString() {
        return "Session [username=" + username + "]";
    }

}
