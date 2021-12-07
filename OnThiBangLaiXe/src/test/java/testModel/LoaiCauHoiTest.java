package testModel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;

public class LoaiCauHoiTest {
	LoaiCauHoi loaiCauHoi; 
  @BeforeTest
  public void beforeTest() {
	  loaiCauHoi = new LoaiCauHoi();
  }

  @AfterTest
  public void afterTest() {
	  loaiCauHoi = null;
  }


  @Test
  public void getIDTest_TC_01() {
	 int ep = 0;
	 assertEquals(loaiCauHoi.getID(), ep);
  }

  @Test
  public void getTenLoaiTest_TC_02() {
	  String ep = null;
	  assertEquals(loaiCauHoi.getTenLoai(), ep);
  }

  @Test
  public void setIDTest_TC_03() {
	  int ep = 1;
	  loaiCauHoi.setID(1);
	  assertEquals(loaiCauHoi.getID(), ep);
  	}

  @Test
  public void setTenLoaiTest_TC_05() {
	  String ep = "";
	  assertFalse(loaiCauHoi.getTenLoai() == ep);
  }
  @Test
  public void setTenLoaiTest_TC_06() {
	  String ep = "hello";
	  loaiCauHoi.setTenLoai("hello");
	  assertTrue(loaiCauHoi.getTenLoai() == ep);
  }
}
