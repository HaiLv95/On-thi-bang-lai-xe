package testController;

import java.util.ArrayList;
import java.util.List;
import testConnectSQL.ConnectSQL;
import java.sql.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import testModel.Question;
import testModel.Answer;
import testModel.CauHoi_DeThi;
import testModel.Dethi;
import testModel.LoaiCauHoi;
import testView.Run;

/**
 *
 * @author hai95
 */
public class QuestionController {

    public static ConnectSQL con = new ConnectSQL();

    public List<Question> getListQuestion() throws Exception {
        List<Question> lstQuesstion = new ArrayList<>();
        try {
            String sql = "select * from cauhoi";
            ResultSet rs = con.createStatement(sql);
            while (rs.next()) {
                lstQuesstion.add(getQuestion(rs));
            }

        } catch (Exception e) {
            throw new Exception("Failed 1: get list Question"+e);
            
        }
        return lstQuesstion;
    }

    public Question getQuestion(ResultSet rs) throws Exception {
        Question getQuestion = new Question();
        try {
            getQuestion.setId(rs.getInt(1));
            getQuestion.setNoiDung(rs.getString(2));
            getQuestion.setHinh(rs.getString(3));
            getQuestion.setLoaiCauHoi_id(rs.getInt(4));
        } catch (Exception e) {
            throw new Exception("Failed 2: get Question failed ");
        }
        return getQuestion;
    }

    public Answer getAnswer(ResultSet rs) throws Exception {
        Answer getAnswer = new Answer();
        try {
            getAnswer.setId(rs.getInt(1));
            getAnswer.setNoiDung(rs.getString(2));
            getAnswer.setTrangThai(rs.getBoolean(3));
            getAnswer.setGiaiThich(rs.getString(4));
            getAnswer.setCauhoi_id(rs.getInt(5));
        } catch (Exception e) {
            throw new Exception("Failed 3: get answers failed ");
        }
        return getAnswer;
    }

    public List<Answer> getListAnswers() throws Exception {
        List<Answer> lstAnswers = new ArrayList<>();
        try {
            String sql = "select * from dapan";
            ResultSet rs = con.prepareExcuteQuery(sql);
            while (rs.next()) {
                lstAnswers.add(getAnswer(rs));
            }
        } catch (Exception e) {
            throw new Exception("Failed 4:  get list answer failed ");
        }
        return lstAnswers;
    }
    public List<Answer> getListAnswersbyQuesstionID(int id) throws Exception {
        List<Answer> lstAnswers = new ArrayList<>();
        try {
            String sql = "select * from dapan where id_cauhoi=?";
            ResultSet rs = con.prepareExcuteQuery(sql,id);
            while (rs.next()) {
                lstAnswers.add(getAnswer(rs));
            }
        } catch (Exception e) {
            throw new Exception("Failed 4:  get list answer failed ");
        }
        return lstAnswers;
    }
    // câu hỏi liệt
    public List<Question> getCauLiet(List<Question> listQuestions) {
        List<Question> lstLiet = new ArrayList<>();
        for (Question lstQ : listQuestions) {
            if (lstQ.getLoaiCauHoi_id() == 3) {
                lstLiet.add(lstQ);
            }
        }
        
        return lstLiet;
    }
    
    public List<Answer> getAnswerCauLiet(int id_cauHoi,List<Answer> listAnswers) {
        List<Answer> lstA = new ArrayList<>();    
        for(Answer lst : listAnswers){
            if(lst.getCauhoi_id() == id_cauHoi){
                lstA.add(lst);
            }
        }
        
        return lstA;
    }
    // câu hỏi khái niệm và quy tắc
    public List<Question> getKhaiNiem(List<Question> listQuestions) {
        List<Question> lstKn = new ArrayList<>();
        for (Question lstQ : listQuestions) {
            if (lstQ.getLoaiCauHoi_id() == 1) {
                lstKn.add(lstQ);
            }
        }
        return lstKn;
    }
    public List<Answer> getAnswerKhaiNiem(int id_cauHoi,List<Answer> listAnswers) {
        List<Answer> lstA = new ArrayList<>();    
        for(Answer lst : listAnswers){
            if(lst.getCauhoi_id() == id_cauHoi){
                lstA.add(lst);
            }
        }
        
        return lstA;
    }
    // câu hỏi sa hình
    public List<Question> getSaHinh(List<Question> listQuestions) {
        List<Question> lstSaHinh = new ArrayList<>();
        for (Question lstQ : listQuestions) {
            if (lstQ.getLoaiCauHoi_id() == 2) {
                lstSaHinh.add(lstQ);
            }
        }
        return lstSaHinh;
    }
    public List<Answer> getAnswerSaHinh(int id_cauHoi,List<Answer> listAnswers) {
        List<Answer> lstA = new ArrayList<>();    
        for(Answer lst : listAnswers){
            if(lst.getCauhoi_id() == id_cauHoi){
                lstA.add(lst);
            }
        }
        
        return lstA;
    }

