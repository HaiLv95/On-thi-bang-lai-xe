package testModel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;

public class DethiTest {
	Dethi deThi;
  @BeforeTest
  public void beforeTest() {
	  deThi = new Dethi();
  }

  @AfterTest
  public void afterTest() {
	  deThi = null;
  }


  @Test
  public void getEmailTest_TC_01() {
    String ep = null;
    assertEquals(deThi.getEmail(), ep);
  }
  @Test
  public void getEmailTest_TC_02() {
	  String ep = null;
	  deThi.setEmail("");
	  assertFalse(deThi.getEmail()==ep);
  }
  @Test
  public void getEmailTest_TC_03() {
	  String ep = "hello";
	  deThi.setEmail("hello");
	  assertEquals(deThi.getEmail(),ep);
  }

  @Test
  public void getIdTest_TC_04() {
	  int ep = 0;
	  assertEquals(deThi.getId(), ep);
  }
  @Test
  public void getIdTest_TC_05() {
	  int ep = 1;
	  deThi.setId(1);
	  assertEquals(deThi.getId(), ep);
  }
  @Test(expectedExceptions = Exception.class)
  public void setIdTest_TC_06() {
	  deThi.setId(-1);
  }

  @Test
  public void getLoaide_idTest_TC_07() {
	  int ep = 0;
	  assertEquals(deThi.getLoaide_id(), ep);
  }
  @Test
  public void getLoaide_idTest_TC_08() {
	  int ep = 1;
	  deThi.setLoaide_id(1);
	  assertEquals(deThi.getLoaide_id(), ep);
  }
  @Test(expectedExceptions =  Exception.class)
  public void setLoaide_idTest_TC_09() {
	  deThi.setLoaide_id(-1);
  }

  @Test
  public void getTimerTest_TC_10() {
	  int ep = 0;
	  assertEquals(deThi.getTimer(), ep);
  }
  @Test
  public void getTimerTest_TC_11() {
	  int ep = 1;
	  deThi.setTimer(1);
	  assertEquals(deThi.getTimer(), ep);
  }
  
  @Test(expectedExceptions =  Exception.class)
  public void setTimerTest_TC_12() {
	  deThi.setTimer(-1);
  }

  @Test
  public void getTrangThaiTest_TC_13() {
	  String ep = null;
	  assertEquals(deThi.getTrangThai(), ep);
  }
  @Test
  public void getTrangThaiTest_TC_14() {
	  String ep = "";
	  assertFalse(deThi.getTrangThai() == ep);
  }
  @Test
  public void getTrangThaiTest_TC_15() {
	  String ep = "hello";
	  deThi.setTrangThai("hello");
	  assertTrue(deThi.getTrangThai() == ep);
  }

  @Test
  public void setEmailTest_TC_16() {
	  String ep = "hello";
	  deThi.setEmail("hello");
	  assertEquals(deThi.getEmail(), ep);
  }

  @Test
  public void setIdTest_TC_17() {
	  int ep = 1;
	  deThi.setId(1);
	  assertTrue(deThi.getId() == ep);
  }

  @Test
  public void setLoaide_idTest_TC_18() {
	  int ep = 1;
	  deThi.setLoaide_id(1);
	  assertTrue(deThi.getLoaide_id() == ep);
  }

  @Test
  public void setTimerTest_TC_19() {
	  int ep = 1;
	  deThi.setTimer(1);
	  assertTrue(deThi.getTimer() == ep);
  }

  @Test
  public void setTrangThaiTest() {
	  String ep = "hello";
	  deThi.setTrangThai("hello");
	  assertEquals(deThi.getTrangThai(), ep);
  }
}
