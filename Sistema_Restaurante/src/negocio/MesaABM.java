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
		
		if (mesa.getEstado().startsWith("l")){
			mesa.setEstadoMesa(new Libre());
		}else if (mesa.getEstado().startsWith("o")){
			mesa.setEstadoMesa(new Ocupada());
		}else{
			mesa.setEstadoMesa(new Terminada());
		}
		return mesa;
	}
	
	public List<Mesa> traerMesa() throws Exception
	{
		List<Mesa> lista = dao.traerMesa();
		if(lista.isEmpty()) throw new Exception("La lista esta vacia");
		for(Mesa m : lista){
			if (m.getEstado().startsWith("l")){
				m.setEstadoMesa(new Libre());
			}else if (m.getEstado().startsWith("o")){
				m.setEstadoMesa(new Ocupada());
			}else{
				m.setEstadoMesa(new Terminada());
			}

		}
		
		return lista;
	}
}
