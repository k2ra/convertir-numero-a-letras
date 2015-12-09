package numeroLetra;

import java.io.*;
import java.text.DecimalFormat;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MuestraResultado extends JFrame implements ActionListener {//se hereda de la clase JFRAME
	/*
	 * se declaran las variables necesarias con sus tipos de datos
	 */
	private JTextField textfield1;
    private JButton boton1;
    private JLabel label1,titulo,instruccion;
    
    ///metodo constructor donde se inicializan las variables
    public MuestraResultado(){
        setLayout(null);
        textfield1=new JTextField();//se crea objeto textfield
        textfield1.setBounds(130,60,150,25);//se le coloca las dimensiones del elemento(x,y,width,height)
        add(textfield1);// agregamos el elemento al frame
        boton1=new JButton("CONVERTIR");//se instancia el objeto button y se le coloca un texto por defecto
        boton1.setBounds(140,150,125,30);//dimensiones del objeto
        add(boton1);//agregamos el boton al frame
        boton1.addActionListener(this);//indicamos el metodo que se ejecutara al momento del clic
        label1=new JLabel();//se crea objeto label donde se mostrara el resultado
        label1.setBounds(5, 100, 500, 20);// se da la dimensiones del elemento
        add(label1);// agregamos el label al frame
        titulo=new JLabel("Convierte el numero dado a letras");//se crea objeto label con texto por defecto que servira para nuestro titulo 
        titulo.setBounds(105, 9, 400, 30);//se le da las dimensiones
        add(titulo);//agregamos al frame el elemento
        instruccion=new JLabel("Introduce un numero entre 0 y 999999 :");//creamos label que sera el de las instrucciones
        instruccion.setBounds(95, 35, 400, 30);
        add(instruccion);
        setTitle("Cambia de numero a letras");//se le da un titulo a la ventana del frame
    }
    
    /*
     *metodo donde definimos que accion se ejecutara una vez se pulse el boton
     */

    public void actionPerformed(ActionEvent e) {
    	DecimalFormat formateador = new DecimalFormat("######.##");
    	NumeroLetra NL =new NumeroLetra();//instanciamos nuestra clase donde estan los metodos
    	double x1;
        if (e.getSource()==boton1) {//condicion si detecta pulso del boton
            String cad1=textfield1.getText();//asignamos el valor ingresado a una variable 
            
            try{
            x1=Double.parseDouble(cad1);//convertimos el valor a doble de punto decimal
            String letra =NL.convertir(x1);//invocamos el metodo convertir y le enviamos como parametro el numero escrito por el usuario
            String total=String.valueOf(letra);//asignamos el valor retornado a una variable
           label1.setText(total);//colocamos el resultado en la etiqueta que creamos para tal fin
            }catch(Exception a){
            	JOptionPane.showMessageDialog(null, "Verifique que los caracteres ingresados sean solo numeros");
           }
            
        }
    }
    
    
    public static void main (String[]args) throws NumberFormatException, IOException {
		
		
		/****************************************************************
		 ********************Crea pantalla en java*********************** 
		 ****************************************************************/
		MuestraResultado mr = new MuestraResultado();//instanciamos la clase que contiene las definiciones de nuestro JFRAME
        mr.setBounds(450,200,500,250);//le asignamos un tamaño a nuestra pantalla 
        mr.setVisible(true);	//indicamos que es visible
		
	}

}
