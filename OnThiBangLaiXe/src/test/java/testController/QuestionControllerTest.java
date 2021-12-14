package testController;

import org.testng.annotations.Test;

import com.mockrunner.mock.jdbc.MockConnection;
import com.mockrunner.mock.jdbc.MockPreparedStatement;
import com.mockrunner.mock.jdbc.MockResultSet;
import com.mockrunner.mock.jdbc.MockStatement;

import testConnectSQL.ConnectSQL;
import testModel.Answer;
import testModel.CauHoi_DeThi;
import testModel.Dethi;
import testModel.LoaiCauHoi;
import testModel.Question;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.ObjectFactory;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import org.mockito.ArgumentMatchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.testng.IObjectFactory;
import org.testng.annotations.AfterMethod;

@PrepareForTest({ QuestionController.class, ConnectSQL.class })
public class QuestionControllerTest {
	QuestionController qCon;
	QuestionController qConSpy;
	MockConnection mockConnection;
	MockStatement mockStatement;
	MockPreparedStatement mockPreparedStatement;

	@BeforeMethod
	public void beforeMethod() {
		qCon = new QuestionController();
		qConSpy = PowerMockito.spy(new QuestionController());
		PowerMockito.mockStatic(ConnectSQL.class);
		mockConnection = PowerMockito.mock(MockConnection.class);
		mockStatement = PowerMockito.mock(MockStatement.class);
		mockPreparedStatement = PowerMockito.mock(MockPreparedStatement.class);
	}

	@ObjectFactory
	public IObjectFactory getIObjectFactory() {
		return new org.powermock.modules.testng.PowerMockObjectFactory();
	}

	@AfterMethod
	public void afterMethod() {
	}

	@Test(expectedExceptions = Exception.class)
	public void createExamTest_TC01_Failed() throws Exception {
		Dethi dethi = new Dethi();
		QuestionController questionController = new QuestionController();
		questionController.createExam(dethi);

	}
//Hàm chồng không biết test
//	@Test
//	public void createExamTest_TC02_Success() throws Exception {
//		Dethi dethi = new Dethi();
//		dethi.setTrangThai("pass");
//		dethi.setEmail("HAILVPH13040@FPT.EDU.VN");
//		dethi.setTimer(600);
//		dethi.setLoaide_id(1);
//		QuestionController questionController = new QuestionController();
//		questionController.createExam(dethi);
//
//	}

	@Test(expectedExceptions = Exception.class)
	public void createExamTest_TC03_Failed() throws Exception {
		Dethi dethi = new Dethi();
		dethi.setTrangThai("pass");
		dethi.setTimer(600);
		dethi.setLoaide_id(1);
		QuestionController questionController = new QuestionController();
		questionController.createExam(dethi);

	}

	@Test(expectedExceptions = Exception.class)
	public void createExamTest_TC04_Failed() throws Exception {
		Dethi dethi = new Dethi();
		dethi.setEmail("HAILVPH13040@FPT.EDU.VN");
		dethi.setTimer(600);
		dethi.setLoaide_id(1);
		QuestionController questionController = new QuestionController();
		questionController.createExam(dethi);

	}

	@Test
	public void deleteQuestionTest_TC05_Success() throws Exception {
		int id = 2;
		QuestionController questionController = new QuestionController();
		int row = 1;
		PowerMockito.when(ConnectSQL.prepareUpdate(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt()))
				.thenReturn(row);
		row = qConSpy.deleteQuestion(id);
		assertEquals(row, 1);
	}

	@Test
	public void deleteQuestionTest_TC06_Failed() throws Exception {
		int id = -1;
		QuestionController questionController = new QuestionController();
		int row = questionController.deleteQuestion(id);
		assertEquals(row, 0);
	}

	@Test
	public void deleteQuestionTest_TC07_Failed() throws Exception {
		int id = 1111111;
		QuestionController questionController = new QuestionController();
		int row = questionController.deleteQuestion(id);
		assertEquals(row, 0);
	}

//	@Test
//	public void getAnswerTest_TC08_Failed() throws Exception {
//		MockResultSet mockResultSetNew = new MockResultSet("getAnswer");
//		mockResultSetNew.addColumn("ID", new Integer[] { 1 });
//		mockResultSetNew.addColumn("Noidung", new String[] { "câu hỏi 1" });
//		mockResultSetNew.addColumn("trangthai", new Boolean[] { true });
//		mockResultSetNew.addColumn("giaithich", new String[] { "Biển báo giao thông" });
//		mockResultSetNew.addColumn("cauhoi_id", new Integer[] { 2 });
//		mockResultSetNew.addColumn("flag", new Boolean[] {true});
//		mockResultSetNew.afterLast();
//		PowerMockito.when(ConnectSQL.prepareExcuteQuery(ArgumentMatchers.anyString())).thenReturn(mockResultSetNew);
//		Answer answer = qConSpy.getAnswer(mockResultSetNew);
//	}

