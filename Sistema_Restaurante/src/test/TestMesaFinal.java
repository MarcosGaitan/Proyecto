package test;

import java.util.List;

import datos.Comanda;
import datos.ComandaItem;
import datos.Mesa;
import datos.MesaFinal;
import negocio.MesaABM;
import negocio.MesaFinalABM;

public class TestMesaFinal {

	public static void main(String[] args) {
		

		MesaFinalABM abm = new MesaFinalABM();
		MesaFinal mesaFinal = null;
		
		// traer mesa final desde Id con comandas y todo
		try 
		{
			long idMesa = 2;
			mesaFinal = abm.traerMesaFinalDesdeIdMesa(idMesa);
			System.out.println("\n idMesaFinal:" + mesaFinal.getIdMesaFinal() + "\n");
		
			for (Comanda c : mesaFinal.getComandas()){
				for (ComandaItem ci : c.getComandaItems()){
					System.out.println("producto: " + ci.getProducto().getNombre());
				}
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}

	}

}
