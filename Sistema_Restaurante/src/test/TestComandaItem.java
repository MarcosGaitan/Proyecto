package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import datos.Comanda;
import datos.ComandaItem;
import datos.Producto;
import negocio.ComandaABM;
import negocio.ComandaItemABM;
import negocio.ProductoABM;

public class TestComandaItem {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		/*
		 *  test para prueba de reporte historico de ventas
		 */
		/*
		ComandaABM ComandaABM = new ComandaABM();
		List <Comanda> comandas = ComandaABM.traerComandaEItems();
		*/
		
		ProductoABM productoABM  = new ProductoABM();	
		List<Producto> lstProducto = productoABM.traerProducto();
		
		int cantidadProductos = lstProducto.size();
		
		ComandaItemABM comandaItemABM = new ComandaItemABM();	
		List<ComandaItem> lista = comandaItemABM.traerComandaItem();
		
		
		String productos[][] = new String[cantidadProductos][2];
		
		// cargo el array con los productos existentes
		for (int i = 0 ; i < lstProducto.size(); i++){
			productos[i][0] = lstProducto.get(i).getNombre();
			productos[i][1] = "0";
		}
		
		// muestra que se hayan cargado bien los productos en el array
		for (int j = 0 ; j < productos.length; j++){
			
			System.out.println("\n producto: " + productos[j][0] + "   cant: " + productos[j][1]);
			
		}
		
		System.out.println("\n \n\n: "); 
		boolean encontrado = false;
	
			for (int i = 0; i < lista.size();i++ ){
				for (int j = 0 ; j < productos.length && !encontrado; j++){
					if ( productos[j][0].equals(  lista.get(i).getProducto().getNombre() )){
						encontrado = true;
						int cantidad  = Integer.parseInt(productos[j][1]) +  lista.get(i).getCantidad();
						productos [j][1] = ""+ cantidad;					
					}
					
				}
				encontrado = false;
			}
		
			// muestra todos los productos con las cantidades compradas..
		for (int j = 0 ; j < productos.length; j++){
			
			System.out.println("\n producto: " + productos[j][0] + "   cant: " + productos[j][1]);
			
		}
		
		List<String> nombreProductos = new ArrayList<String>();
		List<String>  cantidadProducto = new ArrayList<String>();
		
		for (int i = 0; i < productos.length ; i++){
			nombreProductos.add(productos[i][0]);
			cantidadProducto.add(productos[i][1]);
		}
		
		System.out.println("\n \n\n: EN LISTA NOMBRES"); 
		for (int j = 0 ; j < nombreProductos.size(); j++){
			
			System.out.println("\n producto: " + nombreProductos.get(j) + "   cant: " + cantidadProducto.get(j));
			
		}
		
		
	}

}
