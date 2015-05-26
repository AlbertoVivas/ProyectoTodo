/**
 * 
 */
package xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class PracticaJDOM {
	
	
	public static Element parser() throws FileNotFoundException, JDOMException, IOException{
		Element respuesta= null;
		//CREAMOS EL PARSER
		SAXBuilder builder = new SAXBuilder();
		// Construimos el arbol DOM a partir del fichero xml
		Document documentJDOM = builder.build(new FileInputStream("libros.xml"));

		//MOSTRAMOS EL DOCUMENTO
		Element raiz = documentJDOM.getRootElement();
		
		respuesta= raiz;
		return respuesta;
	}
	
	public static ArrayList<Libro> crearArrayList(Element elemento){
		ArrayList<Libro> respuesta = new ArrayList<Libro>();
		
		Libro nlibro = null;
		String etiqueta = "";
		String valor = "";
		String titulo = "";
		String autor = "";
		String anyo = "";
		String isbn = "";
		String editorial = "";
		
		
		//Con esto obtengo todos los datos de los libros que tengo en el fichero xml
		List<Element> libros = elemento.getChildren();
		for (Element libro : libros) {			
			List<Element> detalles = libro.getChildren();
			
			isbn=libro.getAttributeValue("isbn");
			
			for (Element detalle : detalles) {
				etiqueta=detalle.getName();
				valor=detalle.getValue();
				
				switch (etiqueta) {
				case "titulo":
					titulo=valor;
					break;
				case "autor":
					autor=valor;
					break;
				case "anyo":
					anyo=valor;
					break;
				case "editorial":
					editorial=valor;
					break;
				}
			}
			//creo mi nuevo libro
			nlibro = new Libro(isbn, titulo, autor, anyo, editorial);
			//lo añado el array list de libros
		    respuesta.add(nlibro);
		}
		
		return respuesta;
	}
	
	
	public static Document generarmeDocumento(ArrayList<Libro> arraylistlibro) {
		Element rootElement = new Element("Libros");
		Document respuesta = new Document(rootElement);
		int n_libros = 0;

		// me creo la clase padre y me creo mi nuevo documento.
		// Element padre = new Element("Libros");
		// Document documentoJDOM = new Document(padre);
		// con los siguientes pasos, voy añadiendo cada libro del array list

		Iterator<Libro> il = arraylistlibro.iterator();

		while (il.hasNext()) {
			Element nuevoLibro = new Element("Libro");
			Libro nl_il = il.next();// tengo un libro
			nuevoLibro.setAttribute("isbn", nl_il.getIsbn());

			Element tituloE = new Element("titulo");
			tituloE.addContent(nl_il.getTitulo());

			Element anyoE = new Element("anyo");
			anyoE.addContent(nl_il.getAnyo());

			Element autorE = new Element("autor");
			autorE.addContent(nl_il.getAutor());

			Element editorialE = new Element("editorial");
			editorialE.addContent(nl_il.getEditorial());

			nuevoLibro.addContent(tituloE);
			nuevoLibro.addContent(autorE);
			nuevoLibro.addContent(anyoE);
			nuevoLibro.addContent(editorialE);
			n_libros++;
			rootElement.addContent(nuevoLibro);
		}

		// Añado el nuevo nodo que undica el total de libros.
		//Element numLibros = new Element("total");
		//numLibros.addContent("" + n_libros);
		//rootElement.addContent(numLibros);
		
		//De esta manera incluyo el total de libros como un atributo de libros
		rootElement.setAttribute("total",""+n_libros);

		return respuesta;
	}
	
	
	
	
	public static void serializame(Document documento) throws IOException{
		
		//SERIALIZO EL DOCUMENT A UN FICHERO DE SALIDA
	    
	    Format format = Format.getPrettyFormat();
	    // Creamos el serializador con el formato deseado  
	    XMLOutputter xmloutputter = new XMLOutputter(format);
	    // Serializamos el document parseado  
	    String docStr = xmloutputter.outputString(documento); 
	    //Volcamos en un fichero
	    FileWriter fw = new FileWriter("libroPracticaJdomSalida.xml");
	    fw.write(docStr);
	    fw.close();
	}
	
	
	
	
	
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws JDOMException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, JDOMException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Libro> all = new ArrayList<Libro>();
		Element raiz = parser();
		Document doc = null;
		
		//me creo el array list
		all=crearArrayList(raiz);
		
		//Ya tenemos en el array list todos los libros (pero ahora estan desordenados)
		
		//Utilizo collections para ordenar (recordar que para ordenar los libros en mi
		//caso por titulo, hay que agregar a libros que implemente collections y sobre-
		//escribir el compareTo para que compare por el titulo)
		Collections.sort(all);
		
		//Genero nuevo documento
		doc=generarmeDocumento(all);
		
		//serializo 
		serializame(doc);
		System.out.println("Fin programa");
	}
}


