package testView;

/**
 *
 * @author hai95
 */
public class dgRegister extends java.awt.Dialog {

    /**
     * Creates new form Register
     */
    public dgRegister(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(600, 580);
        setLocationRelativeTo(null);
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
        txtConfirmCode = new javax.swing.JTextField();
        pwPass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pwPassCF = new javax.swing.JPasswordField();
        btnRegister = new javax.swing.JButton();
        lblLinkLogin = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEmail1 = new javax.swing.JTextField();
        btnRegister1 = new javax.swing.JButton();

        setTitle("Register");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đăng ký");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(220, 30, 160, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Email");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(90, 80, 50, 22);

        txtConfirmCode.setBackground(new java.awt.Color(231, 243, 231));
        txtConfirmCode.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtConfirmCode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 243, 231), 4));
        jPanel1.add(txtConfirmCode);
        txtConfirmCode.setBounds(90, 390, 260, 40);

        pwPass.setBackground(new java.awt.Color(231, 243, 231));
        pwPass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 243, 231), 4));
        jPanel1.add(pwPass);
        pwPass.setBounds(90, 200, 420, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Mật khẩu");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(90, 170, 90, 22);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Nhập lại mật khẩu");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(90, 270, 150, 22);

        pwPassCF.setBackground(new java.awt.Color(231, 243, 231));
        pwPassCF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 243, 231), 4));
        jPanel1.add(pwPassCF);
        pwPassCF.setBounds(90, 300, 420, 40);

        btnRegister.setBackground(new java.awt.Color(78, 180, 84));
        btnRegister.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("Nhận mã");
        btnRegister.setActionCommand("Đăng kí");
        btnRegister.setBorderPainted(false);
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegister);
        btnRegister.setBounds(370, 390, 140, 40);

        lblLinkLogin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLinkLogin.setForeground(new java.awt.Color(78, 180, 84));
        lblLinkLogin.setText("Bạn đã có tài khoản?");
        lblLinkLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLinkLoginMouseClicked(evt);
            }
        });
        jPanel1.add(lblLinkLogin);
        lblLinkLogin.setBounds(240, 520, 140, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Mã kích hoạt");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(90, 360, 150, 22);

        txtEmail1.setBackground(new java.awt.Color(231, 243, 231));
        txtEmail1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtEmail1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 243, 231), 4));
        jPanel1.add(txtEmail1);
        txtEmail1.setBounds(90, 110, 420, 40);

        btnRegister1.setBackground(new java.awt.Color(78, 180, 84));
        btnRegister1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegister1.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister1.setText("Đăng ký");
        btnRegister1.setActionCommand("Đăng kí");
        btnRegister1.setBorderPainted(false);
        btnRegister1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegister1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegister1);
        btnRegister1.setBounds(90, 460, 420, 40);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 600, 580);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void lblLinkLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLinkLoginMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblLinkLoginMouseClicked

    private void btnRegister1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegister1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegister1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dgRegister dialog = new dgRegister(new java.awt.Frame(), true);
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
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnRegister1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblLinkLogin;
    private javax.swing.JPasswordField pwPass;
    private javax.swing.JPasswordField pwPassCF;
    private javax.swing.JTextField txtConfirmCode;
    private javax.swing.JTextField txtEmail1;
    // End of variables declaration//GEN-END:variables
}
