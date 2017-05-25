package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.ComandaItem;

public class ComandaItemDao {
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
	
	public ComandaItem traerComandaItem(long idComandaItem) throws HibernateException{
		ComandaItem objeto = null;
		try
		{
			iniciaOperacion();
			objeto = (ComandaItem)session.get(ComandaItem.class, idComandaItem);
		}
		finally{
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<ComandaItem> traerComandaItem() throws HibernateException
	{
		List<ComandaItem> lista = null;
		try
		{
			iniciaOperacion();
			String hql = "From ComandaItem c order by c.idComandaItem";
			lista = session.createQuery(hql).list();
		}finally{
			session.close();
		}
		return lista;
	}
	
}
