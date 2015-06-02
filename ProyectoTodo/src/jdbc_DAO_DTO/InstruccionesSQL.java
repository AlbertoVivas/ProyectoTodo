/**
 * 
 */
package jdbc_DAO_DTO;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class InstruccionesSQL {
	//public static string consultaSueldo
	
	public static String consultaSueldo(){
		return "select * from EMPLOYEES WHERE salary>3000";
	}
}
