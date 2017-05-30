package test;

import datos.MesaFinal;
import datos.Ticket;
import negocio.MesaFinalABM;
import negocio.TicketABM;

public class TestTicket {

	public static void main(String[] args) {
		TicketABM abm = new TicketABM();
		
		Ticket ticket = null;
		
		MesaFinalABM mAbm = new MesaFinalABM(); 
		
		try{
			long id=1;
			MesaFinal mesafinal = mAbm.traerMesaFinalyComandas(id);
			System.out.println("mesa:" + mesafinal.getIdMesaFinal());
		    ticket = abm.GenerarPreticket(mesafinal);
			System.out.println("precioTotal: " + ticket.getPrecioTotal());
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
