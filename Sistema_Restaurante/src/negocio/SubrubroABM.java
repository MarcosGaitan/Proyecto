package negocio;

import java.util.List;

import dao.SubrubroDao;
import datos.Subrubro;

public class SubrubroABM {
	
	SubrubroDao dao = new SubrubroDao();
	
	public Subrubro traerSubrubro( long idSubrubro) throws Exception{
		Subrubro p= dao.traerSubrubro(idSubrubro);
			
		if (p==null) throw new Exception ("no existe el Subrubro con el ID indicado"); 
		return p;
	}
	
	public List<Subrubro> traerSubrubro() throws Exception{
		List<Subrubro> lista = dao.traerSubrubro();
			
		if (lista.isEmpty()) throw new Exception ("la lista de Subrubro esta vacia"); 
		return lista;
	}
}
