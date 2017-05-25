package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.ListaPrecio;

public class ListaPrecioDao {
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
	
	public ListaPrecio traerListaPrecio(long idListaPrecio) throws HibernateException{
		ListaPrecio objeto = null;
		try
		{
			iniciaOperacion();
			objeto = (ListaPrecio)session.get(ListaPrecio.class, idListaPrecio);
		}
		finally{
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<ListaPrecio> traerListaPrecio() throws HibernateException
	{
		List<ListaPrecio> lista = null;
		try
		{
			iniciaOperacion();
			String hql = "From ListaPrecio m order by m.idListaPrecio";
			lista = session.createQuery(hql).list();
		}finally{
			session.close();
		}
		return lista;
	}
	
}
