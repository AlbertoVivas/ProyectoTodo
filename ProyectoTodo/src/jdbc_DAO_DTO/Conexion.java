/**
 * 
 */
package jdbc_DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class Conexion {
	
	private String driver;
	private String conexion;
	private String user;
	private String password;
	
	
	public Conexion(String driver, String conexion, String user, String password) {
		this.driver = driver;
		this.conexion = conexion;
		this.user = user;
		this.password = password;
	}
	
	public Statement conectarBBDD() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		Statement stmt = null;
		Class.forName(this.driver);
		conn = DriverManager.getConnection(this.conexion, this.user, this.password);
		stmt = conn.createStatement();
		return stmt;
	}

	
}