	@Test
	public void getAnswerCauLietTest_TC09_Success() {
		List<Answer> lstAnswer = new ArrayList<>();
		lstAnswer.add(new Answer(1, 2, "Biển báo", "giải thích", true, true));
		assertEquals(qCon.getAnswerCauLiet(1, lstAnswer).size(), 0);
	}

	@Test
	public void getAnswerCauLietTest_T10_Success() {
		List<Answer> lstAnswer = new ArrayList<>();
		lstAnswer.add(new Answer(1, 2, "Biển báo", "giải thích", true, true));
		assertEquals(qCon.getAnswerCauLiet(2, lstAnswer).size(), 1);
	}

	@Test
	public void getAnswerCauLietTest_TC11_Success() {
		List<Answer> lstAnswer = new ArrayList<>();
		lstAnswer.add(new Answer(1, 2, "Biển báo", "giải thích", true, true));
		lstAnswer.add(new Answer(2, 3, "Biển báo", "giải thích", true, true));
		assertEquals(qCon.getAnswerCauLiet(2, lstAnswer).size(), 1);
	}

	@Test
	public void getAnswerKhaiNiemTest_TC12_Success() {
		List<Answer> lstAnswer = new ArrayList<>();
		lstAnswer.add(new Answer(1, 2, "Biển báo", "giải thích", true, true));
		lstAnswer.add(new Answer(2, 3, "Biển báo", "giải thích", true, true));
		assertEquals(qCon.getAnswerKhaiNiem(2, lstAnswer).size(), 1);
	}

	@Test
	public void getAnswerKhaiNiemTest_TC13_Success() {
		List<Answer> lstAnswer = new ArrayList<>();
		lstAnswer.add(new Answer(1, 2, "Biển báo", "giải thích", true, true));
		assertEquals(qCon.getAnswerKhaiNiem(2, lstAnswer).size(), 1);
	}

	@Test
	public void getAnswerKhaiNiemTest_TC14_Success() {
		List<Answer> lstAnswer = new ArrayList<>();
		lstAnswer.add(new Answer(1, 2, "Biển báo", "giải thích", true, true));
		assertEquals(qCon.getAnswerCauLiet(1, lstAnswer).size(), 0);
	}

	@Test
	public void getAnswerSaHinhTest_TC15_Success() {
		List<Answer> lstAnswer = new ArrayList<>();
		lstAnswer.add(new Answer(1, 2, "Biển báo", "giải thích", true, true));
		lstAnswer.add(new Answer(2, 3, "Biển báo", "giải thích", true, true));
		assertEquals(qCon.getAnswerSaHinh(2, lstAnswer).size(), 1);
	}

	@Test
	public void getAnswerSaHinhTest_TC16_Success() {
		List<Answer> lstAnswer = new ArrayList<>();
		lstAnswer.add(new Answer(1, 2, "Biển báo", "giải thích", true, true));
		assertEquals(qCon.getAnswerSaHinh(2, lstAnswer).size(), 1);
	}

	@Test
	public void getAnswerSaHinhTest_TC17_Success() {
		List<Answer> lstAnswer = new ArrayList<>();
		lstAnswer.add(new Answer(1, 2, "Biển báo", "giải thích", true, true));
		assertEquals(qCon.getAnswerSaHinh(1, lstAnswer).size(), 0);
	}

	@Test
	public void getCauHoiDTbyDeThiIDTest_TC18_NoResult() throws Exception {
		MockResultSet rs = new MockResultSet("getCauHoiDTbyDeThiIDTest");
		PowerMockito.when(ConnectSQL.prepareExcuteQuery(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt()))
				.thenReturn(rs);
		List lst = qConSpy.getCauHoiDTbyDeThiID(1);
		assertEquals(lst.size(), 0);
	}

