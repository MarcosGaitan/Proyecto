package datos;

import java.util.GregorianCalendar;
import java.util.Set;

public class Comanda {
	
	private int idComanda;
	//private Cliente cliente;
	//private Empleado camarero;
	private boolean confirmada;
	private boolean pagada;
	private boolean anulada;
	private String habitacion;
	private GregorianCalendar fechaCreacion;
	private Set<ComandaItem> comandaItems;
	
	public Comanda() {}
	/*
	public Comanda(Empleado camarero, Set<ComandaItem> comandaItems) {
		super();
		this.camarero = camarero;
		this.comandaItems = comandaItems;
		this.confirmada = false;
		this.pagada = false;
		this.anulada = false;
		this.fechaCreacion = new GregorianCalendar();
	}

	public int getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getCamarero() {
		return camarero;
	}

	public void setCamarero(Empleado camarero) {
		this.camarero = camarero;
	}
	
	*/
	public boolean isConfirmada() {
		return confirmada;
	}

	public void setConfirmada(boolean confirmada) {
		this.confirmada = confirmada;
	}

	public boolean isPagada() {
		return pagada;
	}

	public void setPagada(boolean pagada) {
		this.pagada = pagada;
	}

	public boolean isAnulada() {
		return anulada;
	}

	public void setAnulada(boolean anulada) {
		this.anulada = anulada;
	}

	public String getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(String habitacion) {
		this.habitacion = habitacion;
	}

	public GregorianCalendar getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(GregorianCalendar fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Set<ComandaItem> getComandaItems() {
		return comandaItems;
	}

	public void setComandaItems(Set<ComandaItem> comandaItems) {
		this.comandaItems = comandaItems;
	}

	@Override
	public String toString() {
		return "Comanda [idComanda=" + idComanda + ", confirmada=" + confirmada + ", pagada=" + pagada + ", anulada="
				+ anulada + ", habitacion=" + habitacion + ", fechaCreacion=" + fechaCreacion + ", comandaItems="
				+ comandaItems + "]";
	}
	
	
	
}
