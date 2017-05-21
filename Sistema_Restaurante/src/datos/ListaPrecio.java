package datos;

import java.util.GregorianCalendar;
import java.util.Set;

public class ListaPrecio {
	
	private long idListaPrecio;
	private GregorianCalendar validoDesde;
	private GregorianCalendar validoHasta;
	Set<ItemListaPrecio> itemsListaPrecio;
	
	
	public ListaPrecio() {}


	public ListaPrecio(GregorianCalendar validoDesde, GregorianCalendar validoHasta) {
		super();
		this.validoDesde = validoDesde;
		this.validoHasta = validoHasta;
	}


	public long getIdListaPrecio() {
		return idListaPrecio;
	}


	public void setIdListaPrecio(long idListaPrecio) {
		this.idListaPrecio = idListaPrecio;
	}


	public GregorianCalendar getValidoDesde() {
		return validoDesde;
	}


	public void setValidoDesde(GregorianCalendar validoDesde) {
		this.validoDesde = validoDesde;
	}


	public GregorianCalendar getValidoHasta() {
		return validoHasta;
	}


	public void setValidoHasta(GregorianCalendar validoHasta) {
		this.validoHasta = validoHasta;
	}


	public Set<ItemListaPrecio> getItemsListaPrecio() {
		return itemsListaPrecio;
	}


	public void setItemsListaPrecio(Set<ItemListaPrecio> itemsListaPrecio) {
		this.itemsListaPrecio = itemsListaPrecio;
	}


	@Override
	public String toString() {
		return "ListaPrecio [idListaPrecio=" + idListaPrecio + ", validoDesde=" + validoDesde + ", validoHasta="
				+ validoHasta + ", itemsListaPrecio=" + itemsListaPrecio + "]";
	}
	
	
	
	
}
