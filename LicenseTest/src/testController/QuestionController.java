package testController;

import java.util.ArrayList;
import java.util.List;
import testConnectSQL.ConnectSQL;
import java.sql.*;
import testModel.Question;
import testModel.Answer;

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
            throw new Exception("Failed get list Question");
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
            throw new Exception("get Question failed");
        }
        return getQuestion;
    }
    public Answer getAnswer(ResultSet rs) throws Exception{
        Answer getAnswer = new Answer();
        try {
            getAnswer.setId(rs.getInt(1));
            getAnswer.setNoiDung(rs.getString(2));
            getAnswer.setTrangThai(rs.getBoolean(3));
            getAnswer.setGiaiThich(rs.getString(4));
            getAnswer.setCauhoi_id(rs.getInt(5));
        } catch (Exception e) {
            throw new Exception("failed get answers");
        }
        return getAnswer;
    }
    public List<Answer> getListAnswers() throws Exception{
        List<Answer> lstAnswers = new ArrayList<>();
        try {
            String sql = "select * from dapan";
            ResultSet rs = con.createStatement(sql);
            while (rs.next()) {                
                lstAnswers.add(getAnswer(rs));
            }
        } catch (Exception e) {
            throw new Exception("failed get list answer");
        }
        return lstAnswers;
    }
}
