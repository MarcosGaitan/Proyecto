package test;

import java.util.List;

import datos.PrecioTipoCliente;
import negocio.PrecioTipoClienteABM;



public class TestPrecioTipoCliente {

	public static void main(String[] args) {
		
		PrecioTipoClienteABM abm = new PrecioTipoClienteABM();
		PrecioTipoCliente  te = null;
		List<PrecioTipoCliente> lista = null;
		
		try {
			long id = 1;
			te = abm.traerPrecioTipoCliente(id);
			System.out.println("\n ***precio individual de un objeto *** \n ");
			System.out.println("id: " + te.getItemListaPrecio().getIdItemListaPrecio() + "\n" +"precio: " + te.getPrecio());
			System.out.println("tipo de Cliente: " + te.getTipoCliente().getDescripcion());
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
