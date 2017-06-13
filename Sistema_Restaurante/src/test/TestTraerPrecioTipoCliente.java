package test;

import java.util.List;

import datos.PrecioTipoCliente;
import negocio.PrecioTipoClienteABM;



public class TestTraerPrecioTipoCliente {

	public static void main(String[] args) {
		
		PrecioTipoClienteABM abm = new PrecioTipoClienteABM();
		PrecioTipoCliente  tc = null;
		List<PrecioTipoCliente> lista = null;
		
		try {
			long id = 1;
			tc = abm.traerPrecioTipoCliente(id);
			System.out.println("\n ***precio individual de un objeto *** \n ");
			System.out.println("id: " + tc.getItemListaPrecio().getIdItemListaPrecio() + "\n" +"precio: " + tc.getPrecio());
			System.out.println("tipo de Cliente: " + tc.getTipoCliente().getDescripcion());
			System.out.println("\n ************************* \n ");
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try 
		{
			lista = abm.traerPrecioTipoCliente();
			System.out.println("\n *** lista de todos los precios  ***");
			for (PrecioTipoCliente k : lista)
			{
				System.out.println("id: " + k.getItemListaPrecio().getIdItemListaPrecio() + "\n" +"precio: " + k.getPrecio());
				System.out.println("tipo de Cliente: " + k.getTipoCliente().getDescripcion() + "\n");
			}
			System.out.println("\n ************************* \n ");
		}catch(Exception e1)
		{
			System.out.println(e1.getMessage());
		}

	}

}
