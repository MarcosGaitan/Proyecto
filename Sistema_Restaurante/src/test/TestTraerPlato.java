package test;

import java.util.List;

import datos.Plato;
import datos.Producto;
import negocio.PlatoABM;
import negocio.ProductoABM;

public class TestTraerPlato {

	public static void main(String[] args) {
		
		
		/**
		 * No funciona aun... 
		 * problemas con los mapeos culpa de la Herencia.. 
		 * problemas de mapeo muchos a muchos con PlatoIngrediente
		 */
		PlatoABM abm = new PlatoABM();
		Plato p = null;
		List<Plato> lista = null;

		
		try {
			long idProducto= 1;
			p = abm.traerPlato(idProducto);
			System.out.println("\n " + p + "\n");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		/*
		
		try 
		{
			lista = abm.traerPlato();
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
