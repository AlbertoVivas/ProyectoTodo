/**
 * 
 */
package persona;

/**
 * @author Alberto Vivas
 *
 * 
 */

//package val.examples.basic;
import java.io.Serializable;

public class Persona implements Serializable, Comparable<Persona> {
	
	private int edad;
	private String nombre;
	
	
	public Persona(String nombre, int edad) {
		this.edad = edad;
		this.nombre = nombre;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		//return "nombre: "+this.nombre + " edad:" + this.edad;
		return this.nombre+" "+this.edad;
	}


	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Persona arg0) {
		// TODO Auto-generated method stub
		int respuesta = 0;
		
		if (this.edad > arg0.getEdad()){
			respuesta = 1;
		}else{
			if(this.edad < arg0.getEdad()){
				respuesta = -1;
			}else{// this.edad == arg0.getEdad()
				respuesta = 0;
			}
		}
		
		return respuesta;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	//@Override
	public boolean equals(Persona p) {
		return p.getNombre().equals(this.getNombre())&&p.getEdad()==this.getEdad();
	}

	
}