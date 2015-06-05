/**
 * 
 */
package evaluacion.primera;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * @author Alberto Vivas
 *
 *Main test class of the methods of my java code
 */
public class mainEvaluacionPrimera {
	public static void mostrarLista(ArrayList<RegionsDTO> ale){
		Iterator<RegionsDTO> it = ale.iterator();
		while(it.hasNext()){
			System.out.print(it.next());
		}	
	}
	

	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ArrayList<RegionsDTO> ale = new ArrayList<RegionsDTO>();
		RegionsDAO rdto = new RegionsDAO();
		//recuperar toda la lista de regiones
		System.out.println("recuperar toda la lista de regiones");
		ale=rdto.recuperarTodos();
		mostrarLista(ale);
		//recuperar una region segun su identificador
		System.out.println("\nrecuperar una region segun su identificador\n");
		System.out.println((rdto.recuperarRegion(1).toString()));
		//crear una nueva region en la bd
		System.out.println("\ncrear una nueva region en la bd \n");
		RegionsDTO newreg = new RegionsDTO(6, "Matrix");
		rdto.insertarRegion(newreg);
		ale=rdto.recuperarTodos();
		mostrarLista(ale);
		//modificar una region
		System.out.println("\n modificar una region \n");
		RegionsDTO reg = new RegionsDTO(6, "Matrix");
		RegionsDTO reg_m = new RegionsDTO(6, "The Matrix");
		rdto.modificarRegion(reg, reg_m);
		ale=rdto.recuperarTodos();
		mostrarLista(ale);
	}
}
