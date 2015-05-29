/**
 * 
 */
package excepciones;

import java.io.IOException;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class SerialOutputException extends IOException {
	public static final String mensaje = "Error al leer el fichero ";
	
	public SerialOutputException() {
		super(mensaje);
	}
}
