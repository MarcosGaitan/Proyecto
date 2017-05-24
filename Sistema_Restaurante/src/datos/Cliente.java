package datos;

public class Cliente extends Persona{
	
	private TipoCliente tipoCliente;
		
	//Constructor vacio En caso de necesitarse. 
	public Cliente(){
	}
	
	
	public Cliente( String email, String nombre,
			String apellido, int dni,TipoCliente tipoCliente) {
		super( email, nombre, apellido, dni);
		// TODO Auto-generated constructor stub
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
		return "Cliente: "+this.getApellido()+" "+this.getNombre()+" \nDNI: "+this.getDni()+"\nTipoCliente: "+this.getTipoCliente().getDescripcion();
	}


	@Override
	public long getIdUsuario() {
		return this.idUsuario;
	}


	@Override
	public void setIdUsuario(long idUsuario) {
		this.idUsuario=idUsuario;
	}


	@Override
	public String getEmail() {
		return this.email;
	}

	@Override
	public void setEmail(String email) {
		this.email=email;
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}


	@Override
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}

	@Override
	public String getApellido() {
		return this.apellido;
	}

	@Override
	public void setApellido(String apellido) {
		this.apellido=apellido;
	}

	@Override
	public int getDni() {
		return this.dni; 
	}

	@Override
	public void setDni(int dni) {
		this.dni=dni;
	}

}
