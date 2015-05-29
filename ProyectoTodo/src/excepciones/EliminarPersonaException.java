/**
 * 
 */
package excepciones;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class EliminarPersonaException extends NullPointerException {
	public static final String mensaje = "El nombre no existe";
	public EliminarPersonaException(){
		super(mensaje);
	}
}
