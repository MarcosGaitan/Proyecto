package state;

public class Ocupada extends EstadoMesa{

	@Override
	public EstadoMesa dejarLibre() {
		try {
			throw new Exception( "Error, esta mesa esta ocupada" );
		} catch (Exception e ) {
			e .printStackTrace();
		}
		return this;
	}

	@Override
	public EstadoMesa ocupar() {
		try {
			throw new Exception( "Error, esta mesa ya esta ocupada" );
		} catch (Exception e ) {
			e .printStackTrace();
		}
		return this;
	}

	@Override
	public EstadoMesa terminar() {
		EstadoMesa terminada = new Terminada();
		terminada.color = "azul";
		return terminada;
	}

}
