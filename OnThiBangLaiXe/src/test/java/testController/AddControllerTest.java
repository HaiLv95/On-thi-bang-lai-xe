package testController;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.mockrunner.mock.jdbc.MockConnection;
import com.mockrunner.mock.jdbc.MockPreparedStatement;
import com.mockrunner.mock.jdbc.MockResultSet;
import com.mockrunner.mock.jdbc.MockStatement;

import testConnectSQL.ConnectSQL;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.mockito.ArgumentMatchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;
import org.testng.IObjectFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Parameters;
@PrepareForTest({ AddController.class, ConnectSQL.class })
public class AddControllerTest extends PowerMockTestCase{
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

	@Test(expectedExceptions = Exception.class)
	public void adduserTest_TC01_Failed() throws Exception {
		String user = null;
		String pass = null;
		addCon.adduser(user, pass);
	}
	@Parameters("password")
	@Test(expectedExceptions = Exception.class)
	public void adduserTest_TC02_Failed(String password) throws Exception {
		String user = null;
		addCon.adduser(user, password);
	}
	
	@Parameters("email")
	@Test(expectedExceptions = Exception.class)
	public void adduserTest_TC03_Failed(String email) throws Exception {
		String pass = null;
		addCon.adduser(email, pass);
	}

	@Test(expectedExceptions = Exception.class)
	public void adduserTest_TC04_Failed() throws Exception {
		String pass = null;
		String email = null;
		addCon.adduser(email, pass);
	}
	
	@Parameters({"email", "password"})
	@Test
	public void adduserTest_TC05_Success(String email, String password) throws Exception {
		addCon.adduser(email, password);
	}

	@Test
	public void getcodeTest() {
		String code = addCon.getcode();
		AssertJUnit.assertTrue(code != null);
	}

	@Test
	public void getlistuserTest() throws SQLException {
		mockResultSet = initMockResultSet();
		PowerMockito.when(ConnectSQL.createStatement(ArgumentMatchers.anyString()))
			.thenReturn(mockResultSet);
		PowerMockito.when(mockResultSet.getStatement()).thenReturn(mockStatement);
		PowerMockito.when(mockStatement.getConnection()).thenReturn(mockConnection);
		List result = addConSpy.getlistuser();
		AssertJUnit.assertEquals(1, result.size());
		
	}

	@Parameters("email")
	@Test
	public void sendmailTest(String email) {
		addCon.sendmail(email, "1111");
	}
	private MockResultSet initMockResultSet() throws SQLException {
		mockResultSet.addColumn("user", new String[] {"hai"});
		mockResultSet.addColumn("pass", new String[] {"1234"});
		mockResultSet.addColumn("roles", new String[] {"admin"});
		mockResultSet.beforeFirst();
		return mockResultSet;
	}
}
