package org.example.Databases;

import static org.example.Databases.inventoryDatabase.createInventoryTable;
import static org.example.Databases.mealsDatabase.createMealsTable;
import static org.example.Databases.ordersDatabase.createOrdersTable;
import static org.example.Databases.usersDatabase.createUsersTable;

public class Database {

    private static final String url = "jdbc:sqlite:database.db"; // Database URL

    public static void main(String[] args) {
        createUsersTable();
        createMealsTable();
        createOrdersTable();
        createInventoryTable();
    }
}
