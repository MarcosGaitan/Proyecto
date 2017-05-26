package test;

import java.util.List;

import datos.Stock;
import negocio.StockABM;

public class TestTraerStock {

	public static void main(String[] args) {
		
		StockABM abm = new StockABM();
		Stock  s = null;
		List<Stock> lista = null;
		
		try {
			long id = 1;
			s = abm.traerStock(id);
			System.out.println(s);

			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try 
		{
			lista = abm.traerStock();
			for (Stock k : lista)
			{
				System.out.println("\n "+ k);
			}
		}catch(Exception e1)
		{
			System.out.println(e1.getMessage());
		}


	}

}
