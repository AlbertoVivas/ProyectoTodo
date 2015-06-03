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
 *Clase main de prueba de mi lectura de bd de oracle 
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
		ale=rdto.recuperarTodos();
		mostrarLista(ale);
		//recuperar una region segun su identificador
		ale=rdto.recuperarRegion(1);
		mostrarLista(ale);
		//crear una nueva region en la bd
		RegionsDTO newreg = new RegionsDTO(6, "Matrix");
		rdto.insertarRegion(newreg);
		ale=rdto.recuperarTodos();
		mostrarLista(ale);
	}
}
