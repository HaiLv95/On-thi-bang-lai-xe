package testController;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testConnectSQL.ConnectSQL;
import testModel.User;

public class LoginControllerTest {

	public ConnectSQL con;
	@BeforeTest
	public void init() {
		con = new ConnectSQL();
	}
	
	@Parameters({"email"})
	@Test
	public void TC01_getUserbyEmail_Success(String email) throws Exception {
		LoginController loginController = new LoginController();
		User user= loginController.getUserbyEmail(email);
		assertTrue(user != null);
	}
	
	@Test
	public void TC02_getUserbyEmail_Failed() throws Exception {
		LoginController loginController = new LoginController();
		User user= loginController.getUserbyEmail("");
		assertFalse(user != null);
	}
	
	@Test
	public void TC03_getUserbyEmail_Failed() throws Exception {
		LoginController loginController = new LoginController();
		User user= loginController.getUserbyEmail("afcv");
		assertFalse(user != null);
	}
}
