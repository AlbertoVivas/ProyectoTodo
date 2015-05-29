/**
 * 
 */
package persona;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Spliterator;
import java.util.function.Consumer;

import org.apache.log4j.Logger;

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
public class ListaPersonas implements Iterable<Persona> {
	
	private final static Logger log = Logger.getLogger("mylog");
	public static final int CAPACIDAD = 10;
	private Persona[] array_personas;
	/**
	 * Nuevo constructor, sobrecargando al constructor por defecto 
	 */
	public ListaPersonas()
	{
		this.array_personas = new Persona [CAPACIDAD];
		log.trace("Invocado constructor de Lista persona");
	}

	/**
	 * con esto obtengo la lista de las personas
	 * @return
	 */
	public Persona[] getListaPersonas ()
	{
		return this.array_personas;
		}
	
	/**
	 * Con este metodo nos permite buscar una persona por su nombre,
	 * en caso de encontrarla nos devuelve el objeto persona, y en 
	 * caso de que no nos devuelve null.
	 * @param nombre
	 * @return
	 */
	public Persona buscarPersona (String nombre)
	{
		Persona respuesta = null;
		boolean encontrado = false;
		int contador = 0;
		if((numeroPersonas()!= 0)){
			while((!encontrado)&&(contador < numeroPersonas())){
				if(nombre.equals(array_personas[contador].getNombre())){
					encontrado = true;
					respuesta = array_personas[contador];
				}
				contador++;
			}
		}
		log.trace("Persona buscada!!!");
		return respuesta;
	}
	/**
	 * Con este metodo nos permite buscar una persona por su edad,
	 * en caso de encontrarla nos devuelve el objeto persona, y en 
	 * caso de que no nos devuelve null.
	 * @param edad
	 * @return
	 */
	
	public Persona buscarPersona (int edad)
	{
		Persona respuesta = null;
		boolean encontrado = false;
		int contador = 0;
		if((numeroPersonas()!= 0)){
			while((!encontrado)&&(contador < numeroPersonas())){
				if(edad==(array_personas[contador].getEdad())){
					encontrado = true;
					respuesta = array_personas[contador];
				}
				contador++;
			}
		}
		return respuesta;
	}
	/**
	 * Con este metodo, busco todas las personas que tengan una edad
	 * @param edad
	 * @return
	 */
	public Persona [] buscarPersonasPorEdad(int edad){
		Persona [] respuesta= null;		
		Persona [] rpta_provisional = new Persona[numeroPersonas()];
		int j = 0;
		int numRpta = 0;
		//busco las personas que cohinciden y las guardo en un array provisional
		//del tamaño del numero de personas que tengo
		for (int i = 0; i < numeroPersonas(); i++) {
			if (edad == (array_personas[i].getEdad())) {
				rpta_provisional[j]=array_personas[i];
				j++;		
			}	
		}
		//calculo el tamaño exacto del array para respuesta sin nulos
		for (int i = 0; i < rpta_provisional.length; i++) {
			if (rpta_provisional[i] != null){
				numRpta++;
			}
		}
		//creo mi respuesta
		respuesta = new Persona [numRpta];
		j=0;
		//vuelco los datos en respuesta
		for (int i = 0; i < numRpta; i++) {
			if(rpta_provisional[i] != null){
				respuesta[j]=rpta_provisional[i];
			}
		}
		return respuesta;
	}

