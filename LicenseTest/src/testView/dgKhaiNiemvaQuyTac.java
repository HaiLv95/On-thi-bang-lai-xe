package testView;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.List;
import javax.swing.JOptionPane;
import testController.QuestionController;
import testModel.Answer;
import testModel.CauHoi_DeThi;
import testModel.Question;

/**
 *
 * @author Mint
 */
public class dgKhaiNiemvaQuyTac extends javax.swing.JDialog {

    /**
     * Creates new form dgKhaiNiemvaQuyTac
     */
    int index = 0;
    int count = 1;
    static QuestionController quesController = new QuestionController();
    List<CauHoi_DeThi> lst_CHDTKN;
    List<Question> lstQuestions; // question câu hỏi khái niệm
    List<Answer> listKhaiNiemAnswer; // answer câu hỏi khái niệm

    public dgKhaiNiemvaQuyTac(java.awt.Frame parent, boolean modal, List<CauHoi_DeThi> lst_Kn) {
        super(parent, modal);
        initComponents();
        lst_CHDTKN = lst_Kn;
        settingStart();
    }

    //Khai báo
    public void settingStart() {
        setTitle(" câu hỏi Khái niệm và quy tắc");
        setLocationRelativeTo(null);
        loadQuestionbyIndex(0);
        lblCauHoi.setText("Câu hỏi " + count);
        txpGiaiThich.setVisible(false);
        txtMove.setText(null);
    }

