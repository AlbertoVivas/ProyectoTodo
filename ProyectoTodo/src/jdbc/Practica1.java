/**
 * 
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author Alberto Vivas
 *
 * 
 */

//Realizar un programa que consulte los empleados con un salario mayor a 3000. 
//Para cada empleado recuperado, crear un objeto Empleado e id conformando un 
//ArrayList de empleados. Finalmente, ordenar la lista por el salario, de mayor 
//a menor y mostrarla.

public class Practica1 {

	public static Statement conectarBBDD(String classname, String conexion,String user, String pass, Connection conn) throws SQLException, ClassNotFoundException {

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
		
		return stmt;
	}
	public static int camposDeTabla(String tabla){
		int respuesta =0;
		
		switch (tabla) {
		case "EMPLOYEES":
			respuesta = 11;
			break;
		case "DEPARTMENTS": 
			respuesta = 4;
			break;
		case "LOCATIONS": 
			respuesta = 6;
			break;
		case "COUNTRIES": 
			respuesta = 3;
			break;
		case "REGIONS": 
			respuesta = 2;
			break;
		case "JOB_HISTORY": 
			respuesta = 5;
			break;
		case "JOBS": 
			respuesta = 4;
			break;
		default:
			System.out.println("error!!! nombre no esta en la tabla");
			break;
		}
		
		
		
		return respuesta;
	}
	
	public static void muestraBdEnPantalla(String classname, String conexion,String user, String pass, Connection conn, String tabla) throws ClassNotFoundException, SQLException{
		Statement stmt = null;
		ResultSet rset = null;
		Class.forName(classname);
		conn = DriverManager.getConnection(conexion, user, pass);
		stmt = conn.createStatement();
		String query = "select * from "+tabla;
		rset = stmt.executeQuery(query);
		int tam_rset = camposDeTabla(tabla);
		while(rset.next()){
			for(int i=1;i<=tam_rset;i++){
				System.out.print(rset.getString(i)+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Connection conn = null;
		ResultSet rset = null;
		Statement stmt = null;
		String classname = "oracle.jdbc.driver.OracleDriver";
		String conexion = "jdbc:oracle:thin:@localhost:1521:xe"; 
		String user = "HR";
		String pass = "a123456";
		ListaEmpleados le = new ListaEmpleados();
	
		String query =null;
		try
		{
		stmt=conectarBBDD(classname, conexion, user, pass,conn);
		query = "select * from EMPLOYEES WHERE salary>3000";
		rset = stmt.executeQuery(query);
		
			while (rset.next()) {
					String employee_id = rset.getString(1);
					String first_name = rset.getString(2);
					String last_name = rset.getString(3);
					String email = rset.getString(4);
					String phone_number = rset.getString(5);
					String hire_date = rset.getString(6);
					String job_id = rset.getString(7);
					int salary = rset.getInt(8);
					String commision_pct = rset.getString(9);
					String mannager_id = rset.getString(10);
					String department_id = rset.getString(11);
					le.getListaEmpleados().add(new Empleado(employee_id, first_name, last_name,	email, phone_number, hire_date, job_id,	salary, commision_pct, mannager_id,	department_id));	
			}
				
				//ordenamos por salario
				Collections.sort(le.getListaEmpleados()); 
				//mostramos por consola
				Iterator<Empleado> it = le.getListaEmpleados().iterator();
				while(it.hasNext()){
					System.out.println(it.next());
				}
				
			muestraBdEnPantalla(classname, conexion, user, pass, conn, "JOBS");
			
			System.out.println("----------------");
			muestraBdEnPantalla(classname, conexion, user, pass, conn, "REGIONS");
			
			
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
