package test;

import java.util.List;

import datos.Rubro;
import negocio.RubroABM;

public class TestTraerRubro {

	public static void main(String[] args) {
		
		RubroABM abm = new RubroABM();
		Rubro  sr = null;
		List<Rubro> lista = null;
		
		try {
			long id = 1;
			sr = abm.traerRubro(id);
			System.out.println(sr);

			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try 
		{
			lista = abm.traerRubro();
			for (Rubro k : lista)
			{
				System.out.println("\n "+ k);
			}
		}catch(Exception e1)
		{
			System.out.println(e1.getMessage());
		}

	}

}
