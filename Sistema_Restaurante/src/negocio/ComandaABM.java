package negocio;

import java.util.List;

import org.hibernate.Hibernate;

import dao.ComandaDao;
import datos.Cliente;
import datos.Comanda;
import datos.Producto;

public class ComandaABM {
	
	ComandaDao dao = new ComandaDao();
	
	public long agregarComanda(){
		long idUltimo=0;
		
		return idUltimo;
	}
	
	public void modificarComanda(Comanda comanda){
		
	}
	
	public Comanda traerComanda(long idComanda) throws Exception{
		Comanda comanda = dao.traerComanda(idComanda);
		if(comanda == null) throw new Exception("no existe tal comanda");
		return comanda;
	}
	
	public Comanda traerComandaEItems(long idComanda) throws Exception{
		Comanda comanda = dao.traerComandaEItems(idComanda);
		if(comanda == null) throw new Exception("no existe tal comanda");
		return comanda;
	}

	public List<Comanda> traerComandaEItems() throws Exception {
		List <Comanda> comanda = dao.traerComandaEItems();
		if(comanda == null) throw new Exception("no existe tal comanda");
		return comanda;
	}
	
	public void eliminarComanda(long idComanda) throws Exception{
		Comanda comanda= dao.traerComanda(idComanda);
		
		if (comanda==null) {
			throw new Exception("No existe Comanda con ID: "+idComanda);
		}
		dao.eliminar(comanda);
	}
	
}
