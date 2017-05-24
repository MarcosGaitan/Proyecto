package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.TipoCliente;


public class TipoClienteDao {
	
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
	
	public TipoCliente traerTipoCliente(long idTipoCliente) throws HibernateException
	{
		TipoCliente objeto = null;
		try {
			iniciaOperacion();
			objeto = (TipoCliente) session.get(TipoCliente.class, idTipoCliente);
		}finally {
			session.close();
		}
		return objeto;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoCliente> traerTipoCliente() throws HibernateException
	{
		List<TipoCliente> lista = null;
		try {
			iniciaOperacion();
			String hql = "from TipoCliente t order by t.idTipoCliente";	
			lista = session.createQuery(hql).list();
		}finally {
			session.close();
		}
		return lista;
		
	}
}
