/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqli_zafiyet.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kaan
 */
public class DatabaseConnection {

    private final String connString = "jdbc:sqlite:zafiyet.db";
    private Connection conn;
    private static DatabaseConnection dbConnection;
    
    public Connection getConnection(){
        return this.conn;
    }
    
    
    public static DatabaseConnection getInstance(){
        if(dbConnection == null){
            dbConnection = new DatabaseConnection();
        }
        return dbConnection;
    }
    
    private DatabaseConnection() {
        try {
            conn = DriverManager.getConnection(connString);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
