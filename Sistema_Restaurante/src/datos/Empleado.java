package datos;

public class Empleado extends Persona{
	
	private TipoEmpleado tipoEmpleado;
	private String nombreUsuario;
	private String clave;
	private boolean esActivo;
	
	//Constructor vacio En caso de necesitarse. 
	public Empleado(){
	}
		
	public Empleado(long idUsuario, String email, String nombre,
			String apellido, int dni, TipoEmpleado tipoEmpleado, String nombreUsuario,
			String clave, boolean esActivo) {
		super(idUsuario, email, nombre, apellido, dni);
		this.tipoEmpleado=tipoEmpleado;
		this.nombreUsuario=nombreUsuario;
		this.clave=clave;
		this.esActivo=esActivo;
		// TODO Auto-generated constructor stub
	}
	
	public TipoEmpleado getTipoEmpleado() {
		return tipoEmpleado;
	}
	
	public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public boolean isEsActivo() {
		return esActivo;
	}

	public void setEsActivo(boolean esActivo) {
		this.esActivo = esActivo;
	}

	@Override
	public String toString() {
		return "Tipo Empleado: "+this.tipoEmpleado.getDescripcion();
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
