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
		
			
			MesaFinal mesaFinal = mesaFinalABM.traerMesaFinalDesdeIdMesa(idMesa1);
			
			
			if(mesaFinal != null){
				
				
			}else{
				
			
				
				Mesa mesa1 = mesaABM.traerMesa(idMesa1);
				Mesa mesa2 = mesaABM.traerMesa(idMesa2);
				mesa1.ocupar();
				mesa2.ocupar();
			
				mesaFinal = new MesaFinal(true);
				System.out.println("cree la mesa");
				mesaFinal.agregarMesa(mesa1);
				mesaFinal.agregarMesa(mesa2);
				System.out.println("agrego las mesas");
				mesaABM.actualizarMesa(mesa1);
				
				mesaABM.actualizarMesa(mesa2);
				System.out.println("actualice las mesas");
				mesaFinalABM.agregarMesaFinal(mesaFinal);
				System.out.println("deberia salir aca");
			}
			
			request .getRequestDispatcher( "/layoutMesas.jsp" ).forward( request ,response );
			
			}
			catch (Exception e) {
				response.sendError(500, "no existe mesa final con esa clave. ERROR." );
			}
			
	}

}
