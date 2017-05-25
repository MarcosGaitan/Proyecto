package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Ingrediente;

public class IngredienteDao {
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
	
	public Ingrediente traerIngrediente(long idIngrediente) throws HibernateException{
		Ingrediente objeto = null;
		try
		{
			iniciaOperacion();
			objeto = (Ingrediente)session.get(Ingrediente.class, idIngrediente);
		}
		finally{
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ingrediente> traerIngrediente() throws HibernateException
	{
		List<Ingrediente> lista = null;
		try
		{
			iniciaOperacion();
			String hql = "From Ingrediente c order by c.idIngrediente";
			lista = session.createQuery(hql).list();
		}finally{
			session.close();
		}
		return lista;
	}
	
}
