package testController;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import com.mockrunner.mock.jdbc.MockConnection;
import com.mockrunner.mock.jdbc.MockPreparedStatement;
import com.mockrunner.mock.jdbc.MockResultSet;
import com.mockrunner.mock.jdbc.MockStatement;
import testConnectSQL.ConnectSQL;
import testModel.User;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertEquals;
import java.sql.SQLException;
import java.util.ArrayList;
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
	
	@Parameters({"email", "password"})
	@Test
	public void adduserTest_TC01_Success(String email, String password) throws Exception {
		int row = 0;
		PowerMockito.when(ConnectSQL.prepareUpdate(ArgumentMatchers.anyString()))
			.thenReturn(row);
		assertEquals(addCon.adduser(email, password), row);
		
	}

	@Test
	public void getcodeTest_TC02() {
		String code = addCon.getcode();
		AssertJUnit.assertTrue(code != null);
	}
	@Test
	public void getcodeTest_TC03() {
		String code = addCon.getcode();
		AssertJUnit.assertTrue(code != "");
	}

	@Test
	public void getlistuserTest_TC04() throws Exception{
		mockResultSet.addColumn("user", new String[] {"hailv","hai"});
		mockResultSet.addColumn("pass", new String[] {"a1234","12a"});
		mockResultSet.addColumn("roles", new String[] {"admin", "users"});
		PowerMockito.when(ConnectSQL.createStatement(ArgumentMatchers.anyString())).thenReturn(mockResultSet);
		List result = addConSpy.getlistuser();
		assertEquals(result.size(), 0);
		
		
	}

	@Parameters("email")
	@Test(expectedExceptions = Exception.class)
	public void sendmailTest_TC05(String email) throws Exception {
		addConSpy.sendmail(email, "1111");
	}
}
