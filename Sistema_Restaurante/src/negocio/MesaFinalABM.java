package negocio;

import java.util.List;

import dao.MesaFinalDao;
import datos.MesaFinal;

public class MesaFinalABM {
	
	MesaFinalDao dao = new MesaFinalDao();
	
	public MesaFinal traerMesaFinal(long idMesaFinal) throws Exception
	{
		MesaFinal mesaFinal = dao.traerMesaFinal(idMesaFinal);
		if (mesaFinal == null) throw new Exception("no existe esa Mesa con ese ID");
		return mesaFinal;
	}
	
	public List<MesaFinal> traerMesaFinal() throws Exception
	{
		List<MesaFinal> lista = dao.traerMesaFinal();
		if(lista.isEmpty()) throw new Exception("La lista esta vacia");
		return lista;
	}
	
	public MesaFinal traerMesaFinalyComandas(long idMesaFinal) throws Exception
	{
		MesaFinal mesaFinal = dao.traerMesaFinalyComandas(idMesaFinal);
		if (mesaFinal == null) throw new Exception("No existe tal mesa final");
		return mesaFinal;
	}
	
	public MesaFinal traerMesaFinalDesdeIdMesa(long idMesa) throws Exception{
		MesaFinal mesaFinal = dao.traerMesaFinalDesdeIdMesa(idMesa);
		if (mesaFinal == null) throw new Exception("No existe mesafinal");
		mesaFinal = dao.traerMesaFinalyComandas(mesaFinal.getIdMesaFinal());
		return mesaFinal;
	}

}