    public void createExam() throws Exception {
        List<CauHoi_DeThi> lstCauHoi_DeThi = new ArrayList<>();
        try {
            String sql = "insert into dethi(trangthai, email, timer, id_loaide) values(?,?,?,?)";
            int idDeThi = con.insertObj(sql, "donot", Run.user.getUser(), 900, 1);
            String sqlInsertQuestion = "insert into CAUHOI_DETHI(id_cauhoi, id_dethi, id_cautraloi,  trangthai) values(?,?,?,?)";
            int row = 0;
            List<Question> lstLiet = getCauLiet(getListQuestion());
            List<Question> lstSaHinh = getSaHinh(getListQuestion());
            List<Question> lstKn = getKhaiNiem(getListQuestion());
            Random r = new Random();
            int a = 0, b = 0, c = 0;
            List<Integer> lst = new ArrayList<>();
            while (lstCauHoi_DeThi.size() < 25) {

                while (a < 2) {
                    boolean kq = true;
                    int x = r.nextInt(lstLiet.size());
                    for (Integer integer : lst) {
                        if (x == integer) {
                            kq = false;
                        }
                    }
                    if (kq) {
                        lst.add(x);
                        CauHoi_DeThi cauHoi_DT = new CauHoi_DeThi();
                        cauHoi_DT.setCauHoi_id(lstLiet.get(x).getId());
                        cauHoi_DT.setCauTraLoi(-1);
                        cauHoi_DT.setDeThi_id(idDeThi);
                        cauHoi_DT.setTrangThai(false);
                        lstCauHoi_DeThi.add(cauHoi_DT);
                        a++;
                    }
                }
                while (b < 12) {
                    boolean kq = true;
                    int x = r.nextInt(lstKn.size());
                    for (Integer integer : lst) {
                        if (x == integer) {
                            kq = false;
                        }
                    }
                    if (kq) {
                        lst.add(x);
                        CauHoi_DeThi cauHoi_DT = new CauHoi_DeThi();
                        cauHoi_DT.setCauHoi_id(lstKn.get(x).getId());
                        cauHoi_DT.setCauTraLoi(-1);
                        cauHoi_DT.setDeThi_id(idDeThi);
                        cauHoi_DT.setTrangThai(false);
                        lstCauHoi_DeThi.add(cauHoi_DT);
                        b++;
                    }
                }
                while (c < 11) {
                    boolean kq = true;
                    int x = r.nextInt(lstSaHinh.size());
                    for (Integer integer : lst) {
                        if (x == integer) {
                            kq = false;
                        }
                    }
                    if (kq) {
                        lst.add(x);
                        CauHoi_DeThi cauHoi_DT = new CauHoi_DeThi();
                        cauHoi_DT.setCauHoi_id(lstSaHinh.get(x).getId());
                        cauHoi_DT.setCauTraLoi(-1);
                        cauHoi_DT.setDeThi_id(idDeThi);
                        cauHoi_DT.setTrangThai(false);
                        lstCauHoi_DeThi.add(cauHoi_DT);
                        c++;
                    }
                }

            }
            for (CauHoi_DeThi cauHoi_DeThi : lstCauHoi_DeThi) {
                row += con.prepareUpdate(sqlInsertQuestion, cauHoi_DeThi.getCauHoi_id(), cauHoi_DeThi.getDeThi_id(), cauHoi_DeThi.getCauTraLoi(), cauHoi_DeThi.isTrangThai());
            }
        } catch (Exception ex) {
            throw new Exception("Failed 5: create Question_Exam failed" + ex);
        }
    }

    public Dethi getDeThi(ResultSet rs) throws Exception {

        Dethi dethi = new Dethi();
        try {
            dethi.setId(rs.getInt(1));
            dethi.setTrangThai(rs.getString(2));
            dethi.setEmail(rs.getString(3));
            dethi.setTimer(rs.getInt(4));
            dethi.setLoaide_id(rs.getInt(5));
        } catch (Exception e) {
            throw new Exception("Failed 6: get Exam failed");
        }
        return dethi;
    }

