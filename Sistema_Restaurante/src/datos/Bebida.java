package datos;

public class Bebida extends Producto{
	
	private float litros;
	private Stock stock;
	
	public Bebida() {}

	public Bebida(String nombre, String descripcion, Rubro rubro, Subrubro subrubro, float litros, Stock stock) {
		super(nombre, descripcion, rubro, subrubro);
		this.litros = litros;
		this.stock = stock;
	}

	public float getLitros() {
		return litros;
	}

	public void setLitros(float litros) {
		this.litros = litros;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return super.toString() + "Bebida [litros=" + litros + ", stock=" + stock + "]";
	}
	
	
	
}
