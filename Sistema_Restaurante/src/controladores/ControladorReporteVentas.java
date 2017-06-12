package controladores;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.ComandaItem;
import datos.MesaFinal;
import datos.Producto;
import negocio.ComandaItemABM;
import negocio.MesaFinalABM;
import negocio.ProductoABM;


public class ControladorReporteVentas extends HttpServlet {
	
	protected void doGet(HttpServletRequest request , HttpServletResponse response )
			throws ServletException, IOException {
				procesarPeticion( request , response );
			}
	protected void doPost(HttpServletRequest request , HttpServletResponse response )
			throws ServletException, IOException {
				procesarPeticion( request , response );
			}
	
	private void procesarPeticion(HttpServletRequest request , HttpServletResponse
			response ) throws ServletException, IOException {
			response .setContentType( "text/html;charset=UTF-8" );
			try {
			
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
				List<String> nombreProductos = new ArrayList<String>();
				List<String>  cantidadProducto = new ArrayList<String>();
				
				for (int i = 0; i < productos.length ; i++){
					nombreProductos.add(productos[i][0]);
					cantidadProducto.add(productos[i][1]);
				}

				request.setAttribute("nombreProductos", nombreProductos);
				request.setAttribute("cantidadProducto", cantidadProducto);
				
				request .getRequestDispatcher( "/vistaHistoricoVentas.jsp" ).forward( request ,response );
			}
			catch (Exception e) {
				response.sendError(500, "no existe mesa final con esa clave. ERROR." );
			}
	}

}
