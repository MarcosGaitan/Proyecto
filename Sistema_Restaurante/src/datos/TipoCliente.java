package datos;

public class TipoCliente {
	
	private long idTipoCliente;
	private String descripcion;
	
	public TipoCliente() {}

	public TipoCliente( String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public long getIdTipoCliente() {
		return idTipoCliente;
	}

	public void setIdTipoCliente(long idTipoCliente) {
		this.idTipoCliente = idTipoCliente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoCliente [idTipoCliente=" + idTipoCliente + ", descripcion=" + descripcion + "]";
	}
	
	
}
