package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.ItemListaPrecio;
import datos.ListaPrecio;
import datos.Menu;
import datos.ProductoMenu;

public class MenuDao {
	private static Session session ;
	private Transaction tx ;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil. getSessionFactory ().openSession();
		tx = session .beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx .rollback();
		throw new HibernateException( "ERROR en la capa de acceso a datos" , he);
	}
	
	public Menu traerMenu(long idMenu)
	{
		Menu objeto = null;
		try{
			iniciaOperacion();
			objeto = (Menu)session.get(Menu.class, idMenu);
			
			Hibernate.initialize(objeto.getProductosMenu());
			for (ProductoMenu pm : objeto.getProductosMenu()){
				Hibernate.initialize(pm.getProducto());
			}
			
			//Hibernate.initialize(objeto.getListaPrecio().getItemsListaPrecio());
			
			/*
			for (ItemListaPrecio p : objeto.getListaPrecio().getItemsListaPrecio()){
				Hibernate.initialize(p.getListaPrecio());
				Hibernate.initialize(p.getProducto());
			}
			//Hibernate.initialize(objeto.getProductoMenu());
			 */
			
		}finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Menu> traerMenu()
	{
		List<Menu> lista = null;
		try{
			iniciaOperacion();
			String hql = "from menu m order by m.idMenu";
			lista = session.createQuery(hql).list();
		}
		finally{
			session.close();
		}
		return lista;
	}
	
}
