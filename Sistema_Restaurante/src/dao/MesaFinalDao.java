package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.MesaFinal;

public class MesaFinalDao {
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
	
	public MesaFinal traerMesaFinal(long idMesaFinal) throws HibernateException{
		MesaFinal objeto = null;
		try
		{
			iniciaOperacion();
			objeto = (MesaFinal)session.get(MesaFinal.class, idMesaFinal);
		}
		finally{
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<MesaFinal> traerMesaFinal() throws HibernateException
	{
		List<MesaFinal> lista = null;
		try
		{
			iniciaOperacion();
			String hql = "From MesaFinal m order by m.idMesa";
			lista = session.createQuery(hql).list();
		}finally{
			session.close();
		}
		return lista;
	}
	
}
