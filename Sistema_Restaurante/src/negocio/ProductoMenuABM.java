package negocio;

import java.util.List;

import dao.ProductoMenuDao;
import datos.ProductoMenu;

public class ProductoMenuABM {
	ProductoMenuDao dao = new ProductoMenuDao();
	
	public ProductoMenu traerProductoMenu( long idProductoMenu) throws Exception{
		ProductoMenu p= dao.traerProductoMenu(idProductoMenu);
			
		if (p==null) throw new Exception ("no existe el ProductoMenu con el ID indicado"); 
		return p;
	}
	
	public List<ProductoMenu> traerProductoMenu() throws Exception{
		List<ProductoMenu> lista = dao.traerProductoMenu();
		if (lista.isEmpty()) throw new Exception ("la lista de ProductoMenu esta vacia"); 
		return lista;
	}
	
	public List<ProductoMenu> traerProductosMenuDeTalMenu(long idMenu) throws Exception{
		List<ProductoMenu> lista = dao.traerProductosMenuDeTalMenu(idMenu);
		if (lista.isEmpty()) throw new Exception ("la lista de Producto de ese Menu esta vacia"); 
		return lista;
	}
}
