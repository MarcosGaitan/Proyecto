package datos;

import java.util.Set;

public class ItemListaPrecio {
	
	private long idItemListaPrecio;
	private Producto producto;
	private ListaPrecio listaPrecio;
	private Set<PrecioTipoCliente> preciosTipoCliente;
	
	public ItemListaPrecio() {}

	public ItemListaPrecio(Producto producto, ListaPrecio listaPrecio) {
		super();
		this.producto = producto;
		this.listaPrecio = listaPrecio;
	}

	public long getIdItemListaPrecio() {
		return idItemListaPrecio;
	}

	public void setIdItemListaPrecio(long idItemListaPrecio) {
		this.idItemListaPrecio = idItemListaPrecio;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public ListaPrecio getListaPrecio() {
		return listaPrecio;
	}

	public void setListaPrecio(ListaPrecio listaPrecio) {
		this.listaPrecio = listaPrecio;
	}

	public Set<PrecioTipoCliente> getPreciosTipoCliente() {
		return preciosTipoCliente;
	}

	public void setPreciosTipoCliente(Set<PrecioTipoCliente> preciosTipoCliente) {
		this.preciosTipoCliente = preciosTipoCliente;
	}

	@Override
	public String toString() {
		return "ItemListaPrecio [idItemListaPrecio=" + idItemListaPrecio + ", producto=" + producto + ", listaPrecio="
				+ listaPrecio + ", preciosTipoCliente=" + preciosTipoCliente + "]";
	}

	
	
	
}
