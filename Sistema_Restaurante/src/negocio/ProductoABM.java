package negocio;

import datos.Producto;

import java.util.List;

import dao.ProductoDao;

public class ProductoABM {
	ProductoDao dao = new ProductoDao();
	
	public Producto traerProducto( long idProducto) throws Exception{
		Producto p= dao.traerProducto(idProducto);
			//HECHO-- // implementar si c es null lanzar Exception
		if (p==null) throw new Exception ("no existe el Producto con el ID indicado"); 
		return p;
	}
	
	public List<Producto> traerProducto() throws Exception{
		List<Producto> lista = dao.traerProducto();
			//HECHO-- // implementar si c es null lanzar Exception
		if (lista.isEmpty()) throw new Exception ("la lista de productos esta vacia"); 
		return lista;
	}
	
}
