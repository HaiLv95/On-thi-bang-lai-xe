package testView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import testController.FindPasswordController;
import testConnectSQL.ConnectSQL;

/**
 *
 * @author hai95
 */
public class dgFindPassword extends java.awt.Dialog {

    static ConnectSQL con = new ConnectSQL();
    FindPasswordController co;
    String ss = "";

    /**
     * Creates new form FindPassword
     */
    public dgFindPassword(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(600, 300);
        setLocationRelativeTo(null);
        lblText.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnSendpw = new javax.swing.JButton();
        lblText = new javax.swing.JLabel();
        btnback = new javax.swing.JButton();

        setTitle("Find Pasword");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setText("Quên mật khẩu");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(190, 30, 210, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Email");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(90, 80, 50, 22);

        txtEmail.setBackground(new java.awt.Color(231, 243, 231));
        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 243, 231), 4));
        jPanel1.add(txtEmail);
        txtEmail.setBounds(90, 110, 420, 40);

        btnSendpw.setBackground(new java.awt.Color(78, 180, 84));
        btnSendpw.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSendpw.setForeground(new java.awt.Color(255, 255, 255));
        btnSendpw.setText("Gửi mật khẩu");
        btnSendpw.setBorderPainted(false);
        btnSendpw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendpwActionPerformed(evt);
            }
        });
        jPanel1.add(btnSendpw);
        btnSendpw.setBounds(90, 180, 230, 40);

        lblText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblText.setForeground(new java.awt.Color(78, 180, 84));
        lblText.setText("Vui lòng check email để nhận mật khẩu");
        jPanel1.add(lblText);
        lblText.setBounds(170, 250, 270, 17);

        btnback.setBackground(new java.awt.Color(255, 118, 89));
        btnback.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnback.setForeground(new java.awt.Color(255, 255, 255));
        btnback.setText("Trở về");
        btnback.setBorderPainted(false);
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        jPanel1.add(btnback);
        btnback.setBounds(380, 180, 130, 40);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 600, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        Run.frLogin();
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btnSendpwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendpwActionPerformed

        findpass();
    }//GEN-LAST:event_btnSendpwActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        Run.frLogin();
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnbackActionPerformed
    public void findpass() {
        try {
            if (check() == false) {
                return;
            } else {
                String mail = txtEmail.getText();
                co = new FindPasswordController();
                co.send(mail);
                lblText.setVisible(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "lỗi sento " + e);
        }
    }

    public boolean check() {

        if (txtEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, " vui lòng nhập email trước");
            txtEmail.requestFocus();
            return false;
        }
        try {
            String sql = "select EMAIL from USERS where EMAIL = ?";
            ResultSet rs = con.prepareExcuteQuery(sql, txtEmail.getText());
            while (rs.next()) {
                ss = rs.getString("EMAIL");
            }
            if (!txtEmail.getText().equalsIgnoreCase(ss)) {
                JOptionPane.showMessageDialog(this, "email của bạn chưa đăng ký tài khoản");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dgFindPassword dialog = new dgFindPassword(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSendpw;
    private javax.swing.JButton btnback;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblText;
    private javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables
}
