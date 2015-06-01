/**
 * 
 */
package jdbc;

/**
 * @author Alberto Vivas
 *
 * 
 */
//package val.examples.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDatos {
	
	public static Statement  conectarBBDD(Connection conn, ResultSet rset, Statement stmt) throws SQLException, ClassNotFoundException{
		
		// registro el driver, en realidad, hago que se ejecuten unas pocas
		// líneas de la clase OracleDriver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// DriverManager.registerDriver (new
		// oracle.jdbc.driver.OracleDriver());// método equivalente al anterior
		// Sea como sea, es, <<oye, si te piden una conexión, se la pides a esa
		// clase!>>
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "HR", "a123456");
		stmt = conn.createStatement();
		rset = stmt.executeQuery("select BANNER from SYS.V_$VERSION");
		while (rset.next())
			System.out.println(rset.getString(1));	   
		return stmt;
	}
public static Statement  conectarBBDD(String classname, String conexion,String user, String pass, String query,Connection conn, ResultSet rset ) throws SQLException, ClassNotFoundException{
		
		Statement stmt = null;
		// registro el driver, en realidad, hago que se ejecuten unas pocas
		// líneas de la clase OracleDriver
		Class.forName(classname);
		// DriverManager.registerDriver (new
		// oracle.jdbc.driver.OracleDriver());// método equivalente al anterior
		// Sea como sea, es, <<oye, si te piden una conexión, se la pides a esa
		// clase!>>
		conn = DriverManager.getConnection(conexion, user, pass);
		stmt = conn.createStatement();
		rset = stmt.executeQuery(query);
		while (rset.next())
		{
			for (int i=1;i<=11;i++){
			System.out.print(rset.getString(i)+" ");
			}
			System.out.println();
		}
		return stmt;
	}
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		ResultSet rset = null;
		Statement stmt = null;
		String classname = "oracle.jdbc.driver.OracleDriver";
		String conexion = "jdbc:oracle:thin:@localhost:1521:xe"; 
		String user = "HR";
		String pass = "a123456";
	
		String query = "select BANNER from SYS.V_$VERSION";
		query = "select * from EMPLOYEES";
		try
		{
		stmt=conectarBBDD(classname, conexion, user, pass, query, conn, rset);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally //libero recursos, de "adentro a fuera" , ResultSet, Statment, Conexion
		{
			if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
		  	   
		}  

	}

}
