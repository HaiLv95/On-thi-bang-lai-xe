package testModel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;

public class UserTest {
	User user;
  @BeforeMethod
  public void beforeMethod() {
	  user = new User();
  }

  @AfterMethod
  public void afterMethod() {
	  user = null;
  }


  @Test
  public void getPassTest_TC01() {
	  assertEquals(user.getPass(), null);
  }
  @Test
  public void getPassTest_TC02() {
	  String ep = "pass";
	  user.setPass(ep);
	  assertEquals(user.getPass(), ep);
  }

  @Test
  public void getRolesTest_TC03() {
	  assertEquals(user.getRoles(), null);
  }
  @Test
  public void getRolesTest_TC04() {
	  String ep = "admin";
	  user.setRoles(ep);
	  assertEquals(user.getRoles(), ep);
  }

  @Test
  public void getUserTest_TC05() {
	  assertEquals(user.getUser(), null);
  }
  @Test
  public void getUserTest_TC06() {
	  String ep = "hailv";
	  user.setUser(ep);
	  assertEquals(user.getUser(), ep);
  }

  @Test
  public void setPassTest_TC07() {
	  String ep = "pass";
	  user.setPass(ep);
	  assertEquals(user.getPass(), ep);
  }

  @Test
  public void setRolesTest_TC08() {
	  String ep = "admin";
	  user.setRoles(ep);
	  assertEquals(user.getRoles(), ep);
  }

  @Test
  public void setUserTest_TC09() {
   String username = "hailv";
   user.setUser(username);
   assertEquals(user.getUser(), username);
  }
}