	@Test
	public void getCauHoiDTbyDeThiIDTest_TC19_Success() throws Exception {
		MockResultSet rs = new MockResultSet("getCauHoiDTbyDeThiIDTest");
		rs.addColumn(new Integer[] { 1, 2 });
		rs.addColumn(new Integer[] { 2, 2 });
		rs.addColumn(new Integer[] { 1, 2 });
		rs.addColumn(new Boolean[] { true, true });
		PowerMockito.when(ConnectSQL.prepareExcuteQuery(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt()))
				.thenReturn(rs);
		List lst = qCon.getCauHoiDTbyDeThiID(1);
		assertEquals(lst.size(), 2);
	}

	@Test(expectedExceptions = Exception.class)
	public void getCauHoiDTbyDeThiIDTest_TC20_NoResult() throws Exception {
		MockResultSet rs = new MockResultSet("getCauHoiDTbyDeThiIDTest");
		PowerMockito
				.when(qConSpy, ConnectSQL.prepareExcuteQuery(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt()))
				.thenReturn(rs);
		List lst = qCon.getCauHoiDTbyDeThiID(2);
	}

	@Test
	public void getCauLietTest_TC21_Success() {
		List<Question> list = new ArrayList<>();
		list.add(new Question(1, 2, "Câu 1", "abc.jpg", true));
		list.add(new Question(2, 3, "Câu 2", "abc.jpg", true));
		list.add(new Question(3, 3, "Câu 3", "abc.jpg", true));
		list.add(new Question(4, 1, "Câu 4", "abc.jpg", true));
		list.add(new Question(5, 2, "Câu 5", "abc.jpg", true));
		List<Question> listCaauLiet = qCon.getCauLiet(list);
		assertEquals(listCaauLiet.size(), 2);
	}

	@Test
	public void getCauLietTest_TC22_ListEmty() {
		List<Question> list = new ArrayList<>();
		List<Question> listCaauLiet = qCon.getCauLiet(list);
		assertEquals(listCaauLiet.size(), 0);
	}

	@Test
	public void getCauLietTest_TC23_NoReult() {
		List<Question> list = new ArrayList<>();
		list.add(new Question(1, 2, "Câu 1", "abc.jpg", true));
		list.add(new Question(2, 2, "Câu 2", "abc.jpg", true));
		list.add(new Question(3, 2, "Câu 3", "abc.jpg", true));
		list.add(new Question(4, 1, "Câu 4", "abc.jpg", true));
		list.add(new Question(5, 2, "Câu 5", "abc.jpg", true));
		List<Question> listCaauLiet = qCon.getCauLiet(list);
		assertEquals(listCaauLiet.size(), 0);
	}

//	@Test
//	public void getDeThiTest() {
//		
//	}

	@Test
	public void getKhaiNiemTest_TC24_Success() {
		List<Question> list = new ArrayList<>();
		list.add(new Question(1, 2, "Câu 1", "abc.jpg", true));
		list.add(new Question(2, 2, "Câu 2", "abc.jpg", true));
		list.add(new Question(3, 2, "Câu 3", "abc.jpg", true));
		list.add(new Question(4, 1, "Câu 4", "abc.jpg", true));
		list.add(new Question(5, 2, "Câu 5", "abc.jpg", true));
		List<Question> listCaauLiet = qCon.getKhaiNiem(list);
		assertEquals(listCaauLiet.size(), 1);
	}

	@Test
	public void getKhaiNiemTest_TC25_NoResult() {
		List<Question> list = new ArrayList<>();
		list.add(new Question(1, 2, "Câu 1", "abc.jpg", true));
		list.add(new Question(2, 2, "Câu 2", "abc.jpg", true));
		list.add(new Question(3, 2, "Câu 3", "abc.jpg", true));
		list.add(new Question(4, 3, "Câu 4", "abc.jpg", true));
		list.add(new Question(5, 2, "Câu 5", "abc.jpg", true));
		List<Question> listCaauLiet = qCon.getKhaiNiem(list);
		assertEquals(listCaauLiet.size(), 0);
	}

	@Test
	public void getListAllDTbyEmailTest_TC26_Success() throws Exception {
		MockResultSet rs = new MockResultSet("getDeThiByEmail");
		rs.addColumn("ID", new Integer[] { 1 });
		rs.addColumn("trangthai", new String[] { "pass" });
		rs.addColumn("trangthai", new String[] { "hailvph13040@fpt.edu.vn" });
		rs.addColumn("timer", new Integer[] { 100 });
		rs.addColumn("loaide_id", new Integer[] { 1 });
		rs.beforeFirst();
		PowerMockito.when(ConnectSQL.prepareExcuteQuery(ArgumentMatchers.anyString(), ArgumentMatchers.anyString()))
				.thenReturn(rs);
		List lst = qConSpy.getListAllDTbyEmail("hailvph13040@fpt.edu.vn");
		assertEquals(lst.size(), 1);
	}

