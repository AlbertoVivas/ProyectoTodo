/**
 * 
 */
package jdbc;

import java.util.ArrayList;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class ListaEmpleados {
	private ArrayList<Empleado> listaEmpleados;
	
	public ListaEmpleados(){
		this.listaEmpleados= new ArrayList<Empleado>();
	}
	
	public ArrayList<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public void insertarEmpleado(Empleado em){
		listaEmpleados.add(em);
	}
}
