package test;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import datos.Producto;
import negocio.ProductoABM;

public class TestTraerProducto {

	public static void main(String[] args) {

		ProductoABM abm = new ProductoABM();
		//Producto p = null;
		List<Producto> lista = null;

		/*
		try {
			long idProducto= 1;
			p = abm.traerProducto(idProducto);
			System.out.println("\n nombreProducto: " + p.getNombre() + "\n");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		*/
		
<<<<<<< HEAD
		*/
=======
>>>>>>> 1fca9d9b8de25fff620683bb75ee1faa8afb719a
		try 
		{
			lista = abm.traerProducto();
			
			Collections.sort(lista, new Comparator<Producto>() {
				
				public int compare(Producto o1, Producto o2) {
					
					if (o1.getNombre().compareToIgnoreCase(o2.getNombre()) < 0){
						
						return -1;
					}
					else{
						
						return 0;
					}
				}

			});

			for (Producto k : lista)
			{
<<<<<<< HEAD
				System.out.println("\n "+ k.getIdProducto());
=======
				System.out.println("\n "+ k.getNombre());
>>>>>>> 1fca9d9b8de25fff620683bb75ee1faa8afb719a
			}
		}catch(Exception e1)
		{
			System.out.println(e1.getMessage());
		}
		
	}

}
