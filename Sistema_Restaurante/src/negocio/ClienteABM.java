package negocio;

import java.util.List;

import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	
	ClienteDao dao = new ClienteDao();
	
	public Cliente traerCliente(long idCliente) throws Exception{
		
		Cliente cliente = dao.traerCliente(idCliente);
		if(cliente == null) throw new Exception ("no existe tal cliente");
		return cliente;
	}
	
	public List<Cliente> traerCliente() throws Exception
	{
		List<Cliente> lista = dao.traerCliente();
		if (lista.isEmpty()) throw new Exception("Lista vacia, no hay datos");
		return lista;
	}
	
}
