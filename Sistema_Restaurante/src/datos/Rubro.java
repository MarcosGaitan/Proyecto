package datos;

public class Rubro {
	
	private long idRubro;
	private String nombre;
	
	public Rubro() {}

	public Rubro( String nombre) {
		this.nombre = nombre;
	}

	public long getIdRubro() {
		return idRubro;
	}

	public void setIdRubro(long idRubro) {
		this.idRubro = idRubro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Rubro [idRubro=" + idRubro + ", nombre=" + nombre + "]";
	};

	
}
