package TPO.controlador;


import java.time.LocalDate;
import java.util.ArrayList;

import TPO.modelo.Publicacion;
import TPO.modelo.Subasta;
import TPO.modelo.Transaccion;
import TPO.modelo.Usuario;
import TPO.modelo.VentaInmediata;

@SuppressWarnings("unused")
public class Mercado {

	 ArrayList<Usuario> usuarios;
	 ArrayList<Publicacion> publicaciones;
	 ArrayList<Transaccion> transacciones;
	 private Usuario usuarioActivo;
	 
	 private static Usuario adminSys = new Usuario("Manolo Lama", "Calle siempre viva","admin@.c","admin","admin");
	 private static Usuario testUser = new Usuario("Manolo Lama", "Calle siempre viva","admin@.c","test","test");
	 private static Publicacion testPublicacion = new VentaInmediata(testUser, "Publicacion de prueba", "Esto es una descripcion", "CREDITO", "ninguna", false, "", "", "", 24);
	
	public Mercado() {
		// TODO Auto-generated constructor stub
		usuarios = new ArrayList<Usuario>();
		publicaciones = new ArrayList<Publicacion>();
		transacciones = new ArrayList<Transaccion>();
		usuarios.add(adminSys);
		usuarios.add(testUser);
		publicaciones.add(testPublicacion);
		System.out.println(this.getPublicaciones().size());
	}
	
	//	User related methods
	
	public Usuario buscarUsuario(String usr){
		for (Usuario u : usuarios) {
			if(u.getUsr().equals(usr)){
				return u;
			}
		}
		return null;
	}
	//Privilegio admin
	public boolean sosAdmin(Usuario usr){
		if (usr.equals(adminSys))
			return true;
		else
			return false;
	}
	
	public boolean login(String usuario, String password) {
		Usuario user = this.buscarUsuario(usuario);
		if (user == null) {
			// Retornar mensaje usuario inexistente.
			return false;
		} else {
			if (user.getPwd().equals(password)) {
				this.usuarioActivo = user;
				return true;
			} else {
				return false;
				// Retornar mensaje de contrasena incorrecta
			}
		}
	}
	
	public void altaUsuario(String nom, String dom, String mail, String usr, String pwd){
		if(buscarUsuario(usr)==null){
			Usuario u = new Usuario(nom, dom, mail, usr, pwd); //si no existe, creo nuevo user
			usuarios.add(u);
			System.out.println("El usuario " + usr + " ha sido creado");
		}
		else{ //si existe, salgo sin crearlo
			System.out.println("El usuario " + usr + " ya existe en el sistema");
		}
	}
	

	public boolean bajaUsuario(String usr){
		//busco al usuario en la lista de usuarios y lo borro si lo encuentro
		
		for (Usuario u : usuarios){
			if(u.getUsr().equals(usr)){
					usuarios.remove(u);
					System.out.println("El usuario " + usr + " ha sido borrado");
					return true;
			}
		}
		System.out.println("No se encontre el usuario: "+usr);
		return false;
	}
	
	public void modifUsuario(String nom, String dom, String mail, String usr, String pwd){
		for (Usuario u : usuarios){
			if(u.getUsr().equals(usr)){
				u.setNombre(nom);
				u.setDomicilio(dom);
				u.setMail(mail);
				u.setPwd(pwd);
				System.out.println("El usuario " + usr + " ha sido modificado exitosamente");
				System.out.println("-------");
				System.out.println("Nombre: "+ u.getNombre());
				System.out.println("Domicilio: "+ u.getDomicilio());
				System.out.println("Mail: "+ u.getMail());
				System.out.println("Password: "+ u.getPwd());
				System.out.println("-------");
				return;
			}
		}
		System.out.println("El usuario " + usr + " no ha sido encontrado");
	}
	
	// Metodos relacionados a la publicación
	
	public void crearPublicacionSubasta(
		Usuario vendedor, 
		String titulo, 
		String descripcion, 
		String formaPago, 
		String garantia, 
		boolean esGarantiaExtendida, 
		String tipoContrato,
		float precioMin,
		float precioInicial
	) {
		Subasta nuevaSubasta = new Subasta(this.usuarioActivo, titulo, descripcion, formaPago, garantia, esGarantiaExtendida, precioMin, precioInicial, null, null, "PRODUCTO");
		publicaciones.add(nuevaSubasta);
	}
	
	public void crearPublicacionVentaInmediata(
		Usuario vendedor, 
		String titulo, 
		String descripcion, 
		String formaPago, 
		String garantia, 
		boolean esGarantiaExtendida, 
		String tipoContrato,
		String certificados,
		String tipoPublicacion,
		float precio
	) {
		VentaInmediata nuevaVenta = new VentaInmediata(this.usuarioActivo, titulo, descripcion, formaPago, garantia, esGarantiaExtendida, tipoContrato, certificados, tipoPublicacion, precio);
		publicaciones.add(nuevaVenta);
	}
	
	
	public void verPublicaciones(String usu){
		
		if(usu.equals("-")){
			for (Publicacion publi : publicaciones)
				System.out.println(publi);	
		}else{
			for (Publicacion publi : publicaciones){
				if(publi.getVendedor().getNombre().equals(usu))
					System.out.println(publi);	
			}
		}
	}
	
	public Publicacion buscarPublicacion(String idPub) {
		for (Publicacion publicacion: this.publicaciones) {
			if (publicacion.getIdPub() == idPub)
				return publicacion;
		}
		return null;
	}
	
	public void borrarPublicacion(String id){
		
		for (int i = 0; i<publicaciones.size(); i++){
			
			if(publicaciones.get(i).getIdPub() == id)
				publicaciones.remove(i);
		}
	}
	
	public void ofertar(String idPub, float valorOferta) {
		Publicacion subasta = this.buscarPublicacion(idPub);
		if (subasta instanceof Subasta && subasta != null) {
			subasta.ofertar(this.usuarioActivo, valorOferta);
		} else {
			// Mensaje de error que no existe tal subasta.
		}
	}
	
	public void comprar(String idPub) {
		Publicacion venta = this.buscarPublicacion(idPub);
		if (venta instanceof VentaInmediata && venta != null) {
			// Creamos la transacción.
			Transaccion nuevaTransaccion = new Transaccion(this.usuarioActivo, venta);
			transacciones.add(nuevaTransaccion);
		} else {
			// Mensaje de error que no existe tal subasta.
		}
	}
	
	public void resumenMensual(String usu){
		
		float total = 0;
		//recursiva hasta recorrer todos los usuarios
		if(usu.equals("ALL")){
			for(int i = 0; i<usuarios.size(); i++)
			{
				resumenMensual(usuarios.get(i).getNombre());
			}
		}
		
		for (Transaccion tr : transacciones){
			if(tr.getVendedor().sosElusuario(usu))
				total = total + (comision(tr.getPrecioVenta()));
		}

		System.out.println("El usuario "+usu+" debe "+total);
	}
	
	private float comision(float precioVenta){
		
		float comision = 10;
		return((precioVenta * comision)/100);
	}

	
	//get and set
	public Usuario getUsuarioActivo() {
		return usuarioActivo;
	}

	public void setUsuarioActivo(Usuario usuarioActivo) {
		this.usuarioActivo = usuarioActivo;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public ArrayList<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public ArrayList<Transaccion> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(ArrayList<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}	
	
	
	
		
}
