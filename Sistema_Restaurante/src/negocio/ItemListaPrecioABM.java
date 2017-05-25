package negocio;

import java.util.List;

import dao.ItemListaPrecioDao;
import datos.ItemListaPrecio;

public class ItemListaPrecioABM {
	
	ItemListaPrecioDao dao = new ItemListaPrecioDao();
	
	public ItemListaPrecio traerItemListaPrecio(long idItemListaPrecio) throws Exception{
		
		ItemListaPrecio itemListaPrecio = dao.traerItemListaPrecio(idItemListaPrecio);
		if(itemListaPrecio == null) throw new Exception ("no existe tal Ingrediente");
		return itemListaPrecio;
	}
	
	public List<ItemListaPrecio> traerItemListaPrecio() throws Exception
	{
		List<ItemListaPrecio> lista = dao.traerItemListaPrecio();
		if (lista.isEmpty()) throw new Exception("Lista vacia, no hay datos");
		return lista;
	}
	
}
