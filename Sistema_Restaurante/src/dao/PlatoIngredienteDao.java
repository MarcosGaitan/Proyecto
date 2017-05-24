package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.PlatoIngrediente;
import datos.ProductoMenu;

public class PlatoIngredienteDao {
	
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
	
	public PlatoIngrediente traerPlatoIngrediente(long idPlatoIngrediente) throws HibernateException
	{
		PlatoIngrediente objeto = null;
		try {
			iniciaOperacion();
			objeto = (PlatoIngrediente) session.get(PlatoIngrediente.class, idPlatoIngrediente);
			Hibernate.initialize(objeto.getPlato());
			Hibernate.initialize(objeto.getIngrediente());
		}finally {
			session.close();
		}
		return objeto;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<PlatoIngrediente> traerPlatoIngrediente() throws HibernateException
	{
		List<PlatoIngrediente> lista = null;
		try {
			iniciaOperacion();
			String hql = "from PlatoIngrediente p order by p.idPlatoIngrediente";	
			lista = session.createQuery(hql).list();
			
			for (PlatoIngrediente p : lista)
			{
				Hibernate.initialize(p.getPlato());
				Hibernate.initialize(p.getIngrediente());
			}
		}finally {
			session.close();
		}
		return lista;
		
	}
	
	
	
}
