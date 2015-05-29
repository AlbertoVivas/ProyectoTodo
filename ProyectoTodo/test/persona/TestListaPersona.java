/**
 * 
 */
package persona;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import excepciones.InsertarPersonaException;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class TestListaPersona {

	public static ListaPersonas lp;
	public static Persona p1 = new Persona("Alb",30);
	public static Persona p2 = new Persona("Mikel",28);
	public static Persona p3 = new Persona("Jai",40);
	
	
	@Before
	public void iniciarClase(){
		lp = new ListaPersonas();
		try {
			lp.insertarPersona(p1);
			lp.insertarPersona(p2);
			lp.insertarPersona(p3);
		} catch (InsertarPersonaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Test method for {@link persona.ListaPersonas#ListaPersonas()}.
	 */
	@Test
	public void testListaPersonas() {
		assertNotNull(lp);
	}

	/**
	 * Test method for {@link persona.ListaPersonas#getListaPersonas()}.
	 */
	@Test
	public void testGetListaPersonas() {
		Persona [] ap = new Persona[10];
		ap[0]=p1;
		ap[1]=p2;
		ap[2]=p3;
		assertArrayEquals("test get array",ap,lp.getArrayPersonas());
	}

	/**
	 * Test method for {@link persona.ListaPersonas#buscarPersona(java.lang.String)}.
	 */
	@Test
	public void testBuscarPersonaString() {
		assertEquals("Test buscar p1",p1,lp.buscarPersona("Alb"));
	}

	/**
	 * Test method for {@link persona.ListaPersonas#buscarPersona(int)}.
	 */
	
	@Test
	public void testBuscarPersonaInt() {
		assertEquals("Test buscar p1",p1,lp.buscarPersona(30));
	}


	/**
	 * Test method for {@link persona.ListaPersonas#serializar()}.
	 */
	/*@Test
	public void testSerializar() {
		fail("Not yet implemented");
	}*/

	/**
	 * Test method for {@link persona.ListaPersonas#deserializar()}.
	 */
	/*@Test
	public void testDeserializar() {
		fail("Not yet implemented");
	}*/

	/**
	 * Test method for {@link persona.ListaPersonas#insertarPersona(persona.Persona)}.
	 */
	@Test
	public void testInsertarPersona() {
		Persona [] ap = new Persona[10];
		ap[0]=p1;
		ap[1]=p2;
		ap[2]=p3;
		Persona p4 = new Persona("Gio", 28);
		ap[3]=p4;
		try {
			lp.insertarPersona(p4);
		} catch (InsertarPersonaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertArrayEquals("test insertar persona",ap,lp.getArrayPersonas());
	}

	/**
	 * Test method for {@link persona.ListaPersonas#numeroPersonas()}.
	 */
	@Test
	public void testNumeroPersonas() {
		assertEquals("Test num per",3,lp.numeroPersonas());
	}

	/**
	 * Test method for {@link persona.ListaPersonas#getCapacidad()}.
	 */
	@Test
	public void testGetCapacidad() {
		assertEquals("Test capacidad",10,lp.getCapacidad());
	}

	/**
	 * Test method for {@link persona.ListaPersonas#getArrayPersonas()}.
	 */
	
	@Test
	public void testGetArrayPersonas() {
		Persona [] ap = new Persona[10];
		ap[0]=p1;
		ap[1]=p2;
		ap[2]=p3;
		assertArrayEquals("test get array",ap,lp.getArrayPersonas());
	}

	/**
	 * Test method for {@link persona.ListaPersonas#estaLlena()}.
	 */
	@Test
	public void testEstaLlena() {
		assertFalse(lp.estaLlena());
	}

	/**
	 * Test method for {@link persona.ListaPersonas#mostrar()}.
	 */
	/*@Test
	public void testMostrar() {
		assertEquals("test mostrar","Persona (0): Alb 30 Persona (1): Mikel 28 Persona (2): Jai 40",lp.mostrar());
		
	}*/

	/**
	 * Test method for {@link persona.ListaPersonas#eliminarPersona(persona.Persona)}.
	 */
	@Test
	public void testEliminarPersona() {
		Persona [] ap = new Persona[10];
		ap[0]=p1;
		ap[1]=p2;
		lp.eliminarPersona(p3);
		assertArrayEquals("test eliminar persona p3", ap, lp.getListaPersonas());
	}

	@Test
	public void testEsmayorPersona(){
		//Persona p = new Persona("tete", 2);
		assertThat(lp.buscarPersona("Alb"), new EsPersonaMayorDeEdad());
		//assertThat(p, new EsPersonaMayorDeEdad());
	}

}
