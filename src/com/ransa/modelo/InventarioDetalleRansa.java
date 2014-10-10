package com.ransa.modelo;

public class InventarioDetalleRansa {
	private int IdDetalleInventario;
	private int IdInventario;
	private String NroSerie;
	private String NroDocumento;
	private String Descripcion;
	private String Observacion;
	

	public int getIdDetalleInventario() {
		return IdDetalleInventario;
	}
	public void setIdDetalleInventario(int idDetalleInventario) {
		IdDetalleInventario = idDetalleInventario;
	}
	public int getIdInventario() {
		return IdInventario;
	}
	public void setIdInventario(int idInventario) {
		IdInventario = idInventario;
	}
	public String getNroSerie() {
		return NroSerie;
	}
	public void setNroSerie(String nroSerie) {
		NroSerie = nroSerie;
	}
	public String getNroDocumento() {
		return NroDocumento;
	}
	public void setNroDocumento(String nroDocumento) {
		NroDocumento = nroDocumento;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getObservacion() {
		return Observacion;
	}
	public void setObservacion(String observacion) {
		Observacion = observacion;
	}
	
	
	
}
