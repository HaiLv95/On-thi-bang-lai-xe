package testModel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class QuestionTest {
	Question question;
  @BeforeMethod
  public void beforeTest() {
	  question = new Question();
  }

  @AfterMethod
  public void afterTest() {
	  question = null;
  }


  @Test
  public void getHinhTest_TC01() {
    assertEquals(question.getHinh(), null);
  }
  @Test
  public void getHinhTest_TC02() {
	  question.setHinh("hinh");
	  String ep = "hinh"; 
	  assertEquals(question.getHinh(), ep);
  }

  @Test
  public void getIdTest_TC03() {
    assertEquals(question.getId(), 0);
  }
  @Test
  public void getIdTest_TC04() {
	  question.setId(1);
	  int ep = 1;
	  assertEquals(question.getId(), ep);
  }

  @Test
  public void getLoaiCauHoi_idTest_TC05() {
    assertEquals(question.getLoaiCauHoi_id(), 0);
  }

  @Test
  public void getNoiDungTest_TC06() {
	 question.setLoaiCauHoi_id(1);
	 int ep = 1;
    assertEquals(question.getLoaiCauHoi_id(), ep);
  }

  @Test
  public void isTrangThaiTest_TC07() {
    assertTrue(question.isTrangThai());
  }

  @Test
  public void setHinhTest_TC08() {
    String ep = "hinh.jpg";
    question.setHinh(ep);
    assertEquals(question.getHinh(), ep);
  }

  @Test
  public void setIdTest_TC09() {
	  int ep = 1;
	  question.setId(1);
	  assertEquals(question.getId(), ep);
  }

  @Test
  public void setLoaiCauHoi_idTest_TC10() {
	  int ep = 1;
	  question.setLoaiCauHoi_id(ep);
	  assertEquals(question.getLoaiCauHoi_id(), ep);
  }

  @Test
  public void setNoiDungTest_TC11() {
    String ep = "Noi dung";
    question.setNoiDung(ep);
    assertEquals(question.getNoiDung(), ep);
  }

  @Test
  public void setTrangThaiTest_TC12() {
    boolean ep = true;
    question.setTrangThai(ep);
    assertEquals(question.isTrangThai(), ep);
  }
  @Test
  public void setTrangThaiTest_TC13() {
	  boolean ep = false;
	  question.setTrangThai(ep);
	  assertEquals(question.isTrangThai(), ep);
  }
}
