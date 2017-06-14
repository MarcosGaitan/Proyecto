package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;
import datos.Comanda;
import datos.ComandaItem;
import datos.Producto;


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
	
	public Comanda traerComanda(long idComanda) throws HibernateException{
		Comanda objeto = null;
		try{
			iniciaOperacion();
			objeto = (Comanda)session.get(Comanda.class, idComanda);
			Hibernate.initialize(objeto.getComandaItems());
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
			objeto = (Comanda)session.get(Comanda.class, idComanda);
			Hibernate.initialize(objeto.getComandaItems());
			Hibernate.initialize(objeto.getMesaFinal());

		}finally{
			session.close();
		}
		return objeto;
	}
	
	public List<Comanda> traerComandaEItems() throws HibernateException
	{
		List<Comanda> lista = null;
		try
		{
			iniciaOperacion();
			String hql = "From Comanda c order by c.idComanda";
			lista = session.createQuery(hql).list();
			Hibernate.initialize(lista);
			for (Comanda c: lista){
				Hibernate.initialize(c.getComandaItems());
				Hibernate.initialize(c.getMesaFinal());
				for(ComandaItem ci : c.getComandaItems()){
					Hibernate.initialize(ci.getProducto());
				}
			}
		}finally{
			session.close();
		}
		return lista;
	}
	
}
