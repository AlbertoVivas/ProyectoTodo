/**
 * 
 */
package excepciones;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class EliminarPersonasVacioException extends NullPointerException{
	public static final String mensaje= "Error al eliminar, no hay personas que eliminar";
	public EliminarPersonasVacioException(){
		super(mensaje);
	}

}
