package datos;

import java.util.GregorianCalendar;
import java.util.Set;

public class MesaFinal {
	
	private long idMesaFinal;
	private int cantidadComensales;
	private boolean isActiva;
	private String nombre;
	private GregorianCalendar tiempoInicio;
	private GregorianCalendar tiempoFin;
	private Set<Mesa> mesas;
	private Set<Comanda> comandas;
	
	public MesaFinal() {}

	public long getIdMesaFinal() {
		return idMesaFinal;
	}

	public void setIdMesaFinal(long idMesaFinal) {
		this.idMesaFinal = idMesaFinal;
	}

	public int getCantidadComensales() {
		return cantidadComensales;
	}

	public void setCantidadComensales(int cantidadComensales) {
		this.cantidadComensales = cantidadComensales;
	}

	public boolean isActiva() {
		return isActiva;
	}

	public void setActiva(boolean isActiva) {
		this.isActiva = isActiva;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public GregorianCalendar getTiempoInicio() {
		return tiempoInicio;
	}

	public void setTiempoInicio(GregorianCalendar tiempoInicio) {
		this.tiempoInicio = tiempoInicio;
	}

	public GregorianCalendar getTiempoFin() {
		return tiempoFin;
	}

	public void setTiempoFin(GregorianCalendar tiempoFin) {
		this.tiempoFin = tiempoFin;
	}

	public Set<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(Set<Mesa> mesas) {
		this.mesas = mesas;
	}

	public Set<Comanda> getComandas() {
		return comandas;
	}

	public void setComandas(Set<Comanda> comandas) {
		this.comandas = comandas;
	}

	@Override
	public String toString() {
		return "MesaFinal [idMesaFinal=" + idMesaFinal + ", cantidadComensales=" + cantidadComensales + ", isActiva="
				+ isActiva + ", nombre=" + nombre + ", tiempoInicio=" + tiempoInicio + ", tiempoFin=" + tiempoFin
				+ ", mesas=" + mesas + ", comandas=" + comandas + "]";
	}
	
	
	
}
