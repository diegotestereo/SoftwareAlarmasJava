import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class InsertarDispositivos {
	
	private Statement statemento;
	private ResultSet ResultadoConsulta;
	private Connection con;
	String Nombre,Ip;
	int Puerto;
	
	
	
	public InsertarDispositivos(String Nombre,String Ip,	int Puerto ){
	
		this.Nombre=Nombre;
		this.Ip=Ip;
		this.Puerto=Puerto;
	
	}



	public String getNombre() {
		return Nombre;
	}



	public void setNombre(String nombre) {
		Nombre = nombre;
	}



	public String getIp() {
		return Ip;
	}



	public void setIp(String ip) {
		Ip = ip;
	}



	public int getPuerto() {
		return Puerto;
	}



	public void setPuerto(int puerto) {
		Puerto = puerto;
	}





	public ResultSet getResultadoConsulta() {
		return ResultadoConsulta;
	}



	public void setResultadoConsulta(ResultSet resultadoConsulta) {
		ResultadoConsulta = resultadoConsulta;
	}



	public Statement getStatemento() {
		return statemento;
	}



	public void setStatemento(Statement statemento) {
		this.statemento = statemento;
	}
	

	public void InsertDispos(){
		
		try {
			ConectarDB();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String ConsultaSQL="INSERT INTO tabladispositivos  VALUES (NULL, '"+Nombre+"', '"+Ip+"', '"+Puerto+"'); ";
		Statement Statemento;
		try {
			Statemento = con.createStatement();
			ResultadoConsulta=Statemento.executeQuery(ConsultaSQL);
			Statemento.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void ConectarDB() throws IOException{
		
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
