/**
 * 
 */
package Threads;

import java.sql.Timestamp;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class Mainhilo {

	/**
	 * en este caso no utilizamos hilos sino ver cuanto dura el programa.
	 * -
	 * @param args
	 *  *-*
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long t0 = System.currentTimeMillis();
		Hilo h1 = new Hilo("Conejo");
		Hilo h2 = new Hilo("Tortuga");
		Hilo h3 = new Hilo("Zorro");
		Hilo h4 = new Hilo("cohete");
		

		
		h1.run();
		h2.run();
		h3.run();
		h4.run();
		
		System.out.println("t1");
		long t1 = System.currentTimeMillis();
		System.out.println(t1-t0);
	}

}
