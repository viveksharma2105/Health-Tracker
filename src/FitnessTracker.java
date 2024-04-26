import java.util.HashMap;
import java.util.Map;

public class FitnessTracker {
    private Map<String, User> users;

    public FitnessTracker() {
        this.users = new HashMap<>();
    }

    public boolean registerUser(String username, String password) {
        if (!users.containsKey(username)) {
            users.put(username, new User(username, password));
            return true;
        }
        return false;
    }

    public User loginUser(String username, String password) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
