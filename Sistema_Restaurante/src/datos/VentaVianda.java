package datos;

import java.util.GregorianCalendar;

public class VentaVianda {
	
	private long idVentaVianda;
	private float precioVianda;
	private GregorianCalendar fechaDeVenta;
	private int cantidad;
	private Vianda vianda;
	
	public VentaVianda(){}
	
	public VentaVianda(float precioVianda, GregorianCalendar fechaDeVenta, int cantidad, Vianda vianda) {
		super();
		this.precioVianda = precioVianda;
		this.fechaDeVenta = fechaDeVenta;
		this.cantidad = cantidad;
		this.vianda = vianda;
	}

	public long getIdVentaVianda() {
		return idVentaVianda;
	}

	public void setIdVentaVianda(long idVentaVianda) {
		this.idVentaVianda = idVentaVianda;
	}

	public float getPrecioVianda() {
		return precioVianda;
	}

	public void setPrecioVianda(float precioVianda) {
		this.precioVianda = precioVianda;
	}

	public GregorianCalendar getFechaDeVenta() {
		return fechaDeVenta;
	}

	public void setFechaDeVenta(GregorianCalendar fechaDeVenta) {
		this.fechaDeVenta = fechaDeVenta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Vianda getVianda() {
		return vianda;
	}

	public void setVianda(Vianda vianda) {
		this.vianda = vianda;
	}

	@Override
	public String toString() {
		return "VentaVianda [idVentaVianda=" + idVentaVianda + ", precioVianda=" + precioVianda + ", fechaDeVenta="
				+ fechaDeVenta + ", cantidad=" + cantidad + ", vianda=" + vianda + "]";
	}
	
	
	
}
