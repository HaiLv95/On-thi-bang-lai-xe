package testController;

import static org.testng.Assert.assertTrue;

import org.powermock.api.mockito.PowerMockito;
import org.testng.IObjectFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mockrunner.mock.jdbc.MockConnection;
import com.mockrunner.mock.jdbc.MockPreparedStatement;
import com.mockrunner.mock.jdbc.MockResultSet;
import com.mockrunner.mock.jdbc.MockStatement;

import testConnectSQL.ConnectSQL;

public class changePasswordControllerTest {
	AddController addCon;
	AddController addConSpy;
	MockConnection mockConnection;
	MockStatement mockStatement;
	MockPreparedStatement mockPreparedStatement;
	MockResultSet mockResultSet = new MockResultSet("my mock");
	@BeforeMethod
	public void beforeClass() {
		addCon = new AddController();
		PowerMockito.mockStatic(ConnectSQL.class);
		addConSpy = PowerMockito.spy(new AddController());
		mockConnection = PowerMockito.mock(MockConnection.class);
		mockStatement = PowerMockito.mock(MockStatement.class);
		mockPreparedStatement = PowerMockito.mock(MockPreparedStatement.class);
		mockResultSet = PowerMockito.mock(MockResultSet.class);
	}
	@ObjectFactory
	public IObjectFactory getIObjectFactory() {
		return new org.powermock.modules.testng.PowerMockObjectFactory();
	}

	@AfterMethod
	public void afterClass() {
	}
	
	@Parameters({"pass", "email"})
	@Test
	public void TC01_changePasswordSuccess(String pass, String email) {
		changePasswordController ch = new changePasswordController();
		int row = ch.changePassword(pass, email);
		assertTrue(row > 0);
	}
	@Parameters({ "email"})
	@Test
	public void TC02_changePassword_Failed(String email) {
		changePasswordController ch = new changePasswordController();
		int row = ch.changePassword("", email);
		assertTrue(row < 0);
	}
	
	@Parameters({ "email"})
	@Test
	public void TC03_changePassword_Failed(String email) {
		changePasswordController ch = new changePasswordController();
		int row = ch.changePassword("0000", email);
		assertTrue(row < 0);
	}
	
	@Parameters({ "pass"})
	@Test
	public void TC04_changePassword_Failed(String pass) {
		changePasswordController ch = new changePasswordController();
		int row = ch.changePassword(pass, "");
		assertTrue(row < 0);
	}
	
	@Parameters({ "pass"})
	@Test
	public void TC05_changePassword_Failed(String pass) {
		changePasswordController ch = new changePasswordController();
		int row = ch.changePassword(pass, "abc@gmail.com");
		assertTrue(row < 0);
	}
}
