package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Bebida;

public class BebidaDao {
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
	
	public Bebida traerBebida(long idBebida) throws HibernateException{
		Bebida objeto = null;
		try
		{
			iniciaOperacion();
			objeto = (Bebida)session.get(Bebida.class, idBebida);
		}
		finally{
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Bebida> traerBebida() throws HibernateException
	{
		List<Bebida> lista = null;
		try
		{
			iniciaOperacion();
			String hql = "From Bebida m order by m.idProducto";
			lista = session.createQuery(hql).list();
		}finally{
			session.close();
		}
		return lista;
	}
	
}
