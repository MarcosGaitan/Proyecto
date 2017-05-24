package negocio;

import datos.Usuario;

import java.util.List;

import dao.UsuarioDao;

public class UsuarioABM {
	UsuarioDao dao = new UsuarioDao();
	
	public Usuario traerUsuario(long idUsuario) throws Exception{
		Usuario p= dao.traerUsuario(idUsuario);
		
		if (p==null) throw new Exception ("no existe el Usuario con el ID indicado"); 
		return p;
	}
	
	public Usuario traerUsuario(int dni) throws Exception{
		Usuario p= dao.traerUsuario(dni);
		
		if (p==null) throw new Exception ("no existe el Usuario con el ID indicado"); 
		return p;
	}
	
	public List<Usuario> traerUsuario() throws Exception{
		List<Usuario> lista = dao.traerUsuario();
	
		if (lista.isEmpty()) throw new Exception ("la lista de Usuarios esta vacia"); 
		return lista;
	}
	
}