    //load dữ liệu câu hỏi theo index của list
    public void loadQuestionbyIndex(int index) {
        try {
            //reset radio khi sang câu hỏi mới
            rdoA.setSelected(false);
            rdoB.setSelected(false);
            rdoC.setSelected(false);
            txpGiaiThich.setVisible(false);
            //lấy list câu hỏi khái niệm
            lstQuestions = quesController.getKhaiNiem(quesController.getListQuestion());
            for (Question lsQuestion : lstQuestions) {
                //nếu id câu hỏi ở trong câu hỏi đề thi = id câu hỏi trong list  câu hỏi
                if (lst_CHDTKN.get(index).getCauHoi_id() == lsQuestion.getId()) {
                    txpCauHoi.setText("Câu " + (index + 1) + ": " + lsQuestion.getNoiDung());
                    //set hình
                    if (lsQuestion.getHinh().length() > 0) {
                        lblHinh.setVisible(true);
                        quesController.setIcon(lblHinh, lsQuestion.getHinh());
                    } else {
                        lblHinh.setVisible(false);
                    }
                    // lấy các đáp án của câu hỏi theo id câu hỏi
                    listKhaiNiemAnswer = quesController.getListAnswersbyQuesstionID(lst_CHDTKN.get(index).getCauHoi_id());
                    //xử lý trường hợp câu hỏi có 2 đáp án hoặc 3 đáp án
                    if (listKhaiNiemAnswer.size() == 2) {
                        txpA.setText(listKhaiNiemAnswer.get(0).getNoiDung());
                        txpB.setText(listKhaiNiemAnswer.get(1).getNoiDung());
                        if (lst_CHDTKN.get(index).getCauTraLoi() == listKhaiNiemAnswer.get(0).getId()) {
                            rdoA.setSelected(true);
                            rdoB.setSelected(false);
                            if (listKhaiNiemAnswer.get(0).isTrangThai()) {
                                txpGiaiThich.setText(listKhaiNiemAnswer.get(0).getGiaiThich());
                                txpGiaiThich.setVisible(true);
                            }
                        } else if (lst_CHDTKN.get(index).getCauTraLoi() == listKhaiNiemAnswer.get(1).getId()) {
                            rdoB.setSelected(true);
                            rdoA.setSelected(false);
                            if (listKhaiNiemAnswer.get(1).isTrangThai()) {
                                txpGiaiThich.setText(listKhaiNiemAnswer.get(1).getGiaiThich());
                                txpGiaiThich.setVisible(true);
                            }
                        }
                        rdoC.setVisible(false);
                        txpC.setVisible(false);
                        jScrollPane2.setVisible(false);
                    } else if (listKhaiNiemAnswer.size() == 3) {
                        rdoC.setVisible(true);
                        txpC.setVisible(true);
                        jScrollPane2.setVisible(true);
                        txpA.setText(listKhaiNiemAnswer.get(0).getNoiDung());
                        txpB.setText(listKhaiNiemAnswer.get(1).getNoiDung());
                        txpC.setText(listKhaiNiemAnswer.get(2).getNoiDung());
                        if (lst_CHDTKN.get(index).getCauTraLoi() == listKhaiNiemAnswer.get(0).getId()) {
                            rdoA.setSelected(true);
                            rdoB.setSelected(false);
                            rdoC.setSelected(false);
                            if (listKhaiNiemAnswer.get(0).isTrangThai()) {
                                txpGiaiThich.setText(listKhaiNiemAnswer.get(0).getGiaiThich());
                                txpGiaiThich.setVisible(true);
                            }
                        } else if (lst_CHDTKN.get(index).getCauTraLoi() == listKhaiNiemAnswer.get(1).getId()) {
                            rdoB.setSelected(true);
                            rdoA.setSelected(false);
                            rdoC.setSelected(false);
                            if (listKhaiNiemAnswer.get(1).isTrangThai()) {
                                txpGiaiThich.setText(listKhaiNiemAnswer.get(1).getGiaiThich());
                                txpGiaiThich.setVisible(true);
                            }
                        } else if (lst_CHDTKN.get(index).getCauTraLoi() == listKhaiNiemAnswer.get(2).getId()) {
                            rdoC.setSelected(true);
                            rdoA.setSelected(false);
                            rdoB.setSelected(false);
                            if (listKhaiNiemAnswer.get(2).isTrangThai()) {
                                txpGiaiThich.setText(listKhaiNiemAnswer.get(2).getGiaiThich());
                                txpGiaiThich.setVisible(true);
                            }
                        }
                    }
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Failed get Answers by QuestionID" + ex);
        }
    }

    // xử lí các button
    public void A() {
        rdoA.setSelected(true);
        rdoB.setSelected(false);
        rdoC.setSelected(false);
        //nếu rdo A đang được chọn và đáp án A là đáp án đúng sẽ hiển thị giải thích
        if (listKhaiNiemAnswer.get(0).isTrangThai() == true) {
            txpGiaiThich.setText(listKhaiNiemAnswer.get(0).getGiaiThich());
            txpGiaiThich.setVisible(true);
        } else {
            txpGiaiThich.setVisible(false);
        }
        // nếu đáp án A đang được chọn sẽ set id câu trả lời cho câu hỏi đề thi là id đáp án A. nếu bỏ chọn câu trả lời = -1
        if (rdoA.isSelected()) {
            lst_CHDTKN.get(index).setCauTraLoi(listKhaiNiemAnswer.get(0).getId());
            lst_CHDTKN.get(index).setTrangThai(listKhaiNiemAnswer.get(0).isTrangThai());
        } else {
            lst_CHDTKN.get(index).setCauTraLoi(-1);
            lst_CHDTKN.get(index).setTrangThai(false);
        }
    }

    public void B() {
        rdoA.setSelected(false);
        rdoB.setSelected(true);
        rdoC.setSelected(false);
        if (listKhaiNiemAnswer.get(1).isTrangThai() == true) {
            txpGiaiThich.setText(listKhaiNiemAnswer.get(1).getGiaiThich());
            txpGiaiThich.setVisible(true);
        } else {
            txpGiaiThich.setVisible(false);
        }
        if (rdoB.isSelected()) {
            lst_CHDTKN.get(index).setCauTraLoi(listKhaiNiemAnswer.get(1).getId());
            lst_CHDTKN.get(index).setTrangThai(listKhaiNiemAnswer.get(1).isTrangThai());
        } else {
            lst_CHDTKN.get(index).setCauTraLoi(-1);
            lst_CHDTKN.get(index).setTrangThai(false);
        }
    }

    public void C() {
        rdoA.setSelected(false);
        rdoB.setSelected(false);
        rdoC.setSelected(true);
        if (listKhaiNiemAnswer.get(2).isTrangThai() == true) {
            txpGiaiThich.setText(listKhaiNiemAnswer.get(2).getGiaiThich());
            txpGiaiThich.setVisible(true);
        } else {
            txpGiaiThich.setVisible(false);
        }
        if (rdoC.isSelected()) {
            lst_CHDTKN.get(index).setCauTraLoi(listKhaiNiemAnswer.get(2).getId());
            lst_CHDTKN.get(index).setTrangThai(listKhaiNiemAnswer.get(2).isTrangThai());
        } else {
            lst_CHDTKN.get(index).setCauTraLoi(-1);
            lst_CHDTKN.get(index).setTrangThai(false);
        }
    }

    public void buttonNext() {
        index++;
        count++;

        if (count > 75) {
            index = 0;
            count = 1;
        }
        loadQuestionbyIndex(index);
//        txpGiaiThich.setVisible(false);
//        rdoA.setSelected(false);
//        rdoB.setSelected(false);
//        rdoC.setSelected(false);
        lblCauHoi.setText("Câu hỏi " + count);
        txtMove.setText(null);
    }

    public void buttonPrev() {
        index--;
        count--;
        if (count < 1) {
            index = lst_CHDTKN.size() - 1;
            count = lst_CHDTKN.size();
        }
        loadQuestionbyIndex(index);
//        txpGiaiThich.setVisible(false);
//        rdoA.setSelected(false);
//        rdoB.setSelected(false);
//        rdoC.setSelected(false);
        lblCauHoi.setText("Câu hỏi " + count);
        txtMove.setText(null);
    }

    public void buttonMove() {
        //set về null hết
//        rdoA.setSelected(false);
//        rdoB.setSelected(false);
//        rdoC.setSelected(false);
//        txpGiaiThich.setVisible(false);
        //kiểm tra điều kiện
        int numberMove = Integer.parseInt(txtMove.getText());
        if (numberMove > lst_CHDTKN.size()) {
            JOptionPane.showMessageDialog(this, "Không tồn tại câu hỏi này");

        } else {
            index = numberMove - 1;
            count = numberMove;
            loadQuestionbyIndex(index);
            lblCauHoi.setText("Câu hỏi " + count);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblCauHoi = new javax.swing.JLabel();
        lblHinh = new javax.swing.JLabel();
        rdoC = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txpC = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        txpCauHoi = new javax.swing.JTextPane();
        rdoA = new javax.swing.JRadioButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txpA = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        txpB = new javax.swing.JTextPane();
        rdoB = new javax.swing.JRadioButton();
        pnlMenuCauHoi = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txpGiaiThich = new javax.swing.JTextPane();
        jPanel4 = new javax.swing.JPanel();
        btnMenu1 = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnMove = new javax.swing.JButton();
        txtMove = new javax.swing.JTextField();
        btnPrev = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(229, 229, 229));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(238, 246, 237));
        jPanel3.setLayout(null);

        lblCauHoi.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblCauHoi.setForeground(new java.awt.Color(58, 180, 84));
        lblCauHoi.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblCauHoiAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel3.add(lblCauHoi);
        lblCauHoi.setBounds(20, 10, 250, 30);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(0, 0, 1000, 50);
        jPanel2.add(lblHinh);
        lblHinh.setBounds(530, 180, 450, 250);

        rdoC.setBackground(new java.awt.Color(255, 255, 255));
        rdoC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rdoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoCActionPerformed(evt);
            }
        });
        jPanel2.add(rdoC);
        rdoC.setBounds(20, 350, 20, 21);

        txpC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240), 4));
        txpC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txpC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txpC.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txpC.setEnabled(false);
        txpC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txpCMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(txpC);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(50, 340, 460, 50);

        txpCauHoi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240), 4));
        txpCauHoi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txpCauHoi.setForeground(new java.awt.Color(255, 255, 255));
        txpCauHoi.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txpCauHoi.setEnabled(false);
        jScrollPane3.setViewportView(txpCauHoi);

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(0, 50, 1000, 110);

        rdoA.setBackground(new java.awt.Color(255, 255, 255));
        rdoA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rdoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoAActionPerformed(evt);
            }
        });
        jPanel2.add(rdoA);
        rdoA.setBounds(20, 210, 20, 21);

        txpA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240), 4));
        txpA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txpA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txpA.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txpA.setEnabled(false);
        txpA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txpAMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(txpA);

        jPanel2.add(jScrollPane4);
        jScrollPane4.setBounds(50, 200, 460, 50);

        txpB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240), 4));
        txpB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txpB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txpB.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txpB.setEnabled(false);
        txpB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txpBMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(txpB);

        jPanel2.add(jScrollPane5);
        jScrollPane5.setBounds(50, 270, 460, 50);

        rdoB.setBackground(new java.awt.Color(255, 255, 255));
        rdoB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rdoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoBActionPerformed(evt);
            }
        });
        jPanel2.add(rdoB);
        rdoB.setBounds(20, 280, 20, 21);

        pnlMenuCauHoi.setBackground(new java.awt.Color(255, 255, 255));

        txpGiaiThich.setEditable(false);
        txpGiaiThich.setBackground(new java.awt.Color(78, 180, 84));
        txpGiaiThich.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(78, 180, 84), 4));
        txpGiaiThich.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txpGiaiThich.setForeground(new java.awt.Color(255, 255, 255));
        txpGiaiThich.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txpGiaiThich.setEnabled(false);
        jScrollPane6.setViewportView(txpGiaiThich);

        javax.swing.GroupLayout pnlMenuCauHoiLayout = new javax.swing.GroupLayout(pnlMenuCauHoi);
        pnlMenuCauHoi.setLayout(pnlMenuCauHoiLayout);
        pnlMenuCauHoiLayout.setHorizontalGroup(
            pnlMenuCauHoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        pnlMenuCauHoiLayout.setVerticalGroup(
            pnlMenuCauHoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel2.add(pnlMenuCauHoi);
        pnlMenuCauHoi.setBounds(0, 440, 1000, 70);

        jPanel4.setBackground(new java.awt.Color(78, 180, 84));
        jPanel4.setLayout(null);

        btnMenu1.setBackground(new java.awt.Color(255, 255, 255));
        btnMenu1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnMenu1.setForeground(new java.awt.Color(78, 180, 84));
        btnMenu1.setText("Menu");
        btnMenu1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(78, 227, 145)));
        btnMenu1.setBorderPainted(false);
        btnMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenu1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnMenu1);
        btnMenu1.setBounds(20, 10, 80, 30);

        btnNext.setBackground(new java.awt.Color(78, 180, 84));
        btnNext.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setText("Câu tiếp theo");
        btnNext.setBorderPainted(false);
        btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnMove.setBackground(new java.awt.Color(78, 180, 84));
        btnMove.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMove.setForeground(new java.awt.Color(255, 255, 255));
        btnMove.setText("Đến Câu");
        btnMove.setBorderPainted(false);
        btnMove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveActionPerformed(evt);
            }
        });
        btnMove.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnMoveKeyPressed(evt);
            }
        });

        txtMove.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMove.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMoveActionPerformed(evt);
            }
        });
        txtMove.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMoveKeyPressed(evt);
            }
        });

        btnPrev.setBackground(new java.awt.Color(78, 180, 84));
        btnPrev.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrev.setForeground(new java.awt.Color(255, 255, 255));
        btnPrev.setText("Câu trước");
        btnPrev.setBorderPainted(false);
        btnPrev.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(274, 274, 274)
                        .addComponent(btnMove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMove, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMove, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMove, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCauHoiAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblCauHoiAncestorAdded

    }//GEN-LAST:event_lblCauHoiAncestorAdded

    private void rdoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoCActionPerformed
        // radio button C
        C();
    }//GEN-LAST:event_rdoCActionPerformed

    private void txpCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txpCMouseClicked
        // TODO add your handling code here:
        C();
    }//GEN-LAST:event_txpCMouseClicked

    private void rdoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoAActionPerformed
        // radio button A
        A();
    }//GEN-LAST:event_rdoAActionPerformed

    private void txpAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txpAMouseClicked
        A();
    }//GEN-LAST:event_txpAMouseClicked

    private void txpBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txpBMouseClicked
        // TODO add your handling code here:
        B();
    }//GEN-LAST:event_txpBMouseClicked

    private void rdoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoBActionPerformed
        // radio button B
        B();
    }//GEN-LAST:event_rdoBActionPerformed

    private void btnMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenu1ActionPerformed
        // mở form câu hỏi liệt và đóng form study
        dispose();
        dgStudy study = new dgStudy(Run.home, true);
        study.setVisible(true);
    }//GEN-LAST:event_btnMenu1ActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // nút tiếp theo
        buttonNext();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnMoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveActionPerformed
        buttonMove();
    }//GEN-LAST:event_btnMoveActionPerformed

    private void btnMoveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnMoveKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMoveKeyPressed

    private void txtMoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMoveActionPerformed

    }//GEN-LAST:event_txtMoveActionPerformed

    private void txtMoveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMoveKeyPressed
        // cài đặt nút enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buttonMove();
        }
    }//GEN-LAST:event_txtMoveKeyPressed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        buttonPrev();
    }//GEN-LAST:event_btnPrevActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenu1;
    private javax.swing.JButton btnMove;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblCauHoi;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JPanel pnlMenuCauHoi;
    private javax.swing.JRadioButton rdoA;
    private javax.swing.JRadioButton rdoB;
    private javax.swing.JRadioButton rdoC;
    private javax.swing.JTextPane txpA;
    private javax.swing.JTextPane txpB;
    private javax.swing.JTextPane txpC;
    private javax.swing.JTextPane txpCauHoi;
    private javax.swing.JTextPane txpGiaiThich;
    private javax.swing.JTextField txtMove;
    // End of variables declaration//GEN-END:variables
}
