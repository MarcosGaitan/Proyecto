package negocio;

import java.util.List;

import dao.PlatoDao;

import datos.Plato;

public class PlatoABM {
	PlatoDao dao = new PlatoDao();
	
	public Plato traerPlato( long idProducto) throws Exception{
		Plato p= dao.traerPlato(idProducto);
			//HECHO-- // implementar si c es null lanzar Exception
		if (p==null) throw new Exception ("no existe el Producto con el ID indicado"); 
		return p;
	}
	
	public List<Plato> traerPlato() throws Exception{
		List<Plato> lista = dao.traerPlato();
			//HECHO-- // implementar si c es null lanzar Exception
		if (lista.isEmpty()) throw new Exception ("no existe el Producto con el ID indicado"); 
		return lista;
	}
}
