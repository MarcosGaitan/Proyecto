package negocio;

import java.util.List;

import dao.PrecioTipoClienteDao;
import datos.PrecioTipoCliente;

public class PrecioTipoClienteABM {
	
	
	PrecioTipoClienteDao dao = new PrecioTipoClienteDao();
	
	public PrecioTipoCliente traerPrecioTipoCliente( long idPrecioTipoCliente) throws Exception{
		PrecioTipoCliente p= dao.traerPrecioTipoCliente(idPrecioTipoCliente);

		if (p==null) throw new Exception ("no existe el PrecioTipoCliente con el ID indicado"); 
		return p;
	}
	
	public List<PrecioTipoCliente> traerPrecioTipoCliente() throws Exception{
		List<PrecioTipoCliente> lista = dao.traerPrecioTipoCliente();
			
		if (lista.isEmpty()) throw new Exception ("la lista de PrecioTipoCliente esta vacia"); 
		return lista;
	}
	
}
