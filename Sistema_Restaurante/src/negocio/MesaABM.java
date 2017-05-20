package negocio;

import java.util.List;

import dao.MesaDao;
import datos.Mesa;

public class MesaABM {
	
	MesaDao dao = new MesaDao();
	
	public Mesa traerMesa(long idMesa) throws Exception
	{
		Mesa mesa = dao.traerMesa(idMesa);
		if (mesa == null) throw new Exception("no existe esa Mesa con ese ID");
		return mesa;
	}
	
	public List<Mesa> traerMesa() throws Exception
	{
		List<Mesa> lista = dao.traerMesa();
		if(lista.isEmpty()) throw new Exception("La lista esta vacia");
		return lista;
	}
}
