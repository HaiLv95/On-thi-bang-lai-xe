package testModel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;

public class AnswerTest {
	Answer answer;
  @BeforeTest
  public void beforeTest() {
	  answer = new Answer();
  }

  @AfterTest
  public void afterTest() {
	  answer = null;
  }


  @Test
  public void getCauhoi_idTest_TC_01() {
    
    int expected = 0;
    assertEquals(answer.getCauhoi_id(), expected);
  }
  @Test
  public void getCauhoi_idTest_TC_02() {
	  answer.setCauhoi_id(2);
	  int expected = 2;
	  assertEquals(answer.getCauhoi_id(), expected);
  }

  @Test
  public void getGiaiThichTest_TC03() {
    String expected = null;
    assertEquals(answer.getGiaiThich(), expected);
  }
  @Test
  public void getGiaiThichTest_TC04() {
	  answer.setGiaiThich("1");
	  String expected = "1";
	  assertEquals(answer.getGiaiThich(), expected);
  }

  @Test
  public void getIdTest_TC05() {
    int expected = 0;
    assertEquals(answer.getId(), expected);
  }
  @Test
  public void getIdTest_TC06() {
	  answer.setId(1);
	  int expected = 1;
	  assertEquals(answer.getId(), expected);
  }

  @Test
  public void getNoiDungTest_TC07() {
	  String expect = null;
	  assertEquals(answer.getNoiDung(), expect);
  }
  @Test
  public void getNoiDungTest_TC08() {
	  answer.setNoiDung("hello");
	  String expect = "hello";
	  
	  assertEquals(answer.getNoiDung(), expect);
  }

  @Test
  public void isFlagTest_TC_10() {
	  boolean expect = false;
	  assertEquals(answer.isFlag(), expect);
  }
  @Test
  public void isFlagTest_TC_11() {
	  answer.setFlag(true);
	  boolean expect = true;
	  assertEquals(answer.isFlag(), expect);
  }

  @Test
  public void isTrangThaiTest_TC_12() {
	  boolean exp = false;
	  assertEquals(answer.isTrangThai(), exp);
  }
  @Test
  public void isTrangThaiTest_TC_13() {
	  boolean exp = true;
	  answer.setTrangThai(true);
	  assertEquals(answer.isTrangThai(), exp);
  }

  @Test
  public void setCauhoi_idTest_TC_14() {
	  int exp = 0;
	  assertEquals(answer.getCauhoi_id(), exp);
  }
  @Test(expectedExceptions = Exception.class)
  public void setCauhoi_idTest_TC_15() {
	 answer.setCauhoi_id(-1);
  }
  @Test
  public void setCauhoi_idTest_TC_16() {
	  answer.setCauhoi_id(1);
	  assertEquals(answer.getCauhoi_id(), 1);
  }

  @Test
  public void setFlagTest_TC_17() {
    answer.setFlag(false);
    assertEquals(answer.isFlag(), false);
  }

  @Test
  public void setGiaiThichTest_TC_18() {
	  answer.setGiaiThich("");
	  String exp = null;
	  assertFalse(answer.getGiaiThich().equalsIgnoreCase(exp));
  }
  @Test
  public void setGiaiThichTest_TC_19() {
	  answer.setGiaiThich("hello");
	  String exp = "hello";
	  assertTrue(answer.getGiaiThich().equalsIgnoreCase(exp));
  }

  @Test
  public void setIdTest_TC_20() {
	  answer.setId(1);
	  int ex = 1;
	  assertEquals(answer.getId(), ex);
  }
  @Test(expectedExceptions = Exception.class)
  public void setIdTest_TC_21() {
	  answer.setId(-1);
  }

  @Test
  public void setNoiDungTest_TC_22() {
	  answer.setNoiDung("");
	  String exp = null;
	  assertFalse(answer.getNoiDung().equalsIgnoreCase(exp));
  }
  @Test
  public void setNoiDungTest_TC_23() {
	  answer.setNoiDung("noi dung");
	  String exp = "noi dung";
	  assertTrue(answer.getNoiDung().equalsIgnoreCase(exp));
  }

  @Test
  public void setTrangThaiTest() {
	  answer.setTrangThai(true);
	  assertTrue(answer.isTrangThai());
  }
}
