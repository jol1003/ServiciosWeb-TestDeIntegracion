package com.ransa.modelo;
import java.util.Date;
import java.util.Date;


public class PedidoRansa {
	
	private int IdPedido;
	private int IdTipoPedido;
	private String CodPedido;
	private Date FecPedido;
	private int IdCliente;
	private String NomCliente;
	private int IdEstadoPedido;
	private String NomEstadoPedido;
	private byte StsRegistro;
	private int IdUsuarioCreador;
	private String NomUsuarioCreador;
	private Date FecCreacion;
	private int IdUsuarioupdate;
	private String NomUsuarioUpdate;
	private Date FecUpdate; 
	
	
	
	
	public String getNomUsuarioCreador() {
		return NomUsuarioCreador;
	}
	public void setNomUsuarioCreador(String nomUsuarioCreador) {
		NomUsuarioCreador = nomUsuarioCreador;
	}
	public int getIdUsuarioupdate() {
		return IdUsuarioupdate;
	}
	public void setIdUsuarioupdate(int idUsuarioupdate) {
		IdUsuarioupdate = idUsuarioupdate;
	}
	public String getNomUsuarioUpdate() {
		return NomUsuarioUpdate;
	}
	public void setNomUsuarioUpdate(String nomUsuarioUpdate) {
		NomUsuarioUpdate = nomUsuarioUpdate;
	}
	public Date getFecUpdate() {
		return FecUpdate;
	}
	public void setFecUpdate(Date fecUpdate) {
		FecUpdate = fecUpdate;
	}
	public String getNomCliente() {
		return NomCliente;
	}
	public void setNomCliente(String nomCliente) {
		NomCliente = nomCliente;
	}
	public String getNomEstadoPedido() {
		return NomEstadoPedido;
	}
	public void setNomEstadoPedido(String nomEstadoPedido) {
		NomEstadoPedido = nomEstadoPedido;
	}
	
	
	public int getIdPedido() {
		return IdPedido;
	}
	public void setIdPedido(int idPedido) {
		IdPedido = idPedido;
	}
	public int getIdTipoPedido() {
		return IdTipoPedido;
	}
	public void setIdTipoPedido(int idTipoPedido) {
		IdTipoPedido = idTipoPedido;
	}
	public String getCodPedido() {
		return CodPedido;
	}
	public void setCodPedido(String codPedido) {
		CodPedido = codPedido;
	}
	public int getIdCliente() {
		return IdCliente;
	}
	public void setIdCliente(int idCliente) {
		IdCliente = idCliente;
	}
	public int getIdEstadoPedido() {
		return IdEstadoPedido;
	}
	public void setIdEstadoPedido(int idEstadoPedido) {
		IdEstadoPedido = idEstadoPedido;
	}
	public byte getStsRegistro() {
		return StsRegistro;
	}
	public void setStsRegistro(byte stsRegistro) {
		StsRegistro = stsRegistro;
	}
	public int getIdUsuarioCreador() {
		return IdUsuarioCreador;
	}
	public void setIdUsuarioCreador(int idUsuarioCreador) {
		IdUsuarioCreador = idUsuarioCreador;
	}
	public Date getFecPedido() {
		return FecPedido;
	}
	public void setFecPedido(Date fecPedido) {
		FecPedido = fecPedido;
	}
	public Date getFecCreacion() {
		return FecCreacion;
	}
	public void setFecCreacion(Date fecCreacion) {
		FecCreacion = fecCreacion;
	}
	
	
}
