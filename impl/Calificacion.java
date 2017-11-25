package TPO.impl;

import java.time.LocalDate;

public class Calificacion {

	private Usuario calificador;
	private Transaccion transaccion;
	private int notaCalif;
	private String observaciones;
	private LocalDate fechaCalif;
	
	public Calificacion(Usuario calificador, Transaccion transaccion, int notaCalif, String observaciones) {
		super();
		this.calificador = calificador;
		this.transaccion = transaccion;
		this.notaCalif = notaCalif;
		this.observaciones = observaciones;
		this.setFechaCalif(LocalDate.now()); //le seteo la fecha de cuando creo la calif
	}

	public Usuario getCalificador() {
		return calificador;
	}

	public void setCalificador(Usuario calificador) {
		this.calificador = calificador;
	}

	public Transaccion getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(Transaccion transaccion) {
		this.transaccion = transaccion;
	}

	public int getNotaCalif() {
		return notaCalif;
	}

	public void setNotaCalif(int notaCalif) {
		this.notaCalif = notaCalif;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public LocalDate getFechaCalif() {
		return fechaCalif;
	}

	public void setFechaCalif(LocalDate fechaCalif) {
		this.fechaCalif = fechaCalif;
	}

}
