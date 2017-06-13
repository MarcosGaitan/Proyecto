package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Producto;

public class ProductoDao {
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
	
	public Producto traerProducto(long idProducto) throws HibernateException
	{
		Producto objeto = null;
		try {
			iniciaOperacion();
			objeto = (Producto) session.get(Producto.class, idProducto);
			Hibernate.initialize(objeto.getRubro());
			Hibernate.initialize(objeto.getSubrubro());
		}finally {
			session.close();
		}
		return objeto;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Producto> traerProducto() throws HibernateException
	{
		List<Producto> lista = null;
		try {
			iniciaOperacion();
			String hql = "from Producto p ";	
			lista = session.createQuery(hql).list();
			for (Producto p : lista)
			{
				Hibernate.initialize(p.getRubro());
				Hibernate.initialize(p.getSubrubro());
			}
		}finally {
			session.close();
		}
		return lista;
		
	}
	
}
