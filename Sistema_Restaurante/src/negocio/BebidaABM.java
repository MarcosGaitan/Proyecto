package negocio;

import java.util.List;

import dao.BebidaDao;
import datos.Bebida;

public class BebidaABM {
	
	BebidaDao dao = new BebidaDao();
	
	public Bebida traerBebida(long idBebida) throws Exception{
		
		Bebida bebida = dao.traerBebida(idBebida);
		if(bebida == null) throw new Exception ("no existe tal bebida");
		return bebida;
	}
	
	public List<Bebida> traerBebida() throws Exception
	{
		List<Bebida> lista = dao.traerBebida();
		if (lista.isEmpty()) throw new Exception("Lista vacia, no hay datos");
		return lista;
	}
	
}
