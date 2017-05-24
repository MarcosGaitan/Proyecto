package datos;

public class PrecioTipoCliente {
	
	private long idPrecioTipoCliente;
	private ItemListaPrecio itemListaPrecio;
	private TipoCliente tipoCliente;
	private float precio;
	
	public PrecioTipoCliente() {}

	public PrecioTipoCliente(ItemListaPrecio itemListaPrecio, TipoCliente tipoCliente, float precio) {
		super();
		this.itemListaPrecio = itemListaPrecio;
		this.tipoCliente = tipoCliente;
		this.precio = precio;
	}

	public ItemListaPrecio getItemListaPrecio() {
		return itemListaPrecio;
	}

	public void setItemListaPrecio(ItemListaPrecio itemListaPrecio) {
		this.itemListaPrecio = itemListaPrecio;
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "PrecioTipoCliente [idPrecioTipoCliente=" + idPrecioTipoCliente + ", itemListaPrecio=" + itemListaPrecio
				+ ", tipoCliente=" + tipoCliente + ", precio=" + precio + "]";
	}

	
	
	
	
}
