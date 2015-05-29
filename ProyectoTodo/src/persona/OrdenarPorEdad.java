/**
 * 
 */
package persona;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class OrdenarPorEdad implements Comparator<Persona>{

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Persona arg0, Persona arg1) {
		int respuesta = 0;
		
		if (arg0.getEdad()>arg1.getEdad()) {
			respuesta = 1;
		} else {
			if (arg0.getEdad()<arg1.getEdad()) {
				respuesta = -1;
			} else {
				respuesta = 0;
			}
		}
		return respuesta;
	}

	

}
