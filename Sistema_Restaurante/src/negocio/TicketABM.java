package negocio;

import datos.MesaFinal;
import datos.Ticket;

public class TicketABM {
	
	public Ticket GenerarPreticket(MesaFinal mesaFinal){
		
		Ticket ticket = new Ticket(mesaFinal);
		return ticket;
	}
	
}
