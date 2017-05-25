package negocio;

import java.util.List;

import dao.ListaPrecioDao;
import datos.ListaPrecio;

public class ListaPrecioABM {
	
	ListaPrecioDao dao = new ListaPrecioDao();
	
	public ListaPrecio traerListaPrecio(long idListaPrecio) throws Exception{
		
		ListaPrecio listaPrecio = dao.traerListaPrecio(idListaPrecio);
		if(listaPrecio == null) throw new Exception ("no existe tal Ingrediente");
		return listaPrecio;
	}
	
	public List<ListaPrecio> traerListaPrecio() throws Exception
	{
		List<ListaPrecio> lista = dao.traerListaPrecio();
		if (lista.isEmpty()) throw new Exception("Lista vacia, no hay datos");
		return lista;
	}
	
}
