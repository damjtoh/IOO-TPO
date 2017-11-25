package TPO.impl;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

public abstract class Publicacion {
	
	private String idPub;
	private Usuario vendedor;
	private String titulo;
	private String descripcion;
	private LocalDate fechaPub;
	private LocalDate fechaValido;
//	protected float precio; // Esto se mueve a ventaInmediata
	private String garantia;
	private boolean esGarantiaExtendida;
	private String tipoContrato;
	private String tipoPublicacion;
	private String certificados;
	private Collection<formaPago> formaspago;
	
	private static enum formaPago{CREDITO, EFECTIVO, DEBITO};
	
	
	public Publicacion(
		Usuario vendedor, 
		String titulo, 
		String descripcion, 
		String formaPago, 
		String garantia, 
		boolean esGarantiaExtendida, 
		String tipoContrato, 
		String certificados,
		String tipoPublicacion
	) {
		super();
		this.idPub = UUID.randomUUID().toString();
		this.vendedor = vendedor;
		this.titulo = titulo;
		this.descripcion = descripcion;
		if (tipoPublicacion == "PRODUCTO") {			
			this.garantia = garantia;
			this.esGarantiaExtendida = esGarantiaExtendida;
		} else if (tipoPublicacion == "SERVICIO") {
			this.tipoContrato = tipoContrato;
			this.certificados = certificados;
		}
		this.fechaPub = LocalDate.now().plusDays(30);
		//falta fecha validez 1 mes desde ahora
	}


	public String getIdPub() {
		return idPub;
	}
	
	public Usuario getVendedor() {
		return this.vendedor;
	}


	public void setIdPub(String idPub) {
		this.idPub = idPub;
	}
	


	public void ofertar(Usuario ofertante, float valorOferta) {
		// TODO Auto-generated method stub
	}
	
	public abstract float getPrecio();


	//getters and setters
	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public LocalDate getFechaPub() {
		return fechaPub;
	}


	public void setFechaPub(LocalDate fechaPub) {
		this.fechaPub = fechaPub;
	}


	public LocalDate getFechaValido() {
		return fechaValido;
	}


	public void setFechaValido(LocalDate fechaValido) {
		this.fechaValido = fechaValido;
	}


	public String getGarantia() {
		return garantia;
	}


	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}


	public boolean isEsGarantiaExtendida() {
		return esGarantiaExtendida;
	}


	public void setEsGarantiaExtendida(boolean esGarantiaExtendida) {
		this.esGarantiaExtendida = esGarantiaExtendida;
	}


	public String getTipoContrato() {
		return tipoContrato;
	}


	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}


	public String getTipoPublicacion() {
		return tipoPublicacion;
	}


	public void setTipoPublicacion(String tipoPublicacion) {
		this.tipoPublicacion = tipoPublicacion;
	}


	public String getCertificados() {
		return certificados;
	}


	public void setCertificados(String certificados) {
		this.certificados = certificados;
	}


	public Collection<formaPago> getFormaspago() {
		return formaspago;
	}


	public void setFormaspago(Collection<formaPago> formaspago) {
		this.formaspago = formaspago;
	}


	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	};

	
	
}
