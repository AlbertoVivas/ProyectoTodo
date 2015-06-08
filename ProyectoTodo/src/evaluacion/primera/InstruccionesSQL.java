/**
 * 
 */
package evaluacion.primera;

/**
 *This class wrap, all sql instructions used by others methods
 * @author Alberto Vivas
 *
 * 
 */
public class InstruccionesSQL {
	
	public static String consultaRegiones(){
		return "select * from REGIONS";
	}

	/**
	 * @return
	 */
	public static String consultaregion(int region_id) {
		return "select * from REGIONS where region_id="+region_id;
	}
	
	public static String insertarRegion(){
		return "INSERT INTO REGIONS (region_id,region_name) VALUES (?,?)";
	}
	public static String modificarRegion(){
		return "UPDATE REGIONS SET region_name=? WHERE region_name=?";
	}
	public static String borrarRegion(){
		return "DELETE FROM REGIONS WHERE region_id=? AND region_name=?";
	}
	
}
