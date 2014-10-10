package com.ransa.modelo;

import java.util.Date;

public class PedidoDetalleRansa {
	
	private int IdPedidoDetalle;
	private int IdPedido;
	
	private int IdInventario;
	private int IdDetalleInvetario;
	private String Descripcion;
	private int CantCajas;
	private String IndUbicado;
	private Date FecCreacion;
	
	public int getIdPedidoDetalle() {
		return IdPedidoDetalle;
	}
	public void setIdPedidoDetalle(int idPedidoDetalle) {
		IdPedidoDetalle = idPedidoDetalle;
	}
	public int getIdPedido() {
		return IdPedido;
	}
	public void setIdPedido(int idPedido) {
		IdPedido = idPedido;
	}
	public int getIdInventario() {
		return IdInventario;
	}
	public void setIdInventario(int idInventario) {
		IdInventario = idInventario;
	}
	public int getIdDetalleInvetario() {
		return IdDetalleInvetario;
	}
	public void setIdDetalleInvetario(int idDetalleInvetario) {
		IdDetalleInvetario = idDetalleInvetario;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public int getCantCajas() {
		return CantCajas;
	}
	public void setCantCajas(int cantCajas) {
		CantCajas = cantCajas;
	}
	public String getIndUbicado() {
		return IndUbicado;
	}
	public void setIndUbicado(String indUbicado) {
		IndUbicado = indUbicado;
	}
	public Date getFecCreacion() {
		return FecCreacion;
	}
	public void setFecCreacion(Date fecCreacion) {
		FecCreacion = fecCreacion;
	}
	
	
}
