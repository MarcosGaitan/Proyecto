package state;

import datos.Mesa;

public abstract class EstadoMesa {
	
	protected String color;
	
	public abstract EstadoMesa dejarLibre();
	
	public abstract EstadoMesa ocupar();
	
	public abstract EstadoMesa terminar();
	

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	
}
