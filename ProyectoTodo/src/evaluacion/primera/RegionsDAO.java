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
 * @author Alberto Vivas
 *
 * 
 */
public class RegionsDAO {
	private ResultSet rset;
	
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
	
	@SuppressWarnings("finally")
	public void insertarRegion(RegionsDTO rdto){

		try{
			Connection newconex= Conexion.obtenerConexion();
			
			
			PreparedStatement ps = newconex.prepareStatement(InstruccionesSQL.insertarRegion());
			ps.setInt(1, rdto.getRegion_id());
			ps.setString(2, rdto.getRegion_name());
			
			ps.execute();
			
			/*while (rset.next()) {
				int region_id = rset.getInt(1);
				String region_name = rset.getString(2);
				ale.add(new RegionsDTO(region_id, region_name));
			}*/
			
			
			
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
		
	}
	
}
