package datos;

public abstract class Persona {
	protected long idPersona;
	protected String email;
	protected String nombre;
	protected String apellido;
	protected int dni;
	
	public Persona(){}
	
	public Persona( String email, String nombre,
			String apellido, int dni) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	protected abstract long getIdPersona();

	protected abstract void setIdPersona(long idPersona);

	protected abstract String getEmail();

	protected abstract void setEmail(String email);

	protected abstract String getNombre();

	protected abstract void setNombre(String nombre);

	protected abstract String getApellido();

	protected abstract void setApellido(String apellido);
	
	protected abstract int getDni();

	protected abstract void setDni(int dni);
		
	/*public String toString(){
		return "ID Usuario: "+this.getIdUsuario()+" Nombre: "+this.getNombre()+" Apellido: "+this.getApellido()+" DNI: "+this.getDni();
	}*/
	
	
}

