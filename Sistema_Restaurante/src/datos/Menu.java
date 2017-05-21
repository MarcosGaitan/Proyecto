package datos;

import java.util.Set;

public class Menu {
	
	private long idMenu;
	private String nombre;
	private Set<ProductoMenu> productosMenu;
	private ListaPrecio listaPrecio;
	
	public Menu() {}

	public Menu(String nombre, Set<ProductoMenu> productosMenu, ListaPrecio listaPrecio) {
		super();
		this.nombre = nombre;
		this.productosMenu = productosMenu;
		this.listaPrecio = listaPrecio;
	}

	

	public long getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(long idMenu) {
		this.idMenu = idMenu;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<ProductoMenu> getProductosMenu() {
		return productosMenu;
	}

	public void setProductosMenu(Set<ProductoMenu> productosMenu) {
		this.productosMenu = productosMenu;
	}

	public ListaPrecio getListaPrecio() {
		return listaPrecio;
	}

	public void setListaPrecio(ListaPrecio listaPrecio) {
		this.listaPrecio = listaPrecio;
	}

	@Override
	public String toString() {
		return "Menu [idMenu=" + idMenu + ", nombre=" + nombre + ", productoMenu=" + productosMenu + ", listaPrecio="
				+ listaPrecio + "]";
	}

	
	
	
	
}
