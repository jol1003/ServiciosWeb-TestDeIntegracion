package com.ransa.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InventarioRansa {
	private int IdInventario;
	private int IdDetalleInventario;
	private Date FecInventario;

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
	
	public int getIdInventario() {
		return IdInventario;
	}
	public void setIdInventario(int idInventario) {
		IdInventario = idInventario;
	}
	public Date getFecInventario() {
		return FecInventario;
	}
	public void setFecInventario(Date fecInventario) {
		FecInventario = fecInventario;
	}
	
	
}
