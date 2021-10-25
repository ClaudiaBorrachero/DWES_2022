package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

	public static int numCon = 0;
	public static Connection con=null;
	private static final String conUrl = "jdbc:mariadb://localhost:3336/classicmodels?user=root&password=root"
			+ "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	public static Connection getConnection() {
		
		try{
			if(con == null || con.isClosed()) {
				con = DriverManager.getConnection(ConexionBD.conUrl);
				
				System.out.println("Conexión realizada satisfactoriamente.");
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return con;
		
	}
	
	public static void close(){
		
		try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}	
	
}
