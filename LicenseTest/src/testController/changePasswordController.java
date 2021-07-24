/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testController;
import javax.swing.JOptionPane;
import testConnectSQL.ConnectSQL;
/**
 *
 * @author PC
 */
public class changePasswordController {
    public ConnectSQL con = new ConnectSQL();
    public void changePassword(String pass, String email){
        
        try {
        String sql = "update USERS set PASS = ? WHERE EMAIL =?";
        int row = con.prepareUpdate(sql,pass,email );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
