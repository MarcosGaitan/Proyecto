package negocio;

import java.util.List;

import dao.MesaFinalDao;
import datos.Mesa;
import datos.MesaFinal;

public class MesaFinalABM {
	
	MesaFinalDao dao = new MesaFinalDao();
	
	public long agregarMesaFinal(MesaFinal mesaFinal)
	{
		long id=0;
		id= dao.agregar(mesaFinal);
		return id;
	}
	
	public void actualizarMesaFinal(MesaFinal mesaFinal)
	{
		dao.actualizar(mesaFinal);
	}
	
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
		if (mesaFinal != null) {
			for(Mesa m : mesaFinal.getMesas()){
				m.inicializarMesa();
			}
		}
		return mesaFinal;
	}
	
	public List<MesaFinal> traerMesasFinalesActivas() throws Exception{
		List<MesaFinal> mesasFinales = dao.traerMesaFinalesActivas();
		if (mesasFinales == null) throw new Exception("no hay mesas finales activas");
		return mesasFinales;
	}
	
	public void terminarMesas(MesaFinal mesaFinal)
	{
		mesaFinal.terminarMesas();
	}
	public void liberarMesas(MesaFinal mesaFinal){
		mesaFinal.liberarMesas();
		dao.actualizar(mesaFinal);
	}
	
}
