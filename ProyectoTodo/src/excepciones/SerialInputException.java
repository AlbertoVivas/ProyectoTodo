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
public class SerialInputException extends IOException {
public static final String mensaje = "Error al leer el fichero ";
	public SerialInputException() {
		super(mensaje);
	}
}
