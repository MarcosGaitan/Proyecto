package test;

import java.util.List;

import datos.Comanda;
import negocio.ComandaABM;
public class TestTraerComanda {

	public static void main(String[] args) throws Exception {
		long id=1;  
		ComandaABM abm = new ComandaABM();
		Comanda c = new Comanda();
		System.out.println("1");
		c=abm.traerComandaEItems(1);
		System.out.println("2");
		/*try {
			
			c=abm.traerComanda(id);
			//System.out.println("ID: "+c.getIdComanda());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		/*
		try 
		{
			lista = abm.traerCliente();
			for (Cliente x : lista)
			{
				//aca mezclo datos del Cliente, con Persona y con Tipo Cliente para que se vean.
				//System.out.println("Cliente: "+x.getNombre()+" DNI: "+x.getDni());
				System.out.println("Cliente: "+x.getNombre()+" DNI: "+x.getDni()+" TipoCliente: "+x.getTipoCliente().getDescripcion());
			}
		}catch(Exception e1)
		{
			System.out.println(e1.getMessage());
		}
*/
	}

}
