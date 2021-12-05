package testModel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;

public class CauHoi_DeThiTest {
	CauHoi_DeThi cauhoi;
  @BeforeTest
  public void beforeTest() {
	  cauhoi = new CauHoi_DeThi();
	  
  }

  @AfterTest
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

  @Test(expectedExceptions = Exception.class)
  public void setCauHoi_idTest_TC_09() {
	  cauhoi.setCauHoi_id(-1);
  }
  
  @Test
  public void setCauHoi_idTest_TC_10() {
	  cauhoi.setCauHoi_id(1);
	  int ep = 1;
	  assertEquals(cauhoi.getCauHoi_id(), ep);
  }

  @Test(expectedExceptions = Exception.class)
  public void setCauTraLoiTest_TC_11() {
	  cauhoi.setCauTraLoi(-1);
  }
  
  @Test
  public void setCauTraLoiTest_TC_12() {
	  int ep = 1;
	  cauhoi.setCauTraLoi(1);
	  assertEquals(cauhoi.getCauTraLoi(), ep);
  }
    @Test(expectedExceptions = Exception.class)
    public void setCauTraLoiTest_TC_13() {
    	cauhoi.setCauTraLoi(-1);
  }
    @Test
    public void setCauTraLoiTest_TC_14() {
    	cauhoi.setCauTraLoi(1);
    	int ep = 1;
    	assertEquals(cauhoi.getCauTraLoi(), ep);
    }

  @Test(expectedExceptions = Exception.class)
  public void setDeThi_idTest_TC_15() {
	  cauhoi.setDeThi_id(-1);
  }
  @Test
  public void setDeThi_idTest_TC_16() {
	  cauhoi.setDeThi_id(1);
	  int ep = 1;
	  assertEquals(cauhoi.getDeThi_id(), ep);
  }

  @Test
  public void setTrangThaiTest_TC_17() {
	  boolean ep = true;
	  assertEquals(cauhoi.isTrangThai(), ep);
	  
  }
  @Test
  public void setTrangThaiTest_TC_18() {
	  cauhoi.setTrangThai(true);
	  assertTrue(cauhoi.isTrangThai());
	  
  }
}
