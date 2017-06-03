package state;

public class Terminada extends EstadoMesa{

	@Override
	public EstadoMesa dejarLibre() {
		EstadoMesa libre = new Libre();
		libre.setColor("verde");
		return libre;
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
