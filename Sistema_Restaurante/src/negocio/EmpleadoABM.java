package negocio;


import datos.Empleado;

import java.util.List;

import dao.EmpleadoDao;

public class EmpleadoABM {
	EmpleadoDao dao = new EmpleadoDao();
	
	public Empleado traerEmpleado(long idEmpleado) throws Exception{
		Empleado p= dao.traerEmpleado(idEmpleado);
		
		if (p==null) throw new Exception ("no existe el Usuario con el ID indicado"); 
		return p;
	}
	
	public Empleado traerEmpleado(int dni) throws Exception{
		Empleado p= dao.traerEmpleado(dni);
		
		if (p==null) throw new Exception ("no existe el Usuario con el ID indicado"); 
		return p;
	}
	
	public List<Empleado> traerEmpleado() throws Exception{
		List<Empleado> lista = dao.traerEmpleado();
	
		if (lista.isEmpty()) throw new Exception ("la lista de Usuarios esta vacia"); 
		return lista;
	}
	
	public Empleado iniciarSesion( String usuario,String clave)throws Exception{
		Empleado u= dao.iniciarSesion(usuario, clave);
		if(u==null)throw new Exception("ERROR el usuario con HHHese email o clave no existe ERROR");
	return u;
	}
}
