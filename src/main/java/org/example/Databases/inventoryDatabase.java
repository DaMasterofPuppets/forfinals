package org.example.Databases;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.sql.DriverManager.getConnection;

public class inventoryDatabase {

    private static final String url = "jdbc:sqlite:database.db";

    public inventoryDatabase() throws SQLException {
    }

    // Create Inventory table
    public static void createInventoryTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Inventory ("
                + "inventoryId INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "mealId INTEGER, "
                + "mealName TEXT NOT NULL, "
                + "price TEXT NOT NULL, "
                + "quantity INTEGER NOT NULL, "
                + "FOREIGN KEY (mealId) REFERENCES meals(mealId))"; // Link mealId to meals table;

        try (Connection connection = getConnection(url);
             Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
            System.out.println("Table 'Inventory' created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Helper method to check if a meal name exists in the meals table and retrieve its mealId
    public static Integer getMealIdByName(String mealName) {
        String query = "SELECT mealId FROM meals WHERE mealName = ?";
        try (Connection connection = getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, mealName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("mealId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // Return null if meal name does not exist
    }

    // Add inventory item only if mealName exists in meals table
    public static void addInventory(String mealName, int quantity, double price) {
        Integer mealId = getMealIdByName(mealName);
        if (mealId == null) {
            System.out.println("Meal name not found in meals table. Cannot add to inventory.");
            return;
        }

        String insertSQL = "INSERT INTO Inventory (mealId, mealName, price, quantity) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setInt(1, mealId);
            preparedStatement.setString(2, mealName);
            preparedStatement.setDouble(3, price);  // Set the price
            preparedStatement.setInt(4, quantity);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Inventory item added successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete inventory item only if mealName exists in meals table
    public static boolean deleteInventory(int inventoryId) {
        String deleteSQL = "DELETE FROM Inventory WHERE inventoryId = ?";
        try (Connection connection = getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setInt(1, inventoryId);
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Inventory item deleted successfully!");
                return true;
            } else {
                System.out.println("No inventory item found with inventoryId '" + inventoryId + "'.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    //list inventory
    public static List<String[]> listInventory() {
        List<String[]> inventoryData = new ArrayList<>();
        String query = "SELECT inventoryId, mealId, mealName, quantity, price FROM Inventory ORDER BY inventoryId";

        try (Connection connection = getConnection("jdbc:sqlite:database.db");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String inventoryId = String.format("%03d", resultSet.getInt("inventoryId"));
                String mealId = String.valueOf(resultSet.getInt("mealId"));
                String mealName = resultSet.getString("mealName");  // Fetch meal name from the result set
                String quantity = String.valueOf(resultSet.getInt("quantity"));
                String price = String.format("₱%.2f", resultSet.getDouble("price"));
                inventoryData.add(new String[]{inventoryId, mealId, mealName, quantity, price});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return inventoryData;
    }

    // Method to get vegetarian meals and store them in a new list
    public static List<String[]> getVegetarianMeals() {
        List<String[]> vegetarianMeals = new ArrayList<>();
        String query = "SELECT inventoryId, mealId, mealName, price, quantity FROM Inventory WHERE mealId IN " +
                "(SELECT mealId FROM meals WHERE dietType = 'vegetarian')";

        try (Connection connection = getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            // Iterate over the result set and add vegetarian meals to the list
            while (resultSet.next()) {
                String inventoryId = String.format("%03d", resultSet.getInt("inventoryId"));
                String mealId = String.format("%03d", resultSet.getInt("mealId"));
                String mealName = resultSet.getString("mealName");
                String price = String.format("₱%.2f", resultSet.getDouble("price"));
                String quantity = String.valueOf(resultSet.getInt("quantity"));
                vegetarianMeals.add(new String[]{inventoryId, mealId, mealName,  quantity, price});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vegetarianMeals;
    }

    // Method to get vegetarian meals and store them in a new list
    public static List<String[]> getNonVegetarianMeals() {
        List<String[]> nonVegetarianMeals = new ArrayList<>();
        String query = "SELECT inventoryId, mealId, mealName, price, quantity FROM Inventory WHERE mealId IN " +
                "(SELECT mealId FROM meals WHERE dietType = 'non-vegetarian')";

        try (Connection connection = getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            // Iterate over the result set and add vegetarian meals to the list
            while (resultSet.next()) {
                String inventoryId = String.format("%03d", resultSet.getInt("inventoryId"));
                String mealId = String.format("%03d", resultSet.getInt("mealId"));
                String mealName = resultSet.getString("mealName");
                String price = String.format("₱%.2f", resultSet.getDouble("price"));
                String quantity = String.valueOf(resultSet.getInt("quantity"));
                nonVegetarianMeals.add(new String[]{inventoryId, mealId, mealName,  quantity, price});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nonVegetarianMeals;
    }

    public static void updateInventory(String mealName, String quantity, String price, String inventoryId) {
        String updateInventorySQL = "UPDATE Inventory SET mealName = ?, quantity = ?, price = ? WHERE inventoryId = ?";

        try (Connection connection = getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(updateInventorySQL)) {

            preparedStatement.setString(1, mealName);
            preparedStatement.setString(2, quantity);
            preparedStatement.setString(3, price);
            preparedStatement.setString(4, inventoryId);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Inventory updated successfully!");
            } else {
                System.out.println("No inventory item found with the specified ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Authenticate if the inventory ID exists
    public static boolean authenticateInventoryId(int inventoryId) {
        String selectSQL = "SELECT * FROM inventory WHERE inventoryId = ?";
        try (Connection connection = getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            preparedStatement.setInt(1, inventoryId);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
