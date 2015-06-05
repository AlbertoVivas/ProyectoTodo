/**
 * 
 */
package evaluacion.primera;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import evaluacion.primera.Conexion;
import evaluacion.primera.InstruccionesSQL;

/**
 * DAO = Data Access Object
 * this class is part of the dao - dto methodology
 * @author Alberto Vivas
 *
 * 
 */
public class RegionsDAO {
	private ResultSet rset;
	/**
	 * this this method u get all regions in the DB 
	 * @return ArrayList<RegionsSTO>
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@SuppressWarnings("finally")
	public ArrayList<RegionsDTO> recuperarTodos()
			throws ClassNotFoundException, SQLException {
		ArrayList<RegionsDTO> ale = new ArrayList<RegionsDTO>();
		try {
			rset = Conexion.conectarBBDD().executeQuery(InstruccionesSQL.consultaRegiones());

			while (rset.next()) {
				int region_id = rset.getInt(1);
				String region_name = rset.getString(2);
				ale.add(new RegionsDTO(region_id, region_name));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally // libero los recursos
		{
			if (rset != null) {
				try {
					rset.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			Conexion.LiberarRecursos();
			return ale;
		}

	}
	/**
	 * This method gives the region name of a region in the data base
	 * by a region id.
	 * @param id_region
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@SuppressWarnings("finally")
	public ArrayList<RegionsDTO> recuperarRegion(int id_region)
			throws ClassNotFoundException, SQLException {
		ArrayList<RegionsDTO> ale = new ArrayList<RegionsDTO>();
		try {
			rset = Conexion.conectarBBDD().executeQuery(InstruccionesSQL.consultaregion(id_region));

			while (rset.next()) {
				int region_id = rset.getInt(1);
				String region_name = rset.getString(2);
				ale.add(new RegionsDTO(region_id, region_name));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally // libero los recursos
		{
			if (rset != null) {
				try {
					rset.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			Conexion.LiberarRecursos();
			return ale;
		}

	}
	
	/**
	 * This method set a new region with a id and name
	 * using prepare statement 
	 *
	 * @param rdto
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	
	public boolean insertarRegion(RegionsDTO rdto) throws ClassNotFoundException, SQLException{
		boolean respuesta = false;
		if(recuperarRegion(rdto.getRegion_id())== null){ //nos aseguramos de que la region no exista.
		
			try {
				Connection newconex = Conexion.obtenerConexion();
				PreparedStatement ps = newconex
						.prepareStatement(InstruccionesSQL.insertarRegion());
				ps.setInt(1, rdto.getRegion_id());
				ps.setString(2, rdto.getRegion_name());

				ps.execute();
				respuesta = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally // libero los recursos
			{
				if (rset != null) {
					try {
						rset.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				Conexion.LiberarRecursos();

			}
		}else{
			System.out.println("Ya existe el identificador de region: "+rdto.getRegion_id());
		}
		return respuesta;
	}
	
}
