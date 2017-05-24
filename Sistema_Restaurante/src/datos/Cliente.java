package datos;

public class Cliente extends Usuario{
	
	private TipoCliente tipoCliente;
		
	//Constructor vacio En caso de necesitarse. 
	public Cliente(){
	}

	public Cliente(long idUsuario, String email, String clave, boolean esActivo, int dni, String nombre,
			String apellido, TipoCliente tipoCliente) {
		super(idUsuario, email, clave, esActivo, dni, nombre, apellido);
		this.tipoCliente=tipoCliente;
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	@Override
	public String toString() {
		return "Tipo Cliente: "+this.tipoCliente.getDescripcion();
	}

	
	

}
