package negocio;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Funciones {
	public static int traerAnio(GregorianCalendar f){
		return f.get(Calendar.YEAR);
	}

	public static int traerMes(GregorianCalendar f){
		return f.get(Calendar.MONTH)+1;
	}

	public static int traerDia(GregorianCalendar f){
		return f.get(Calendar.DAY_OF_MONTH);
	}
	public static int traerDiaSemana(GregorianCalendar f){
		return f.get(Calendar.DAY_OF_WEEK);
	}
	
	public static boolean esBisiesto(int anio){
		return (anio % 4 ==0 && anio % 100 != 0 || anio % 400 ==0 );
	}

	public static int diferenciaEnDias(GregorianCalendar fechaMayor, GregorianCalendar fechaMenor) {
		long  diferenciaEn_ms = fechaMayor.getTimeInMillis() - fechaMenor.getTimeInMillis();
		long dias = diferenciaEn_ms / (1000 * 60 * 60 * 24);
		return (int) dias;
	}
	
	public static boolean esFechaValida(int anio,int mes, int dia){
		return (
				(mes==1) || (mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12) && (dia >=1 && dia <=31)) ||
				((mes==4||mes==6||mes==9||mes==11) && (dia >=1 && dia <=30)) ||
		        ( (mes==2) && (esBisiesto(anio))  && (dia >=1 && dia <=29)) ||
		        ( (mes==2) && ((esBisiesto(anio)== false) && (dia >=1 && dia <=28) )
			   );
	}

	public static GregorianCalendar traerFecha(int anio,int mes,int dia){

		GregorianCalendar fecha = null;
		if (esFechaValida(anio, mes, dia)){
		  fecha=new GregorianCalendar(anio,mes-1,dia);
		}else{
			System.out.println("Fecha invalida");
		}
		return fecha;	
		
	}

	public static GregorianCalendar traerFecha(String f){
		try {
			int dia=Integer.parseInt(f.substring(0,2));
			int mes=Integer.parseInt(f.substring(3,5)) - 1;
			int anio=Integer.parseInt(f.substring(6,10));
			return new GregorianCalendar(anio,mes,dia);
		}
		catch(Exception e){
			System.out.println(" la fecha ingresa es incorrecta");
			return null;
		}
		
	}
	public static String traerFecha(GregorianCalendar f){
		return traerDia(f)+"/"+traerMes(f)+"/"+ traerAnio(f)+" "+ f.get(Calendar.HOUR_OF_DAY)+":"+f.get(Calendar.MINUTE);
	}
	
	public static String traerFechaCorta(GregorianCalendar f){
		String fechaCorta="";
	    if (traerDia(f) < 10)
	    {
	    	fechaCorta="0"+ traerDia(f);
	    }
		else{
			fechaCorta= ""+ traerDia(f);
	    }
	    
	    if (traerMes(f) <10 ){
			fechaCorta += "/0"+traerMes(f);
			}
		else{
			fechaCorta = fechaCorta + "/"+ traerMes(f);
		}
		return fechaCorta +"/" +f.get(Calendar.YEAR); 
			
	}
	
	public static String traerHora(GregorianCalendar f){
		
		int hora =  f.get(Calendar.HOUR_OF_DAY);
		int min = f.get(Calendar.MINUTE);
		int seg = f.get(Calendar.SECOND);
		return hora+":"+ min+ ":"+seg;
	}

	public static boolean  esDiaHabil (GregorianCalendar f){
		int dia= traerDiaSemana(f);
		return (dia >1 && dia <7);
	}
	

	public static String traerMesNombre(GregorianCalendar f){
		int mesNum =f.get(Calendar.MONTH);
		String mes[]={"Enero", "Febrero", "Marzo", "Abril",
					  "Mayo", "Junio", "Julio", "Agosto", "Septiembre", 
					  "Octubre", "Noviembre", "Diciembre"};
		return mes[mesNum];
	}
	
	public static String traerDiaNombre(GregorianCalendar f){
		int diaNum = f.get(Calendar.DAY_OF_WEEK)-1;
		String[] dia={"Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};
		return dia[diaNum];
	}
	
	public static String traerFechaLarga(GregorianCalendar f){
		int dia=f.get(Calendar.DAY_OF_WEEK);
		int diaM=f.get(Calendar.DAY_OF_MONTH);
		
		String Dia[]={"Domingo", "Lunes", "Martes", "Miercoles",
					  "Jueves", "Viernes", "Sabado"};
		String FechaLarga=Dia[dia-1]+" "+diaM+" de "+traerMesNombre(f)+" del "+f.get(Calendar.YEAR);
		return FechaLarga;
	}
	
	public static boolean sonFechasIguales(GregorianCalendar fecha, GregorianCalendar fecha1){
		return (fecha.get(Calendar.YEAR)==fecha1.get(Calendar.YEAR) &&
				fecha.get(Calendar.MONTH)==fecha1.get(Calendar.MONTH) &&
				fecha.get(Calendar.DAY_OF_MONTH)==fecha1.get(Calendar.DAY_OF_MONTH)
				);
	}

	public static int traerCantDiasDeUnMes(int anio,int mes){
		int cantidadDia=0;
		if (mes==2){
			if (esBisiesto(anio)){
				cantidadDia=29;
			}
			else{
				cantidadDia=28;
			}
		}
		else if (mes==4 || mes==6 || mes==9 || mes==11){
			cantidadDia=30;
		}
		else{
			cantidadDia=31;
		}

		return cantidadDia;
	}
	
	public static double aproximar2Decimal(double numero){
		BigDecimal numero1= new BigDecimal(numero);
		BigDecimal r = numero1.setScale(2,BigDecimal.ROUND_HALF_UP);
		numero=r.doubleValue();
		return numero;
		
	}

//*********************************************************************
	public static double convertirADouble(int n){
		return Double.parseDouble(String.valueOf(n));
	}
//*********************************************************************
	public static boolean esNumero(char n){
		
		if(Character.isDigit(n)){
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean esCaracter(char n){
		
		if(Character.isLetter(n)){
			return true;
		}
		else {
			return false;
		}
	}


	public static boolean  esCadenaNros(String c){
		boolean numero= true;
		char caracter=' ';
		int n=0;
		for (n=0;n<c.length();n++){
			caracter=c.charAt(n);
			if(esNumero(caracter)!= true){
				numero= false;
			}
	
		}
		return numero;	
	}

	public static boolean  esCadenaLetras(String c){
		boolean letra= true;
		char caracter=' ';
		int n=0;
		for (n=0;n<c.length();n++){
			caracter=c.charAt(n);
			if(esCaracter(caracter)!= true){
				letra= false;
			}
	
		}
		return letra;	
	}
	/*
	private int buscarIdMaximo()
	{
		int idMax = 0;
		if (!this.lista.isEmpty()){
			ListIterator<Clase> iter = this.lista.listIterator(this.lista.size());
			idMax = iter.previous().getId();
		}
		return idMax +1;
	}
	*/
}
