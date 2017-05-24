package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Stock;

public class StockDao {

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
	
	public Stock traerStock(long idStock) throws HibernateException
	{
		Stock objeto = null;
		try {
			iniciaOperacion();
			objeto = (Stock) session.get(Stock.class, idStock);
		}finally {
			session.close();
		}
		return objeto;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Stock> traerStock() throws HibernateException
	{
		List<Stock> lista = null;
		try {
			iniciaOperacion();
			String hql = "from Stock t order by t.idStock";	
			lista = session.createQuery(hql).list();
		}finally {
			session.close();
		}
		return lista;
		
	}
}
