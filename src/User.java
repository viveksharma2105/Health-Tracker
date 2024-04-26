import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User {
    private String username;
    private String password;
    private ArrayList<String> foodIntake;
    private ArrayList<Integer> foodCalories;
    private ArrayList<String> exercises;
    private ArrayList<Integer> exerciseCalories;

    // Pre-defined food choices with their calorie values
    private static final Map<Integer, String> foodChoices = new HashMap<>();
    static {
        foodChoices.put(1, "Apple");
        foodChoices.put(2, "Banana");
        foodChoices.put(3, "Chicken Breast");
        foodChoices.put(4, "Salad");
        foodChoices.put(5, "Pasta");
    }

    // Pre-defined exercise choices with estimated calories burned per hour
    private static final Map<Integer, String> exerciseChoices = new HashMap<>();
    static {
        exerciseChoices.put(1, "Running");
        exerciseChoices.put(2, "Cycling");
        exerciseChoices.put(3, "Swimming");
        exerciseChoices.put(4, "Jumping Rope");
        exerciseChoices.put(5, "Walking");
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.foodIntake = new ArrayList<>();
        this.foodCalories = new ArrayList<>();
        this.exercises = new ArrayList<>();
        this.exerciseCalories = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<String> getFoodIntake() {
        return foodIntake;
    }

    public ArrayList<Integer> getFoodCalories() {
        return foodCalories;
    }

    public ArrayList<String> getExercises() {
        return exercises;
    }

    public ArrayList<Integer> getExerciseCalories() {
        return exerciseCalories;
    }

    // Method to display food choices and prompt user to select
    public void selectFood() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select food from the following options:");
        System.out.println("Index\tFood\t\t\t\tCalories");
        for (Map.Entry<Integer, String> entry : foodChoices.entrySet()) {
            System.out.println(entry.getKey() + "\t\t" + entry.getValue() + "\t\t\t\t" + getFoodCalories(entry.getValue()));
        }
        System.out.print("Enter the index of your choice: ");
        int selectedFoodIndex = scanner.nextInt();
        if (foodChoices.containsKey(selectedFoodIndex)) {
            String selectedFood = foodChoices.get(selectedFoodIndex);
            foodIntake.add(selectedFood);
            foodCalories.add(getFoodCalories(selectedFood));
        } else {
            System.out.println("Invalid choice.");
        }
    }

    // Method to display exercise choices and prompt user to select
    public void selectExercise() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select exercise from the following options:");
        System.out.println("Index\tExercise\t\t\t\tCalories burned per hour");
        for (Map.Entry<Integer, String> entry : exerciseChoices.entrySet()) {
            System.out.println(entry.getKey() + "\t\t" + entry.getValue() + "\t\t\t\t" + getExerciseCalories(entry.getValue()));
        }
        System.out.print("Enter the index of your choice: ");
        int selectedExerciseIndex = scanner.nextInt();
        if (exerciseChoices.containsKey(selectedExerciseIndex)) {
            String selectedExercise = exerciseChoices.get(selectedExerciseIndex);
            exercises.add(selectedExercise);
            exerciseCalories.add(getExerciseCalories(selectedExercise));
        } else {
            System.out.println("Invalid choice.");
        }
    }

    // Hardcoded logic to fetch calories for the given food
    private int getFoodCalories(String food) {
        Map<String, Integer> foodCaloriesMap = new HashMap<>();
        foodCaloriesMap.put("Apple", 52);
        foodCaloriesMap.put("Banana", 105);
        foodCaloriesMap.put("Chicken Breast", 165);
        foodCaloriesMap.put("Salad", 100);
        foodCaloriesMap.put("Pasta", 220);
        return foodCaloriesMap.getOrDefault(food, 0);
    }

    // Hardcoded logic to fetch calories for the given exercise
    private int getExerciseCalories(String exercise) {
        Map<String, Integer> exerciseCaloriesMap = new HashMap<>();
        exerciseCaloriesMap.put("Running", 600);
        exerciseCaloriesMap.put("Cycling", 500);
        exerciseCaloriesMap.put("Swimming", 700);
        exerciseCaloriesMap.put("Jumping Rope", 800);
        exerciseCaloriesMap.put("Walking", 300);
        return exerciseCaloriesMap.getOrDefault(exercise, 0);
    }

    public int calculateNetCalories() {
        int totalFoodCalories = foodCalories.stream().mapToInt(Integer::intValue).sum();
        int totalExerciseCalories = exerciseCalories.stream().mapToInt(Integer::intValue).sum();
        return totalFoodCalories - totalExerciseCalories;
    }

    // Method to suggest exercises based on pre-defined choices
    public void suggestActivities(int netCalories) {
        if (netCalories > 0) {
            System.out.println("Suggested Exercises:");
            System.out.println("Exercise\t\t\t\tCalories burned per hour");
            for (Map.Entry<Integer, String> entry : exerciseChoices.entrySet()) {
                System.out.println(entry.getValue() + "\t\t\t\t" + getExerciseCalories(entry.getValue()) + " calories burned per hour");
            }
        } else if (netCalories < 0) {
            System.out.println("Suggested Food Options:");
            System.out.println("Food\t\t\t\tCalories");
            for (Map.Entry<Integer, String> entry : foodChoices.entrySet()) {
                System.out.println(entry.getValue() + "\t\t\t\t" + getFoodCalories(entry.getValue()) + " calories");
            }
        } else {
            System.out.println("You have maintained your net calorie balance. Keep it up!");
        }
    }

}
