/**
 * 
 */
package jdbc_DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class Conexion {
	
	
	private static Connection conn = null;
	private static Statement stmt = null;
	
	private static Conexion o_conexion = new Conexion();// \
	private Conexion(){}								// |--- Pattern
	public static Conexion getInstance(){				// |--- Singleton
		return o_conexion;}								// /
														
	
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String conexion = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "HR";
	private static final String password = "a123456";
	
	public static Statement conectarBBDD() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		Savepoint sp = null;
		try{	
		conn = DriverManager.getConnection(conexion, user, password);
		conn.setAutoCommit(false);
		sp = conn.setSavepoint();
		stmt = conn.createStatement();
		conn.commit();
		}catch(Throwable t){
			conn.rollback(sp);
		}
		return stmt;
	}
	public static void LiberarRecursos(){
		if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
	}

	
}
