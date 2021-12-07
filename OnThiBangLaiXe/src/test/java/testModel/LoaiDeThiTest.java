package testModel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;

public class LoaiDeThiTest {
	LoaiDeThi loaiDeThi;
  @BeforeTest
  public void beforeTest() {
	  loaiDeThi = new LoaiDeThi();
  }

  @AfterTest
  public void afterTest() {
	  loaiDeThi = null;
  }


  @Test
  public void getLoaiDe_IDTest_TC01() {
	  assertEquals(loaiDeThi.getLoaiDe_ID(), 0);
  }

  @Test
  public void getTenLoaiTest_TC02() {
	  assertEquals(loaiDeThi.getTenLoai(), null);
  }

  @Test
  public void setLoaiDe_IDTest_TC03() {
	  loaiDeThi.setLoaiDe_ID(1);
	  int ep = 1;
	  assertEquals(loaiDeThi.getLoaiDe_ID(), ep);
  	}

  @Test
  public void setTenLoaiTest() {
    loaiDeThi.setTenLoai("hello");
    String ep = "hello";
    assertEquals(loaiDeThi.getTenLoai(), ep);
  }
}
