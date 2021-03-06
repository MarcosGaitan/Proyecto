package datos;

public class ProductoMenu {
	private long idProductoMenu;
	private Menu menu;
	private Producto producto;
	private boolean habilitado;
	
	public ProductoMenu() {}

	public ProductoMenu( Menu menu, Producto producto, boolean habilitado) {
		super();
		this.menu = menu;
		this.producto = producto;
		this.habilitado = habilitado;
	}
	
	public long getIdProductoMenu() {
		return idProductoMenu;
	}

	public void setIdProductoMenu(long idProductoMenu) {
		this.idProductoMenu = idProductoMenu;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	@Override
	public String toString() {
		return "ProductoMenu [idProductoMenu=" + idProductoMenu + ", menu=" + menu + ", producto=" + producto
				+ ", habilitado=" + habilitado + "]";
	}

	
	
	
	
	
}
