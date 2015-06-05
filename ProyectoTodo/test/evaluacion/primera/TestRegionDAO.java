/**
 * 
 */
package evaluacion.primera;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class TestRegionDAO {
	
	
	/**
	 * Test method for {@link evaluacion.primera.RegionsDAO#recuperarTodos()}.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testRecuperarTodos() throws ClassNotFoundException, SQLException {
		RegionsDAO rdao = new RegionsDAO();
		assertNotNull(rdao.recuperarTodos());
	}

	/**
	 * Test method for {@link evaluacion.primera.RegionsDAO#recuperarRegion(int)}.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testRecuperarRegion() throws ClassNotFoundException, SQLException {
		RegionsDAO rdao = new RegionsDAO();
		RegionsDTO rdto = new RegionsDTO(1,"Europe");
		ArrayList<RegionsDTO> alrdto = new ArrayList<RegionsDTO>();
		alrdto.add(rdto);
		assertEquals(alrdto, rdao.recuperarRegion(1));
	}

	/**
	 * Test method for {@link evaluacion.primera.RegionsDAO#insertarRegion(evaluacion.primera.RegionsDTO)}.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testInsertarRegion() throws ClassNotFoundException, SQLException {
		RegionsDAO rdao = new RegionsDAO();
		RegionsDTO rdto = new RegionsDTO(1,"Europe");
		assertFalse(rdao.insertarRegion(rdto));
	}

}
