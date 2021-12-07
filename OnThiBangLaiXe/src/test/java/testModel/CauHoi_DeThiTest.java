package testModel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class CauHoi_DeThiTest {
	CauHoi_DeThi cauhoi;
  @BeforeMethod
  public void beforeTest() {
	  cauhoi = new CauHoi_DeThi();
	  
  }

  @AfterMethod
  public void afterTest() {
	  cauhoi = null;
  }


  @Test
  public void getCauHoi_idTest_TC_01() {
    int ep = 0;
    assertEquals(cauhoi.getCauHoi_id(), ep);
  }
  @Test
  public void getCauHoi_idTest_TC_02() {
	  int ep = 1;
	  cauhoi.setCauHoi_id(1);
	  assertEquals(cauhoi.getCauHoi_id(), ep);
  }

  @Test
  public void getCauTraLoiTest_TC_03() {
	  int ep = 0;
	  assertEquals(cauhoi.getCauTraLoi(), ep);
  }
  @Test
  public void getCauTraLoiTest_TC_04() {
	  int ep = 1;
	  cauhoi.setCauTraLoi(1);
	  assertEquals(cauhoi.getCauTraLoi(), ep);
  }

  @Test
  public void getDeThi_idTest_TC_05() {
	  int ep = 0;
	  assertEquals(cauhoi.getDeThi_id(), ep);
  }
  
  @Test
  public void getDeThi_idTest_TC_06() {
	  int ep = 1;
	  cauhoi.setDeThi_id(1);
	  assertEquals(cauhoi.getDeThi_id(), ep);
  }

  @Test
  public void isTrangThaiTest_TC_07() {
	  assertFalse(cauhoi.isTrangThai());
  }
  @Test
  public void isTrangThaiTest_TC_08() {
	  cauhoi.setTrangThai(true);
	  assertTrue(cauhoi.isTrangThai());
  }

  
  @Test
  public void setCauHoi_idTest_TC_09() {
	  cauhoi.setCauHoi_id(1);
	  int ep = 1;
	  assertEquals(cauhoi.getCauHoi_id(), ep);
  }

  
  @Test
  public void setCauTraLoiTest_TC_10() {
	  int ep = 1;
	  cauhoi.setCauTraLoi(1);
	  assertEquals(cauhoi.getCauTraLoi(), ep);
  }

    @Test
    public void setCauTraLoiTest_TC_11() {
    	cauhoi.setCauTraLoi(1);
    	int ep = 1;
    	assertEquals(cauhoi.getCauTraLoi(), ep);
    }

  @Test
  public void setDeThi_idTest_TC_12() {
	  cauhoi.setDeThi_id(1);
	  int ep = 1;
	  assertEquals(cauhoi.getDeThi_id(), ep);
  }

  @Test
  public void setTrangThaiTest_TC_13() {
	  cauhoi.setTrangThai(true);
	  assertTrue(cauhoi.isTrangThai());
	  
  }
}
