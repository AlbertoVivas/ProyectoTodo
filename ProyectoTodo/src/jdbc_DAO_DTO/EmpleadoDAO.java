/**
 * 
 */
package jdbc_DAO_DTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



/**
 * @author Alberto Vivas
 *
 * 
 */
public class EmpleadoDAO {
	//recuperar Todos() List<Empleados>
	private ResultSet rset;
	
	@SuppressWarnings("finally")
	public ArrayList<EmpleadoDTO> recuperarTodos() throws ClassNotFoundException,
			SQLException {
		ArrayList<EmpleadoDTO> ale = new ArrayList<EmpleadoDTO>();
		try {
			rset = Conexion.conectarBBDD().executeQuery(InstruccionesSQL.consultaSueldo());

			while (rset.next()) {
				String employee_id = rset.getString(1);
				String first_name = rset.getString(2);
				String last_name = rset.getString(3);
				String email = rset.getString(4);
				String phone_number = rset.getString(5);
				String hire_date = rset.getString(6);
				String job_id = rset.getString(7);
				int salary = rset.getInt(8);
				String commision_pct = rset.getString(9);
				String mannager_id = rset.getString(10);
				String department_id = rset.getString(11);
				ale.add(new EmpleadoDTO(employee_id, first_name, last_name, email,
						phone_number, hire_date, job_id, salary, commision_pct,
						mannager_id, department_id));
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
	
}
