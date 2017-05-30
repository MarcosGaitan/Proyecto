package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;

import datos.Empleado;
import datos.MesaFinal;
import datos.Ticket;
import negocio.EmpleadoABM;
import negocio.MesaFinalABM;
import negocio.TicketABM;

public class ControladorEmitirPreticket  extends HttpServlet {
	
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
		
			String idMesaFinal = request.getParameter ( "idMesaFinal" );
			long id = Long.parseLong(idMesaFinal);
			
			MesaFinalABM mesaFinalABM= new MesaFinalABM ();
			TicketABM ticketABM = new TicketABM();
			
			MesaFinal mesaFinal = mesaFinalABM.traerMesaFinalyComandas(id);
			Ticket ticket = ticketABM.GenerarPreticket(mesaFinal);
			
			
			request.setAttribute( "mesaFinal" , mesaFinal );
			request.setAttribute("ticket", ticket);
			
			request .getRequestDispatcher( "/vistaPreTicket.jsp" ).forward( request ,response );
			}
			catch (Exception e) {
				response.sendError(500, "no existe mesa final con esa clave. ERROR." );
			}
	}

}
