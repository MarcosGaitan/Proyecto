package datos;

public class Empleado extends Usuario{
	//Mapear por ID de usuario o de tipoempleado? 
	//No encuentro como mapear esto
	
	private TipoEmpleado tipoEmpleado;
	
	//Constructor vacio En caso de necesitarse. 
	public Empleado(){
	}
	
	public Empleado(long idUsuario, String email, String clave, boolean esActivo, int dni, String nombre,
			String apellido, TipoEmpleado tipoEmpleado) {
		super(idUsuario, email, clave, esActivo, dni, nombre, apellido);
		this.tipoEmpleado=tipoEmpleado;
	}


	@Override
	public String toString() {
		return "Tipo Empleado: "+this.tipoEmpleado.getDescripcion();
	}
	
	
	

}