	@Test
	public void getListAllDTbyEmailTest_TC27_Success() throws Exception {
		MockResultSet rs = new MockResultSet("getDeThiByEmail");
		rs.addColumn("ID", new Integer[] { 1, 2 });
		rs.addColumn("trangthai", new String[] { "pass", "Failed" });
		rs.addColumn("trangthai", new String[] { "hailvph13040@fpt.edu.vn", "hailvph13040@fpt.edu.vn" });
		rs.addColumn("timer", new Integer[] { 100, 300 });
		rs.addColumn("loaide_id", new Integer[] { 1, 1 });
		rs.beforeFirst();
		PowerMockito.when(ConnectSQL.prepareExcuteQuery(ArgumentMatchers.anyString(), ArgumentMatchers.anyString()))
				.thenReturn(rs);
		List lst = qConSpy.getListAllDTbyEmail("hailvph13040@fpt.edu.vn");
		assertEquals(lst.size(), 2);
	}

	@Test
	public void getListAllDTbyEmailTest_TC28_NoResult() throws Exception {
		MockResultSet rs = new MockResultSet("getDeThiByEmail");
		PowerMockito.when(ConnectSQL.prepareExcuteQuery(ArgumentMatchers.anyString(), ArgumentMatchers.anyString()))
				.thenReturn(rs);
		List lst = qConSpy.getListAllDTbyEmail("hailvph13040@fpt.edu.vn");
		assertEquals(lst.size(), 0);
	}

	@Test
	public void getListAnswersTest_TC29_Success() throws Exception {
		MockResultSet mockResultSetNew = new MockResultSet("getAnswer");
		mockResultSetNew.addColumn("ID", new Integer[] { 1 });
		mockResultSetNew.addColumn("Noidung", new String[] { "câu hỏi 1" });
		mockResultSetNew.addColumn("trangthai", new Boolean[] { true });
		mockResultSetNew.addColumn("giaithich", new String[] { "Biển báo giao thông" });
		mockResultSetNew.addColumn("cauhoi_id", new Integer[] { 2 });
		mockResultSetNew.addColumn("flag", new Boolean[] { true });
		mockResultSetNew.beforeFirst();
		PowerMockito.when(ConnectSQL.prepareExcuteQuery(ArgumentMatchers.anyString())).thenReturn(mockResultSetNew);
		List lstAnswer = qConSpy.getListAnswers();
		assertEquals(lstAnswer.size(), 1);
	}

	@Test
	public void getListAnswersTest_TC30_Success() throws Exception {
		MockResultSet mockResultSetNew = new MockResultSet("getAnswer");
		mockResultSetNew.addColumn("ID", new Integer[] { 1, 2 });
		mockResultSetNew.addColumn("Noidung", new String[] { "câu hỏi 1", "câu hỏi 2" });
		mockResultSetNew.addColumn("trangthai", new Boolean[] { true, false });
		mockResultSetNew.addColumn("giaithich", new String[] { "Biển báo giao thông", "Biển báo giao thông" });
		mockResultSetNew.addColumn("cauhoi_id", new Integer[] { 2, 3 });
		mockResultSetNew.addColumn("flag", new Boolean[] { true });
		mockResultSetNew.beforeFirst();
		PowerMockito.when(ConnectSQL.prepareExcuteQuery(ArgumentMatchers.anyString())).thenReturn(mockResultSetNew);
		List lstAnswer = qConSpy.getListAnswers();
		assertEquals(lstAnswer.size(), 2);
	}

	@Test
	public void getListAnswersTest_TC31_NoResult() throws Exception {
		MockResultSet mockResultSetNew = new MockResultSet("getAnswer");
		PowerMockito.when(ConnectSQL.prepareExcuteQuery(ArgumentMatchers.anyString())).thenReturn(mockResultSetNew);
		List lstAnswer = qConSpy.getListAnswers();
		assertEquals(lstAnswer.size(), 0);
	}

