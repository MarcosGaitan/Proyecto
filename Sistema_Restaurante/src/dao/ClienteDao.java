package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;

public class ClienteDao {
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
	
	public Cliente traerCliente(long idPersona) throws HibernateException{
		Cliente objeto = null;
		try
		{
			iniciaOperacion();
			objeto = (Cliente)session.get(Cliente.class, idPersona);
		}
		finally{
			session.close();
		}
		return objeto;
	}
	
		
	@SuppressWarnings("unchecked")
	public List<Cliente> traerCliente() throws HibernateException
	{
		List<Cliente> lista = null;
		try
		{
			iniciaOperacion();
			String hql = "From Cliente c order by c.idPersona";
			lista = session.createQuery(hql).list();
		}finally{
			session.close();
		}
		return lista;
	}
	
}
