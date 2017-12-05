package TPO.modelo;

import java.time.LocalDate;

public class Transaccion {

	private Usuario comprador;
	private Usuario vendedor;
	private float precioVenta;
	private LocalDate fechaOperacion;
	private Publicacion publicacion;
	private boolean calificada;
	
	public Transaccion(
		Usuario comprador, 
		Publicacion publicacion
	) {
		super();
		this.comprador = comprador;
		this.vendedor = publicacion.getVendedor();
		this.precioVenta = publicacion.getPrecio();
		this.fechaOperacion = LocalDate.now();
		this.publicacion = publicacion;
		this.calificada = false;
	}

	public Usuario getComprador() {
		return comprador;
	}

	public void setComprador(Usuario comprador) {
		this.comprador = comprador;
	}

	public Usuario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}

	public float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Publicacion getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

	public LocalDate getFechaOperacion() {
		return fechaOperacion;
	}

	public void setFechaOperacion(LocalDate fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}
	
	public String toString() {
		return "Comprador: "+this.getComprador().getNombre() + "\nVendedor: "+this.getVendedor().getNombre() +"\n Articulo: " + this.getPublicacion().getTitulo();
	}
	
	public boolean getCalificada() {
		return this.calificada;
	}
	
	public void setCalificada() {
		this.calificada = true;
	}

	
}
