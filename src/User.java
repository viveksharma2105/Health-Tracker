public class User {
    private String username;
    private String password;
    private int foodIntakeCalories;
    private int exerciseCalories;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.foodIntakeCalories = 0;
        this.exerciseCalories = 0;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getFoodIntakeCalories() {
        return foodIntakeCalories;
    }

    public void addFoodIntakeCalories(int calories) {
        foodIntakeCalories += calories;
    }

    public int getExerciseCalories() {
        return exerciseCalories;
    }

    public void addExerciseCalories(int calories) {
        exerciseCalories += calories;
    }

    public int calculateNetCalories() {
        return foodIntakeCalories - exerciseCalories;
    }
}
