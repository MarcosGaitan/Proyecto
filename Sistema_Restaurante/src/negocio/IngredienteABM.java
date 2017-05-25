package negocio;

import java.util.List;

import dao.IngredienteDao;
import datos.Ingrediente;

public class IngredienteABM {
	
	IngredienteDao dao = new IngredienteDao();
	
	public Ingrediente traerIngrediente(long idIngrediente) throws Exception{
		
		Ingrediente ingrediente = dao.traerIngrediente(idIngrediente);
		if(ingrediente == null) throw new Exception ("no existe tal Ingrediente");
		return ingrediente;
	}
	
	public List<Ingrediente> traerIngrediente() throws Exception
	{
		List<Ingrediente> lista = dao.traerIngrediente();
		if (lista.isEmpty()) throw new Exception("Lista vacia, no hay datos");
		return lista;
	}
	
}
