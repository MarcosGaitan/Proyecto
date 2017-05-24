package datos;

public class ComandaItem {
	private long idComandaItem;
	private Producto producto;
	private Comanda comanda;
	private float precio;
	private int cantidad;
	
	public ComandaItem() {}

	public ComandaItem(long idComandaItem, Producto producto, Comanda comanda, float precio, int cantidad) {
		this.idComandaItem=idComandaItem;
		this.producto = producto;
		this.comanda = comanda;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	
	
	public long getIdComandaItem() {
		return idComandaItem;
	}

	public void setIdComandaItem(long idComandaItem) {
		this.idComandaItem = idComandaItem;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "ComandaItem [producto=" + producto + ", comanda=" + comanda + ", precio=" + precio + ", cantidad="
				+ cantidad + "]";
	}
	
	
	
}
