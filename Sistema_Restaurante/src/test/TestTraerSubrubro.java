package test;

import java.util.List;

import datos.Subrubro;
import negocio.SubrubroABM;

public class TestTraerSubrubro {

	public static void main(String[] args) {
		

		SubrubroABM abm = new SubrubroABM();
		Subrubro  sr = null;
		List<Subrubro> lista = null;
		
		try {
			long id = 1;
			sr = abm.traerSubrubro(id);
			System.out.println(sr);

			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try 
		{
			lista = abm.traerSubrubro();
			for (Subrubro k : lista)
			{
				System.out.println("\n "+ k);
			}
		}catch(Exception e1)
		{
			System.out.println(e1.getMessage());
		}

	}

}
