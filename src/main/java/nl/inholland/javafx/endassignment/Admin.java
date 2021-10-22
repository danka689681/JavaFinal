package nl.inholland.javafx.endassignment;

public class Admin extends User {
    private String role ;

    public Admin(String userName, String password, String role) {
        super(userName, password);
        this.role = role;
    }

    public String toString() {
        return this.role;
    }
}
