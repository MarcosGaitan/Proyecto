package test;

import java.util.List;

import datos.Mesa;
import state.Libre;
import negocio.MesaABM;

public class TestTraerMesa {

	public static void main(String[] args) {
		
		MesaABM abm = new MesaABM();
		Mesa mesa = null;
		List <Mesa> lista = null;
		try 
		{
			long idMesa = 1;
			mesa = abm.traerMesa(idMesa);
			System.out.println("\n" + mesa + "\n");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		/*
		try 
		{
			
			lista = abm.traerMesa();
			for (Mesa m : lista){
				System.out.println("\n" + m);
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		*/
		
	}
	

}
