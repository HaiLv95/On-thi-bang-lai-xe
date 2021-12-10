package testController;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ConnectionTest {
	String url;
	String user;
	String pass;
	Connection connection;
	@Parameters({ "temphost", "tempuser", "temppass", "tempdb", "tempport" })
	@Test
	public void CDB_TC001_ConectSuccess(String temphost, String tempuser, String temppass, String tempdb,
			String tempport)throws Exception {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				url = "jdbc:sqlserver://" + temphost + ":" + tempport + ";databaseName=" + tempdb;
				user = tempuser;
				pass = temppass;
				connection = DriverManager.getConnection(url, user, pass);
	}

	@Parameters({ "tempuser", "temppass", "tempdb", "tempport" })
	@Test
	public void CDB_TC002_ConectFailed(String tempuser, String temppass, String tempdb, String tempport)
			throws Exception{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			url = "jdbc:sqlserver://" + "" + ":" + tempport + ";databaseName=" + tempdb;
			user = tempuser;
			pass = temppass;
			connection = DriverManager.getConnection(url, user, pass);
			assertFalse(connection != null);
	}

	@Parameters({ "temphost", "temppass", "tempdb", "tempport" })
	@Test
	public void CDB_TC003_ConectFailed(String temphost, String temppass, String tempdb, String tempport)
			throws Exception{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			url = "jdbc:sqlserver://" + temphost + ":" + tempport + ";databaseName=" + tempdb;
			user = "";
			pass = temppass;
			connection = DriverManager.getConnection(url, user, pass);
			assertFalse(connection != null);
	}

	@Parameters({ "temphost", "temppass", "tempdb", "tempport" })
	@Test
	public void CDB_TC004_ConectFailed(String temphost, String temppass, String tempdb, String tempport)
			throws Exception{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			url = "jdbc:sqlserver://" + temphost + ":" + tempport + ";databaseName=" + tempdb;
			user = "abv";
			pass = temppass;
			connection = DriverManager.getConnection(url, user, pass);
			assertFalse(connection != null);
	}

	@Parameters({ "temphost", "tempuser", "tempdb", "tempport" })
	@Test
	public void CDB_TC005_ConectFailed(String temphost, String tempuser, String tempdb, String tempport) 
			throws Exception{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			url = "jdbc:sqlserver://" + temphost + ":" + tempport + ";databaseName=" + tempdb;
			user = tempuser;
			pass = "";
			connection = DriverManager.getConnection(url, user, pass);
			assertFalse(connection != null);
	}

	@Parameters({ "temphost", "tempuser", "tempdb", "tempport" })
	@Test
	public void CDB_TC006_ConectFailed(String temphost, String tempuser, String tempdb, String tempport)
			throws Exception{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			url = "jdbc:sqlserver://" + temphost + ":" + tempport + ";databaseName=" + tempdb;
			user = tempuser;
			pass = "123";
			connection = DriverManager.getConnection(url, user, pass);
			assertFalse(connection != null);
	}

	@Parameters({ "temphost", "tempuser", "temppass", "tempport" })
	@Test
	public void CDB_TC007_ConectFailed(String temphost, String tempuser, String temppass, String tempport)
			throws Exception{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			url = "jdbc:sqlserver://" + temphost + ":" + tempport + ";databaseName=" + "a";
			user = tempuser;
			pass = temppass;
			connection = DriverManager.getConnection(url, user, pass);
			assertFalse(connection != null);
	}

	@Parameters({ "temphost", "tempuser", "temppass", "tempport" })
	@Test
	public void CDB_TC008_ConectFalse(String temphost, String tempuser, String temppass, String tempport)
			throws Exception{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			url = "jdbc:sqlserver://" + temphost + ":" + tempport + ";databaseName=" + "abc";
			user = tempuser;
			pass = temppass;
			connection = DriverManager.getConnection(url, user, pass);
			assertFalse(connection != null);
	}

	@Parameters({ "temphost", "tempuser", "temppass", "tempdb" })
	@Test
	public void CDB_TC009_ConectFailed(String temphost, String tempuser, String temppass, String tempdb)
			throws Exception{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			url = "jdbc:sqlserver://" + temphost + ":" + "" + ";databaseName=" + tempdb;
			user = tempuser;
			pass = temppass;
			connection = DriverManager.getConnection(url, user, pass);
			assertFalse(connection != null);
	}

	@Parameters({ "temphost", "tempuser", "temppass", "tempdb" })
	@Test
	public void CDB_TC010_ConectFailed(String temphost, String tempuser, String temppass, String tempdb) 
			throws Exception{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			url = "jdbc:sqlserver://" + temphost + ":" + "123" + ";databaseName=" + tempdb;
			user = tempuser;
			pass = temppass;
			connection = DriverManager.getConnection(url, user, pass);
			assertFalse(connection != null);
	}

	@Parameters({ "tempuser", "temppass", "tempdb", "tempport" })
	@Test
	public void CDB_TC011_ConectFailed(String tempuser, String temppass, String tempdb, String tempport) 
			throws Exception{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			url = "jdbc:sqlserver://" + "abc" + ":" + tempport + ";databaseName=" + tempdb;
			user = tempuser;
			pass = temppass;
			connection = DriverManager.getConnection(url, user, pass);
			assertFalse(connection != null);
	}
}
