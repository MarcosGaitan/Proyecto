package controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.MesaFinal;
import datos.Ticket;
import negocio.MesaFinalABM;
import negocio.TicketABM;


@WebServlet("/ControladorReporteEstadoSalon")
public class ControladorReporteEstadoSalon extends HttpServlet {
	
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
				
			
				
			MesaFinalABM mesaFinalABM= new MesaFinalABM ();
			
			int activa = 0; // mesas activas = false;
			List<MesaFinal> lstMesaFinal = mesaFinalABM.traerMesasFinalesActivas(activa);
			
			request.setAttribute( "lstMesaFinal" , lstMesaFinal );
			
			request .getRequestDispatcher( "/vistaReporteEstadoSalon.jsp" ).forward( request ,response );
			}
			catch (Exception e) {
				response.sendError(500, "no existe mesa final con esa clave. ERROR." );
			}
	}


}
