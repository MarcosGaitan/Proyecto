package test;

import java.util.List;

import datos.Producto;
import negocio.ProductoABM;

public class TestTraerProducto {

	public static void main(String[] args) {

		ProductoABM abm = new ProductoABM();
		Producto p = null;
		List<Producto> lista = null;

		
		try {
			long idProducto= 1;
			p = abm.traerProducto(idProducto);
			System.out.println("\n nombreProducto: " + p.getNombre() + "\n");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		/*
		try 
		{
			lista = abm.traerProducto();
			for (Producto k : lista)
			{
				System.out.println("\n "+ k);
			}
		}catch(Exception e1)
		{
			System.out.println(e1.getMessage());
		}
		*/
	}

}
