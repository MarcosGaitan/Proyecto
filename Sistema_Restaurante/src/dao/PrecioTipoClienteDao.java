package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.PrecioTipoCliente;

public class PrecioTipoClienteDao {
	
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
	
	public PrecioTipoCliente traerPrecioTipoCliente(long idPrecioTipoCliente) throws HibernateException
	{
		PrecioTipoCliente objeto = null;
		try {
			iniciaOperacion();
			objeto = (PrecioTipoCliente) session.get(PrecioTipoCliente.class, idPrecioTipoCliente);
			Hibernate.initialize(objeto.getItemListaPrecio());
			Hibernate.initialize(objeto.getTipoCliente());
		}finally {
			session.close();
		}
		return objeto;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<PrecioTipoCliente> traerPrecioTipoCliente() throws HibernateException
	{
		List<PrecioTipoCliente> lista = null;
		try {
			iniciaOperacion();
			String hql = "from PrecioTipoCliente p order by p.idPrecioTipoCliente";	
			lista = session.createQuery(hql).list();
			for (PrecioTipoCliente p : lista){
				Hibernate.initialize(p.getItemListaPrecio());
				Hibernate.initialize(p.getTipoCliente());
			}
		}finally {
			session.close();
		}
		return lista;
	}
	
}
