package controladores;

import java.io.IOException;
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


@WebServlet("/ControladorTraerMesasFinales")
public class ControladorTraerMesasFinales extends HttpServlet {
	
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
				MesaABM abmMesa = new MesaABM();
				MesaFinalABM abm = new MesaFinalABM();
				
				int activa= 1;	// mesas activas = true
				List<MesaFinal> mesasFinales = abm.traerMesasFinalesActivas(activa);
				
				request.setAttribute("mesasFinales", mesasFinales);
				
				request.getRequestDispatcher("/vistaMesasFinales.jsp").forward(request, response);
			}catch (Exception e) {
				response.sendError(500, "no se pudo traer las mesas . ERROR." );
			}
			
	}

	

}
