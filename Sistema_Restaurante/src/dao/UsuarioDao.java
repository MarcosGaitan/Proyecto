package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;
import datos.Usuario;

public class UsuarioDao {
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
	
	public Usuario traerUsuario (long idUsuario ) throws HibernateException
	{
		Usuario objeto = null;
		try {
			iniciaOperacion();
			objeto = (Usuario) session.get(Usuario.class, idUsuario);
			//Hibernate.initialize(objeto.getRubro());
			//Hibernate.initialize(objeto.getSubrubro());
		}finally {
			session.close();
		}
		return objeto;
		
	}
	
	public Usuario traerUsuario (int dni) throws HibernateException
	{
		Usuario objeto = null;
		try {
			iniciaOperacion();
			objeto = (Usuario) session .createQuery( "from Usuario u where u.dni=" +dni).uniqueResult();
			//Hibernate.initialize(objeto.getRubro());
			//Hibernate.initialize(objeto.getSubrubro());
		}finally {
			session.close();
		}
		return objeto;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> traerUsuario() throws HibernateException
	{
		List<Usuario> lista = null;
		try {
			iniciaOperacion();
			String hql = "from Usuario u ";	
			lista = session.createQuery(hql).list();
			/*for (Usuario u : lista)
			{
				Hibernate.initialize(p.getRubro());
				Hibernate.initialize(p.getSubrubro());
			}*/
		}finally {
			session.close();
		}
		return lista;
		
	}
	
}
