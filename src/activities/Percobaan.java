/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activities;

import entities.Supplier;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import utils.Koneksi;

/**
 *
 * @author anantyan
 */
public class Percobaan {

    /*private static Connection conn;*/ // ternyata sudah ada di Koneksi.java
    private static Statement state;
    private static PreparedStatement pre_state;
    
    public static void main(String[] args) {
        
        String sql;
        try {
            state = Koneksi.connDB().createStatement(); // versi statement
            Supplier sp = new Supplier("PT Abadi", "Purwokerto", "0281123456", "abadi@gmail.com");
            sql = "INSERT INTO supplier (nama_supplier, alamat, telp, email)"
            + "VALUES ('"+sp.getNama()+"','"+sp.getAlamat()+"','"+sp.getTelp()+"','"+sp.getEmail()+"')";
            state.executeUpdate(sql);
            
            /*sql = "INSERT INTO supplier (nama_supplier, alamat, telp, email) "
            + "VALUES (?,?,?,?)";*/
            sql = "UPDATE supplier SET nama_supplier=?, alamat=?"
            + "WHERE kode_supplier=?";
            pre_state = Koneksi.connDB().prepareStatement(sql); // versi prepare statement
            /*pre_state.setString(1, "PT Permata");
            pre_state.setString(2, "Ajibarang");
            pre_state.setString(3, "0281123456");
            pre_state.setString(4, "abadi@gmail.com");*/
            pre_state.setString(1, "PT Permata");
            pre_state.setString(2, "Ajibarang");
            pre_state.setInt(3, 1);
            pre_state.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            state = null;
            pre_state = null;
        } catch(Exception e) {
            System.err.println(e.getMessage());
            state = null;
            pre_state = null;
        } finally {
            try {
                state.close();
                pre_state.close();
                /*conn.close();*/ // Sebenarnya ga usah ga paapa 
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                state = null;
                pre_state = null;
            }
        }
    }
}
