import java.util.*;

public class UserInterface {
    private FitnessTracker fitnessTracker;
    private Scanner scanner;

    public UserInterface() {
        this.fitnessTracker = new FitnessTracker();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("1. Register\n2. Login\n3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void registerUser() {
        System.out.print("Enter username: ");
        String regUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String regPassword = scanner.nextLine();
        if (fitnessTracker.registerUser(regUsername, regPassword)) {
            System.out.println("Registration successful.");
        } else {
            System.out.println("Username already exists.");
        }
    }

    private void loginUser() {
        System.out.print("Enter username: ");
        String loginUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String loginPassword = scanner.nextLine();
        User loggedInUser = fitnessTracker.loginUser(loginUsername, loginPassword);
        if (loggedInUser != null) {
            System.out.println("Login successful. Welcome, " + loggedInUser.getUsername() + "!");
            handleUserActions(loggedInUser);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private void handleUserActions(User user) {
        while (true) {
            System.out.println("1. Track food intake\n2. Track exercise\n3. Calculate net calories\n4. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter calories consumed: ");
                    int caloriesConsumed = scanner.nextInt();
                    user.addFoodIntakeCalories(caloriesConsumed);
                    System.out.println("Calories consumed added successfully.");
                    break;
                case 2:
                    System.out.print("Enter calories burned: ");
                    int caloriesBurned = scanner.nextInt();
                    user.addExerciseCalories(caloriesBurned);
                    System.out.println("Calories burned added successfully.");
                    break;
                case 3:
                    int netCalories = user.calculateNetCalories();
                    System.out.println("Net calories: " + netCalories);
                    if (netCalories > 0) {
                        System.out.println("You gained " + netCalories + " calories.");
                    } else if (netCalories < 0) {
                        System.out.println("You burned " + (-netCalories) + " calories.");
                    } else {
                        System.out.println("You consumed and burned equal calories.");
                    }
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
