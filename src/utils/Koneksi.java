/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author anantyan
 */
public class Koneksi {
    
    private static Connection conn;
    
    public static Connection connDB() {
        
        try { // teknik singleton pattern
            String host = "jdbc:mysql://localhost:3306/db_penjualan";
            String user = "root";
            String pass = "";
            if(conn == null) {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                conn = DriverManager.getConnection(host, user, pass);
            }
        } catch(SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        
        return conn;
    }
}
