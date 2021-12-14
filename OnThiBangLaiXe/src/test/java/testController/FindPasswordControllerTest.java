package testController;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.sql.SQLException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FindPasswordControllerTest {
	
//	@Parameters("email")
//	@Test
//	public void TC01_sendEmail(String email) throws SQLException {
//		FindPasswordController fd = new FindPasswordController();
//		assertFalse(fd.send(email));
//	}
	
	@Test
	public void TC02_sendEmail_Failed() throws SQLException {
		FindPasswordController fd = new FindPasswordController();
		assertFalse(fd.send(""));
	}
	
//	@Test
//	public void TC03_sendEmail_Failed(String email) throws SQLException {
//		FindPasswordController fd = new FindPasswordController();
//		assertFalse(fd.send("adv"));
//	}
}
