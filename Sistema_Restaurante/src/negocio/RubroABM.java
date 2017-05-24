package negocio;

import java.util.List;

import dao.RubroDao;
import datos.Rubro;

public class RubroABM {
	
	RubroDao dao = new RubroDao();
	
	public Rubro traerRubro( long idRubro) throws Exception{
		Rubro p= dao.traerRubro(idRubro);
			
		if (p==null) throw new Exception ("no existe el Rubro con el ID indicado"); 
		return p;
	}
	
	public List<Rubro> traerRubro() throws Exception{
		List<Rubro> lista = dao.traerRubro();
			
		if (lista.isEmpty()) throw new Exception ("la lista de Rubro esta vacia"); 
		return lista;
	}
}
