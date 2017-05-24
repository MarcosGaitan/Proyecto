package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Producto;
import datos.TipoEmpleado;

public class TipoEmpleadoDao {
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
	
	public TipoEmpleado traerTipoEmpleado(long idTipoEmpleado) throws HibernateException
	{
		TipoEmpleado objeto = null;
		try {
			iniciaOperacion();
			objeto = (TipoEmpleado) session.get(TipoEmpleado.class, idTipoEmpleado);
		}finally {
			session.close();
		}
		return objeto;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoEmpleado> traerTipoEmpleado() throws HibernateException
	{
		List<TipoEmpleado> lista = null;
		try {
			iniciaOperacion();
			String hql = "from TipoEmpleado t order by t.idTipoEmpleado";	
			lista = session.createQuery(hql).list();
		}finally {
			session.close();
		}
		return lista;
		
	}
}
