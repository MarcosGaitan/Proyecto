package negocio;

import java.util.List;

import datos.TipoCliente;
import dao.TipoClienteDao;

public class TipoClienteABM {
	
TipoClienteDao dao = new TipoClienteDao();
	
	public TipoCliente traerTipoCliente( long idTipoCliente) throws Exception{
		TipoCliente p= dao.traerTipoCliente(idTipoCliente);
			//HECHO-- // implementar si c es null lanzar Exception
		if (p==null) throw new Exception ("no existe el Cliente con el ID indicado"); 
		return p;
	}
	
	public List<TipoCliente> traerTipoCliente() throws Exception{
		List<TipoCliente> lista = dao.traerTipoCliente();
			//HECHO-- // implementar si c es null lanzar Exception
		if (lista.isEmpty()) throw new Exception ("la lista de clientes esta vacia"); 
		return lista;
	}
	
}
