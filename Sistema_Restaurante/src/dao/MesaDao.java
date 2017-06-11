package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Mesa;
import datos.MesaFinal;

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
	
	public void actualizar(Mesa objeto) {
		
		try {
			iniciaOperacion();
			session.update(objeto);
			tx .commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session .close();
		}
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
	
	public Mesa traerMesa(int nroMesa) throws HibernateException{
		Mesa objeto = null;
		try
		{
			iniciaOperacion();
			String hql = "from Mesa m where m.numero="+ nroMesa;
			objeto = (Mesa)session.createQuery(hql).uniqueResult();
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
	
	@SuppressWarnings("unchecked")
	public List<Mesa> traerTerminadas() throws HibernateException
	{
		List<Mesa> lista = null;
		try
		{
			iniciaOperacion();
			String hql = "From Mesa m where m.estado = 'terminada' order by m.idMesa";
			lista = session.createQuery(hql).list();
		}finally{
			session.close();
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Mesa> traerOcupadas() throws HibernateException
	{
		List<Mesa> lista = null;
		try
		{
			iniciaOperacion();
			String hql = "From Mesa m where m.estado = 'ocupada' order by m.idMesa";
			lista = session.createQuery(hql).list();
		}finally{
			session.close();
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Mesa> traerLibres() throws HibernateException
	{
		List<Mesa> lista = null;
		try
		{
			iniciaOperacion();
			String hql = "From Mesa m where m.estado = 'libre' order by m.idMesa";
			lista = session.createQuery(hql).list();
		}finally{
			session.close();
		}
		return lista;
	}
}
