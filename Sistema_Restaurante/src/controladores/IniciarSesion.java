package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;
import datos.Empleado;
import negocio.EmpleadoABM;

public class IniciarSesion extends HttpServlet {

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
		
			String usuario=request . getParameter ( "usuario" );
			String clave=request . getParameter ( "pass" );
			EmpleadoABM empleadoAbm= new EmpleadoABM ();
			Empleado empleado = empleadoAbm.iniciarSesion( usuario,clave );
				/*long id=Integer.parseInt (request.getParameter( "pass" ));	
				EmpleadoABM empleadoAbm= new EmpleadoABM ();
				Empleado empleado = empleadoAbm.traerEmpleado(id);*/
			request .setAttribute( "empleado" , empleado );
			if (empleado.getTipoEmpleado().getDescripcion().startsWith("Gerente")){
				request .getRequestDispatcher( "/controlGerente.jsp" ).forward( request ,response );
			}else{
				request .getRequestDispatcher( "/bienvenido.jsp" ).forward( request ,response );
			}
			}
			catch (Exception e) {
				response.sendError(500, "ERROR el usuario con ese email o clave no existe ERROR." );
						}
			}
}
			
	

