package testModel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class QuestionTest {
	Question question;
  @BeforeTest
  public void beforeTest() {
	  question = new Question();
  }

  @AfterTest
  public void afterTest() {
	  question = null;
  }


  @Test
  public void getHinhTest() {
    
  }

  @Test
  public void getIdTest() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getLoaiCauHoi_idTest() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getNoiDungTest() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void isTrangThaiTest() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void setHinhTest() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void setIdTest() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void setLoaiCauHoi_idTest() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void setNoiDungTest() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void setTrangThaiTest() {
    throw new RuntimeException("Test not implemented");
  }
}
