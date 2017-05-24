package test;

import java.util.List;

import datos.ItemListaPrecio;
import datos.Menu;
import datos.ProductoMenu;
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
			System.out.println(menu.getIdMenu());
			System.out.println("**** lista de productos ****");
			for (ProductoMenu m1 : menu.getProductosMenu())
			{
				System.out.println( "idProducto: " + m1.getIdProductoMenu() + "     ,nombre: " + m1.getProducto().getNombre());
				
			}
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
