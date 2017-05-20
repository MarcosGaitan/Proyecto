package datos;

public class Stock {
	
	private long idStock;
	private float maximo;
	private float minimo;
	private float existente;
	
	public Stock() {}

	public Stock(float maximo, float minimo, float existente) {
		super();
		this.maximo = maximo;
		this.minimo = minimo;
		this.existente = existente;
	}

	public long getIdStock() {
		return idStock;
	}

	public void setIdStock(long idStock) {
		this.idStock = idStock;
	}

	public float getMaximo() {
		return maximo;
	}

	public void setMaximo(float maximo) {
		this.maximo = maximo;
	}

	public float getMinimo() {
		return minimo;
	}

	public void setMinimo(float minimo) {
		this.minimo = minimo;
	}

	public float getExistente() {
		return existente;
	}

	public void setExistente(float existente) {
		this.existente = existente;
	}

	@Override
	public String toString() {
		return "Stock [idStock=" + idStock + ", maximo=" + maximo + ", minimo=" + minimo + ", existente=" + existente
				+ "]";
	}
	
	
	
}
