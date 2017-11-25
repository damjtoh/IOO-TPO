package TPO.modelo;

import java.time.LocalDate;
import java.util.Collection;

public class Subasta extends Publicacion {

	private float precioMin;
	private float precioInicial;
	private LocalDate diasVigencia;
	private Collection<Oferta> ofertas;
	
	public Subasta(
		Usuario vendedor, 
		String titulo, 
		String descripcion, 
		String formaPago, 
		String garantia, 
		boolean esGarantiaExtendida, 
		float precioMin,
		float precioInicial,
		String tipoContrato, 
		String certificados,
		String tipoPublicacion
	) {
		super(vendedor, titulo, descripcion, formaPago, garantia, esGarantiaExtendida, tipoContrato, certificados, tipoPublicacion);
		this.setPrecioMin(precioMin);
		this.precioInicial = precioInicial;
	}
	@Override
	public void ofertar(Usuario ofertante, float valorOferta) {
		float maxOferta = this.buscarMayorOferta();
		if (valorOferta > maxOferta) {			
			Oferta nuevaOferta = new Oferta(ofertante, valorOferta);
			this.ofertas.add(nuevaOferta);
		} else {
			// Retornar mensaje de que la oferta debe ser mayor a la actual;
		}
	}
	
	public float buscarMayorOferta() {
		float max = -1;
		for (Oferta oferta : this.ofertas) {
			if (oferta.getMonto() > max)
				max = oferta.getMonto();
		}
		return max;
	}
	
	@Override
	public float getPrecio() {
		//deberia ser igual a la ultima oferta, o no?
		return (buscarMayorOferta());
	}
	
	//getters and setters
	public float getPrecioMin() {
		return precioMin;
	}
	public void setPrecioMin(float precioMin) {
		this.precioMin = precioMin;
	}
	public float getPrecioInicial() {
		return precioInicial;
	}
	public void setPrecioInicial(float precioInicial) {
		this.precioInicial = precioInicial;
	}
	public LocalDate getDiasVigencia() {
		return diasVigencia;
	}
	public void setDiasVigencia(LocalDate diasVigencia) {
		this.diasVigencia = diasVigencia;
	}
	public Collection<Oferta> getOfertas() {
		return ofertas;
	}
	public void setOfertas(Collection<Oferta> ofertas) {
		this.ofertas = ofertas;
	}
	
	

	
}
