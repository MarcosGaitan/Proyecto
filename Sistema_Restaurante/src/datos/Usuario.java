package datos;

public class Usuario {
	private long idUsuario;
	private String email;
	private String clave;
	private boolean esActivo;
	private String nombre;
	private String apellido;
	private int dni;
	
	public Usuario(){}

	public Usuario(long idUsuario, String email, String clave, boolean esActivo, int dni, String nombre,
			String apellido) {
		this.idUsuario = idUsuario;
		this.email = email;
		this.clave = clave;
		this.esActivo = esActivo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	};
	
	public String toString(){
		return "ID Usuario: "+this.getIdUsuario()+" Nombre: "+this.getNombre()+" Apellido: "+this.getApellido()+" DNI: "+this.getDni();
	}
	
	
}
