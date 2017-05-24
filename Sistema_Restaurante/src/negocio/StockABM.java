package negocio;

import java.util.List;

import dao.StockDao;
import datos.Stock;

public class StockABM {
	
	StockDao dao = new StockDao();
	
	public Stock traerStock( long idStock) throws Exception{
		Stock p= dao.traerStock(idStock);
			
		if (p==null) throw new Exception ("no existe el Stock con el ID indicado"); 
		return p;
	}
	
	public List<Stock> traerStock() throws Exception{
		List<Stock> lista = dao.traerStock();
			
		if (lista.isEmpty()) throw new Exception ("la lista de Stock esta vacia"); 
		return lista;
	}
}
