/**
 * 
 */
package persona;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class MapToString extends HashMap<String, Persona>{
	
	public MapToString(){
		super();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return super.toString();
		//hm.
		String str_dev = "";
		Iterator i = this.entrySet().iterator();
		
		while (i.hasNext())
		{
			str_dev = str_dev + i.next().toString()+"\n";
		}
		return str_dev;
	}
	

}
