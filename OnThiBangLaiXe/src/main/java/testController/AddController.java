/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testController;

import java.util.ArrayList;
import java.util.List;
import testModel.User;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import testConnectSQL.ConnectSQL;
import java.sql.ResultSet;

/**
 *
 * @author PC
 */
public class AddController {

    public ConnectSQL con = new ConnectSQL();

    public void sendmail(String email, String code) throws Exception {
        final String username = "hai95.lv@gmail.com";
        final String password = "Quangtan2017";
        try {
            Properties prop = new Properties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true");
            Session session = Session.getInstance(prop, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("QLLX send to code","utf-8");
            message.setText("code siêu vip: " + code, "utf-8", "html");
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Lỗi gửi mail");
        }
    }

    public int adduser(String EMAIL, String PASS) throws Exception {
    	int row =0;
        try {
            String ROLES = "USER";
            String sql = "insert into users (EMAIL,PASS,ROLES) values(?,?,?)";
           row = con.prepareUpdate(sql, EMAIL, PASS, ROLES);
        } catch (Exception e) {
            throw new Exception();
        }
        return row;
    }

    public String getcode() {
        int index = 0;
        String code = "";
        Random r = new Random();
        while (index < 6) {
            int x = r.nextInt(10);	
            code += x;
            index++;
        }
        return code;
    }

    public List<User> getlistuser() {
        List<User> lstUser = new ArrayList<>();
        try {
            String sql = "select * from USERS";
            ResultSet rs = con.createStatement(sql);
            while (rs.next()) {
                //lấy thông tin từ csdl gán vào user 
                User user = new User();
                user.setUser(rs.getString(1));
                user.setPass(rs.getString(2));
                user.setRoles(rs.getString(3));
                // thêm đối tượng vào list
                lstUser.add(user);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return lstUser;
    }
}
