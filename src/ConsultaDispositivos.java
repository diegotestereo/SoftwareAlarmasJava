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

import Ventanas.VentanaPrincipal;

public class ConsultaDispositivos extends Thread{

	private  Socket s ;
	private static  BufferedReader in;
	private  PrintStream out;
	private  int contador =0;
	

	private  Connection con=null;
	private  Statement Statemento;
	private  String msgIn ,msgIdDispo,msgTemp;
	private  int IdDispo;
	private  int Temp;
	private VentanaPrincipal ventanaP;

	public ConsultaDispositivos(Connection con,VentanaPrincipal ventanaP){	
	
		this.con=con;
		this.ventanaP=ventanaP;
	}
	
	
	public Connection getCon() {
		return con;
	}


	public void setCon(Connection con) {
		this.con = con;
	}


	public VentanaPrincipal getVentanaP() {
		return ventanaP;
	}


	public void setVentanaP(VentanaPrincipal ventanaP) {
		this.ventanaP = ventanaP;
	}


	
	public  void run() {
		
		System.out.println("******** Iniciando Cliente  *********");
		
		try {
			
		//	s = new Socket("192.168.0.200",9001);
			s = new Socket("localhost",9001);
			
			System.out.println("Conexion Establecida: "+s.getInetAddress().getHostName());
			ventanaP.textAreaConsolaP.append("Conexion Establecida: "+s.getInetAddress().getHostName()+"\n");
			//String consulta ="INSERT INTO tablatemperaturas (IdDispositivo,Temp) VALUES ("+msgIdDispo+","+msgTemp+")";
			in= new BufferedReader(new InputStreamReader(s.getInputStream()));
			out= new PrintStream(s.getOutputStream());
			
			while(true){
				++contador;
				Thread.sleep(3000);
				
				out.println("$001te#");
				s.setSoTimeout(5000);
				msgIn=in.readLine();
				msgIdDispo=msgIn.substring(3, 6);
				IdDispo=Integer.parseInt(msgIdDispo);
				msgTemp=msgIn.substring(9, 11);
				Temp=Integer.parseInt(msgTemp);
				System.out.println();
				String mensaje =new String(contador+" - Id Dispositivo: "+msgIdDispo+" Temperatura: "+msgTemp+" °C\n");
				System.out.println(mensaje);
				
			// almacenar informacion en BD	
				
				Statement Statemento =con.createStatement();
				Statemento.execute("INSERT INTO tablatemperaturas (IdDispositivo,Temp) VALUES ("+msgIdDispo+","+msgTemp+")");
				Statemento.close();
				ventanaP.textAreaConsolaP.append(mensaje);
			
			}
			
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
			CloseSocket();
			try {
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		} catch (IOException e) {
		
			e.printStackTrace();
			CloseSocket();
			try {
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			CloseSocket();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	

	
    private static void CloseSocket(){
	 try {
		 in.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
	

}
