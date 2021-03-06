package controladores;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;

import dao.ComandaDao;
import datos.Cliente;
import datos.Comanda;
import datos.Empleado;
import datos.MesaFinal;
import negocio.ClienteABM;
import negocio.ComandaABM;
import negocio.EmpleadoABM;
import negocio.MesaFinalABM;

public class ControladorEliminarComanda extends HttpServlet {
	protected void doGet(HttpServletRequest request , HttpServletResponse response )
			throws ServletException, IOException {
				procesarPeticion( request , response );
			}
	protected void doPost(HttpServletRequest request , HttpServletResponse response )
			throws ServletException, IOException {
				procesarPeticion(request , response);
			}
	
	private void procesarPeticion(HttpServletRequest request , HttpServletResponse
			response) throws ServletException, IOException {
			response.setContentType( "text/html;charset=UTF-8" );
			try {
				
				ComandaABM abm = new ComandaABM();
				long idComanda = Long.parseLong((String) request.getParameter("idComanda"));
				abm.eliminarComanda(idComanda);
				
				
				request.getRequestDispatcher( "/vistaEliminarComandas.jsp" ).forward( request ,response );

			}
			catch (Exception e) {
				response.sendError(500, "ERROR." );
			}

	}
}