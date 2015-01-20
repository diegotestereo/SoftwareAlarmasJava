
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;

import Ventanas.VentanaIngresoDispo;
import Ventanas.VentanaPrincipal;


public class TablaDispositivos extends Thread{

	 private  Connection con=null;
	 private  VentanaIngresoDispo ventanaDispo;
	 private VentanaPrincipal ventanaP;
	
	public TablaDispositivos(Connection con,VentanaPrincipal ventanaP)//,VentanaIngresoDispo ventanaDispo){
	{
		this.con=con;
		this.ventanaP=ventanaP;
		//this.ventanaDispo=ventanaDispo;
		
	}
	
	public void run() {
		
		ConsultarDispoBD();
		
		
	}
	
	
	public VentanaPrincipal getVentanaP() {
		return ventanaP;
	}

	public void setVentanaP(VentanaPrincipal ventanaP) {
		this.ventanaP = ventanaP;
	}
	
	
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public VentanaIngresoDispo getVentanaDispo() {
		return ventanaDispo;
	}

	public void setVentanaDispo(VentanaIngresoDispo ventanaDispo) {
		this.ventanaDispo = ventanaDispo;
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
				ventanaP.textAreaConsolaP.append(Salida+"\n");
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
