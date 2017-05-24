package test;

import java.util.List;

import datos.PlatoIngrediente;
import negocio.PlatoIngredienteABM;

public class TestPlatoIngrediente {

	public static void main(String[] args) {
		
		PlatoIngredienteABM abm = new PlatoIngredienteABM();
		PlatoIngrediente  te = null;
		List<PlatoIngrediente> lista = null;
		
		try {
			long id = 1;
			te = abm.traerPlatoIngrediente(id);
			System.out.println("\n ***platoIngrediente individual de un objeto *** \n ");
			System.out.println("id: " + te.getIdPlatoIngrediente() + "\t plato: " + te.getPlato().getNombre());
			System.out.println("ingrediente: " + te.getIngrediente().getNombre() +"\t cantidad: " + te.getCantidad());
			System.out.println("\n ************************* \n ");
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try 
		{
			lista = abm.traerPlatoIngrediente();
			System.out.println("\n *** lista de todos los platoingrediente  ***");
			for (PlatoIngrediente k : lista)
			{
				System.out.println("id: " + k.getIdPlatoIngrediente() + "\t plato: " + k.getPlato().getNombre());
				System.out.println("ingrediente: " + k.getIngrediente().getNombre() +"\t cantidad: " + k.getCantidad());
				System.out.println("\n ************************* \n ");
			}
			System.out.println("\n ************************* \n ");
		}catch(Exception e1)
		{
			System.out.println(e1.getMessage());
		}
		
	}

}
