/**
 * 
 */
package evaluacion.primera;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

/**
 * In this class is condensed all connections needed to access the data base
 * the singleton pattern is used, and we ensure to free connections after use.
 * 
 * @author Alberto Vivas
 *
 * 
 */
public class Conexion {
	
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String conexion = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "HR";
	private static final String password = "a123456";
	
	private static Conexion o_conexion = new Conexion();// \
	private Conexion(){}								// |--- Pattern
	public static Conexion getInstance(){				// |--- Singleton
		return o_conexion;}								// /
	
	public static Connection obtenerConexion() throws SQLException, ClassNotFoundException{
		Connection conn;
		Class.forName(driver);
		conn = DriverManager.getConnection(conexion, user, password);
		return conn;
	}
														
	public static void LiberarRecursos(Statement stmt,Connection conn,ResultSet rset){
		if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
		if (rset != null)   { try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
	}
	/**
	 * @param newconex
	 */
	public static void LiberarRecursos(Connection conn, PreparedStatement pstmt) {
		if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
		if (pstmt != null)	{ try {	pstmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		
	}
	
}
