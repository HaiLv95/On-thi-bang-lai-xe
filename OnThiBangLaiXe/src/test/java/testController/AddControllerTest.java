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
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;
import org.testng.IObjectFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
@PrepareForTest({ AddController.class, ConnectSQL.class})
public class AddControllerTest extends PowerMockTestCase{
	AddController addCon;
	AddController addConSpy;
	MockConnection mockConnection;
	MockStatement mockStatement;
	MockPreparedStatement mockPreparedStatement;
	
	@BeforeMethod
	public void beforeClass() {
		addCon = new AddController();
		PowerMockito.mockStatic(ConnectSQL.class);
		addConSpy = PowerMockito.spy(new AddController());
		mockConnection = PowerMockito.mock(MockConnection.class);
		mockStatement = PowerMockito.mock(MockStatement.class);
		mockPreparedStatement = PowerMockito.mock(MockPreparedStatement.class);
	}
	@ObjectFactory
	public IObjectFactory getIObjectFactory() {
		return new org.powermock.modules.testng.PowerMockObjectFactory();
	}

	@AfterMethod
	public void afterClass() {
	}
	
	@Parameters({"email", "pass"})
	@Test
	public void adduserTest_TC01_Success(String email, String pass) throws Exception {
		int row = 0;
		PowerMockito.when(ConnectSQL.prepareUpdate(ArgumentMatchers.anyString()))
			.thenReturn(row);
		assertEquals(addCon.adduser(email, pass), row);
		
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
		MockResultSet mockResultSetNew = new MockResultSet("ID");
		mockResultSetNew.addColumn("user", new String[] {"hailv","hai"});
		mockResultSetNew.addColumn("pass", new String[] {"a1234","12a"});
		mockResultSetNew.addColumn("roles", new String[] {"admin", "users"});
		PowerMockito.when(ConnectSQL.createStatement(ArgumentMatchers.anyString())).thenReturn(mockResultSetNew);
		List result = addConSpy.getlistuser();
		assertEquals(result.size(), 2);
	}
	@Test
	public void getlistuserTest_TC05() throws Exception{
		MockResultSet mockResultSetNew = new MockResultSet("ID");
		mockResultSetNew.addColumn("user", new String[] {"hailv"});
		mockResultSetNew.addColumn("pass", new String[] {"a1234"});
		mockResultSetNew.addColumn("roles", new String[] {"admin"});
		PowerMockito.when(ConnectSQL.createStatement(ArgumentMatchers.anyString())).thenReturn(mockResultSetNew);
		List result = addConSpy.getlistuser();
		assertEquals(result.size(), 1);
	}

//	@Parameters("email")
//	@Test
//	public void sendmailTest_TC06(String email) throws Exception {
//		addCon.sendmail(email, "1111");
//	}
}
