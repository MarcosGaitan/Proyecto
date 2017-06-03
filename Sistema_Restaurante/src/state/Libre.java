package state;

public class Libre extends EstadoMesa{

	@Override
	public EstadoMesa dejarLibre() {
		try {
			throw new Exception( "Error, esta Mesa ya está libre" );
		} catch (Exception e ) {
			e .printStackTrace();
		}
		return this;
	}

	@Override
	public EstadoMesa ocupar() {
		EstadoMesa ocupada = new Ocupada();
		ocupada.setColor("rojo");
		return ocupada;
	}

	@Override
	public EstadoMesa terminar() {
		try {
			throw new Exception( "Error, esta Mesa está libre" );
		} catch (Exception e ) {
			e .printStackTrace();
		}
		return this;
		
	}
	@Override
	public String getColor() {
		return this.color;
	}

}
