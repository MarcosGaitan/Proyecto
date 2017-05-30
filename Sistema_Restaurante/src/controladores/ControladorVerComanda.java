package controladores;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;

import datos.Comanda;
import negocio.ComandaABM;

public class ControladorVerComanda extends HttpServlet {
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
				ComandaABM abm = new ComandaABM();
				List<Comanda> comandas = abm.traerComandaEItems();
				request.setAttribute("comandas", comandas);
				request.getRequestDispatcher( "/vistaComandas.jsp" ).forward( request ,response );
				
				
			/*String idMesaFinal = request.getParameter ( "idMesaFinal" );
			long id = Long.parseLong(idMesaFinal);
			
			MesaFinalABM mesaFinalABM= new MesaFinalABM ();
			TicketABM ticketABM = new TicketABM();
			
			MesaFinal mesaFinal = mesaFinalABM.traerMesaFinalyComandas(id);
			Ticket ticket = ticketABM.GenerarPreticket(mesaFinal);
			
			
			request.setAttribute( "mesaFinal" , mesaFinal );
			request.setAttribute("ticket", ticket);
			
			request .getRequestDispatcher( "/vistaPreTicket.jsp" ).forward( request ,response );*/
			}
			catch (Exception e) {
				response.sendError(500, "No hay Comandas. ERROR." );
			}

	}
}