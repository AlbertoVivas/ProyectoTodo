/**
 * 
 */
package xml;

import java.util.HashMap;

/**
 * @author Alberto Vivas
 *
 * Tengo aca la clase lista libros, la cual usa los libros como objeto.
 * Como añadido, sobreescribo el metodo to string para cambiar el syso
 */
public class ListaLibros{

	/**
	 * Me creo el hashmap que contendra la coleccion de libros.
	 */
	//private HashMap<String, Libro> hm_libro = new HashMap<String, Libro>();	
	private HMlibroToString hm_libro = new HMlibroToString();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListaLibros ll = new ListaLibros();
		
		Libro l1 = new Libro("9788496208568", "CANCION DE HIELO Y FUEGO", "JRR Martin", "2007", "GIGAMESH");
		Libro l2 = new Libro("9788445071793", "EL SEÑOR DE LOS ANILLOS", "J.R.R. TOLKIEN", "2002", "MINOTAURO");
		Libro l3 = new Libro("9788427201187", "DIVERGENTE", "VERONICA ROTH", "2011", "MOLINO");
		
		ll.hm_libro.put(l1.getIsbn(), l1);
		ll.hm_libro.put(l2.getIsbn(), l2);
		ll.hm_libro.put(l3.getIsbn(), l3);
		
		System.out.println(ll.hm_libro);
		
	}

}
