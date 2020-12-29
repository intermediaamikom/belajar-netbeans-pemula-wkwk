/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import utils.Koneksi;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author anantyan
 */
public class OnClick {
    
    private static PreparedStatement pre_state;
    
    public static PreparedStatement clickStatement(String sql) {
        try {
            pre_state = Koneksi.connDB().prepareStatement(sql);
        } catch (SQLException e) {
            pre_state = null;
            System.err.println(e.getMessage());
        }
        
        return pre_state;
    }
}
