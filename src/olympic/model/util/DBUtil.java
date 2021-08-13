package olympic.model.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	
	private static Properties dbinfo = new Properties();
	
	private static Properties sql = new Properties();
	
	static{ 
		try {
			dbinfo.load(new FileReader("db.properties"));
			sql.load(new FileReader("sql.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(sql);
	}
	
	public static Properties getSql() {
		return sql;
	}

	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(dbinfo.getProperty("jdbc.url") , 
										   dbinfo.getProperty("jdbc.id"), 
										   dbinfo.getProperty("jdbc.pw"));
	}

	public static void close(Connection con, Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public static void close(Connection con, Statement stmt, ResultSet rset) {
		try {
			if (rset != null) {
				rset.close();
				rset = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}
}