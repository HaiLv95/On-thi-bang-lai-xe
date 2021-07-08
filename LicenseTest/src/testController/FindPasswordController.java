/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testController;
import java.net.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import testConnectSQL.ConnectSQL;

/**
 *
 * @author PC
 */
public class FindPasswordController {
    public ConnectSQL con = new ConnectSQL();
public void send(String email , String pass){
    // đăng nhập gmail
//        Authenticator authenticator = new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication(){
//                String email ="quangvmph12936@fpt.edu.vn";
//                String  password = "quang";
//                return  new PasswordAuthentication(email,password);
//            }
//        };
//    
        String username = "quangvmph12936@fpt.edu.vn";
        String password = "35n135261";
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(username, password);
//                    }
                });
         try {
         Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("quangvmph12936@fpt.edu.vn"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("QLLX send to passwword");
            message.setText(pass);

            Transport.send(message);

            System.out.println("Done");
    } catch (MessagingException e) {
         e.printStackTrace();
    }
}
}
