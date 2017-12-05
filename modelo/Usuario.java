package TPO.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Usuario {

	private String nombre;
	private String domicilio;
	private String mail;
	private String usr;
	private String pwd;
	private LocalDate datePwdSet;
	private ArrayList<Calificacion> calificacionesCompra;// esta hecho dos veces? se necesita en constructor?
	private ArrayList<Calificacion> calificacionesVenta; // esta hecho dos veces? se necesita en constructor?
	
	public Usuario(String nombre, String domicilio, String mail, String usr, String pwd) {
		super();
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.mail = mail;
		this.usr = usr;
		this.pwd = pwd;
		this.datePwdSet = LocalDate.now();
		this.calificacionesCompra = new ArrayList<Calificacion>();
		this.calificacionesVenta = new ArrayList<Calificacion>();
	}
	
	//getters y setters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public LocalDate getDatePwdSet() {
		return datePwdSet;
	}

	public void setDatePwdSet(LocalDate datePwdSet) {
		this.datePwdSet = datePwdSet;
	}
	
	public String getUsr() {
		return usr;
	}
	
	// FIN getters y setters


	// este me parece que no sirve
	public boolean sosElusuario(String usrn){
		return(usr.equals(usrn));
	}
	// revisarlo
	
	public float getReputacionVenta(){
		float total = 0;
		int cantidad = this.calificacionesVenta.size();
		if (cantidad == 0)
			return 0;
		for (Calificacion calificacion : calificacionesVenta) {
			total = total + calificacion.getNotaCalif();		
		}
		return total/cantidad; //devuelve el promedio de las notas de las calificaciones de venta
	}
	
	public float reputacionCompra(){
		float total = 0;
		int cont = 0;
		for (Calificacion calificacion : calificacionesCompra) {
			total = total + calificacion.getNotaCalif();
			cont++;			
		}
		float promedio = total/cont;
		return promedio; //devuelve el promedio de las notas de las calificaciones de compra
	}
	
	public void calificar(Usuario calificador, Transaccion transaccion, int calificacion) {
		Calificacion newCalificacion = new Calificacion(calificador, transaccion, calificacion, "");
		this.calificacionesVenta.add(newCalificacion);
	}
	
	public ArrayList<Calificacion> getCalificaciones() {
		return this.calificacionesVenta;
	}
	
}
