/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Koneksi;

/**
 *
 * @author anantyan
 */
public class Main {

    private static Connection conn;
    private static Statement state;
    private static PreparedStatement pre_state;
    
    public static void main(String[] args) {
        
        String sql;
        conn = Koneksi.connDB();
        try {
            state = conn.createStatement(); // versi statement
            Supplier sp = new Supplier("PT Abadi", "Purwokerto", "0281123456", "abadi@gmail.com");
            sql = "INSERT INTO supplier (nama_supplier, alamat, telp, email)"
                    + "VALUES ('"+sp.getNama()+"','"+sp.getAlamat()+"','"+sp.getTelp()+"','"+sp.getEmail()+"')";
            state.executeUpdate(sql);
            
            sql = "INSERT INTO supplier (nama_supplier, alamat, telp, email) "
                    + "VALUES (?,?,?,?)";
            pre_state = conn.prepareStatement(sql); // versi prepare statement
            pre_state.setString(1, "PT Permata");
            pre_state.setString(2, "Ajibarang");
            pre_state.setString(3, "0281123456");
            pre_state.setString(4, "abadi@gmail.com");
            pre_state.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch(Exception e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                state.close();
                pre_state.close();
                conn.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
