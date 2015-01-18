import java.awt.Label;

import javax.swing.*;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;





public class SoftwareAlarmasJava extends JFrame{
    
	
	
     public   SoftwareAlarmasJava()  {
		
		JFrame f =new JFrame();
		f.setBounds(10,10, 500, 300);
		f.setTitle("Servidor JAVA - Estacion Terrena Balcarce");
		f.setVisible(true);
		
		
		
	}
	

	
		
	public static void main(String[] args) {
	
	
		
		ServidorDeConsultasSQL ServerCon =new ServidorDeConsultasSQL();
		ServerCon.start();
		
		ConsultaDispositivos hiloConsulta= new ConsultaDispositivos();
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
	
		
	
 }
	



