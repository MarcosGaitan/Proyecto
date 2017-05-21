package datos;

import com.sun.prism.Image;

public class Producto {
	
	protected long idProducto;
	protected String nombre;
	protected String descripcion;
	protected byte[] imagen;
	protected Rubro rubro;
	protected Subrubro subrubro;

	public Producto() {}

	public Producto(String nombre, String descripcion, Rubro rubro, Subrubro subrubro) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.rubro = rubro;
		this.subrubro = subrubro;
		this.imagen = null;
	}

	public long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public Rubro getRubro() {
		return rubro;
	}

	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}

	public Subrubro getSubrubro() {
		return subrubro;
	}

	public void setSubrubro(Subrubro subrubro) {
		this.subrubro = subrubro;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", imagen=" + imagen + ", rubro=" + rubro + ", subrubro=" + subrubro + "]";
	}
	
	
	
	
}
