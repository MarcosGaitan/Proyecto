package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Rubro;

public class RubroDao {
	
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
	
	public Rubro traerRubro(long idRubro) throws HibernateException
	{
		Rubro objeto = null;
		try {
			iniciaOperacion();
			objeto = (Rubro) session.get(Rubro.class, idRubro);
		}finally {
			session.close();
		}
		return objeto;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Rubro> traerRubro() throws HibernateException
	{
		List<Rubro> lista = null;
		try {
			iniciaOperacion();
			String hql = "from Rubro r order by r.idRubro";	
			lista = session.createQuery(hql).list();
		}finally {
			session.close();
		}
		return lista;
		
	}
}
