import java.util.*;

public class FitnessTracker {
    private List<User> users;

    public FitnessTracker() {
        this.users = new ArrayList<>();
    }

    public boolean registerUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false; // Username already exists
            }
        }
        users.add(new User(username, password));
        return true;
    }

    public User loginUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user; // User found, return the user object
            }
        }
        return null; // User not found
    }
}
