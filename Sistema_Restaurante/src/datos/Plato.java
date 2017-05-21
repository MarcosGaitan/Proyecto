package datos;

import java.io.Serializable;
import java.util.Set;

public class Plato extends Producto implements Serializable{
	
	
	Set<PlatoIngrediente> platoIngredientes;
	
	public Plato() {}

	public Plato(String nombre, String descripcion, Rubro rubro, Subrubro subrubro, Set<PlatoIngrediente> platoIngredientes) {
		super(nombre, descripcion,rubro,subrubro);
		this.platoIngredientes = platoIngredientes;
	}

	public Set<PlatoIngrediente> getPlatoIngredientes() {
		return platoIngredientes;
	}

	public void setPlatoIngredientes(Set<PlatoIngrediente> platoIngredientes) {
		this.platoIngredientes = platoIngredientes;
	}

	@Override
	public String toString() {
		
		return super.toString()+ "\n Plato [platoIngredientes=" + platoIngredientes + "]";
	}
	
	
	
}
