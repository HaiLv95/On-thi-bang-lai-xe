package testController;

import java.security.interfaces.RSAKey;
import testModel.User;
import java.util.ArrayList;
import java.util.List;
import testConnectSQL.ConnectSQL;
import java.sql.*;
/**
 *
 * @author hai95
 */
public class LoginController {
    public ConnectSQL con = new ConnectSQL();
    public User getUser(ResultSet rs) throws Exception{
        User getUser = new User();
        try {
            getUser.setUser(rs.getString(1));
            getUser.setPass(rs.getString(2));
            getUser.setRoles(rs.getString(3));
        } catch (Exception e) {
            throw new Exception("Failed get user");
        }
        return getUser;
    }
    public User checkUser(String email) throws Exception{
        User user = new User();
        try {
            String sql = "select * from users where email = ?";
            ResultSet rs = con.prepareExcuteQuery(sql, email);
            while (rs.next()) {                
                user = getUser(rs);
            }
        } catch (Exception e) {
            throw new Exception("Failed checkuser");
        }
        return user;
    }
}
