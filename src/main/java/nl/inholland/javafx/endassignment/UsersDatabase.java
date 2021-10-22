package nl.inholland.javafx.endassignment;

import java.util.ArrayList;
import java.util.List;

public class UsersDatabase {
    public static void createUser(List users, String username, String password) {
        User newUser = new User(username, password);
        users.add(newUser);
    }

    public static void createAdmin(List users, String username, String password, String role) {
        User newUser = new Admin(username, password, role);
        users.add(newUser);
    }

    public List<User> users = new ArrayList<>();

    public UsersDatabase() {
        createUser(users, "User", "user");
        createAdmin(users, "Admin", "admin", "Admin");
    }

    public List<User> getUsers() {
        return users;
    }

}