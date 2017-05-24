package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.ProductoMenu;

public class ProductoMenuDao {
	
	
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
	
	public ProductoMenu traerProductoMenu(long idProductoMenu) throws HibernateException
	{
		ProductoMenu objeto = null;
		try {
			iniciaOperacion();
			objeto = (ProductoMenu) session.get(ProductoMenu.class, idProductoMenu);
			Hibernate.initialize(objeto.getMenu());
			Hibernate.initialize(objeto.getProducto());
			
		}finally {
			session.close();
		}
		return objeto;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductoMenu> traerProductoMenu() throws HibernateException
	{
		List<ProductoMenu> lista = null;
		try {
			iniciaOperacion();
			String hql = "from ProductoMenu p ";	
			lista = session.createQuery(hql).list();
			
			for (ProductoMenu p : lista)
			{
				Hibernate.initialize(p.getMenu());
				Hibernate.initialize(p.getProducto());
			}
			
		}finally {
			session.close();
		}
		return lista;
	}
	
	public List<ProductoMenu> traerProductosMenuDeTalMenu(long idMenu) throws HibernateException
	{
		List<ProductoMenu> lista = null;
		try {
			iniciaOperacion();
			String hql = "from ProductoMenu p where p.menu="+idMenu;	
			lista = session.createQuery(hql).list();
			
			
			for (ProductoMenu p : lista)
			{
				Hibernate.initialize(p.getMenu());
				Hibernate.initialize(p.getProducto());
			}
			
		}finally {
			session.close();
		}
		return lista;
	}
}
