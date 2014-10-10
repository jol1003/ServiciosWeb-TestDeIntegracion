package com.ransa.modelo;

import java.util.Date;

public class PedidoMovimientoRansa {
	
	private int IdPedidoMovimiento;
	private int IdPedido;
	private Date FecMovimeinto;
	private int IdEstadopedido;
	private String NomEstadoPedido;
	private Date FecInicio;
	private Date FecFin;
	private byte StsRegistro;
	private int IdUsuarioCreador;
	private String NomUsuarioCreador;
	private Date FecCreacion;
	private int IdUsuarioUpdate;
	private String NomUsuarioUpdate;
	private Date FecUpdate;
	
	
	
	public String getNomEstadoPedido() {
		return NomEstadoPedido;
	}
	public void setNomEstadoPedido(String nomEstadoPedido) {
		NomEstadoPedido = nomEstadoPedido;
	}
	public byte getStsRegistro() {
		return StsRegistro;
	}
	public void setStsRegistro(byte stsRegistro) {
		StsRegistro = stsRegistro;
	}
	public Date getFecCreacion() {
		return FecCreacion;
	}
	public void setFecCreacion(Date fecCreacion) {
		FecCreacion = fecCreacion;
	}
	public int getIdUsuarioUpdate() {
		return IdUsuarioUpdate;
	}
	public void setIdUsuarioUpdate(int idUsuarioUpdate) {
		IdUsuarioUpdate = idUsuarioUpdate;
	}
	public Date getFecUpdate() {
		return FecUpdate;
	}
	public void setFecUpdate(Date fecUpdate) {
		FecUpdate = fecUpdate;
	}
	public String getNomUsuarioCreador() {
		return NomUsuarioCreador;
	}
	public void setNomUsuarioCreador(String nomUsuarioCreador) {
		NomUsuarioCreador = nomUsuarioCreador;
	}
	public String getNomUsuarioUpdate() {
		return NomUsuarioUpdate;
	}
	public void setNomUsuarioUpdate(String nomUsuarioUpdate) {
		NomUsuarioUpdate = nomUsuarioUpdate;
	}
	
	public int getIdPedidoMovimiento() {
		return IdPedidoMovimiento;
	}
	public void setIdPedidoMovimiento(int idPedidoMovimiento) {
		IdPedidoMovimiento = idPedidoMovimiento;
	}
	public int getIdPedido() {
		return IdPedido;
	}
	public void setIdPedido(int idPedido) {
		IdPedido = idPedido;
	}
	public int getIdEstadopedido() {
		return IdEstadopedido;
	}
	public void setIdEstadopedido(int idEstadopedido) {
		IdEstadopedido = idEstadopedido;
	}
	public Date getFecMovimeinto() {
		return FecMovimeinto;
	}
	public void setFecMovimeinto(Date fecMovimeinto) {
		FecMovimeinto = fecMovimeinto;
	}
	public Date getFecInicio() {
		return FecInicio;
	}
	public void setFecInicio(Date fecInicio) {
		FecInicio = fecInicio;
	}
	public Date getFecFin() {
		return FecFin;
	}
	public void setFecFin(Date fecFin) {
		FecFin = fecFin;
	}
	public int getIdUsuarioCreador() {
		return IdUsuarioCreador;
	}
	public void setIdUsuarioCreador(int idUsuarioCreador) {
		IdUsuarioCreador = idUsuarioCreador;
	}
	
}
