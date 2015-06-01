/**
 * 
 */
package xml;

/**
 * @author Alberto Vivas
 *
 * Dedicado a juanjo xD
 */
public class piramide {
	
	public static void haz_piramide(int nivel){
		String j = "";
		for (int i = 1; i < nivel; i++) {
			System.out.println(j+=i);
		}
	}
	
	public static void haz_piramide2punto0(int level){
		String [] num = new String [level];
		String [] num_volt = new String [level];
		String [] num_most = new String [level];
		resetString(num_volt);
		resetString(num_most);
		resetString(num);
		
		String j = "";
		for (int i = 1; i < level; i++) {
			num[i]=(j+=i);
		}
		
		for (int i = 1; i < level; i++) {
			int longi = num[i].length();
			for (int k = 1; k < longi; k++) {
				num_volt[i]+=num[i].charAt(longi-1-k);
			}
		}
		
		for (int i = 1; i < num_most.length; i++) {
			num_most[i]=espaciame(i,level)+num[i]+num_volt[i];
		}
		
		for (int i = 1; i < num.length; i++) {
			System.out.println(num_most[i]);
		}
	}
	
	public static String espaciame(int nivel_actual, int nivel_max){
		String respuesta = "";
		
		for (int i = 0; i < nivel_max-nivel_actual; i++) {
			respuesta+=" ";
		}
		
		return respuesta;
	}
	
	public static void resetString(String [] string){
		for (int i = 0; i < string.length; i++) {
			string[i]="";
		}	
	}

	
	
	
	public static void main(String[] args) {
		//haz_piramide(10);
		haz_piramide2punto0(110);
	}
}
