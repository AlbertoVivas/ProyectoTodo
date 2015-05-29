/**
 * 
 */
package excepciones;

import persona.ListaPersonas;

//import curso.repaso.basico.ListaPersonas;

/**
 * @author Alberto Vivas
 *
 * 
 */

//package val.examples.basic.exceptions;

//import val.examples.basic.ListaPersonas;

public class InsertarPersonaException extends Exception{
	
	public static final String mensaje = "Numero de personas excecido. Máximo " + ListaPersonas.CAPACIDAD + " personas";
	
	//agrego esto
	
	public InsertarPersonaException(){
		super(mensaje);
	}
	
}