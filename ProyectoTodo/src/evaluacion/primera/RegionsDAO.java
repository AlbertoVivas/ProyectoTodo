/**
 * 
 */
package evaluacion.primera;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import evaluacion.primera.Conexion;
import evaluacion.primera.InstruccionesSQL;

/**
 * DAO = Data Access Object
 * this class is part of the dao - dto methodology
 * @author Alberto Vivas
 */
public class RegionsDAO {
	private final static Logger log = Logger.getLogger("mylog");
	/**
	 * this this method u get all regions in the DB
	 * @return return an array list with all regions on the data base
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@SuppressWarnings("finally")
	public ArrayList<RegionsDTO> recuperarTodos() throws ClassNotFoundException, SQLException {
		Connection newconex = null;
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<RegionsDTO> ale = new ArrayList<RegionsDTO>();
		try {
			newconex = Conexion.obtenerConexion();
			stmt = newconex.createStatement();
			rset = stmt.executeQuery(InstruccionesSQL.consultaRegiones());

			while (rset.next()) {
				int region_id = rset.getInt(1);
				String region_name = rset.getString(2);
				ale.add(new RegionsDTO(region_id, region_name));
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al recuperar todas las regiones");
		} finally // libero los recursos
		{
			Conexion.LiberarRecursos(stmt,newconex,rset);
			return ale;
		}

	}
	/**
	 * This method gives the region name of a region in the data base
	 * @param id_region
	 * @return if region exist return a region, if doesn't exist return null. 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@SuppressWarnings("finally")
	public RegionsDTO recuperarRegion(int id_region)throws ClassNotFoundException, SQLException {
		RegionsDTO respuesta = null;
		Connection newconex =null;
		Statement stmt = null;
		ResultSet rset=null;
		try {
			newconex = Conexion.obtenerConexion();
			stmt = newconex.createStatement();
			rset = stmt.executeQuery(InstruccionesSQL.consultaregion(id_region));

			while (rset.next()) {
				int region_id = rset.getInt(1);
				String region_name = rset.getString(2);
				respuesta = (new RegionsDTO(region_id, region_name));
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al recuperar la region "+id_region);
		} finally // libero los recursos
		{
			Conexion.LiberarRecursos(stmt,newconex,rset);
			return respuesta;
		}

	}
	
	/**
	 * This method set a new region with a id and name
	 * using prepare statement 
	 * @param rdto
	 * @return return a boolean (T/F) if can insert the region
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean insertarRegion(RegionsDTO rdto) throws ClassNotFoundException, SQLException{
		boolean respuesta = false;
		Connection newconex =null;
		PreparedStatement ps = null;
		Savepoint sp = null;
		if(recuperarRegion(rdto.getRegion_id())== null){ //nos aseguramos de que la region no exista.
		
			try {
				newconex = Conexion.obtenerConexion();
				newconex.setAutoCommit(false);
				sp= newconex.setSavepoint();
				ps = newconex.prepareStatement(InstruccionesSQL.insertarRegion());
				ps.setInt(1, rdto.getRegion_id());
				ps.setString(2, rdto.getRegion_name());
				ps.execute();
				newconex.commit();
				respuesta = true;
			} catch (Exception e) {
				e.printStackTrace();
				newconex.rollback(sp);
				
				log.error("Ha ocurrido un error en el TRY CATCH al insertar la region: "+rdto);
			} finally // libero los recursos
			{
				Conexion.LiberarRecursos(newconex, ps);
			}
		}else{
			System.out.println("Ya existe el identificador de region: "+rdto.getRegion_id());
			log.warn("Ya existe el identificador de region: "+rdto.getRegion_id());
		}
		return respuesta;
	}
	
	public boolean modificarRegion(RegionsDTO rdto,RegionsDTO n_rdto) throws ClassNotFoundException, SQLException{
		boolean respuesta = false;
		Connection newconex =null;
		PreparedStatement ps = null;
		Savepoint sp = null;
		if(recuperarRegion(rdto.getRegion_id()).equals(rdto)){ //nos aseguramos de que la region exista.
			
			try {
				newconex = Conexion.obtenerConexion();
				newconex.setAutoCommit(false);
				sp= newconex.setSavepoint();
				
				ps = newconex.prepareStatement(InstruccionesSQL.modificarRegion());
				ps.setString(1, n_rdto.getRegion_name());
				ps.setString(2, rdto.getRegion_name());
				ps.execute();
				newconex.commit();
				respuesta = true;
			} catch (Exception e) {
				newconex.rollback(sp);
				e.printStackTrace();
				log.error("Ha ocurrido un error el el TRY CATCH al modificar la region: "+rdto+" por "+n_rdto);
			} finally // libero los recursos
			{
				Conexion.LiberarRecursos(newconex, ps);
			}
		}else{
			System.out.println("No se puede modificar una region que no existe: "+rdto.getRegion_id()+" "+rdto.getRegion_name());
			log.warn("No se puede modificar una region que no existe: "+rdto.getRegion_id()+" "+rdto.getRegion_name());
		}
		return respuesta;
	}
	
	public boolean borrarRegion(RegionsDTO rdto) throws ClassNotFoundException, SQLException{
		boolean respuesta = false;
		Connection newconex =null;
		PreparedStatement ps = null;
		Savepoint sp = null;
		
		if(recuperarRegion(rdto.getRegion_id()).equals(rdto)){ //nos aseguramos de que la region exista.
			try {
				newconex = Conexion.obtenerConexion();
				newconex.setAutoCommit(false);// desactivamos el autocommit (hacer que los cambios se hagan reales en la bd sin mi orden)
				sp= newconex.setSavepoint(); // Hacemos un savepoint
				ps = newconex.prepareStatement(InstruccionesSQL.modificarRegion());
				ps.setInt(1, rdto.getRegion_id());
				ps.setString(2, rdto.getRegion_name());
				ps.execute();
				newconex.commit();
				respuesta = true;
			} catch (Exception e) {
				newconex.rollback(sp);
				e.printStackTrace();
				log.error("Ha ocurrido un error en el TRY CATCH al borrar la region: "+rdto);
			} finally // libero los recursos
			{
				Conexion.LiberarRecursos(newconex, ps);
			}
		}else{
			System.out.println("No se puede borrar una region que no existe: "+rdto.getRegion_id()+" "+rdto.getRegion_name());
			log.warn("No se puede borrar una region que no existe: "+rdto.getRegion_id()+" "+rdto.getRegion_name());
		}
		return respuesta;
	}
}