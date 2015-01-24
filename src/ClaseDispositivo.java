
public class ClaseDispositivo {
private String Nombre,Ip;
private int Puerto;

	
public ClaseDispositivo(String nombre,String ip,int puerto){
	this.Nombre=nombre;
	this.Ip=ip;
	this.Puerto=puerto;
	
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
	



}
