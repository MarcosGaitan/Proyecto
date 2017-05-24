package datos;

public class PlatoIngrediente{
	
	private long idPlatoIngrediente;
	private Plato plato;
	private Ingrediente ingrediente;
	private float cantidad;
	
	
	public PlatoIngrediente() {}


	public PlatoIngrediente(Plato plato, Ingrediente ingrediente, float cantidad) {
		super();
		this.plato = plato;
		this.ingrediente = ingrediente;
		this.cantidad = cantidad;
	}


	
	public long getIdPlatoIngrediente() {
		return idPlatoIngrediente;
	}


	public void setIdPlatoIngrediente(long idPlatoIngrediente) {
		this.idPlatoIngrediente = idPlatoIngrediente;
	}


	public Plato getPlato() {
		return this.plato;
	}


	public void setPlato(Plato plato) {
		this.plato = plato;
	}


	public Ingrediente getIngrediente() {
		return ingrediente;
	}


	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}


	public float getCantidad() {
		return cantidad;
	}


	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}


	@Override
	public String toString() {
		return "PlatoIngrediente [idPlatoIngrediente=" + idPlatoIngrediente + ", plato=" + plato + ", ingrediente="
				+ ingrediente + ", cantidad=" + cantidad + "]";
	}


	
	
}
