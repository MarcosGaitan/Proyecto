package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Plato;
import datos.PlatoIngrediente;
import datos.Producto;


public class PlatoDao {
	
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
	
	public Plato traerPlato(long idProducto) throws HibernateException
	{
		Plato objeto = null;
		try {
			iniciaOperacion();
			objeto = (Plato) session.get(Plato.class, idProducto);
			
			Hibernate.initialize(objeto.getPlatoIngredientes());
			
			
			for (PlatoIngrediente p : objeto.getPlatoIngredientes()){
				Hibernate.initialize(p.getPlato());
				Hibernate.initialize(p.getIngrediente());
			}
			
			
		}finally {
			session.close();
		}
		return objeto;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Plato> traerPlato() throws HibernateException
	{
		List<Plato> lista = null;
		try {
			iniciaOperacion();
			String hql = "from Plato p ";	
			lista = session.createQuery(hql).list();
			for (Plato p : lista)
			{
				Hibernate.initialize(p.getPlatoIngredientes());
			}
		}finally {
			session.close();
		}
		return lista;
		
	}
	
}
