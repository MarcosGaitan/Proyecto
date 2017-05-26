package test;

import java.util.List;

import datos.Bebida;
import negocio.BebidaABM;

public class TestTraerBebida {

	public static void main(String[] args) {
		
		BebidaABM abmBebida = new BebidaABM();
		Bebida  bebida = null;
		List<Bebida> lista = null;
		
		try {
			long id = 12;
			bebida = abmBebida.traerBebida(id);
			System.out.println(bebida.getDescripcion());

			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try 
		{
			lista = abmBebida.traerBebida();
			for (Bebida k : lista)
			{
				System.out.println("Producto ID: "+k.getIdProducto()+" "+k.getDescripcion());
			}
		}catch(Exception e1)
		{
			System.out.println(e1.getMessage());
		}

	}

}
