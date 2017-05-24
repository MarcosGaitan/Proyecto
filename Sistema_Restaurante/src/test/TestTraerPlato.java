package test;

import java.util.List;

import datos.Plato;
import datos.PlatoIngrediente;
import datos.Producto;
import negocio.PlatoABM;
import negocio.ProductoABM;

public class TestTraerPlato {

	public static void main(String[] args) {
		
		
		/**
		 * No funciona aun... 
		 * problemas con los mapeos culpa de la Herencia.. 
		 * 
		 */
		PlatoABM abm = new PlatoABM();
		Plato p = null;
		List<Plato> lista = null;

		
		try {
			long idProducto= 1;
			p = abm.traerPlato(idProducto);
			System.out.println("\n nombre Producto: " + p.getNombre() + "\n");
			System.out.println("** ingredientes **");
			for (PlatoIngrediente i : p.getPlatoIngredientes()){
				System.out.println(i.getIngrediente().getNombre());
			}
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
