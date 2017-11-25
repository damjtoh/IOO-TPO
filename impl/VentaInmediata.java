package TPO.impl;


public class VentaInmediata extends Publicacion {
	private float precio;
	public VentaInmediata(
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
		super(vendedor, titulo, descripcion, formaPago, garantia,
				esGarantiaExtendida, tipoContrato, certificados,
				tipoPublicacion);
		this.precio = precio;
	}
	
	@Override
	public float getPrecio() {
		return this.precio;
	}

}
