package numeroLetra;

import java.io.*;
import java.math.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class NumeroLetra {
	/*
	 * se crearon tres arreglos con valores fijos los cuales pertenecen a las unidades,decenas y centenas
	 * de los nombres de los numeros que no se repiten. lo demas se realizara por medio de concatenaciones
	 * se trato en lo posible coincidir las posiciones con los numeros para realizar relaciones directas 
	 *  
	 * */
	
	 static final String[] unid = { "", "UNO ", "DOS ", "TRES ",
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
		String cientos="", miles="";
		int longitud=0 ;
		int numero =0, cont=0;
		
		longitud = String.valueOf(cadenaNumero[0]).length();
		
		ArrayList<String> letra  = new ArrayList<String>();

		try{
		
		if(ingreso > 0 && ingreso <= 999999){
			
			for(int i=longitud; i>=1; i--){
				centesimas="";
				if (cont==0 ){
					
					if(ingreso <10){
						centesimas= cadenaNumero[0].substring((i-1), i);
						centesimas =unid[Integer.parseInt(centesimas)];
					}
					else{
						numero= Integer.parseInt(cadenaNumero[0].substring((i-2), i));
											
						if(numero >= 10 && numero <=20){
	
							centesimas= cadenaNumero[0].substring((i-2), i);
							centesimas =unid[Integer.parseInt(centesimas)];
							i-=1;
							cont+=1;
							}						
						else
							{
							centesimas= cadenaNumero[0].substring((i-1), i);
							centesimas =unid[Integer.parseInt(centesimas)];
							}
					}
				}
				else
				if(cont==1){
					numero= Integer.parseInt(cadenaNumero[0].substring((i-1), i));
					if (numero ==0){
						
					}
					else if(Integer.parseInt(cadenaNumero[0].substring((i), i+1))==0 || numero==2){
						centesimas= cadenaNumero[0].substring((i-1), i);
						centesimas =dec[Integer.parseInt(centesimas)-2];
					}
					else{
					centesimas= cadenaNumero[0].substring((i-1), i);
					centesimas =dec[Integer.parseInt(centesimas)-2] +" Y ";
					}
				}
				else
				if(cont==2){
					numero= Integer.parseInt(cadenaNumero[0].substring((i-1), i));
					if (numero ==0){
						
					}else if(Integer.parseInt(cadenaNumero[0].substring((i-1), i+2)) ==100){
						centesimas="CIEN ";
					}					
					else{
						// prueba = Integer.parseInt(cadenaNumero[0].substring((i-1), i+2));
					centesimas= cadenaNumero[0].substring((i-1), i);
					centesimas =cent[Integer.parseInt(centesimas)-1];
					}
				}
				else
				if(longitud >3){
					if(cont==3){
						//numero= Integer.parseInt(cadenaNumero[0].substring((i-2), i));
						numero= Integer.parseInt(cadenaNumero[0].substring((i-1), i));
						
						if(i>1 && Integer.parseInt(cadenaNumero[0].substring((i-2), i)) >= 10 && Integer.parseInt(cadenaNumero[0].substring((i-2), i)) <=20){

							centesimas= cadenaNumero[0].substring((i-2), i);
							centesimas =unid[Integer.parseInt(centesimas)];
							i-=1;
							cont+=1;
						}
						else
						if (numero ==0){
							
						}else if(numero == 1 && i==1){
							
							centesimas="MIL ";
						}
						else{
						centesimas= cadenaNumero[0].substring((i-1), i);
						centesimas =unid[Integer.parseInt(centesimas)];
						}
					}
					else
					if(cont==4){
						numero= Integer.parseInt(cadenaNumero[0].substring((i-1), i));
						if (numero ==0){
							
						}
						else if(Integer.parseInt(cadenaNumero[0].substring((i), i+1))==0 || numero==2){
							centesimas= cadenaNumero[0].substring((i-1), i);
							centesimas =dec[Integer.parseInt(centesimas)-2];
						}
						else{
						centesimas= cadenaNumero[0].substring((i-1), i);
						centesimas =dec[Integer.parseInt(centesimas)-2]+" Y ";
						}
					}
					else
					if(cont==5){
						numero= Integer.parseInt(cadenaNumero[0].substring((i-1), i));
						if (numero ==0){
							
						}else if(Integer.parseInt(cadenaNumero[0].substring((i-1), i+2)) ==100){
							centesimas="CIEN ";
						}					
						else{
						centesimas= cadenaNumero[0].substring((i-1), i);
						centesimas =cent[Integer.parseInt(centesimas)-1];
						}
					}
					if(i==1 && ingreso>1999 ){
						miles=centesimas+miles + "MIL ";
					}else{
					miles=centesimas + miles;
					}
				}
				letra.add(centesimas);
				if(cont<=2){
				cientos = centesimas + cientos;
				}
				
				cont+= 1;
				
			}
			centesimas=miles+cientos+" con "+cadenaNumero[1]+"/100";// se concatena los valores de miles y cientos
			
			
		}else{
			if(longitud == 1 && ingreso ==0){
				centesimas="***************************************";
			}else
			{
				centesimas="numero fuera del RANGO PERMITIDO";
			}
		
		}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Verifique el valor ingresado","", JOptionPane.ERROR_MESSAGE); 
		}
		return centesimas;
		

	}
	
}