	@Test
	public void getListAnswersbyQuesstionIDTest_TC32_Success() throws Exception {
		MockResultSet mockResultSetNew = new MockResultSet("getAnswer");
		mockResultSetNew.addColumn("ID", new Integer[] { 1, 2 });
		mockResultSetNew.addColumn("Noidung", new String[] { "câu hỏi 1", "câu hỏi 2" });
		mockResultSetNew.addColumn("trangthai", new Boolean[] { true, false });
		mockResultSetNew.addColumn("giaithich", new String[] { "Biển báo giao thông", "Biển báo giao thông" });
		mockResultSetNew.addColumn("cauhoi_id", new Integer[] { 2, 3 });
		mockResultSetNew.addColumn("flag", new Boolean[] { true, true });
		mockResultSetNew.beforeFirst();
		PowerMockito.when(ConnectSQL.prepareExcuteQuery(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt()))
				.thenReturn(mockResultSetNew);
		List lstAnswer = qConSpy.getListAnswersbyQuesstionID(2);
		assertEquals(lstAnswer.size(), 2);
	}

	@Test
	public void getListAnswersbyQuesstionIDTest_TC33_Success() throws Exception {
		MockResultSet mockResultSetNew = new MockResultSet("getAnswer");
		mockResultSetNew.addColumn("ID", new Integer[] { 1 });
		mockResultSetNew.addColumn("Noidung", new String[] { "câu hỏi 1" });
		mockResultSetNew.addColumn("trangthai", new Boolean[] { true });
		mockResultSetNew.addColumn("giaithich", new String[] { "Biển báo giao thông" });
		mockResultSetNew.addColumn("cauhoi_id", new Integer[] { 2 });
		mockResultSetNew.addColumn("flag", new Boolean[] { true });
		mockResultSetNew.beforeFirst();
		PowerMockito.when(ConnectSQL.prepareExcuteQuery(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt()))
				.thenReturn(mockResultSetNew);
		List lstAnswer = qConSpy.getListAnswersbyQuesstionID(2);
		assertEquals(lstAnswer.size(), 1);
	}

	@Test
	public void getListAnswersbyQuesstionIDTest_TC34_NoResult() throws Exception {
		MockResultSet mockResultSetNew = new MockResultSet("getAnswer");
		PowerMockito.when(ConnectSQL.prepareExcuteQuery(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt()))
				.thenReturn(mockResultSetNew);
		List lstAnswer = qConSpy.getListAnswersbyQuesstionID(2);
		assertEquals(lstAnswer.size(), 0);
	}

//	@Test
//	public void getListDTbyEmailTest_TC35_Success() throws SQLException {
//		MockResultSet rs = new MockResultSet("getDeThiByEmail");
//		rs.addColumn("ID", new Integer[] {1, 2});
//		rs.addColumn("trangthai", new String[] {"pass", "Failed"});
//		rs.addColumn("email", new String[] {"hailvph13040@fpt.edu.vn","hailvph13040@fpt.edu.vn"});
//		rs.addColumn("timer", new Integer[] {100, 300});
//		rs.addColumn("loaide_id", new Integer[] {1,1});
//		rs.beforeFirst();
//		PowerMockito.when(ConnectSQL.prepareExcuteQuery(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt())).thenReturn(rs);
//		List list = qConSpy.getListDTbyEmail(1, "hailvph13040@fpt.edu.vn");
//		assertEquals(list.size(), 2);
//	}
//	@Test
//	public void getListDTbyEmailTest_TC36_Success() throws SQLException {
//		MockResultSet rs = new MockResultSet("getDeThiByEmail");
//		rs.addColumn("ID", new Integer[] {1});
//		rs.addColumn("trangthai", new String[] {"pass"});
//		rs.addColumn("email", new String[] {"hailvph13040@fpt.edu.vn"});
//		rs.addColumn("timer", new Integer[] {100});
//		rs.addColumn("loaide_id", new Integer[] {1});
//		rs.beforeFirst();
//		PowerMockito.when(ConnectSQL.prepareExcuteQuery(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt())).thenReturn(rs);
//		List list = qConSpy.getListDTbyEmail(1, "hailvph13040@fpt.edu.vn");
//		assertEquals(list,1);
//	}
//	@Test
//	public void getListDTbyEmailTest_TC37_NoResult() throws SQLException {
//		MockResultSet rs = new MockResultSet("getDeThiByEmail");
//		PowerMockito.when(ConnectSQL.prepareExcuteQuery(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt())).thenReturn(rs);
//		List list = qConSpy.getListDTbyEmail(1, "hailvph13040@fpt.edu.vn");
//		assertEquals(list,0);
//	}

