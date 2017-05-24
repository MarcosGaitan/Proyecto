package test;

import java.util.List;

import datos.Usuario;
import negocio.UsuarioABM;

public class TestTraerUsuario {

	public static void main(String[] args) {

		UsuarioABM abm = new UsuarioABM();
		Usuario u = null;
		List<Usuario> lista = null;

		
		try {
			int dni= 33333333;
			u = abm.traerUsuario(dni);
			System.out.println("\n " + u.toString() + "\n");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		//Funciona por ID y por DNI
		/*
		try
		{
			lista = abm.traerUsuario();
			for (Usuario u2 : lista)
			{
				System.out.println("\n "+ u2.toString());
			}
		}catch(Exception e1)
		{
			System.out.println(e1.getMessage());
		}
		*/
		//Funciona
	}

}
