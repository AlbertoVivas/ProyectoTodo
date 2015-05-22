/**
 * 
 */
package xml;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class HMlibroToString extends HashMap<String, Libro>{

		public HMlibroToString(){
			super();
		}
		
		/* (non-Javadoc)
		 * @see java.util.AbstractMap#toString()
		 */
		@Override
		public String toString() {
		String str_dev = "";
		Iterator i1 = values().iterator();
		//Iterator i = entrySet().iterator();
		while(i1.hasNext()){
			str_dev+=i1.next()+"\n";
		}
			
			return str_dev;
		}
		
		
}
