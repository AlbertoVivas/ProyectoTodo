/**
 * 
 */
package Threads;

/**
 * @author Alberto Vivas
 *
 * 
 */
//package val.examples.threads;

public class Hilos extends Thread {
	public long t;
    public Hilos(String str) {
        super(str);
    }
    public long getT(){
    	return this.t;
    }
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Km " + i + " : " + getName());
            try {
                sleep((long)(Math.random() * 2500));
            } catch (InterruptedException e) {}
        }
        System.out.println("Llego a la meta! " + getName());
        this.t=System.currentTimeMillis();
        System.out.println(t+"------------"+getName());
   
    }
}