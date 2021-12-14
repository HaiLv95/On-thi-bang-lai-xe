package testController;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ConnectionTest {
	String url;
	String user;
	String pass;
	Connection connection;
	@Parameters({ "tempuser", "temppass"})
	@Test
	public void CDB_TC001_ConectSuccess(String tempuser, String temppass)throws Exception {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				InetAddress host = InetAddress.getLocalHost();
	            String localhost = host.getHostName();
				url = "jdbc:sqlserver://" + localhost + ":1433;databaseName=QLYLAIXE";
				user = tempuser;
				pass = temppass;
				connection = DriverManager.getConnection(url, user, pass);
	}

	@Parameters({ "tempuser", "temppass"})
	@Test(expectedExceptions = Exception.class)
	public void CDB_TC002_ConectFailed(String tempuser, String temppass)
			throws Exception{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			url = "jdbc:sqlserver://" + "" + ":1433;databaseName=QLYLAIXE";
			user = tempuser;
			pass = temppass;
			connection = DriverManager.getConnection(url, user, pass);
	}

	@Parameters({"temppass"})
	@Test(expectedExceptions = Exception.class)
	public void CDB_TC003_ConectFailed(String temppass)
			throws Exception{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			InetAddress host = InetAddress.getLocalHost();
            String localhost = host.getHostName();
			url = "jdbc:sqlserver://" + localhost + ":1433;databaseName=QLYLAIXE";
			user = "";
			pass = temppass;
			connection = DriverManager.getConnection(url, user, pass);
	}

	@Parameters({"temppass"})
	@Test(expectedExceptions = Exception.class)
	public void CDB_TC004_ConectFailed(String temppass)
			throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		InetAddress host = InetAddress.getLocalHost();
        String localhost = host.getHostName();
		url = "jdbc:sqlserver://" + localhost + ":1433;databaseName=QLYLAIXE";
		user = "abc";
		pass = temppass;
		connection = DriverManager.getConnection(url, user, pass);
	}

	@Parameters({"tempuser"})
	@Test(expectedExceptions = Exception.class)
	public void CDB_TC005_ConectFailed( String tempuser) 
			throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		InetAddress host = InetAddress.getLocalHost();
        String localhost = host.getHostName();
		url = "jdbc:sqlserver://" + localhost + ":1433;databaseName=QLYLAIXE";
		user = tempuser;
		pass = "";
		connection = DriverManager.getConnection(url, user, pass);
	}

	@Parameters({"tempuser"})
	@Test(expectedExceptions = Exception.class)
	public void CDB_TC006_ConectFailed(String tempuser)
			throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		InetAddress host = InetAddress.getLocalHost();
        String localhost = host.getHostName();
		url = "jdbc:sqlserver://" + localhost + ":1433;databaseName=QLYLAIXE";
		user = tempuser;
		pass = "123";
		connection = DriverManager.getConnection(url, user, pass);
	}

	@Parameters({"tempuser", "temppass"})
	@Test(expectedExceptions = Exception.class)
	public void CDB_TC007_ConectFailed(String tempuser, String temppass)
			throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		InetAddress host = InetAddress.getLocalHost();
        String localhost = host.getHostName();
		url = "jdbc:sqlserver://" + localhost + ":1433;databaseName=a";
		user = tempuser;
		pass = temppass;
		connection = DriverManager.getConnection(url, user, pass);
	}

	@Parameters({"tempuser", "temppass"})
	@Test(expectedExceptions = Exception.class)
	public void CDB_TC008_ConectFalse(String tempuser, String temppass)
			throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		InetAddress host = InetAddress.getLocalHost();
        String localhost = host.getHostName();
		url = "jdbc:sqlserver://" + localhost + ":;databaseName=QLYLAIXE";
		user = tempuser;
		pass = temppass;
		connection = DriverManager.getConnection(url, user, pass);
	}

	@Parameters({ "tempuser", "temppass"})
	@Test(expectedExceptions = Exception.class)
	public void CDB_TC009_ConectFailed(String tempuser, String temppass) 
			throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		InetAddress host = InetAddress.getLocalHost();
        String localhost = host.getHostName();
		url = "jdbc:sqlserver://" + localhost + ":123;databaseName=QLYLAIXE";
		user = tempuser;
		pass = temppass;
		connection = DriverManager.getConnection(url, user, pass);
	}

	@Parameters({ "tempuser", "temppass"})
	@Test(expectedExceptions = Exception.class)
	public void CDB_TC010_ConectFailed(String tempuser, String temppass) 
			throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		InetAddress host = InetAddress.getLocalHost();
        String localhost = host.getHostName();
		url = "jdbc:sqlserver://" + "abc" + ":123;databaseName=QLYLAIXE";
		user = tempuser;
		pass = temppass;
		connection = DriverManager.getConnection(url, user, pass);
	}
}
