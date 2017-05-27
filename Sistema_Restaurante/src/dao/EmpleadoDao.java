package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


//import datos.Cliente;
import datos.Persona;
import datos.Empleado;


public class EmpleadoDao {
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
	
	public Empleado traerEmpleado(long idEmpleado ) throws HibernateException
	{
		Empleado objeto = null;
		try {
			iniciaOperacion();
			objeto = (Empleado) session.get(Empleado.class, idEmpleado);
			//Hibernate.initialize(objeto.getRubro());
			//Hibernate.initialize(objeto.getSubrubro());
		}finally {
			session.close();
		}
		return objeto;
		
	}
	
	public Empleado traerEmpleado(int dni) throws HibernateException
	{
		Empleado objeto = null;
		try {
			iniciaOperacion();
			objeto = (Empleado) session .createQuery( "from Empleado e where e.dni=" +dni).uniqueResult();
			//Hibernate.initialize(objeto.getRubro());
			//Hibernate.initialize(objeto.getSubrubro());
		}finally {
			session.close();
		}
		return objeto;
		
	}
	
	/*public Empleado iniciarSesion( String email,String clave) throws HibernateException {
		Empleado objeto = null ;
		try {
		iniciaOperacion();
		objeto = (Empleado) session.createQuery( "from Empleado e where e.email='"+email+"'and e.clave='"+clave+"' and e.esActivo=1").uniqueResult();
		} finally {
		session.close();
		}
		return objeto;
		}*/
	public Empleado iniciarSesion( String usuario,String clave) throws HibernateException {
		Empleado objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Empleado) session.createQuery( "from Empleado e where e.nombreUsuario='"+usuario+"' and e.clave='"+clave+"' and e.esActivo=1 ").uniqueResult();
			Hibernate.initialize(objeto.getTipoEmpleado());
		} finally {
		session.close();
		}
		return objeto;
		}
	
	@SuppressWarnings("unchecked")
	public List<Empleado> traerEmpleado() throws HibernateException
	{
		List<Empleado> lista = null;
		try {
			iniciaOperacion();
			String hql = "from Empleado u ";	
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
