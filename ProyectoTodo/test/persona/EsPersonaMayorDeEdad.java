/**
 * 
 */
package persona;

import org.hamcrest.Description;
import org.junit.internal.matchers.TypeSafeMatcher;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class EsPersonaMayorDeEdad extends TypeSafeMatcher<Persona> {

	/* (non-Javadoc)
	 * @see org.hamcrest.SelfDescribing#describeTo(org.hamcrest.Description)
	 */
	@Override
	public void describeTo(Description arg0) {
		arg0.appendText("Resultado esperado: si la edad de pesona es 18 o mas es cierto que es mayor de edad ");
		arg0.appendText("Resultado optenido: la persona es menor");
		
	}

	/* (non-Javadoc)
	 * @see org.junit.internal.matchers.TypeSafeMatcher#matchesSafely(java.lang.Object)
	 */
	@Override
	public boolean matchesSafely(Persona arg0) {
		boolean respuesta = false;
		// TODO Auto-generated method stub
		if (arg0.getEdad()>=18){
			respuesta = true;
		}else{
			respuesta = false;
		}
		
		
		return respuesta;
	}
	

}
