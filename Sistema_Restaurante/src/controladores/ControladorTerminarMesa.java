package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Mesa;
import datos.MesaFinal;
import negocio.MesaABM;
import negocio.MesaFinalABM;

/**
 * Servlet implementation class ControladorTerminarMesa
 */
@WebServlet("/ControladorTerminarMesa")
public class ControladorTerminarMesa extends HttpServlet {
	
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
				
			long idMesa = Long.parseLong(request.getParameter ( "id" ));
				
			MesaFinalABM mesaFinalABM = new MesaFinalABM();
			
			MesaFinal mesaFinal = mesaFinalABM.traerMesaFinalDesdeIdMesa(idMesa);
			MesaABM mesaABM = new MesaABM();
			
			if (mesaFinal != null){		
				
				mesaFinalABM.terminarMesas(mesaFinal);
								
				for (Mesa m : mesaFinal.getMesas()){
					mesaABM.actualizarMesa(m);
				}
			}
			

			request .getRequestDispatcher( "/layoutMesas.jsp" ).forward( request ,response );
			
			
			}
			catch (Exception e) {
				response.sendError(500, " TerminarMesa(). ERROR." );
			}
			
	}

}
