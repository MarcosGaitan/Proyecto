package datos;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

public class Ticket {
	
	private long idTicket;
	private float precioTotal;
	private boolean confirmado;
	private boolean pagado;
	private GregorianCalendar fecha;
	private boolean cortesia;
	private Empleado autorizadoPor;
	private String formaDePago;
	private MesaFinal mesaFinal;
	
	public Ticket() {}

	public Ticket (MesaFinal mesaFinal) {
		super();
		this.precioTotal = calcularPrecioTotal(mesaFinal.getComandas());
		this.mesaFinal = mesaFinal;
		this.confirmado = false;
		this.pagado = false;
		this.cortesia = false;
		this.autorizadoPor = null;
		this.fecha = new GregorianCalendar();
	}

	public long getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(long idTicket) {
		this.idTicket = idTicket;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}

	public boolean isConfirmado() {
		return confirmado;
	}

	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public boolean isCortesia() {
		return cortesia;
	}

	public void setCortesia(boolean cortesia) {
		this.cortesia = cortesia;
	}

	public Empleado getAutorizadoPor() {
		return autorizadoPor;
	}

	public void setAutorizadoPor(Empleado autorizadoPor) {
		this.autorizadoPor = autorizadoPor;
	}

	public String getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}

	public MesaFinal getMesaFinal() {
		return mesaFinal;
	}

	public void setMesaFinal(MesaFinal mesaFinal) {
		this.mesaFinal = mesaFinal;
	}
	
	private float calcularPrecioTotal(Set<Comanda> comandas) {
		float precioTotal = 0;
		for (Comanda c : comandas){
			for (ComandaItem ci : c.getComandaItems()){
				precioTotal += ci.getPrecio();
			}
		}

		return precioTotal;
	}
	
}
