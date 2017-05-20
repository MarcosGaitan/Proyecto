package datos;

public class TipoEmpleado {
	
	private long idTipoEmpleado;
	private String descripcion;
	
	public TipoEmpleado(){}

	public TipoEmpleado( String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public long getIdTipoEmpleado() {
		return idTipoEmpleado;
	}

	public void setIdTipoEmpleado(long idTipoEmpleado) {
		this.idTipoEmpleado = idTipoEmpleado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoEmpleado [idTipoEmpleado=" + idTipoEmpleado + ", descripcion=" + descripcion + "]";
	}
	
	
}