	@Test
	public void getListQuestionTest_TC38_Success() throws Exception {
		MockResultSet rs = new MockResultSet("getListQuestion");
		rs.addColumn("ID", new Integer[] { 1 });
		rs.addColumn("noidung", new String[] { "Luat giao thong" });
		rs.addColumn("hinh", new String[] { "hinh.jpg" });
		rs.addColumn("loaicauhoi_id", new Integer[] { 1 });
		rs.addColumn("trangthai", new Boolean[] { true });
		rs.beforeFirst();
		PowerMockito.when(ConnectSQL.createStatement(ArgumentMatchers.anyString())).thenReturn(rs);
		List list = qConSpy.getListQuestion();
		assertEquals(list.size(), 1);
	}

	@Test
	public void getListQuestionTest_TC39_Success() throws Exception {
		MockResultSet rs = new MockResultSet("getListQuestion");
		rs.addColumn("ID", new Integer[] { 1, 2 });
		rs.addColumn("noidung", new String[] { "Luat giao thong", "Luat giao thong" });
		rs.addColumn("hinh", new String[] { "hinh.jpg", "hinh.jpg" });
		rs.addColumn("loaicauhoi_id", new Integer[] { 1, 1 });
		rs.addColumn("trangthai", new Boolean[] { true, true });
		rs.beforeFirst();
		PowerMockito.when(ConnectSQL.createStatement(ArgumentMatchers.anyString())).thenReturn(rs);
		List list = qConSpy.getListQuestion();
		assertEquals(list.size(), 2);
	}

	@Test
	public void getListQuestionTest_TC40_NoResult() throws Exception {
		MockResultSet rs = new MockResultSet("getListQuestion");
		rs.beforeFirst();
		PowerMockito.when(ConnectSQL.createStatement(ArgumentMatchers.anyString())).thenReturn(rs);
		List list = qConSpy.getListQuestion();
		assertEquals(list.size(), 0);
	}

	@Test
	public void getSaHinhTest_TC41_Success() {
		List<Question> listQ = new ArrayList<>();
		listQ.add(new Question(1, 1, "Cau hoi 1", "Hinh1.jpg", true));
		listQ.add(new Question(2, 2, "Cau hoi 2", "Hinh2.jpg", true));
		listQ.add(new Question(3, 1, "Cau hoi 3", "Hinh3.jpg", true));
		assertEquals(qConSpy.getSaHinh(listQ).size(), 1);
	}

	@Test
	public void getSaHinhTest_TC42_Success() {
		List<Question> listQ = new ArrayList<>();
		listQ.add(new Question(1, 1, "Cau hoi 1", "Hinh1.jpg", true));
		listQ.add(new Question(2, 2, "Cau hoi 2", "Hinh2.jpg", true));
		listQ.add(new Question(3, 2, "Cau hoi 3", "Hinh3.jpg", true));
		assertEquals(qConSpy.getSaHinh(listQ).size(), 2);
	}

	@Test
	public void getSaHinhTest_TC43_NoResult() {
		List<Question> listQ = new ArrayList<>();
		assertEquals(qConSpy.getSaHinh(listQ).size(), 0);
	}

	@Test
	public void getlistLoaiCauHoiTest_TC43_NoResult() throws Exception {
		MockResultSet rs = new MockResultSet("getListLoaiCauHoi");
		PowerMockito.when(ConnectSQL.createStatement(ArgumentMatchers.anyString())).thenReturn(rs);
		List listResult = qConSpy.getlistLoaiCauHoi();
		assertEquals(listResult.size(), 0);
	}

	@Test
	public void getlistLoaiCauHoiTest_TC44_Success() throws Exception {
		MockResultSet rs = new MockResultSet("getListLoaiCauHoi");
		rs.addColumn("ID", new Integer[] { 1 });
		rs.addColumn("TenLoai", new String[] { "Sa Hinh" });
		PowerMockito.when(ConnectSQL.createStatement(ArgumentMatchers.anyString())).thenReturn(rs);
		List listResult = qConSpy.getlistLoaiCauHoi();
		assertEquals(listResult.size(), 1);
	}

