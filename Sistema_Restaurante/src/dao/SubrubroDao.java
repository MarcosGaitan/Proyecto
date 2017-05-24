package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Subrubro;

public class SubrubroDao {
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
	
	public Subrubro traerSubrubro(long idSubrubro) throws HibernateException
	{
		Subrubro objeto = null;
		try {
			iniciaOperacion();
			objeto = (Subrubro) session.get(Subrubro.class, idSubrubro);
		}finally {
			session.close();
		}
		return objeto;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Subrubro> traerSubrubro() throws HibernateException
	{
		List<Subrubro> lista = null;
		try {
			iniciaOperacion();
			String hql = "from Subrubro ";	
			lista = session.createQuery(hql).list();
		}finally {
			session.close();
		}
		return lista;
		
	}
}
