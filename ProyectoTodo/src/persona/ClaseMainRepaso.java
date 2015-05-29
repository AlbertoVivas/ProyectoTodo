/**
 * 
 */
package persona;

import java.io.IOException;
import java.util.ArrayList;

import excepciones.EliminarPersonaException;
import excepciones.EliminarPersonasVacioException;
import excepciones.InsertarPersonaException;
import excepciones.SerialInputException;
import excepciones.SerialOutputException;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class ClaseMainRepaso {

	/**
	 * @param args
	 * @throws InsertarPersonaException 
	 * @throws IOException 
	 */
	
	/*public static void mostrarListaPersonas(ArrayList<Persona> ar){
		
		
		
	}*/
	
	public static void main(String[] args) throws InsertarPersonaException, IOException {
		// TODO Auto-generated method stub
		ListaPersonas lp = new ListaPersonas();
		Persona p = new Persona("kk", 21);
		
		lp.mostrar();
		try{
		lp.deserializar();
		}catch (SerialInputException e){}
		
		lp.mostrar();
		
		try{
			lp.insertarPersona(p);
			}catch (InsertarPersonaException e){}
		
		lp.mostrar();
		
		try{
			lp.insertarPersona(p);
			}catch (InsertarPersonaException e){}
		
		/*lp.mostrar();
		
		try{
		lp.eliminarPersona(p);
		}catch (EliminarPersonaException e){
		}catch (EliminarPersonasVacioException e2){}
	 	
		lp.mostrar();*/
		try{
			lp.eliminarPersona(p);
			}catch (EliminarPersonaException e){
			}catch (EliminarPersonasVacioException e2){
			}catch (NullPointerException n){}
		/*lp.mostrar();
		
		try{
		lp.insertarPersona(p);
		}catch (InsertarPersonaException e){}
		
		lp.mostrar();
		try{
			lp.eliminarPersona(p);
			}catch (EliminarPersonaException e){
			}catch (EliminarPersonasVacioException e2){}
		lp.mostrar();*/
		p = new Persona("Alb", 30);
		try{
			lp.insertarPersona(p);
			}catch (InsertarPersonaException e){}
		
		lp.mostrar();
		p = new Persona("Mik", 28);
		try{
			lp.insertarPersona(p);
			}catch (InsertarPersonaException e){}
		lp.mostrar();
		p = new Persona("Tam", 28);
		try{
			lp.insertarPersona(p);
			}catch (InsertarPersonaException e){}
		lp.mostrar();
		p = new Persona("Iña", 35);
		try{
			lp.insertarPersona(p);
			}catch (InsertarPersonaException e){}
		lp.mostrar();
		
		try{
			lp.eliminarPersona(p);
			}catch (EliminarPersonaException e){
			}catch (EliminarPersonasVacioException e2){}
		lp.mostrar();
		
		
		
		
		//usando Array list
		/*ArrayList <Persona> alp= new ArrayList<Persona>();
		
		
		alp.add(p);
		p = new Persona("alb", 30);
		alp.add(p);
		p = new Persona("mik", 28);
		alp.add(p);
		p = new Persona("tam", 27);
		alp.add(p);
		System.out.println(alp.toString());
		alp.remove(p);
		System.out.println(alp.toString());
		alp.add(p);
		System.out.println(alp.toString());
		
		for (Persona per : alp) {
			System.out.println(per);
		}*/
		
		try{
		//System.out.println(lp.serializar());
		if (lp.serializar()){
			System.out.println("Guardado exitosamente!!!");
		}
		}catch (SerialOutputException e){}
		
		
	}

}
