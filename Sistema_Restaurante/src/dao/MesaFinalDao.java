package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Comanda;
import datos.ComandaItem;
import datos.Mesa;
import datos.MesaFinal;

public class MesaFinalDao {
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
	
	
	
	
	public long agregar(MesaFinal objeto) {
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
	
	public void actualizar(MesaFinal mesaFinal){
		try{
			iniciaOperacion();
			session.update(mesaFinal);
			tx.commit();
		}catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
		
	}
	public MesaFinal traerMesaFinal(long idMesaFinal) throws HibernateException{
		MesaFinal objeto = null;
		try
		{
			iniciaOperacion();
			objeto = (MesaFinal)session.get(MesaFinal.class, idMesaFinal);
		}
		finally{
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<MesaFinal> traerMesaFinal() throws HibernateException
	{
		List<MesaFinal> lista = null;
		try
		{
			iniciaOperacion();
			String hql = "From MesaFinal m order by m.idMesa";
			lista = session.createQuery(hql).list();
		}finally{
			session.close();
		}
		return lista;
	}
	
	public MesaFinal traerMesaFinalyComandas(long idMesaFinal) throws HibernateException{
		MesaFinal objeto = null;
		try
		{
			iniciaOperacion();
			objeto = (MesaFinal)session.get(MesaFinal.class, idMesaFinal);
			
			Hibernate.initialize(objeto.getComandas());
			for (Comanda c : objeto.getComandas())
			{
				Hibernate.initialize(c.getComandaItems());
				for(ComandaItem ci : c.getComandaItems()){
					Hibernate.initialize(ci.getProducto());
				}
			}
			
		}
		finally{
			session.close();
		}
		return objeto;
	}
	
	public MesaFinal traerMesaFinalDesdeIdMesa(long idMesa) throws HibernateException{

		List<MesaFinal> lista ;
		MesaFinal objeto = null;
		try
		{
			iniciaOperacion();
			String hql = "from MesaFinal mf where mf.activa = 1 order by mf.idMesaFinal";
			lista = session.createQuery(hql).list();
			boolean encontrado = false;
			for (int i = 0; i<lista.size() && !encontrado;i++){
				for (Mesa m : lista.get(i).getMesas()){
					if(m.getIdMesa() == idMesa){
						objeto = lista.get(i);
						encontrado=true;
						Hibernate.initialize(objeto.getMesas());
					}
				}
			}
			
			
		}finally{
			session.close();
		}
		return objeto;
	}
	
	public List<MesaFinal> traerMesaFinalesActivas(int activa) throws HibernateException
	{
		List<MesaFinal> lista = null;
		try
		{
			iniciaOperacion();
			String hql = "From MesaFinal m where m.activa = "+ activa;
			lista = session.createQuery(hql).list();
			
			for (MesaFinal mf : lista){
				Hibernate.initialize(mf.getMesas());
			}
		}finally{
			session.close();
		}
		return lista;
	}
	
}
