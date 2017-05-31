package test;

import java.util.List;

import datos.Comanda;
import negocio.ComandaABM;
import negocio.Funciones;
import datos.ComandaItem;
public class TestTraerComanda {

	public static void main(String[] args) throws Exception {
		
		List <Comanda> comandas = null;  
		ComandaABM abm = new ComandaABM();
		//Comanda c = null;
		
		try{
			long id=1;
			comandas = abm.traerComandaEItems();
			
			for (Comanda c : comandas){
				System.out.println("idComanda: " + c.getIdComanda() + "   fecha Creacion: " + Funciones.traerFechaCorta(c.getFechaCreacion()));
				System.out.println("ITEMS: ");
				for (ComandaItem i : c.getComandaItems()){
					
					System.out.println("    ItemID: "+i.getIdComandaItem());
					System.out.println("    NombreProducto: "+i.getProducto().getNombre());
					System.out.println("    Precio: $"+i.getPrecio());
				}
			}
			//c = abm.traerComanda(id);
			/*c = abm.traerComandaEItems(1);
			System.out.println("idComanda: " + c.getIdComanda() + "   fecha Creacion: " + Funciones.traerFechaCorta(c.getFechaCreacion()));
			System.out.println("idMesaFinal: " + c.getMesaFinal().getIdMesaFinal());
			System.out.println("idCamarero: " + c.getCamarero().getIdPersona());
			System.out.println("ITEMS: ");
			for (ComandaItem i : c.getComandaItems()){
				
				System.out.println("    ItemID: "+i.getIdComandaItem());
				System.out.println("    Precio: "+i.getPrecio());
			} */
			
		
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
	}

}
