package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Mesa;

public class MesaDao {
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
	
	public Mesa traerMesa(long idMesa) throws HibernateException{
		Mesa objeto = null;
		try
		{
			iniciaOperacion();
			objeto = (Mesa)session.get(Mesa.class, idMesa);
		}
		finally{
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Mesa> traerMesa() throws HibernateException
	{
		List<Mesa> lista = null;
		try
		{
			iniciaOperacion();
			String hql = "From Mesa m order by m.idMesa";
			lista = session.createQuery(hql).list();
		}finally{
			session.close();
		}
		return lista;
	}
	
}
