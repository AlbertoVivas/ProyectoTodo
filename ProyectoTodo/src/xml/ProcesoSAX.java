//package org.microforum.cursojava;
package xml;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class ProcesoSAX {

	public static void main(String[] args) {  
		Libro libro = new Libro();
        LibroXML libroxml = new LibroXML(libro);
	      try {  
	         // Creamos nuestro objeto libro vacío  
	         //Libro libro = new Libro();  
	         // Creamos la factoria de parseadores por defecto  
	         XMLReader reader = XMLReaderFactory.createXMLReader();  
	         // Añadimos nuestro manejador al reader pasandole el objeto libro
	         //reader.setContentHandler(LibroXML);
	         reader.setContentHandler(libroxml);
	         //reader.setContentHandler(new LibroXML(libro));           
	         // Procesamos el xml de ejemplo  
	         //reader.parse(new InputSource(new FileInputStream("libro.xml")));  
	         reader.parse(new InputSource(new FileInputStream("libros.xml")));
	         
	         //System.out.println(libro.toString());    
	         System.out.println(libroxml.hmsl);
	         
	        /* Iterator i =libroxml.hmsl.entrySet().iterator();
	         while(i.hasNext()){
	        	 System.out.println(i.next());
	         }*/
	         
	      } catch (SAXException e) {  
	         e.printStackTrace();  
	      } catch (IOException e) {  
	         e.printStackTrace();  
	      }  
	  
	   }  
}
