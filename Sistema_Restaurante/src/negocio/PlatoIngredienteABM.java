package negocio;

import java.util.List;

import dao.PlatoIngredienteDao;
import datos.PlatoIngrediente;

public class PlatoIngredienteABM {
	
	PlatoIngredienteDao dao = new PlatoIngredienteDao();
	
	public PlatoIngrediente traerPlatoIngrediente( long idPlatoIngrediente) throws Exception{
		PlatoIngrediente p= dao.traerPlatoIngrediente(idPlatoIngrediente);
		
		if (p==null) throw new Exception ("no existe el PlatoIngrediente con el ID indicado"); 
		return p;
	}
	
	public List<PlatoIngrediente> traerPlatoIngrediente() throws Exception{
		List<PlatoIngrediente> lista = dao.traerPlatoIngrediente();
		if (lista.isEmpty()) throw new Exception ("la lista de PlatoIngrediente esta vacia"); 
		return lista;
	}
}
