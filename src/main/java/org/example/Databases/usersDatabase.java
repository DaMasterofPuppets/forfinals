package org.example.Databases;
import java.sql.*;

public class usersDatabase {

    private static final String url = "jdbc:sqlite:database.db";

    //Create Users Table
    public static void createUsersTable() {
        String usersSql = "CREATE TABLE IF NOT EXISTS users (" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "userName TEXT NOT NULL, " +
                "passWord TEXT NOT NULL," +
                "roles TEXT NOT NULL);";

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {
            if (connection != null) {
                statement.execute(usersSql);
                System.out.println("User table created successfully");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Add a new User
    public static void registerUser(String userName, String passWord, String roles) {
        String insertSql = "INSERT INTO users (userName, passWord, roles) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, passWord);
            preparedStatement.setString(3, roles);
            preparedStatement.executeUpdate();
            System.out.println("User registered successfully");
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    //Authenticate the credentials of User
    public static boolean authenticateUser(String userName, String passWord) {
        String selectSql = "SELECT * FROM users WHERE userName = ? AND passWord = ?";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, passWord);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
            return false;
        }
    }

    //Check if the username is already registered
    public static boolean isUsernameAvailable(String userName) {
        String checkSql = "SELECT * FROM users WHERE userName = ?";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(checkSql)) {
            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery();

            return !resultSet.next();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
            return false;
        }
    }
}
