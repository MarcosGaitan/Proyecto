package negocio;

import java.util.List;

import dao.ComandaItemDao;
import datos.ComandaItem;

public class ComandaItemABM {
	
	ComandaItemDao dao = new ComandaItemDao();
	
	public ComandaItem traerComandaItem(long idComandaItem) throws Exception{
		
		ComandaItem comandaItem = dao.traerComandaItem(idComandaItem);
		if(comandaItem == null) throw new Exception ("no existe tal comandaItem");
		return comandaItem;
	}
	
	public List<ComandaItem> traerComandaItem() throws Exception
	{
		List<ComandaItem> lista = dao.traerComandaItem();
		if (lista.isEmpty()) throw new Exception("Lista vacia, no hay datos");
		return lista;
	}

}
