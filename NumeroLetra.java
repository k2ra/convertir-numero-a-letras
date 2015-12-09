package numeroLetra;

import java.io.*;
import java.math.*;

public class NumeroLetra {
	 static final String[] unid = { "***", "UNO ", "DOS ", "TRES ",
        "CUATRO ", "CINCO ", "SEIS ", "SIETE ", "OCHO ", "NUEVE ", "DIEZ ",
        "ONCE ", "DOCE ", "TRECE ", "CATORCE ", "QUINCE ", "DIECISEIS",
        "DIECISIETE", "DIECIOCHO", "DIECINUEVE", "VEINTE" };

	 static final String[] dec = { "VENTI", "TREINTA ", "CUARENTA ",
        "CINCUENTA ", "SESENTA ", "SETENTA ", "OCHENTA ", "NOVENTA ",
        "CIEN " };

	 static final String[] cent = { "CIENTO ", "DOSCIENTOS ",
        "TRESCIENTOS ", "CUATROCIENTOS ", "QUINIENTOS ", "SEISCIENTOS ",
        "SETECIENTOS ", "OCHOCIENTOS ", "NOVECIENTOS " };
	 String a;
	 
	 
	public String convertir(double ingreso){
		
		String cadenaNumero[] = String.valueOf(ingreso).split("\\.");
		String milesimas,centesimas=null;
		String numeroLetra;
		int longitud=0 ;
		int numero =0, cont=0;
		
		longitud = String.valueOf(cadenaNumero[0]).length();
		
		
		
		/*if(longitud == 6){
			centesimas = cadenaNumero[0].substring((longitud/2), longitud);
			milesimas = cadenaNumero[0].substring(0, (longitud/2));
			System.out.println(milesimas.substring(1, 2));
			milesimas =cent[Integer.parseInt(milesimas.substring(0, 1))-1] + dec[Integer.parseInt(milesimas.substring(1, 2))-2] + " y " + unid[Integer.parseInt(milesimas.substring(2, 3))] ; 
			centesimas =cent[Integer.parseInt(centesimas.substring(0, 1))-1] + dec[Integer.parseInt(centesimas.substring(1, 2))-2] + " y " + unid[Integer.parseInt(centesimas.substring(2, 3))] ;
			numeroLetra =milesimas +" MIL "+ centesimas;
			return numeroLetra;
		}*/
				
		if(ingreso >= 0 && ingreso < 999999){
			
			for(int i=longitud; i>=1; i--){
				//cadenaNumero[0].substring((i-1), i) 
				if (cont==0 ){
					if(ingreso >=10 && ingreso<= 20){
						
						System.out.println("hola");
						
					}else{
						centesimas= cadenaNumero[0].substring((i-1), i);
						centesimas =unid[Integer.parseInt(centesimas)];
					}

				}
				
				if(cont==1){
					centesimas= cadenaNumero[0].substring((i-1), i);
					centesimas =dec[Integer.parseInt(centesimas)-2];
				}
				if(cont==2){
					centesimas= cadenaNumero[0].substring((i-1), i);
					centesimas =cent[Integer.parseInt(centesimas)-1];
				}
				if(cont==3){
					centesimas= cadenaNumero[0].substring((i-1), i);
					centesimas =unid[Integer.parseInt(centesimas)]+"MIL";
				}
				if(cont==4){
					centesimas= cadenaNumero[0].substring((i-1), i);
					centesimas =dec[Integer.parseInt(centesimas)-2];
				}
				if(cont==5){
					centesimas= cadenaNumero[0].substring((i-1), i);
					centesimas =cent[Integer.parseInt(centesimas)-1];
				}
				
				System.out.println(centesimas);
				
				cont+= 1;
			}

			
		}else{
			
			return a =" numero fuera del RANGO PERMITIDO";
		}
		
		return a =" sali";
		
	}
	
	private int descomponeNumero(){
		return 0;
	}
}
