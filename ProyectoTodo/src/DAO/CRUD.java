package modelo.persistencia.DAO;


import modelo.persistencia.DTO.GenericDTO;

public interface CRUD {

	
	 	
	 public abstract void create (GenericDTO ObjectDTO) throws Exception;
	 
	 public abstract void update (GenericDTO ObjectDTO) throws Exception;
	 
	 public abstract GenericDTO read (String Condicion) throws Exception;
	 	 
	 public abstract void delete (String Condicion) throws Exception;
	 
	 public String getNombreDAO ();
	 
	 
}
