package TPO.impl;

import java.time.LocalDate;

public class Transaccion {

	private Usuario comprador;
	private Usuario vendedor;
	private float precioVenta;
	private LocalDate fechaOperacion;
	private Publicacion publicacion;
	
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

	
}
