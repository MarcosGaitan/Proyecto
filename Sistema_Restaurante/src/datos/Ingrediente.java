package datos;

public class Ingrediente {
	private long idIngrediente;
	private String nombre;
	private Stock stock;
	
	public Ingrediente() {}

	public Ingrediente(String nombre) {
		super();
		this.nombre = nombre;
	}

	public long getIdIngrediente() {
		return idIngrediente;
	}

	public void setIdIngrediente(long idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Ingrediente [idIngrediente=" + idIngrediente + ", nombre=" + nombre + ", stock=" + stock + "]";
	}
	
	
	
	
}
