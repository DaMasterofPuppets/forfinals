package org.example.Databases;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class mealsDatabase {

    private static final String url = "jdbc:sqlite:database.db";

    //Create Meals Table
    public static void createMealsTable() {
        String mealsSql= "CREATE TABLE IF NOT EXISTS meals (" +
                "mealId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "mealName TEXT, " +
                "description TEXT, " +
                "category TEXT, " +
                "ingredients TEXT, " +
                "dietType TEXT, " +
                "spice TEXT, " +
                "servingSize TEXT, " +
                "unit TEXT, " +
                "nutritionalValue TEXT);";

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {
            if (connection != null) {
                statement.execute(mealsSql);
                System.out.println("Meals table created successfully");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Add Meals
    public static void addMeals(String mealName, String description, String category, String ingredients, String dietType, String spice, String servingSize, String unit, String nutritionalValue) {
        String insertMeals = "INSERT INTO meals (mealName, description, category, ingredients, dietType, spice, servingSize, unit, nutritionalValue) VALUES (?,?,?,?,?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(insertMeals)) {
            preparedStatement.setString(1, mealName);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, category);
            preparedStatement.setString(4, ingredients);
            preparedStatement.setString(5, dietType);
            preparedStatement.setString(6, spice);
            preparedStatement.setString(7, servingSize);
            preparedStatement.setString(8, unit);
            preparedStatement.setString(9, nutritionalValue);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Update Meals
    public static void updateMeals (String mealName, String description, String category, String ingredients, String dietType, String spice, String servingSize, String nutritionalValue) {
        String updateMeals = "UPDATE meals SET description = ?, category = ?, ingredients = ?, dietType = ?, spice = ?, servingSize = ?, nutritionalValue = ? WHERE mealName = ?";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(updateMeals)) {

            preparedStatement.setString(1, description);
            preparedStatement.setString(2, category);
            preparedStatement.setString(3, ingredients);
            preparedStatement.setString(4, dietType);
            preparedStatement.setString(5, spice);
            preparedStatement.setString(6, servingSize);
            preparedStatement.setString(7, nutritionalValue);
            preparedStatement.setString(8, mealName);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Delete Meals
    public static void deleteMeal(int mealId) {
        String deleteSQL = "DELETE FROM Meals WHERE mealId = ?";
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {

            if (connection!=null) {
                System.out.println("Meal deleted successfully");
            }

            preparedStatement.setInt(1, mealId);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Meal deleted successfully");
            } else {
                System.out.println("Meal does not exist.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Get Meals to display in the Menu Page
    public static List<String[]> getMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, category, ingredients, dietType, spice, servingSize, nutritionalValue FROM meals"; // Adjust SQL query

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectMeals);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String mealName = resultSet.getString("mealName");
                String mealId = resultSet.getString("mealId");
                String description = resultSet.getString("description");
                String category = resultSet.getString("category");
                String ingredients = resultSet.getString("ingredients");
                String dietType = resultSet.getString("dietType");
                String spice = resultSet.getString("spice");
                String servingSize = resultSet.getString("servingSize");
                String nutritionalValue = resultSet.getString("nutritionalValue");
                menu.add(new String[]{mealName, mealId, description, category, ingredients, dietType, spice, servingSize, nutritionalValue}); // Add meal name and description as an array
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }

    //Get Vegetarian Meals to display in Inventory Page
    public static List<String[]> getVegetarianMeals(){
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, nutritionalValue, spice, servingSize, dietType, ingredients FROM meals WHERE  diettYPE = 'vegetarian'";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectMeals);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String mealName = resultSet.getString("mealName");
                String mealId = resultSet.getString("mealId");
                String description = resultSet.getString("description");
                String ingredients = resultSet.getString("ingredients");
                String dietType = resultSet.getString("dietType");
                String spice = resultSet.getString("spice");
                String servingSize = resultSet.getString("servingSize");
                String nutritionalValue = resultSet.getString("nutritionalValue");
                menu.add(new String[]{mealName, mealId, description, nutritionalValue, spice, servingSize, dietType, ingredients});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }

    //Get NON Vegetarian Meals to display in Inventory Page
    public static List<String[]> getNonVegetarianMeals(){
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, nutritionalValue, spice, servingSize, dietType, ingredients FROM meals WHERE  diettYPE = 'non-vegetarian'";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectMeals);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String mealName = resultSet.getString("mealName");
                String mealId = resultSet.getString("mealId");
                String description = resultSet.getString("description");
                String ingredients = resultSet.getString("ingredients");
                String dietType = resultSet.getString("dietType");
                String spice = resultSet.getString("spice");
                String servingSize = resultSet.getString("servingSize");
                String nutritionalValue = resultSet.getString("nutritionalValue");
                menu.add(new String[]{mealName, mealId, description, nutritionalValue, spice, servingSize, dietType, ingredients});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }

    //Get Breakfast Meals to display in the Menu Page
    public static List<String[]> getBreakfastMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, nutritionalValue, spice, servingSize, dietType, ingredients   FROM meals WHERE category = 'breakfast'";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectMeals);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String mealName = resultSet.getString("mealName");
                String mealId = resultSet.getString("mealId");
                String description = resultSet.getString("description");
                String ingredients = resultSet.getString("ingredients");
                String dietType = resultSet.getString("dietType");
                String spice = resultSet.getString("spice");
                String servingSize = resultSet.getString("servingSize");
                String nutritionalValue = resultSet.getString("nutritionalValue");
                menu.add(new String[]{mealName, mealId, description, nutritionalValue, spice, servingSize, dietType, ingredients});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }

    //Get Vegetarian Breakfast Meals
    public static List<String[]> getBreakfastVegetarianMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, nutritionalValue, spice, servingSize, dietType, ingredients   FROM meals WHERE category = 'breakfast' AND diettYPE = 'vegetarian'";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectMeals);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String mealName = resultSet.getString("mealName");
                String mealId = resultSet.getString("mealId");
                String description = resultSet.getString("description");
                String ingredients = resultSet.getString("ingredients");
                String dietType = resultSet.getString("dietType");
                String spice = resultSet.getString("spice");
                String servingSize = resultSet.getString("servingSize");
                String nutritionalValue = resultSet.getString("nutritionalValue");
                menu.add(new String[]{mealName, mealId, description, nutritionalValue, spice, servingSize, dietType, ingredients});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }

    //Get Non Vegetarian Breakfast Meals
    public static List<String[]> getBreakfastNonVegetarianMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, nutritionalValue, spice, servingSize, dietType, ingredients   FROM meals WHERE category = 'breakfast' AND diettYPE = 'non-vegetarian'";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectMeals);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String mealName = resultSet.getString("mealName");
                String mealId = resultSet.getString("mealId");
                String description = resultSet.getString("description");
                String ingredients = resultSet.getString("ingredients");
                String dietType = resultSet.getString("dietType");
                String spice = resultSet.getString("spice");
                String servingSize = resultSet.getString("servingSize");
                String nutritionalValue = resultSet.getString("nutritionalValue");
                menu.add(new String[]{mealName, mealId, description, nutritionalValue, spice, servingSize, dietType, ingredients});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }

    //Get Lunch Meals to display in the Menu Page
    public static List<String[]> getLunchMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, nutritionalValue, spice, servingSize, dietType, ingredients   FROM meals WHERE category = 'lunch'";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectMeals);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String mealName = resultSet.getString("mealName");
                String mealId = resultSet.getString("mealId");
                String description = resultSet.getString("description");
                String ingredients = resultSet.getString("ingredients");
                String dietType = resultSet.getString("dietType");
                String spice = resultSet.getString("spice");
                String servingSize = resultSet.getString("servingSize");
                String nutritionalValue = resultSet.getString("nutritionalValue");
                menu.add(new String[]{mealName, mealId, description, nutritionalValue, spice, servingSize, dietType, ingredients});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }

    //Get Dinner Meals to display in the Menu Page
    public static List<String[]> getDinnerMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, category, ingredients, dietType, spice, servingSize, nutritionalValue FROM meals WHERE category = 'dinner'";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectMeals);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String mealName = resultSet.getString("mealName");
                String mealId = resultSet.getString("mealId");
                String description = resultSet.getString("description");
                String category = resultSet.getString("category");
                String ingredients = resultSet.getString("ingredients");
                String dietType = resultSet.getString("dietType");
                String spice = resultSet.getString("spice");
                String servingSize = resultSet.getString("servingSize");
                String nutritionalValue = resultSet.getString("nutritionalValue");
                menu.add(new String[]{mealName, mealId, description, category, ingredients, dietType, spice, servingSize, nutritionalValue});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }

    //Get Searched Meals to display in the Menu Page
    public static List<String[]> getSearchedMeals(String search) {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, category, ingredients, dietType, spice, servingSize, nutritionalValue FROM meals WHERE mealName = ? VALUES (?)";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectMeals);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String mealName = resultSet.getString("mealName");
                String mealId = resultSet.getString("mealId");
                String description = resultSet.getString("description");
                String category = resultSet.getString("category");
                String ingredients = resultSet.getString("ingredients");
                String dietType = resultSet.getString("dietType");
                String spice = resultSet.getString("spice");
                String servingSize = resultSet.getString("servingSize");
                String nutritionalValue = resultSet.getString("nutritionalValue");

                preparedStatement.setString(1, search);

                menu.add(new String[]{mealName, mealId, description, category, ingredients, dietType, spice, servingSize, nutritionalValue});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }

    public static void deleteMealByName(String mealName) {
        String deleteSQL = "DELETE FROM Meals WHERE mealName = ?";
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {

            preparedStatement.setString(1, mealName);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Meal deleted successfully by Name.");
            } else {
                System.out.println("No meal found with the given Name.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Authenticate if the meal exists
    public static boolean authenticateMealName(String mealName) {
        String selectSQL = "SELECT * FROM meals WHERE mealName = ?";
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            preparedStatement.setString(1, mealName);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
