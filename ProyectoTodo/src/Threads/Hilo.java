/**
 * 
 */
package Threads;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class Hilo  {
		public String name="";
	    public Hilo(String str) {
	        this.name=str;
	    }
	    
	    public String getName(){
	    	return this.name;
	    }
	    
	    public void run() {
	        for (int i = 0; i < 10; i++) {
	            System.out.println("Km " + i + " : " + getName());
	            try {
	                Thread.sleep((long)(Math.random() * 2500));
	            } catch (InterruptedException e) {}
	        }
	        System.out.println("Llego a la meta! " + getName());
	    }
	}