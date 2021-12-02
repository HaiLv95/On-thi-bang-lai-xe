/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testController;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import testConnectSQL.ConnectSQL;
import java.sql.*;

/**
 *
 * @author PC
 */
public class FindPasswordController {
    public ConnectSQL con = new ConnectSQL();
public void send(String email) throws SQLException{
        String pass = null;
       final   String fromemail = "quangvmph12936@fpt.edu.vn";
       final String frompasswordemail ="vuminhquang";
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); 
        
         try {
             Authenticator auth = new Authenticator() {
                 @Override
                 protected PasswordAuthentication getPasswordAuthentication(){
                     return  new PasswordAuthentication(fromemail,frompasswordemail);
                 }
             };
             Session s = Session.getDefaultInstance(prop,auth);
            Message message = new MimeMessage(s);
            message.setFrom(new InternetAddress("quangvmph12936@fpt.edu.vn"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("QLLX send to passwword");
            String sql = "select PASS from USERS where EMAIL = ? ";
            ResultSet rs = con.prepareExcuteQuery(sql, email );
            while(rs.next()){
                pass = rs.getString("PASS");
            }
            message.setText("password của bạn là: " + pass);
            Transport.send(message);
    } catch (MessagingException e) {
             JOptionPane.showMessageDialog(null, "lỗi send"+e);
    }
}
}
