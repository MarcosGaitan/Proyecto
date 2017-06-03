package negocio;

import java.util.List;

import dao.MesaDao;
import datos.Mesa;
import state.Libre;
import state.Ocupada;
import state.Terminada;

public class MesaABM {
	
	MesaDao dao = new MesaDao();
	
	public Mesa traerMesa(long idMesa) throws Exception
	{
		Mesa mesa = dao.traerMesa(idMesa);
		if (mesa == null) throw new Exception("no existe esa Mesa con ese ID");
		mesa.inicializarMesa();
		
		return mesa;
	}
	
	public List<Mesa> traerMesa() throws Exception
	{
		List<Mesa> lista = dao.traerMesa();
		if(lista.isEmpty()) throw new Exception("La lista esta vacia");
		for(Mesa m : lista){
			m.inicializarMesa();
		}
		return lista;
	}
	
	public void actualizarMesa(Mesa mesa)
	{
		
		dao.actualizar(mesa);
	}
	
	public List<Mesa> traerTerminadas(){
		List<Mesa> mesas = dao.traerTerminadas();
		return mesas;
	}
	
	public List<Mesa> traerOcupadas(){
		List<Mesa> mesas = dao.traerOcupadas();
		return mesas;
	}
	public List<Mesa> traerLibres(){
		List<Mesa> mesas = dao.traerLibres();
		return mesas;
	}
}
