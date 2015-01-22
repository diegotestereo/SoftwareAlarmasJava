
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Ventanas.VentanaIngresoDispo;
import Ventanas.VentanaPrincipal;


public class TablaDispositivos extends Thread{

	 private  Connection con=null;
	 private  VentanaIngresoDispo ventanaDispo;
	 private VentanaPrincipal ventanaP;
	 private JTable tabla;
	
	public TablaDispositivos(Connection con,VentanaPrincipal ventanaP,JTable tabla)//,VentanaIngresoDispo ventanaDispo){
	{
		this.con=con;
		this.ventanaP=ventanaP;
		this.tabla=tabla;
		
	}
	
	public JTable getTabla() {
		return tabla;
	}

	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}

	public void run() {
		
		ConsultarDispoBD();
		
		
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
			
			
			
			 String[] columnas ={"Id","Nombre","Ip","Puerto"};
			 DefaultTableModel tabla = new DefaultTableModel(null,columnas);
			
			 try {
				Statement Statemento =con.createStatement();
				ResultSet ResultadoConsulta=Statemento.executeQuery(consulta);
				
			 while(ResultadoConsulta.next()){
				
				 int IdDispositivo =ResultadoConsulta.getInt(1);
				 String Nomdispo =ResultadoConsulta.getString(2);
				 String IpDispo =ResultadoConsulta.getString(3);
				 int Puerto =ResultadoConsulta.getInt(4);
				
				 Salida ="Dispositivo: "+Nomdispo+" Id: "+IdDispositivo+" Ip: "+IpDispo+" Puerto: "+Puerto;
				
				 String[] filas ={Integer.toString(IdDispositivo),Nomdispo,IpDispo,Integer.toString(Puerto)};
			     tabla.addRow(filas);
				 ventanaP.tablaDispositivosP.setModel(tabla);
				
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
