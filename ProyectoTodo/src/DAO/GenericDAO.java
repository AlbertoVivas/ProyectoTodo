package modelo.persistencia.DAO;

import modelo.errores.Error;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import modelo.persistencia.Pool;
import modelo.persistencia.DAO.ConstantesDAO;
import modelo.persistencia.DTO.GenericDTO;
import modelo.persistencia.instrucciones.Consulta;

public abstract class GenericDAO   {
	
	
	
	protected Connection conexion;
	protected Statement st;
	protected ResultSet rs;
	
		
	
	public abstract GenericDTO componerObjeto (ResultSet rs) throws SQLException;
	
	public String sustituirArgumentos (String sentencia, List<Object> argumentos) throws Exception
	{
		String sentenciatraducida = "";
		
		boolean sustituido = false;
		int numargs = argumentos.size();
		int numargsEncontrados = 0;
		int pos = -1;
		int longuitud = sentencia.length() - 1;
		char carcateractual = '0';
		String argaux = null;
		Object obaux = null;
		
		try
		{
		System.out.println("num args " + argumentos.size());
		while (!sustituido)
		{
			pos = pos + 1;
			carcateractual = sentencia.charAt(pos);
			if (carcateractual == ConstantesDAO.caracterParametro)
			{
				if (argumentos.get(numargsEncontrados) == null)
				{
					argaux = "NULL";
				}
				else {
					obaux = argumentos.get(numargsEncontrados);
					if (obaux instanceof String)
						{
						argaux = "'"+ obaux.toString() +"'";
						}
					else
						argaux = obaux.toString();
				}
				
				sentenciatraducida = sentenciatraducida + argaux;
				numargsEncontrados = numargsEncontrados + 1;
			}
			else
			{
				sentenciatraducida = sentenciatraducida + carcateractual;
				
			}
			sustituido = ((numargsEncontrados == numargs) || (longuitud == pos));
		}
		
		if ((numargsEncontrados == numargs) && (longuitud != pos))
		{
			sentenciatraducida = sentenciatraducida + sentencia.substring(pos+1, longuitud+1);
		}
		
		}catch (Exception e) {
			e.printStackTrace();
			//log.error(Error.NumeroArgumentosQuery);
			throw e;
		}
		System.out.println(sentenciatraducida);
		return sentenciatraducida;
	}
	
	public GenericDTO ejecutaConsultaSimple (String consulta, List<Object> argumentos) throws Exception
	{
		GenericDTO dtoAux = null;
		String consultaTraducida = null;
		
		try
			{
				if (argumentos != null)
				{
					consultaTraducida = sustituirArgumentos (consulta, argumentos);
				}
				else 
					consultaTraducida = consulta;
					conexion = Pool.getConnection();
					st = conexion.createStatement();
					st.execute(consultaTraducida);
					rs = st.getResultSet();
				if (rs != null)
				{
					if (rs.next())
					{
						dtoAux = this.componerObjeto(rs);					
					
					}
				}
		}
		finally
		{
			Pool.liberarRecursos(conexion, st, rs);
		}
								
		return dtoAux;
	}
	
	public List<GenericDTO> ejecutaConsultaMultiple (String consulta , List<Object> argumentos) throws Exception
	{
		List<GenericDTO> ldev = null;
		GenericDTO dtoAux = null;
		String consultaTraducida = null;
		
		try
			{
				if (argumentos != null)
				{
					consultaTraducida = sustituirArgumentos (consulta, argumentos);
				}
				else 
					consultaTraducida = consulta;
					conexion = Pool.getConnection();
					st = conexion.createStatement();
					st.execute(consultaTraducida);
					rs = st.getResultSet();
					if (rs != null)
					{
						ldev = new LinkedList<GenericDTO>();
						while (rs.next())
						{
							dtoAux = this.componerObjeto(rs);
							ldev.add(dtoAux);
						}
			
				}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			Pool.liberarRecursos(conexion, st, rs);
		}
		return ldev;
	}
	
	public void ejecutaSentencia (String instruccion, List<Object> argumentos) throws Exception
	{
		String instruccionTraducida = null;
		
		
		try
		
			{
				if (argumentos != null)
				{
					instruccionTraducida = sustituirArgumentos(instruccion, argumentos);
				}
				else
					instruccionTraducida = instruccion;
				conexion = Pool.getConnection();
				st = conexion.createStatement();
				st.execute(instruccionTraducida);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			Pool.liberarRecursos(conexion, st);
		}
		
	}
/**
 * Se usa para saber el identificador del último registro insertado en la base de datos, usando para ello la función prevista en el core MYSQL
 * En especial, se motiva en saber el último valor de autoincremento asignado, para operar con ese ID posterioremente.
 * 
 * @return el ID del último registro insertado
 */
	public Object obtenerUltimoIdIntroducido ()
	{
		Object ivalor = 0;
		
		try
		{
				conexion = Pool.getConnection();
				st = conexion.createStatement();
				st.execute(Consulta.ConsultarUltimoIdInsertado);
				rs = st.getResultSet();
				if (rs != null)
				{
					while (rs.next())
					{
						ivalor= rs.getObject(1);
					}
		
				}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			Pool.liberarRecursos(conexion, st, rs);
		}
		
		return ivalor;
		 //ejecutaConsultaSimple(Consulta.ConsultarUltimoIdInsertado, null);
	}
	

	
	
}