	public boolean serializar () throws IOException
	{
		//Hacer uso del fichero de propiedades serializa.properties, 
		//para obtener de él el valor de la clave destino, 
		//que representa el nombre del fichero de salida
		boolean respuesta = false;
		FileInputStream fis = new FileInputStream("serializa.properties");
		Properties properties = new Properties();
		
		ObjectOutputStream oos = null;
		File file = null;
		try{
		properties.load(fis);//cargo las propiedades de serializa	
		file = new File(properties.getProperty("destino"));
		file.createNewFile();
		oos = new ObjectOutputStream(new FileOutputStream(properties.getProperty("destino")));
		oos.writeObject(array_personas);
		respuesta = true;
		}catch (Exception e ){
			System.out.println("Error al escribir el fichero "+properties.getProperty("destino"));
			log.error("Error al escribir el fichero");
			throw new SerialOutputException(); 
		}finally{
			oos.close();
		}
		return respuesta;
	}
	/**
	 * Con este metodo, recupero las personas que estan almacenadas en un 
	 * archivo, el cual viene dado por properties
	 * @return
	 * @throws IOException 
	 */
	public boolean deserializar() throws IOException
	//public boolean deserializar() throws SerialInputException
	{
		boolean respuesta = false;
		FileInputStream fis = new FileInputStream("serializa.properties");
		Properties properties = new Properties();
		
		ObjectInputStream ois = null;
		File file = null;
		try
		{
			
			properties.load(fis);//cargo las propiedades de serializa	
			file = new File(properties.getProperty("destino"));
			file.createNewFile();
			ois = new ObjectInputStream(new FileInputStream(properties.getProperty("destino")));
			this.array_personas =(Persona [])ois.readObject();
			respuesta = true;
		}
		catch (Exception e )
		{
			System.out.println("Error al escribir el fichero "+properties.getProperty("destino"));
			log.error("Error al escribir el fichero");
			throw new SerialInputException();
		}
		finally
			{
				ois.close();
			}
		return respuesta;	
	}
	
		
	
	public void insertarPersona (Persona p) throws InsertarPersonaException
	{//no se puede insertar una persona si es igual
		if (!estaLlena()){//si tengo espacio para insertar	
			if(numeroPersonas()!=0){
				if(buscarPersona(p.getNombre())== null) {
					//System.out.println("num de per "+numeroPersonas() );
					array_personas[numeroPersonas()]=p;
				
				}else{
					System.out.println("Ya existe esa persona");
					log.debug("Ya existe esa persona");
				}
			}else{
				array_personas[0]=p;
			}
		}else{
			//System.out.println("Capacidad limite alcanzada!!!");
			log.error("Numero de personas excecido. Máximo");
			throw new InsertarPersonaException();
		}
		
		
		
	}
	
	public int numeroPersonas()
	{
		int respuesta = 0;
		for (int i = 0; i < CAPACIDAD; i++) {
			if(this.array_personas[i]!=null){
				respuesta++;
			}
		}
		return respuesta;
	}
	
	public int getCapacidad(){
		return this.CAPACIDAD;
	}
	public Persona[] getArrayPersonas(){
		return this.array_personas;
	}
	
	public boolean estaLlena()
	{
		return numeroPersonas()==CAPACIDAD;
	}
	
	public void mostrar()
	{
		if (numeroPersonas()>0)
		for (int i = 0; i < numeroPersonas(); i++) {
			System.out.println("Persona("+(i+1)+"): "+array_personas[i].toString());
		}else{
			System.out.println("No hay personas que mostrar");
		}
	}
	public void eliminarPersona(Persona p){
		int posicionBorrar = -1;
		int contador = 0;
		int numPer =numeroPersonas();
		
		//System.out.println(!buscarPersona(p.getNombre()).getNombre().equals(null));
		
		if(numPer!=0){
			if(!(buscarPersona(p.getNombre()).getNombre().equals(null))){
			
				while ((posicionBorrar ==-1)&&(contador < numeroPersonas())) {
					if(p.getNombre().equals(array_personas[contador].getNombre())){
						posicionBorrar = contador;	
					}	
					contador++;
				}
				if (posicionBorrar == -1){
					System.out.println("El nombre no existe!!!");
					throw new EliminarPersonasVacioException();
				}else{
					int j=0;
					for (int i = 0; i < CAPACIDAD; i++) {
						if(i!=posicionBorrar){
							array_personas[j]=array_personas[i];
							j++;
						}	
					}
					array_personas[numPer]=null;
				}	
				
				
			}else{
				System.out.println("No se puede borrar una persona que no existe");
				log.debug("No se puede borrar una persona que no existe");
				throw new EliminarPersonaException();
			}	
		}else{
			System.out.println("No hay personas que borrar");
			log.debug("No hay personas que borrar");
			throw new EliminarPersonasVacioException();
		}
		
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Iterable#forEach(java.util.function.Consumer)
	 */
	@Override
	public void forEach(Consumer<? super Persona> arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<Persona> iterator() {
		// TODO Auto-generated method stub
		return new Recorrer(this);
	}

	/* (non-Javadoc)
	 * @see java.lang.Iterable#spliterator()
	 */
	@Override
	public Spliterator<Persona> spliterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