    public List<Dethi> getListDTbyEmail() throws Exception {
        String sql = "select * from dethi where email=? and id_loaide=1";
        List<Dethi> lstDethi = new ArrayList<>();
        try {
            ResultSet rs = con.prepareExcuteQuery(sql, Run.user.getUser());
            while (rs.next()) {
                lstDethi.add(getDeThi(rs));
            }
        } catch (Exception e) {
            throw new Exception("Failed 7: get list Exam failed ");
        }
        return lstDethi;
    }

    public void getCauHoibyIdDT(int id) throws Exception {
        String sql = "select * from CAUHOI_DETHI where id_dethi=?";
        List<CauHoi_DeThi> lstCauHoi_DeThi = new ArrayList<>();
        try {
            ResultSet rs = con.prepareExcuteQuery(sql, id);
            lstCauHoi_DeThi.add(getCauHoi_DeThi(rs));
        } catch (Exception e) {
            throw new Exception("Failed 8: get list Question_Exam failed");
        }
    }

    public CauHoi_DeThi getCauHoi_DeThi(ResultSet rs) throws Exception {
        CauHoi_DeThi cauHoi = new CauHoi_DeThi();
        try {
            cauHoi.setCauHoi_id(rs.getInt(1));
            cauHoi.setDeThi_id(rs.getInt(2));
            cauHoi.setCauTraLoi(rs.getInt(3));
            cauHoi.setTrangThai(rs.getBoolean(4));
        } catch (Exception e) {
            throw new Exception("Failed 9:  get Question_Exam ");
        }
        return cauHoi;
    }
    public List<CauHoi_DeThi> getCauHoiDTbyDeThiID(int deThi_ID) throws Exception{
        String sqlCauHoi_DeThi = "select * from CAUHOI_DETHI where id_dethi=?";
        List<CauHoi_DeThi> lstCauHoi_DeThi = new ArrayList<>();
        try {
            ResultSet rs = con.prepareExcuteQuery(sqlCauHoi_DeThi, deThi_ID);
            while (rs.next()) {                
                lstCauHoi_DeThi.add(getCauHoi_DeThi(rs));
            }
        } catch (Exception e) {
            throw new Exception("Failed get list Question exam by Exam_id");
        }
        return lstCauHoi_DeThi;
    }
    public int updateExambyID(Dethi dethi) throws Exception{
        String sql = "update dethi set trangthai=?, email=?, timer=?, id_loaide=? where id_dethi=?";
        int row = 0;
        try {
           row  = con.prepareUpdate(sql, dethi.getTrangThai(), Run.user.getUser(), dethi.getTimer(), dethi.getLoaide_id(),dethi.getId());
        } catch (Exception e) {
            throw new Exception("Failed update Exam");
        }
        return row; 
    }
    public int updateQuestionExam(CauHoi_DeThi questionExam) throws Exception{
        String sql = "update CAUHOI_DETHI set id_cautraloi=?, trangthai=? where id_cauhoi=? and id_dethi=?";
        int row = 0;
        try {
           row = con.prepareUpdate(sql, questionExam.getCauTraLoi(), questionExam.isTrangThai(), questionExam.getCauHoi_id(), questionExam.getDeThi_id());
        } catch (Exception e) {
            throw new Exception("Failed update Question Exam");
        }
        return row;
    }
    public List<LoaiCauHoi> getlistLoaiCauHoi() throws Exception{
        String sql = "select * from loaicauhoi";
        List<LoaiCauHoi> lst_loaiCauHoi = new ArrayList<>();
        try {
           ResultSet rs = con.createStatement(sql);
           while(rs.next()){
               lst_loaiCauHoi.add(getQuesstionType(rs));
           }
        } catch (Exception e) {
            throw new Exception("Failed get list question type");
        }
        return lst_loaiCauHoi;
    }
    public LoaiCauHoi getQuesstionType(ResultSet rs) throws Exception{
        LoaiCauHoi questionType = new LoaiCauHoi();
        try {
            questionType.setID(rs.getInt(1));
            questionType.setTenLoai(rs.getString(2));
        } catch (Exception e) {
            throw new Exception("Failed get question type");
        }
        return questionType;
    }
}
