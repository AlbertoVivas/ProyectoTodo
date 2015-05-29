/**
 * 
 */
package persona;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class TestPersona {
	
	public static Persona persona;
	public static String nombre;
	public static int edad;
	
	/*@BeforeClass
	public static void iniciaClase(){
		persona = new Persona(nombre, edad);
	}*/
	
	@Before
	public void inicia(){
		nombre="alb";
		edad = 30;
		persona = new Persona(nombre, edad);
	}

	/**
	 * Test method for {@link persona.Persona#Persona(java.lang.String, int)}.
	 */
	@Test
	public void testPersona() {
		//assertEquals("Persona alb 30", persona, new Persona("alb",30));
		Persona p1 =new Persona("alb",30);
		Persona p2 = new Persona("alb",30);
		assertTrue(p1.equals(p2));
	}

	/**
	 * Test method for {@link persona.Persona#getEdad()}.
	 */
	@Test
	public void testGetEdad() {
		assertEquals("edad 30", 30, persona.getEdad());
	}

	/**
	 * Test method for {@link persona.Persona#setEdad(int)}.
	 */
	@Test
	public void testSetEdad() {
		persona.setEdad(20);
		assertEquals("set edad 20", 20, persona.getEdad());
	}

	/**
	 * Test method for {@link persona.Persona#getNombre()}.
	 */
	@Test
	public void testGetNombre() {
		assertEquals("Nombre alb", "alb", persona.getNombre());
	}

	/**
	 * Test method for {@link persona.Persona#setNombre(java.lang.String)}.
	 */
	@Test
	public void testSetNombre() {
		persona.setNombre("vale");
		assertEquals("Set nombre vale", "vale", persona.getNombre());
		
	}

	/**
	 * Test method for {@link persona.Persona#toString()}.
	 */
	@Test
	public void testToString() {
		assertEquals("To string alb 30","alb 30",persona.toString());
	}

	/**
	 * Test method for {@link persona.Persona#compareTo(persona.Persona)}.
	 */
	@Test
	public void testCompareTo1() {
		Persona p1 = new Persona("alb", 30);
		Persona p2 = new Persona("Mikel", 28);
		assertEquals("alb 30 > mikel 28",1,p1.compareTo(p2));
	}
	
	@Test
	public void testCompareTo_1() {
		Persona p1 = new Persona("alb", 30);
		Persona p2 = new Persona("Mikel", 28);
		assertEquals("alb 30 > mikel 28",-1,p2.compareTo(p1));
	}
	
	@Test
	public void testCompareTo0() {
		Persona p1 = new Persona("alb", 30);
		Persona p2 = new Persona("alb", 30);
		assertEquals("alb 30 > mikel 28",0,p1.compareTo(p2));
	}
}
