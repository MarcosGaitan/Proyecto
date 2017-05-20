package datos;

import state.EstadoMesa;
import state.Libre;

public class Mesa {
	
	private long idMesa;
	private int cantidadComensales;
	private int numero;
	private EstadoMesa estado = new Libre();
	
	public Mesa() {
	}

	public Mesa(int cantidadComensales, int numero) {
		this.cantidadComensales = cantidadComensales;
		this.numero = numero;
	}
	
	/*  metodos de estados de mesa*/
	public void dejarLibre()
	{
		this.setEstado(this.getEstado().dejarLibre());
	}
	
	public void ocupar()
	{
		this.setEstado(this.getEstado().ocupar());
	}
	
	public void terminar()
	{
		this.setEstado(this.getEstado().terminar());
	}
	/* Getters and Setters*/
	public long getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(long idMesa) {
		this.idMesa = idMesa;
	}

	public int getCantidadComensales() {
		return cantidadComensales;
	}

	public void setCantidadComensales(int cantidadComensales) {
		this.cantidadComensales = cantidadComensales;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public EstadoMesa getEstado() {
		return estado;
	}

	public void setEstado(EstadoMesa estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Mesa [idMesa=" + idMesa + ", cantidadComensales=" + cantidadComensales + ", numero=" + numero
				+ ", estado=" + estado + "]";
	}
	
	
	
	
}