	@Test
	public void getlistLoaiCauHoiTest_TC45_Success() throws Exception {
		MockResultSet rs = new MockResultSet("getListLoaiCauHoi");
		rs.addColumn("ID", new Integer[] { 1, 2 });
		rs.addColumn("TenLoai", new String[] { "Sa Hinh", "Cau Liet" });
		PowerMockito.when(ConnectSQL.createStatement(ArgumentMatchers.anyString())).thenReturn(rs);
		List listResult = qConSpy.getlistLoaiCauHoi();
		assertEquals(listResult.size(), 2);
	}

	@Test
	public void insertDapAnTest_TC46_NullParam() throws Exception {
		Answer answer = new Answer();
		int row = qConSpy.insertDapAn(answer);
		assertEquals(row, 0);
	}

	@Test
	public void insertDapAnTest_TC47_NullGiaiThich() throws Exception {
		Answer answer = new Answer(1, 2, "Duong danh cho nguoi di bo", null, false, true);
		qCon.insertDapAn(answer);
	}

	@Test
	public void insertDapAnTest_TC48_NullNoiDung() throws Exception {
		Answer answer = new Answer(1, 2, null, "dap an dung", false, true);
		int row = qConSpy.insertDapAn(answer);
		assertEquals(row, 0);
	}
	@Test(expectedExceptions = Exception.class)
	public void insertDapAnTest_TC48_NullParam() throws Exception {
		Answer answer = null;
		qConSpy.insertDapAn(answer);
	}

	@Test
	public void insertDapAnTest_TC49_Success() throws Exception {
		MockResultSet rs = new MockResultSet("insert Answer");
		int row = 1;
		Answer answer = new Answer(1, 2, "Duong danh cho nguoi di bo", "dap an dung", false, true);
		PowerMockito.when(ConnectSQL.prepareUpdate(ArgumentMatchers.anyString(), ArgumentMatchers.any()))
				.thenReturn(row);
		row = qConSpy.insertDapAn(answer);
		assertEquals(row, 1);
	}

	@Test(expectedExceptions = Exception.class)
	public void insertQuestionTest_TC50_EmptyQuestion() throws Exception {
		Question question = null;
		qCon.insertQuestion(question);
	}
	@Test
	public void insertQuestionTest_TC51_NullQuestion() throws Exception {
		Question question = new Question();
		int row = qCon.insertQuestion(question);
		assertEquals(row, 0);
	}
	@Test
	public void insertQuestionTest_TC52_Success() throws Exception {
		Question question = new Question(1, 1, "Cau hoi 1", "hinh.jpg", true);
		int row = 1;
		PowerMockito.when(ConnectSQL.insertObj(ArgumentMatchers.anyString(), ArgumentMatchers.any())).thenReturn(row);
		row = qCon.insertQuestion(question);
		assertEquals(row, 1);
	}

	@Test(expectedExceptions = Exception.class)
	public void updateDapAnTest_TC53_Nullparam() throws Exception {
		Answer answer = null;
		int row = qCon.updateDapAn(answer);
	}
	@Test
	public void updateDapAnTest_TC54_Failed() throws Exception {
		Answer answer = new Answer(-1, 1, "duong bo", "oto không bay được", true, true);
		int row = qCon.updateDapAn(answer);
		assertEquals(row, 0);
	}
	@Test
	public void updateDapAnTest_TC55_Success() throws Exception {
		Answer answer = new Answer(1, 1, "duong bo", "oto không bay được", true, true);
		int row = 1;
		PowerMockito.when(ConnectSQL.prepareUpdate(ArgumentMatchers.anyString(), ArgumentMatchers.any())).thenReturn(row);
		assertEquals(row, 1);
	}
	@Test
	public void updateDapAnTest_TC56_NullID() throws Exception {
		Answer answer = new Answer();
		answer.setCauhoi_id(1);
		answer.setFlag(true);
		answer.setGiaiThich("dung");
		answer.setNoiDung("Cau hoi");
		answer.setTrangThai(true);
		int row = qCon.updateDapAn(answer);
		assertEquals(row, 0);
	}

