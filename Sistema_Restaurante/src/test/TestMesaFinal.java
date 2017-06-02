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
		MesaFinal mesaFinal = new MesaFinal(true);
		MesaABM mesaABM = new MesaABM();
		long idMesa1 = 1;
		long idMesa2 = 3;
		
		
		// traer mesa final desde Id con comandas y todo
		try 
		{
			long idMesa = 2;
			//mesaFinal = abm.traerMesaFinalDesdeIdMesa(idMesa);
			
			Mesa mesa1 = mesaABM.traerMesa(idMesa1);
			Mesa mesa2 = mesaABM.traerMesa(idMesa2);
			mesaFinal.agregarMesa(mesa1);
			mesaFinal.agregarMesa(mesa2);
			
			System.out.println("\n idMesaFinal:" + mesaFinal.getIdMesaFinal() + "\n");
			for(Mesa m : mesaFinal.getMesas()){
				System.out.println("\n mesa id: :" + m.getIdMesa() + "\n");
			}
			System.out.println("\n mesa1:" + mesaFinal.getIdMesaFinal() + "\n");
			/*
			mesaFinal = abm.traerMesaFinalyComandas(mesaFinal.getIdMesaFinal());
			for (Comanda c : mesaFinal.getComandas()){
				for (ComandaItem ci : c.getComandaItems()){
					System.out.println("producto: " + ci.getProducto().getNombre());
				}
			}
			*/
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}

	}

}
