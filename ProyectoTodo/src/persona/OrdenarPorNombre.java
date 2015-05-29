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
public class OrdenarPorNombre implements Comparator<Persona>{

	@Override
	public int compare(Persona arg0, Persona arg1) {
		return arg0.getNombre().compareTo(arg1.getNombre());
	}
}
