package datos;


import java.util.Set;

public class Vianda {
	
	private long idVianda;
	private String nombre;
	private String descripcion;
	private float precioVianda;
	private Set<Producto> productos;
	
	public Vianda() {}

	public Vianda(String nombre, String descripcion, float precioVianda) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioVianda = precioVianda;
	}

	public long getIdVianda() {
		return idVianda;
	}

	public void setIdVianda(long idVianda) {
		this.idVianda = idVianda;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecioVianda() {
		return precioVianda;
	}

	public void setPrecioVianda(float precioVianda) {
		this.precioVianda = precioVianda;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Vianda [idVianda=" + idVianda + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", precioVianda=" + precioVianda + ", productos=" + productos + "]";
	}
	
	
	
}
