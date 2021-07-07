package testConnectSQL;

/**
 *
 * @author hai95
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConnectSQL {

    private static Connection con;
    public static String user, pass;

    static {
        try {
            BufferedReader bfr = new BufferedReader(new FileReader("driver.txt"));
            user = bfr.readLine();
            pass = bfr.readLine();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Failed: Lỗi đọc file driver: " + ex);
        }
    }

    protected static void driverTest() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (java.lang.ClassNotFoundException e) {
            throw new Exception("MySQL JDBC Driver not found ...");
        }
    }

    public static Connection Connect() throws UnknownHostException, Exception {
        try {
            ConnectSQL.driverTest();
            InetAddress host = InetAddress.getLocalHost();
            String localhost = host.getHostName();
            con = DriverManager.getConnection("jdbc:sqlserver://" + localhost + ":1433;databaseName=QLYLAIXE", user, pass);

        } catch (UnknownHostException ex) {
            throw new UnknownHostException("Failed: Not foud localhost" + ex);
        } catch (Exception e) {
            throw new Exception("Failed: Lỗi kết nối CSDL: " + e);
        }
        return con;
    }
    public static Object insertObj(String sql) throws Exception{
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = Connect();
            pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            int row = pst.executeUpdate();
            if (row == 0) {
                throw new SQLException("Failed to insert, no row inserted");
            }
            try (ResultSet rs = pst.getGeneratedKeys()){
                while (rs.next()) {                    
                    Object generatedKey = rs.getObject(1);
                    return generatedKey;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed insert: " + e);
        }
        return null;
    }

    public static int prepareUpdate(String sql, Object... args) {
        int row = 0;
        try {
            PreparedStatement pst = Connect().prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pst.setObject(i + 1, args[i]);
            }
            row = pst.executeUpdate();
            Statement st = con.createStatement();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return row;
    }

    public static ResultSet prepareExcuteQuery(String sql, Object... args) {
        ResultSet rs = null;
        try {
            PreparedStatement pst = Connect().prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pst.setObject(i+1, args[i]);
            }
            rs = pst.executeQuery();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    public static ResultSet createStatement(String sql) {
        ResultSet rs = null;
        try {
            Statement st = Connect().createStatement();
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rs;
    }
}
