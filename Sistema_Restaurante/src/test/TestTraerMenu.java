package test;

import java.util.List;

import datos.Menu;
import negocio.MenuABM;

public class TestTraerMenu {

	public static void main(String[] args) {
		/*
		 * Hasta que no pueda mapear el muchos a muchos no puedo probar nada
		 * se q llegua al menu si corto el mapeo para q no me traigan nada mas que la ListaPrecio 
		 *   sin calcular los productos que tiene..
		 * 
		 */
		MenuABM abm = new MenuABM();
		Menu menu = null;
		List<Menu> lista = null;
		
		try {
			long idMenu = 1;
			menu = abm.traerMenu(idMenu);
			System.out.print(menu);
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
