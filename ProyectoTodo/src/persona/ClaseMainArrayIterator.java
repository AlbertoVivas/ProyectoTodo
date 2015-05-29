/**
 * 
 */
package persona;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import excepciones.EliminarPersonaException;
import excepciones.EliminarPersonasVacioException;
import excepciones.InsertarPersonaException;
import excepciones.NotaException;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class ClaseMainArrayIterator {

	/**
	 * @param args
	 * @throws InsertarPersonaException 
	 * @throws NotaException 
	 */
	public static void main(String[] args) throws InsertarPersonaException, NotaException {
		// TODO Auto-generated method stub
		
		
		Persona p1 = new Persona("alb", 30);
		Persona p2 = new Persona("mik", 28);
		Persona p3 = new Persona("tam", 27);
		Persona p4 = new Persona("iña", 35);
		
		//usando Array list
		//ArrayList<Persona> alp = new ArrayList<Persona>();
		
		//usando iterator
		
		ListaPersonas lp = new ListaPersonas();
		lp.mostrar();
		try{
			lp.insertarPersona(p1);
			}catch (InsertarPersonaException e){
			}catch (NullPointerException n){}
		lp.mostrar();
		try{
			lp.insertarPersona(p2);
			}catch (InsertarPersonaException e){
			}catch (NullPointerException n){}
		try{
			lp.insertarPersona(p3);
			}catch (InsertarPersonaException e){
			}catch (NullPointerException n){}
		lp.mostrar();
		Iterator<Persona> ip = lp.iterator();
		System.out.println("iterator");
		while(ip.hasNext()){
			System.out.println(ip.next().toString());
		}
		try{
		ip.remove();
		}catch(EliminarPersonaException e){
		}catch(EliminarPersonasVacioException e1){
		}catch(NullPointerException n){}
		
		ip = lp.iterator();
		while(ip.hasNext()){
			System.out.println(ip.next().toString());
		}
		try{
			ip.remove();
			}catch(EliminarPersonaException e){
			}catch(EliminarPersonasVacioException e1){
			}catch(NullPointerException n){}
			
			ip = lp.iterator();
			while(ip.hasNext()){
				System.out.println(ip.next().toString());
			}
		
		System.out.println("fin iterator");
		
		
		
		
		Persona p = new Persona("kk", 999);
		Map <String, Persona> mapaPersonas = new HashMap<String, Persona>();
		mapaPersonas.put(p.getNombre(),p);
		
		System.out.println(mapaPersonas);
		p = new Persona("kk", 100005);
		mapaPersonas.put(p.getNombre()+"xxx",p);
		System.out.println(mapaPersonas.toString());
		
		//MapToString mts = new MapToString(mapaPersonas);
		//System.out.println(mts);
		
		
		Alumno a1 = new Alumno("alb", 30, 9);
		Alumno a2 = new Alumno("mik", 28, 10);
		Alumno a3 = new Alumno("iña", 35, 4);//A sugerencia de tamara!!! xD
		Alumno a4 = new Alumno("Tama", 28, 8);
		TreeMap<Integer , Persona> tmmp = new TreeMap<>();
		tmmp.put(a1.getNota(),a1);
		tmmp.put(a2.getNota(),a2);
		tmmp.put(a3.getNota(),a3);
		tmmp.put(a4.getNota(),a4);
		
		System.out.println(tmmp);
		
		LinkedHashMap<Integer, Persona> lhmmp = new LinkedHashMap<>();
		lhmmp.put(a1.getNota(),a1);
		lhmmp.put(a2.getNota(),a2);
		lhmmp.put(a3.getNota(),a3);
		lhmmp.put(a4.getNota(),a4);
		
		System.out.println(lhmmp);
		
		Map<String, Persona> mi_mapa = new MapToString();
		mi_mapa.put(p1.getNombre(), p1);
		mi_mapa.put(p2.getNombre(), p2);
		mi_mapa.put(p3.getNombre(), p3);
		System.out.println(mi_mapa);
		
		
		Set<Persona> tsp = new TreeSet<Persona>();
		tsp.add(p1);
		System.out.println(tsp);
		tsp.add(p2);
		System.out.println(tsp);
		tsp.add(p3);
		System.out.println(tsp);
		tsp.add(p4);
		System.out.println(tsp);
		
		System.out.println("Collections");
		ArrayList<Persona> alp = new ArrayList<Persona>();
		alp.add(p1);
		alp.add(p2);
		alp.add(p3);
		alp.add(p4);
		System.out.println(alp);
		
		Collections.sort(alp, new OrdenarPorNombre());
		System.out.println(alp);
		Collections.sort(alp, new OrdenarPorEdad());
		System.out.println(alp);
		
	}

}
