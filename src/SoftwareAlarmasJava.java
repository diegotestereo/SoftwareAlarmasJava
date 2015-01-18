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




public class SoftwareAlarmasJava extends JFrame{

	private static  Socket s ;
	private static  BufferedReader in;
	private  static PrintStream out;
	private  int contador =0;
	private static  Connection con=null;
	private static  Statement Statemento;
	private  String msgIn ,msgIdDispo,msgTemp;
	private static  int IdDispo;
	private  int Temp;
	
	
	
     /**
	 * Sistemas de alarmas con JAVA
	 * Estacion Terrena Balcarce
	 */
	private static final long serialVersionUID = 1L;

	private JLabel label1,label2;
	
	


	public   SoftwareAlarmasJava()  {
		setLayout(null);
		label1=new JLabel("Sistema de Alarmas JAVA");
		label1.setBounds(20,20, 300, 30);
		add(label1);
		label2=new JLabel("Version 0.1");
		label2.setBounds(20,100, 100, 30);
		add(label2);
		
		
	}
	

	
		
	public static void main(String[] args){
	
		SoftwareAlarmasJava Formulario = new SoftwareAlarmasJava();
		Formulario.setBounds(0,0,300,200);
		Formulario.setResizable(false);
		//Formulario.setVisible(true);
		
		//Conexion a la base de datos
		
	
			try {
				ConectarDB();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("Error: "+e1);
			}
		
		// Levantar Tabla dispositivos configurados
		TablaDispositivos levantarDispositivos=new TablaDispositivos(con);
		levantarDispositivos.start();
		
		// se crea el servidor de consultas de dispositivos
		ServidorDeConsultasSQL ServerCon =new ServidorDeConsultasSQL(con);
		ServerCon.start();
		
		// se crea  consultas de SQL y escritura
		ConsultaDispositivos hiloConsulta= new ConsultaDispositivos(con);
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
		
		
		
	/*	System.out.println("******** Iniciando Cliente  *********");
		
		
			
			try {
			//	s = new Socket("192.168.0.200",9001);
				s = new Socket("localhost",9001);
				in= new BufferedReader(new InputStreamReader(s.getInputStream()));
				out= new PrintStream(s.getOutputStream());
				System.out.println("Conexion Establecida: "+s.getInetAddress().getHostName());
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("No se pudo conectar al Dispositivo");
			//	System.out.println("Error: " +e);
			}
		
		*/
		
	
	
 }
	
}


