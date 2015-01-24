import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;


public class ServidorDeConsultasSQL  extends Thread {

	 private  ServerSocket sk;
	 private    BufferedReader entrada;
	 private   PrintWriter salida;
	 private  Connection con=null;
	 private  int Puerto=5000;
	 private  Boolean Serv=true;
	 private String datos = null ;
	 
	 
			
public ServidorDeConsultasSQL(Connection con){
	
	this.con=con;
	
}
	
	
public   void run() {
	 
	   try {
	          sk = new ServerSocket(Puerto);
	          while (Serv) { 
	        	     System.out.println("********************************************************");
	                 System.out.println("************  Servidor esperando Cliente   *************");
	                 System.out.println("************    IP: "+InetAddress.getLocalHost().getHostAddress()+":"+Puerto+"     *************");
	                 System.out.println("********************************************************");
		                 
	                 System.out.println();
	                 
	                 Socket cliente = sk.accept();
	                 System.out.println();
	                 System.out.println("----------------   Ingreso Cliente   -------------------");
	                 System.out.println();
	               Boolean exit=true;
				do{
	                 entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
	                 salida = new PrintWriter(new OutputStreamWriter(cliente.getOutputStream()),true);
		              
	                 datos = entrada.readLine();
	                 
	                 if (datos.equals(null)){
	                	 datos="n";
	                	 
	                 }
	                 switch (datos) {
					case "x":
						 exit=false;
		            	   System.out.println("se recibio un 'X' ");
		            	   salida.println("Conexion Cerrada");
				     	break;
					case "n":
				      	   System.out.println("se recibio un null ");
			            	    
							break;
					case "?":
							
		            	   System.out.println("consulta BD Temteraturas");
		            	   salida.println("Servidor: Consulta por la BD de datos..");
		            	   salida.println(ConsultarTempBD());
		       		break;
					default:
						break;
					}
	                 
	              }while(exit);
	                 cliente.close();
	                 System.out.println("------------  Cerro sesion Cliente !!!  --------------------");
	          }
	   } catch (IOException e) {
		   System.out.println("Dato recibido: "+datos);
	          System.out.println(e);
	   }
	 
	 
		
}


private  String ConsultarTempBD() {
	//	 int TempResul;
		 
		 String consulta ="SELECT * FROM temperaturas  ORDER BY Id DESC LIMIT 1 ";
		 String Salida = null;
		 try {
			Statement Statemento =con.createStatement();
			ResultSet ResultadoConsulta=Statemento.executeQuery(consulta);
			
		 while(ResultadoConsulta.next()){
			 int Registro =ResultadoConsulta.getInt(1);
			 int Dispositivo =ResultadoConsulta.getInt(2);
			 int Temperatura =ResultadoConsulta.getInt(3);
			 Timestamp Fecha =ResultadoConsulta.getTimestamp(4);
			 Salida =Fecha+" Dispo N° "+Dispositivo+" Temp: "+Temperatura+" °C - Reg: "+Registro;
			 System.out.println(Salida);
		 }
			
			Statemento.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Salida;

}

}