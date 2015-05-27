/**
 * 
 */
package jUnit;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class TestOperaciones {

	public static Operaciones op;
	
	@BeforeClass
	public static void iniciaClase() {
		op = new Operaciones();
	}
	
	/**
	 * Test method for {@link jUnit.Operaciones#suma(int, int)}.
	 */
	@Test
	public void testSuma() {
		assertEquals("5+3=8", 8, op.suma(5, 3));
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link jUnit.Operaciones#multiplicacion(int, int)}.
	 */
	@Test
	public void testMultiplicacion() {
		assertEquals("5*3=15", 15, op.multiplicacion(5, 3));
	}

	/**
	 * Test method for {@link jUnit.Operaciones#division(int, int)}.
	 */
	@Test
	public void testDivision() {
		assertEquals("5/3=1", 1, op.division(5, 3));
	}

	/**
	 * Test method for {@link jUnit.Operaciones#resta(int, int)}.
	 */
	@Test
	public void testResta() {
		assertEquals("5-3=8", 2, op.resta(5, 3));
	}
	
	@AfterClass
	public static void finalClase(){
		op=null;
	}

}
