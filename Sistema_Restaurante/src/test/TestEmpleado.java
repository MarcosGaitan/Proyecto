package test;
import java.util.List;


import datos.Empleado;
import negocio.EmpleadoABM;

public class TestEmpleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			EmpleadoABM u1=new EmpleadoABM();
			
			String usuario="naz";
			String clave="123";
			//System.out.println( "\n---> Traer usuario idUsuario=" +dni+"\n\n" );
		//	Empleado u=u1.traerUsuario(dni);
		//	System.out.println(u+ "\nPertenece a " +u.getEmail()+u.getDni());
			
			System.out.println( "\n---> Traer usuario idEmpleado=" +usuario+"\n\n" );
			Empleado u2=u1.iniciarSesion(usuario,clave);
			System.out.println(u2+ "\nPertenece a " +u2.getClave());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}	

	}
	
}