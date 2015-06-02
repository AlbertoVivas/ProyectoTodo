/**
 * 
 */
package jdbc_DAO_DTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class Main {

	public static void mostrarLista(ArrayList<EmpleadoDTO> ale){
		Iterator<EmpleadoDTO> it = ale.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ArrayList<EmpleadoDTO> ale = new ArrayList<EmpleadoDTO>();
		EmpleadoDAO edao = new EmpleadoDAO();
		ale=edao.recuperarTodos();
		mostrarLista(ale);
	}
}
