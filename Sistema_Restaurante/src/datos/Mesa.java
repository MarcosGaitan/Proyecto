package datos;

import state.EstadoMesa;
import state.Libre;
import state.Ocupada;
import state.Terminada;

public class Mesa {
	
	
	
	private long idMesa;
	private int cantidadComensales;
	private int numero;
	private EstadoMesa estadoMesa;
	private String estado; 
	
	public Mesa() {
	}

	public Mesa(int cantidadComensales, int numero) {
		this.cantidadComensales = cantidadComensales;
		this.numero = numero;
		this.estadoMesa = new Libre();
		this.estado = "libre";
	}
	
	/*  metodos de estados de mesa*/
	public void dejarLibre()
	{
		this.setEstadoMesa(this.getEstadoMesa().dejarLibre());
		if (this.getEstadoMesa().getColor().equals("verde")){
			this.estado = "libre";
		}
	}
	
	public void ocupar()
	{
		
		this.setEstadoMesa(this.getEstadoMesa().ocupar());
		if (this.getEstadoMesa().getColor().equals("rojo")){
			
			this.estado = "ocupada";
		}
	}
	
	public void terminar()
	{
		this.setEstadoMesa(this.getEstadoMesa().terminar());
		if (this.getEstadoMesa().getColor().equals("azul")){
			this.estado = "terminada";
		}
		
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

	public EstadoMesa getEstadoMesa() {
		return estadoMesa;
	}

	public void setEstadoMesa(EstadoMesa estadoMesa) {
		this.estadoMesa = estadoMesa;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	public void inicializarMesa(){
		if (this.getEstado().startsWith("l")){
			this.setEstadoMesa(new Libre());
			this.getEstadoMesa().setColor("verde");
		}else if (this.getEstado().startsWith("o")){
			this.setEstadoMesa(new Ocupada());
			this.getEstadoMesa().setColor("rojo");
		}else{
			this.setEstadoMesa(new Terminada());
			this.getEstadoMesa().setColor("azul");
		}
	}
	@Override
	public String toString() {
		return "Mesa [idMesa=" + idMesa + ", cantidadComensales=" + cantidadComensales + ", numero=" + numero
				+ ", estadoMesa=" + estadoMesa.toString() + ", estado=" + estado  ;
	}
		

	
	
}
