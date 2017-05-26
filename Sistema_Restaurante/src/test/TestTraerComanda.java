package test;

import java.util.List;

import datos.Comanda;
import negocio.ComandaABM;
import negocio.Funciones;
public class TestTraerComanda {

	public static void main(String[] args) throws Exception {
		
		  
		ComandaABM abm = new ComandaABM();
		Comanda c = null;
		
		try{
			long id=1;
			c = abm.traerComanda(id);
			System.out.println("idComanda: " + c.getIdComanda() + "   fecha Creacion: " + Funciones.traerFechaCorta(c.getFechaCreacion()));
			System.out.println("idMesaFinal: " + c.getMesaFinal().getIdMesaFinal());
			System.out.println("idCamarero: " + c.getCamarero().getIdPersona());
		
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
