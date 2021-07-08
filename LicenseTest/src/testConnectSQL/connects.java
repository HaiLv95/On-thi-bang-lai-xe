package testConnectSQL;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Mint
 */
public class connects {
    public static void main(String[] args) {
        java.sql.Connection conn;
        try{
            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=QLYLAIXE;user=dovancuongadhp;password=123";
            conn = DriverManager.getConnection(dbURL);
            if(conn != null){
                System.out.println("Kết nối thành công");
            }
                    
        } catch (SQLException ex){
            System.out.println("Kết nối thất bại");
            
        }
    }
    
}
