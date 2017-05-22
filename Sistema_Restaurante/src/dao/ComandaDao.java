package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Comanda;

public class ComandaDao {
	
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
	
	
	public long agregar(Comanda objeto) {
		long id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt (session.save(objeto).toString());
			tx .commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session .close();
		}
		return id;
	}
	
	public Comanda traerComanda(long idComanda){
		Comanda objeto = null;
		try{
			iniciaOperacion();
			objeto = (Comanda)session.get(Comanda.class, idComanda);
		}
		finally{
			session.close();
		}
		return objeto;
	}
	
	public void modificar(Comanda objeto){
		try{
			iniciaOperacion();
				session.update(objeto);
				tx.commit();
			
		}catch(HibernateException he){
			this.manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
		
	}
	
	public void eliminar(Comanda objeto){
		try{
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		}catch(HibernateException he){
			this.manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
	}
	
	public Comanda traerComandaEItems(long idComanda){
		Comanda objeto = null;
		try{
			iniciaOperacion();
			String hql = "from comanda c where c.idComanda =" + idComanda; 
			objeto = (Comanda)session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto);
		}finally{
			session.close();
		}
		return objeto;
	}
	
	
	
}
