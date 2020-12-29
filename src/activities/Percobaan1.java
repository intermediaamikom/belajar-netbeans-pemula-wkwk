/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activities;

import helpers.OnClick;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anantyan
 */
public class Percobaan1 {
    
    private static PreparedStatement pre_state;
    
    public static void main(String[] args) {
        
        String sql = "INSERT INTO supplier (nama_supplier, alamat, telp, email) "
                + "VALUES (?,?,?,?)";
        try {
            pre_state = OnClick.clickStatement(sql);
            pre_state.setString(1, "PT Permata");
            pre_state.setString(2, "Ajibarang");
            pre_state.setString(3, "0281123456");
            pre_state.setString(4, "asd@gmail.com");
            pre_state.executeUpdate();
            if(pre_state != null) {
                System.out.println("Success insert!");
            } else {
                System.err.print("Failure insert!");
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            try {
                pre_state.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
    }
}
