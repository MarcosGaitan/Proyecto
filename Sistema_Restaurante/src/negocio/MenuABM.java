package negocio;

import java.util.List;

import dao.MenuDao;
import datos.Menu;

public class MenuABM {
	
	MenuDao dao = new MenuDao();
	
	public Menu traerMenu(long idMenu) throws Exception{
		
		Menu menu = dao.traerMenu(idMenu);
		if(menu == null) throw new Exception ("no existe tal menu");
		return menu;
	}
	
	public List<Menu> traerMenu() throws Exception
	{
		List<Menu> lista = dao.traerMenu();
		if (lista.isEmpty()) throw new Exception("Lista vacia, no hay datos");
		return lista;
	}
	
}
