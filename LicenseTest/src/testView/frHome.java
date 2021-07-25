package testView;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JRootPane;

/**
 *
 * @author hai95
 * thêm icon vào 
 */

public class frHome extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public frHome() {
        initComponents();
        setsize();
        
    }
    public void setsize(){
        pnlHome.setSize(1200, 800);
        setLocationRelativeTo(null);
    }

    public void setColor(JButton btn){
        btn.setBackground(new Color(255,32,104));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        pnlHome = new javax.swing.JPanel();
        btnCauHoi = new javax.swing.JButton();
        btnLyThuyet = new javax.swing.JButton();
        btnThi = new javax.swing.JButton();
        btnChangePw = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ôn thi bằng lái xe máy");
        setAlwaysOnTop(true);

        pnlHome.setBackground(new java.awt.Color(255, 255, 255));
        pnlHome.setPreferredSize(new java.awt.Dimension(1200, 800));
        pnlHome.setLayout(null);

        btnCauHoi.setBackground(new java.awt.Color(255, 118, 89));
        btnCauHoi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCauHoi.setForeground(new java.awt.Color(255, 255, 255));
        btnCauHoi.setIcon(new javax.swing.ImageIcon("E:\\5.Fork\\On-thi-bang-lai-xe\\LicenseTest\\src\\Images\\Question_fill.png")); // NOI18N
        btnCauHoi.setText("Bộ câu hỏi");
        btnCauHoi.setBorderPainted(false);
        btnCauHoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCauHoi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCauHoi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCauHoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCauHoiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCauHoiMouseExited(evt);
            }
        });
        btnCauHoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCauHoiActionPerformed(evt);
            }
        });
        pnlHome.add(btnCauHoi);
        btnCauHoi.setBounds(480, 290, 250, 180);

        btnLyThuyet.setBackground(new java.awt.Color(0, 182, 222));
        btnLyThuyet.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLyThuyet.setForeground(new java.awt.Color(255, 255, 255));
        btnLyThuyet.setIcon(new javax.swing.ImageIcon("E:\\5.Fork\\On-thi-bang-lai-xe\\LicenseTest\\src\\Images\\File_dock_fill.png")); // NOI18N
        btnLyThuyet.setText("Học lý thuyết");
        btnLyThuyet.setBorderPainted(false);
        btnLyThuyet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLyThuyet.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLyThuyet.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLyThuyet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLyThuyetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLyThuyetMouseExited(evt);
            }
        });
        btnLyThuyet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLyThuyetActionPerformed(evt);
            }
        });
        pnlHome.add(btnLyThuyet);
        btnLyThuyet.setBounds(120, 110, 230, 180);

        btnThi.setBackground(new java.awt.Color(86, 222, 167));
        btnThi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnThi.setForeground(new java.awt.Color(255, 255, 255));
        btnThi.setIcon(new javax.swing.ImageIcon("E:\\5.Fork\\On-thi-bang-lai-xe\\LicenseTest\\src\\Images\\Desk_alt_fill.png")); // NOI18N
        btnThi.setText("Thi thử");
        btnThi.setBorderPainted(false);
        btnThi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnThiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnThiMouseExited(evt);
            }
        });
        btnThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThiActionPerformed(evt);
            }
        });
        pnlHome.add(btnThi);
        btnThi.setBounds(350, 110, 380, 180);

        btnChangePw.setBackground(new java.awt.Color(248, 205, 54));
        btnChangePw.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnChangePw.setForeground(new java.awt.Color(255, 255, 255));
        btnChangePw.setIcon(new javax.swing.ImageIcon("E:\\5.Fork\\On-thi-bang-lai-xe\\LicenseTest\\src\\Images\\User_fill.png")); // NOI18N
        btnChangePw.setText("Đổi mật khẩu");
        btnChangePw.setBorderPainted(false);
        btnChangePw.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChangePw.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChangePw.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChangePw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnChangePwMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnChangePwMouseExited(evt);
            }
        });
        btnChangePw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePwActionPerformed(evt);
            }
        });
        pnlHome.add(btnChangePw);
        btnChangePw.setBounds(120, 290, 360, 180);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlHome, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlHome, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void btnLyThuyetActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        dgStudy study = new dgStudy(Run.home, true);
        study.setVisible(true);
    }                                           

    private void btnThiActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        dgMenuDT deThi = new dgMenuDT(Run.home, true);
        deThi.setVisible(true);
    }                                      

    private void btnCauHoiActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        dgQuestionList dgList = new dgQuestionList(Run.home, true);
        dgList.setVisible(true);
    }                                         

    private void btnChangePwActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void btnLyThuyetMouseEntered(java.awt.event.MouseEvent evt) {                                         
        // 1
        setColor(btnLyThuyet);
    }                                        

    private void btnLyThuyetMouseExited(java.awt.event.MouseEvent evt) {                                        
        // 2
        btnLyThuyet.setBackground(new Color(0,182,222));
    }                                       

    private void btnThiMouseEntered(java.awt.event.MouseEvent evt) {                                    
        // 1
        setColor(btnThi);
    }                                   

    private void btnThiMouseExited(java.awt.event.MouseEvent evt) {                                   
        // 2
        btnThi.setBackground(new Color(86,222,167));
    }                                  

    private void btnChangePwMouseEntered(java.awt.event.MouseEvent evt) {                                         
        // 1
        setColor(btnChangePw);
    }                                        

    private void btnChangePwMouseExited(java.awt.event.MouseEvent evt) {                                        
        // 2
        btnChangePw.setBackground(new Color(248,205,54));
    }                                       

    private void btnCauHoiMouseEntered(java.awt.event.MouseEvent evt) {                                       
        // 1
        setColor(btnCauHoi);
    }                                      

    private void btnCauHoiMouseExited(java.awt.event.MouseEvent evt) {                                      
        // 2
        btnCauHoi.setBackground(new Color(255,118,89));
    }                                     
    
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnCauHoi;
    private javax.swing.JButton btnChangePw;
    private javax.swing.JButton btnLyThuyet;
    private javax.swing.JButton btnThi;
    private javax.swing.JPanel pnlHome;
    // End of variables declaration                   
}
