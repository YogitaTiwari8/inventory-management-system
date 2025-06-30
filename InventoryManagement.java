/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inventory.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yogit
 */
public class InventoryManagement {
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
    static final String DB_NAME = "InventoryDB";
    static final String USER = "root";
    static final String PASSWORD = "admin123";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD); Statement stmt = conn.createStatement()) {
            String createDBQuery = "CREATE DATABASE IF NOT EXISTS " + DB_NAME;
            stmt.executeUpdate(createDBQuery);
            System.out.println("Database created or already exists.");
            String dbURL = JDBC_URL + DB_NAME;
            try (Connection dbConn = DriverManager.getConnection(dbURL, USER, PASSWORD); Statement dbStmt = dbConn.createStatement(); 
                    Statement update = dbConn.createStatement()) { 
                String createTableQuery = "CREATE TABLE IF NOT EXISTS signup ("
                        + "Id INT AUTO_INCREMENT PRIMARY KEY, "
                        + "Username VARCHAR(100) NOT NULL ,"
                        + "Password VARCHAR(8) NOT NULL,"
                        + "Timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
                        + ")AUTO_INCREMENT=100";
                dbStmt.executeUpdate(createTableQuery);
                System.out.println("Table created or already exists.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        SignUp obj = new SignUp();
    }
}
