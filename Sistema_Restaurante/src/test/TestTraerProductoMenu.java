package test;

import java.util.List;

import datos.Menu;
import datos.ProductoMenu;
import negocio.MenuABM;
import negocio.ProductoMenuABM;

public class TestTraerProductoMenu {

	public static void main(String[] args) {
		
		ProductoMenuABM abm = new ProductoMenuABM();
		ProductoMenu p = null;
		List<ProductoMenu> lista = null;

		
		try {
			long idProducto= 1;
			p = abm.traerProductoMenu(idProducto);
			System.out.println("\n idProductoMenu: " + p.getIdProductoMenu() + "\n");
			System.out.println(" tiene: " + p.getProducto().getNombre() + "\n");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	
		
		try 
		{
			MenuABM abmMenu = new MenuABM();
			long idMenu = 1;
			Menu menu = abmMenu.traerMenu(idMenu);
			lista = abm.traerProductosMenuDeTalMenu(idMenu);
			System.out.println("Menu: "+ menu.getNombre() );
			System.out.println("*** lista de productos de ese Menu ***");
			for (ProductoMenu k : lista)
			{
				System.out.println("\n "+ k.getProducto().getNombre());
			}
		}catch(Exception e1)
		{
			System.out.println(e1.getMessage());
		}
		
		
		try 
		{
			lista = abm.traerProductoMenu();
			System.out.println("*** lista de todos productos totales en todos los menues***");
			for (ProductoMenu k : lista)
			{
				System.out.println("\n "+ k.getProducto().getNombre());
			}
		}catch(Exception e1)
		{
			System.out.println(e1.getMessage());
		}
	}

}
