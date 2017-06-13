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

public class ControladorAgregarComanda extends HttpServlet {
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
				ClienteABM cabm = new ClienteABM();
				EmpleadoABM eABM = new EmpleadoABM();
				MesaFinalABM mABM = new MesaFinalABM();
				//ACA ME QUEDE, NO OLVIDARME QUE SAQUE EL EXCEPTION EN DAO DE CLIENTE.
				
				
				String mf = request.getParameter("mesaFinal");	
				
				long mesaFinal = Long.parseLong(mf);
				
				String habitacion = request.getParameter("habitacion");
				
				String idC = request.getParameter("idCamarero");
				long idCamarero = Long.parseLong( idC );
				
				int dni= Integer.parseInt(request.getParameter("dni"));
				
				Cliente cliente = null;
				Empleado camarero = null;
				MesaFinal mesa= null;
				
				if (dni!=0){
					cliente = cabm.traerCliente(dni);
				}
				
				camarero = eABM.traerEmpleado(idCamarero);
				
				if(mesaFinal!=0){
					mesa= mABM.traerMesaFinal(mesaFinal);
				}
				
				Comanda comanda = new Comanda(cliente, camarero, null, habitacion, mesa);
				
				ComandaDao cDao = new ComandaDao();
				long idComanda= cDao.agregar(comanda);
				comanda = cDao.traerComandaEItems(idComanda);
				
				request.setAttribute("comanda", comanda);
				request.getRequestDispatcher( "/vistaComandaAgregada.jsp" ).forward( request ,response );

			}
			catch (Exception e) {
				response.sendError(500, "ERROR." );
			}

	}
}