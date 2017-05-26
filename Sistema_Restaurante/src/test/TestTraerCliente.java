package test;

import java.util.List;

import datos.Cliente;
import negocio.ClienteABM;
import datos.TipoCliente;
import negocio.TipoClienteABM;
public class TestTraerCliente {

	public static void main(String[] args) {
		
		ClienteABM abm = new ClienteABM();
		Cliente objeto= null;
		List<Cliente> lista = null;
		TipoClienteABM TCabm = new TipoClienteABM();
		try {
			long id = 3;
			objeto = abm.traerCliente(id);
			//FUNCIONA. Trae un cliente con sus datos de persona, pero no puedo conectar con "tipoCliente"
			System.out.println(objeto.getNombre());
			//TRAE EL CLIENTE, PERO SI QUIERO IMPRIMIR SU TIPO DE CLIENTE, SALEN ERRORES, YA NO SE SI SON DE 
			//MAPEO, SI SON DE LOGICA O QUE MIERDA, ME CANSE CON ESTE.. SIGO DE LARGO.
			//System.out.println("Cliente: "+x.getNombre()+" DNI: "+x.getDni()+" TipoCliente: "+x.getTipoCliente().getDescripcion());
			
			//---ACTUALIZACION FUNCIONAL. NO ESTOY SEGURO QUE ESTE BIEN. Mi idea no era usar 2 abm. mi idea era llegar a todos los datos desde el cliente.
			System.out.println("Cliente: "+objeto.getNombre()+" DNI: "+objeto.getDni()+" TipoCliente: "+TCabm.traerTipoCliente(objeto.getTipoCliente().getIdTipoCliente()));   
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		/*
		try 
		{
			lista = abm.traerCliente();
			for (Cliente x : lista)
			{
				//aca mezclo datos del Cliente, con Persona y con Tipo Cliente para que se vean.
				//System.out.println("Cliente: "+x.getNombre()+" DNI: "+x.getDni());
				System.out.println("Cliente: "+x.getNombre()+" DNI: "+x.getDni()+" TipoCliente: "+x.getTipoCliente().getDescripcion());
			}
		}catch(Exception e1)
		{
			System.out.println(e1.getMessage());
		}
*/
	}

}
