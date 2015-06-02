package modelo.persistencia.DAO.tablas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import modelo.persistencia.DAO.CRUD;
import modelo.persistencia.DAO.ConstantesDAO;
import modelo.persistencia.DAO.GenericDAO;
import modelo.persistencia.DAO.Recuperable;
import modelo.persistencia.DTO.ArticuloDTO;
import modelo.persistencia.DTO.GenericDTO;
import modelo.persistencia.DTO.VentaDTO;
import modelo.persistencia.instrucciones.Alta;
import modelo.persistencia.instrucciones.Consulta;

public class VentaDAO extends GenericDAO implements CRUD, Recuperable{

	@Override
	public List<GenericDTO> recuperarTodos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(GenericDTO ObjectDTO) throws Exception {
		// TODO Auto-generated method stub

		VentaDTO ventaDTO = null;
		List<Object> listaArgs = null;
		String sentencia = Alta.InsertarVenta;
		
				
			ventaDTO = (VentaDTO) ObjectDTO;
			listaArgs = new LinkedList<Object>();
			listaArgs.add(ventaDTO.getIdTicket());
			listaArgs.add(ventaDTO.getArticulo());
			listaArgs.add(ventaDTO.getStock());
			listaArgs.add(ventaDTO.getPvreal());
			
			
			
		    this.ejecutaSentencia(sentencia, listaArgs);

		
	}

	@Override
	public void update(GenericDTO ObjectDTO) throws Exception {
		// TODO Auto-generated method stub
		
		
	}
	
	@Override
	public GenericDTO componerObjeto(ResultSet rs) throws SQLException {
		VentaDTO ventaDTO = null;
		
		
		ventaDTO = new VentaDTO(rs.getString(ConstantesDAO.campoClaveVenta), rs.getString(ConstantesDAO.campoArticuloVenta), 
				rs.getString(ConstantesDAO.campoStockVenta), 
				Float.valueOf(rs.getFloat(ConstantesDAO.campoPrecioRealVenta)).floatValue());
				
		return ventaDTO;
	}

	@Override
	public GenericDTO read(String idventa) throws Exception {
		
		List<Object> listaArgs = null;
		VentaDTO ventaDTO = null;
		String consulta = Consulta.ConsultarVenta;
		
		listaArgs = new LinkedList<Object>();
		listaArgs.add(idventa);
		
		ventaDTO = (VentaDTO)this.ejecutaConsultaSimple(consulta, listaArgs);
		
		return ventaDTO;
	}

	@Override
	public void delete(String Condicion) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNombreDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