	@Test
	public void updateExambyIDTest_TC57_EmptyDethi() throws Exception {
		Dethi dethi = new Dethi();
		int row = 0;
		PowerMockito.when(ConnectSQL.prepareUpdate(ArgumentMatchers.anyString(), ArgumentMatchers.any())).thenReturn(row);
		qConSpy.updateExambyID(dethi, "HAILVPH13040@FPT.EDU.VN");
	}
	@Test
	public void updateExambyIDTest_TC58_EmptyEmail() throws Exception {
		Dethi dethi = new Dethi();
		String email = "";
		int row = 0;
		PowerMockito.when(ConnectSQL.prepareUpdate(ArgumentMatchers.anyString(), ArgumentMatchers.any())).thenReturn(row);
		qConSpy.updateExambyID(dethi, email);
	}
	@Test
	public void updateExambyIDTest_TC58_NullEmail() throws Exception {
		Dethi dethi = new Dethi();
		String email = null;
		int row = 0;
		PowerMockito.when(ConnectSQL.prepareUpdate(ArgumentMatchers.anyString(), ArgumentMatchers.any())).thenReturn(row);
		qConSpy.updateExambyID(dethi, email);
	}
	@Test(expectedExceptions = Exception.class)
	public void updateExambyIDTest_TC59_NullDeThi() throws Exception {
		Dethi dethi = null;
		String email = "HAILVPH13040@FPT.EDU.VN";
		int row = 0;
		PowerMockito.when(ConnectSQL.prepareUpdate(ArgumentMatchers.anyString(), ArgumentMatchers.any())).thenReturn(row);
		qConSpy.updateExambyID(dethi, email);
	}
	@Test
	public void updateExambyIDTest_TC60_Success() throws Exception {
		Dethi dethi = new Dethi(1,400,1,"pass", "hailvph13040@fpt.edu.vn");
		int row = 1;
		PowerMockito.when(ConnectSQL.prepareUpdate(ArgumentMatchers.anyString(), ArgumentMatchers.any())).thenReturn(row);
		row = qConSpy.updateExambyID(dethi, "HAILVPH13040@FPT.EDU.VN");
		assertEquals(row, 1);
	}

	@Test
	public void updateQuesstionTest_61_Success() throws Exception {
		Question question = new Question(1, 1, "Cau hoi 1", "hinh1.png", true);
		int row = 1;
		PowerMockito.when(ConnectSQL.prepareUpdate(ArgumentMatchers.anyString(), ArgumentMatchers.any())).thenReturn(row);
		row = qConSpy.updateQuesstion(question);
		assertEquals(row, 1);
	}
	@Test
	public void updateQuesstionTest_62_EmptyQuestion() throws Exception {
		Question question = new Question();
		int row = 0;
		PowerMockito.when(ConnectSQL.prepareUpdate(ArgumentMatchers.anyString(), ArgumentMatchers.any())).thenReturn(row);
		row = qConSpy.updateQuesstion(question);
		assertEquals(row, 0);
	}
	@Test(expectedExceptions = Exception.class)
	public void updateQuesstionTest_62_NullQuestion() throws Exception {
		Question question = null;
		int row = 0;
		PowerMockito.when(ConnectSQL.prepareUpdate(ArgumentMatchers.anyString(), ArgumentMatchers.any())).thenReturn(row);
		row = qConSpy.updateQuesstion(question);
		assertEquals(row, 0);
	}

	@Test
	public void updateQuestionExamTest_TC63_Success() throws Exception {
		CauHoi_DeThi cauHoi_DeThi = new CauHoi_DeThi(1, 1, 1, true);
		int row = 1;
		PowerMockito.when(ConnectSQL.prepareUpdate(ArgumentMatchers.anyString(), ArgumentMatchers.any())).thenReturn(row);
		row = qConSpy.updateQuestionExam(cauHoi_DeThi);
		assertEquals(row, 1);
	}
	@Test(expectedExceptions = Exception.class)
	public void updateQuestionExamTest_TC64_Null() throws Exception {
		CauHoi_DeThi cauHoi_DeThi = null;
		int row = 1;
		PowerMockito.when(ConnectSQL.prepareUpdate(ArgumentMatchers.anyString(), ArgumentMatchers.any())).thenReturn(row);
		row = qConSpy.updateQuestionExam(cauHoi_DeThi);
		assertEquals(row, 1);
	}
	@Test
	public void updateQuestionExamTest_TC64_Empty() throws Exception {
		CauHoi_DeThi cauHoi_DeThi = new CauHoi_DeThi();
		int row = 0;
		PowerMockito.when(ConnectSQL.prepareUpdate(ArgumentMatchers.anyString(), ArgumentMatchers.any())).thenReturn(row);
		row = qConSpy.updateQuestionExam(cauHoi_DeThi);
		assertEquals(row,0);
	}
}
