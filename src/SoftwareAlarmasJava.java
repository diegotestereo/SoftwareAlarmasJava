import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

import Ventanas.VentanaIngresoDispo;
import Ventanas.VentanaPrincipal;;




public class SoftwareAlarmasJava {

	private static  Connection con=null;

	static VentanaPrincipal ventanaP;
	static VentanaIngresoDispo ventanaInDisp;
	
		
	public static void main(String[] args){
	
		// se crea y abre la ventana principal d el aplicacion
		ventanaP=new VentanaPrincipal();
		ventanaP.setVisible(true);
		ventanaP.textAreaConsolaP.append("Iniciando Sistema...\n");
	
		
		//Conexion a la base de datos
		
	
			try {
				ConectarDB();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("Error: "+e1);
			}
		
		// Levantar Tabla dispositivos configurados
		TablaDispositivos levantarDispositivos=new TablaDispositivos(con,ventanaP);
		levantarDispositivos.start();
		
		// se crea el servidor de consultas de dispositivos
		ServidorDeConsultasSQL ServerCon =new ServidorDeConsultasSQL(con);
		ServerCon.start();
		
		// se crea  consultas de SQL y escritura
		ConsultaDispositivos hiloConsulta= new ConsultaDispositivos(con,ventanaP);
		hiloConsulta.start();
		
		while(true){
			//System.out.println("Hilo Principal Main");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	

	}
	
		
	public static void ConectarDB() throws IOException{
		
try {
			
			System.out.println("Consulta Dispositivos: Conectando a la base de datos");
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
			 con =DriverManager.getConnection("jdbc:mysql://localhost/bdtemperaturas","root","");
			System.out.println("Consulta Dispositivos: Se conecto !!!");
			
		} catch (Exception e) {
			System.out.println("Consulta Dispositivos:No se puede conectar a la Base de Datos");
			System.out.println("Consulta Dispositivos:Error: "+e); 
				}
		
		
		
	
		
	
	
 }
	
}


