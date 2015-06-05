/**
 * 
 */
package evaluacion.primera;

/**
 * DTO = Data Type Object
 * this class is part of the dao - dto methodology
 * @author Alberto Vivas
 *
 * 
 */
public class RegionsDTO implements Comparable<RegionsDTO>{

	private int region_id;
	private String region_name;
	
	
	public RegionsDTO(int region_id, String region_name) {
		this.region_id = region_id;
		this.region_name = region_name;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String respuesta="";
		respuesta+="-----------------------------------"+"\n";
		respuesta+="Identificador de region: "+region_id+"\n";
		respuesta+="Nombre de region: "+region_name+"\n";
		respuesta+="-----------------------------------"+"\n";
		return respuesta;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	
	
	@Override
	public int compareTo(RegionsDTO arg0) {
		return this.getRegion_id()-arg0.getRegion_id();
	}

	public int getRegion_id() {
		return region_id;
	}


	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}


	public String getRegion_name() {
		return region_name;
	}


	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	
	
	
	
}
