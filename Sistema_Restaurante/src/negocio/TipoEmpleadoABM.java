package negocio;

import java.util.List;

import dao.TipoEmpleadoDao;
import datos.TipoEmpleado;



public class TipoEmpleadoABM {
	
	TipoEmpleadoDao dao = new TipoEmpleadoDao();
	
	public TipoEmpleado traerTipoEmpleado( long idTipoEmpleado) throws Exception{
		TipoEmpleado p= dao.traerTipoEmpleado(idTipoEmpleado);
			//HECHO-- // implementar si c es null lanzar Exception
		if (p==null) throw new Exception ("no existe el Emepleado con el ID indicado"); 
		return p;
	}
	
	public List<TipoEmpleado> traerTipoEmpleado() throws Exception{
		List<TipoEmpleado> lista = dao.traerTipoEmpleado();
			//HECHO-- // implementar si c es null lanzar Exception
		if (lista.isEmpty()) throw new Exception ("la lista de empleados esta vacia"); 
		return lista;
	}
}
