package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.ItemListaPrecio;

public class ItemListaPrecioDao {
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
	
	public ItemListaPrecio traerItemListaPrecio(long idItemListaPrecio) throws HibernateException{
		ItemListaPrecio objeto = null;
		try
		{
			iniciaOperacion();
			objeto = (ItemListaPrecio)session.get(ItemListaPrecio.class, idItemListaPrecio);
		}
		finally{
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<ItemListaPrecio> traerItemListaPrecio() throws HibernateException
	{
		List<ItemListaPrecio> lista = null;
		try
		{
			iniciaOperacion();
			String hql = "From ItemListaPrecio m order by m.idItemListaPrecio";
			lista = session.createQuery(hql).list();
		}finally{
			session.close();
		}
		return lista;
	}
	
}
