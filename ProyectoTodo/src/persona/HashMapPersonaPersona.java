/**
 * 
 */
package persona;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import excepciones.MainUsing;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class HashMapPersonaPersona {
	//recibo un hashmap que tiene clave y valor
	//ordeno los valores
	//en hashmap el metodo.values y lo meto en una lista
	//ordeno la lista
	//recorro esa coleccion y los meto en un Linkedhashmap que
	//respeto el orden de insersion
	//
	
	public LinkedHashMap<Persona, Persona> ordenarHMPP(HashMap<Persona, Persona> hm){
		LinkedHashMap<Persona, Persona> lhmpp = new LinkedHashMap<Persona, Persona>();
		TreeMap<Persona,Persona> tmpp = new TreeMap<Persona,Persona>();
		tmpp.putAll(hm);
		lhmpp.putAll(tmpp);
		return lhmpp;
	}
	
	public Map<Persona, Integer> cambiaKxVhm(HashMap<Integer, Persona> hm){
		HashMap<Persona, Integer> respuesta = new HashMap<Persona, Integer>();
		Iterator iterador = hm.entrySet().iterator();
		
		while(iterador.hasNext()){
			Map.Entry<Integer,Persona> e = (Map.Entry<Integer,Persona>)iterador.next();
			respuesta.put((Persona)e.getValue(), (Integer)e.getKey());
		}
		return respuesta;
	}
	
	public LinkedHashMap<Persona, Persona> ordenarHMPPporvalue(HashMap<Persona, Persona> hm){
		LinkedHashMap<Persona, Persona> lhmpp = new LinkedHashMap<Persona, Persona>();
		TreeSet<Persona> tspp = new TreeSet<Persona>();
		HashMap<Persona, Persona> mapa = new HashMap<Persona, Persona>();
		Persona p = null;
		tspp.addAll((hm.values()));
		Iterator iterador = hm.entrySet().iterator();
		
		while(iterador.hasNext()){
			Map.Entry<Persona,Persona> e = (Map.Entry<Persona,Persona>)iterador.next();
			mapa.put((Persona)e.getValue(), (Persona)e.getKey());
		}
		
		Iterator<Persona> ite_ts = tspp.iterator();
		
		while(ite_ts.hasNext()){
			p=ite_ts.next();
			lhmpp.put(mapa.get(p), p);
		}
		
		return lhmpp;
	}
	
	public static void main(String[] args) {
		Persona p1 = new Persona("alb", 30);
		Persona p2 = new Persona("mik", 28);
		Persona p3 = new Persona("tam", 27);
		Persona p4 = new Persona("iña", 35);
		Persona p5 = new Persona("Jai", 48);
		Persona p6 = new Persona("ruth", 36);
		
		HashMap<Persona, Persona> hm = new HashMap<Persona, Persona>();
		hm.put(p1, p1);
		hm.put(p2, p2);
		hm.put(p3, p3);
		hm.put(p4, p4);
		hm.put(p5, p5);
		hm.put(p6, p6);
		
		System.out.println(hm.toString());
		
		
		
		System.out.println("metodo");
		HashMapPersonaPersona hmpp = new HashMapPersonaPersona();
		System.out.println(hmpp.ordenarHMPP(hm));
		System.out.println("fin metodo");
		
		/*
		TreeMap<Persona, Persona> tmpp = new TreeMap<Persona, Persona>();
		tmpp.putAll(hm);
		LinkedHashMap<Persona,Persona> lhmpp = new LinkedHashMap<Persona,Persona>();
		lhmpp.putAll(tmpp);
		System.out.println(lhmpp);
		*/
		HashMap<Integer, Persona> hmip = new HashMap<Integer, Persona>();
		HashMap<Persona, Integer> hmpi = new HashMap<Persona, Integer>();
		
		hmip.put(p1.getEdad(), p1);
		hmip.put(p2.getEdad(), p2);
		hmip.put(p3.getEdad(), p3);
		hmip.put(p4.getEdad(), p4);
		hmip.put(p5.getEdad(), p5);
		hmip.put(p6.getEdad(), p6);
		
		System.out.println(hmip);
		
		hmpi=(HashMap<Persona, Integer>)hmpp.cambiaKxVhm(hmip);
		
		System.out.println(hmpi);
		
		System.out.println("Ordenar por valor");
		HashMap<Persona, Persona> hmpp2 = new HashMap<Persona, Persona>();
		HashMap<Persona, Persona> hmpp3 = new HashMap<Persona, Persona>();
		hmpp2.put(p1, p1);
		hmpp2.put(p2, p2);
		hmpp2.put(p3, p3);
		hmpp2.put(p4, p4);
		hmpp2.put(p5, p5);
		hmpp2.put(p6, p6);
		System.out.println(hmpp2);
		hmpp3=hmpp.ordenarHMPPporvalue(hmpp2);
		System.out.println();
		System.out.println(hmpp3);
		System.out.println("fin ordenar por valor");
	}
	
}
