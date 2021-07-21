/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testController;

import java.util.ArrayList;
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

/**
 *
 * @author PC
 */
public class AddController {

    public ConnectSQL con = new ConnectSQL();

    public void sendmail(String email,String code) {
        final String fromemail = "quangvmph12936@fpt.edu.vn";
        final String frompassemail = "vuminhquang";
     
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        try {
            Authenticator auth = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromemail, frompassemail);
                }
            };
            Session s = Session.getDefaultInstance(prop, auth);
            Message message = new MimeMessage(s);
            message.setFrom(new InternetAddress("quangvmph12936@fpt.edu.vn"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("QLLX send to code");  
            message.setText("code siêu vip: " + code);
            Transport.send(message);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "lỗi send" + e);
        }
    }

    public void adduser(String EMAIL, String PASS) {
        try {
            String ROLES = "USER";
            String sql = "insert into users (EMAIL,PASS,ROLES) values(?,?,?)";
            int row = con.prepareUpdate(sql, EMAIL, PASS, ROLES);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
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

}
