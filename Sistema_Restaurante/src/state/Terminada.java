package state;

public class Terminada extends EstadoMesa{

	@Override
	public EstadoMesa dejarLibre() {
		this.color = "verde";
		return new Libre();
	}

	@Override
	public EstadoMesa ocupar() {
		try {
			throw new Exception( "Error, esta mesa esta terminada" );
		} catch (Exception e ) {
			e .printStackTrace();
		}
		return this;
	}

	@Override
	public EstadoMesa terminar() {
		try {
			throw new Exception( "Error, esta mesa ya esta terminada" );
		} catch (Exception e ) {
			e .printStackTrace();
		}
		return this;
	}

}
