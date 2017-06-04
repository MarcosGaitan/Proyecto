package controladores;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Mesa;
import datos.MesaFinal;
import negocio.MesaABM;
import negocio.MesaFinalABM;


@WebServlet("/ControladorUnirMesas")
public class ControladorUnirMesas extends HttpServlet {
       
	
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
				
			long idMesa1 = Long.parseLong(request.getParameter ( "mesa1" ));
			long idMesa2 = Long.parseLong(request.getParameter ( "mesa2" ));
			
		
			MesaFinalABM mesaFinalABM = new MesaFinalABM();
			MesaABM mesaABM = new MesaABM();
			MesaFinal mesaFinal = null;
			MesaFinal mesaFinal1 = mesaFinalABM.traerMesaFinalDesdeIdMesa(idMesa1);
			MesaFinal mesaFinal2 = mesaFinalABM.traerMesaFinalDesdeIdMesa(idMesa2);
			if (mesaFinal1 == null || mesaFinal2 == null){
				if (mesaFinal1 != null){
					mesaFinal = mesaFinal1;		
					
				}
				else{
					mesaFinal = mesaFinal2;
					
				}
				
				Mesa mesa1 = mesaABM.traerMesa(idMesa1);										
				Mesa mesa2 = mesaABM.traerMesa(idMesa2);
		
				mesa1.ocupar();	
				mesa2.ocupar();		
				mesaABM.actualizarMesa(mesa1);
				mesaABM.actualizarMesa(mesa2);
				
		
				if(mesaFinal != null){
					   
					    mesaFinal.agregarMesa(mesa1);
						mesaFinal.agregarMesa(mesa2);
						mesaABM.actualizarMesa(mesa2);
						mesaFinalABM.actualizarMesaFinal(mesaFinal);
						
				}else{
					
						mesaFinal = new MesaFinal(true);
						mesaFinal.agregarMesa(mesa1);
						mesaFinal.agregarMesa(mesa2);
						
						mesaFinalABM.agregarMesaFinal(mesaFinal);
					}
			
			}
	
			request .getRequestDispatcher( "/layoutMesas.jsp" ).forward( request ,response );
			
			}
			catch (Exception e) {
				response.sendError(500, "ERROR: problemas al intentar unir las mesas. ." );
			}
			
	}

}
