import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TablaDispositivos extends Thread{

	 private  Connection con=null;
	 
	 
	public TablaDispositivos(Connection con){
		
		this.con=con;
		
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
