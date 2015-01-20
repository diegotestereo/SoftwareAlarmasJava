
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;

import Ventanas.VentanaPrincipal;


public class TablaDispositivos extends Thread{

	 private  Connection con=null;
	 private  VentanaPrincipal ventanaP;
	
	public TablaDispositivos(Connection con,VentanaPrincipal ventanaP){
		
		this.con=con;
		this.ventanaP=ventanaP;
		
	}
	
	public void run() {
		
		ConsultarDispoBD();
		
		
	}
	
	private  String ConsultarDispoBD() {
		    
		 
			 String consulta ="SELECT * FROM tabladispositivos ";
			 String Salida = null;
			 try {
				Statement Statemento =con.createStatement();
				ResultSet ResultadoConsulta=Statemento.executeQuery(consulta);
				
			 while(ResultadoConsulta.next()){
				 int IdDispositivo =ResultadoConsulta.getInt(1);
				 String Nomdispo =ResultadoConsulta.getString(2);
				 String IpDispo =ResultadoConsulta.getString(3);
				 int Puerto =ResultadoConsulta.getInt(4);
					
				 Salida ="Dispositivo: "+Nomdispo+" Id: "+IdDispositivo+" Ip: "+IpDispo+" Puerto: "+Puerto;
				//ventanaP.tableDispositivos.set
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
