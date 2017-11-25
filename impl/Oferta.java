package TPO.impl;


public class Oferta {

	private float valorOferta;
	private Usuario ofertante;
	
	public Oferta(Usuario ofertante, float valorOferta) {
		this.ofertante = ofertante;
		this.valorOferta = valorOferta;
	}
	
	public float getMonto() {
		return this.valorOferta;
	}
	
	public Usuario getOfertante() {
		return this.ofertante;
	}

}
