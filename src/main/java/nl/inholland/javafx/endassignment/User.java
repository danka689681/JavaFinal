package nl.inholland.javafx.endassignment;

public class User {
    protected String userName;
    protected String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return this.userName;
    }

    public String toString() {
        return this.userName;
    }


    public String getPassword() {
        return this.password;
    }
}
