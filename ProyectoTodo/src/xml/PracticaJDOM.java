/**
 * 
 */
package xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

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
	
	
	
	
	
	
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws JDOMException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, JDOMException, IOException {
		// TODO Auto-generated method stub
		Element raiz = parser();
		

	}

}
