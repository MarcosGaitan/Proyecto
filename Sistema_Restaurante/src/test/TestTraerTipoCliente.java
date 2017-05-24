package test;

import java.util.List;

import datos.TipoCliente;
import negocio.TipoClienteABM;

public class TestTraerTipoCliente {

	public static void main(String[] args) {
		
		TipoClienteABM abm = new TipoClienteABM();
		TipoCliente  te = null;
		List<TipoCliente> lista = null;
		
		try {
			long id = 1;
			te = abm.traerTipoCliente(id);
			System.out.println("id:" + te.getIdTipoCliente()+ "	nombre:" + te.getDescripcion());

			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try 
		{
			lista = abm.traerTipoCliente();
			for (TipoCliente k : lista)
			{
				System.out.println("\n "+ k);
			}
		}catch(Exception e1)
		{
			System.out.println(e1.getMessage());
		}

	}

}
