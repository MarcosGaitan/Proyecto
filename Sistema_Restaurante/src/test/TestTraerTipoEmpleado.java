package test;

import java.util.List;


import datos.TipoEmpleado;
import negocio.TipoEmpleadoABM;

public class TestTraerTipoEmpleado {

	public static void main(String[] args) {
		
		TipoEmpleadoABM abm = new TipoEmpleadoABM();
		TipoEmpleado  te = null;
		List<TipoEmpleado> lista = null;
		
		try {
			long id = 1;
			te = abm.traerTipoEmpleado(id);
			System.out.println("id:" + te.getIdTipoEmpleado()+ "	nombre:" + te.getDescripcion());

			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try 
		{
			lista = abm.traerTipoEmpleado();
			for (TipoEmpleado k : lista)
			{
				System.out.println("\n "+ k);
			}
		}catch(Exception e1)
		{
			System.out.println(e1.getMessage());
		}
		
	}

}
