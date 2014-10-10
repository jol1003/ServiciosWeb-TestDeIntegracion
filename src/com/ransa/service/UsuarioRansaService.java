/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ransa.service;

import java.util.List;

import com.ransa.modelo.AreaRansa;
import com.ransa.modelo.EstadoPedidoRansa;
import com.ransa.modelo.InventarioRansa;
import com.ransa.modelo.PedidoDetalleRansa;
import com.ransa.modelo.PedidoMovimientoRansa;
import com.ransa.modelo.PedidoRansa;
import com.ransa.modelo.SerieRansa;
import com.ransa.modelo.TipoPedidoRansa;
import com.ransa.modelo.UsuarioRansa;
/**
 *
 * @author jol
 */
//@WebService
public interface UsuarioRansaService {
    
	public Boolean iniciarSesion(String usuario, String clave);
    public UsuarioRansa datosUsuario(String usuario, String clave, String tipoUsuario);
    
    public String insertarPedido(int tipoPedido, int idCliente, int idUsuario);
    public String insertaPedidoDetalle(int idPedido, int idInventario, int idDetalleInv, String desc, int cantCajas, int idUsuario);
    public String insertarPedidoMovimiento(int idPedido, int idEstadoPedido, int idUsuario);
    public List<PedidoMovimientoRansa> getPedidoMovimiento(String idPedido);
    public List<InventarioRansa> getBusqueda(String nom);
    
    public List<Object> getLisGenerico(String tabla, String condicion);
    public List<Object> getCombos(String tabla);
    public List<Object> getComboArea(String tabla, int filtro);
    
    public List<PedidoRansa> getPedido(String codPedido);
    
    //public List<List<String>> getCargo(String tabla);
    //toda la tabla serie extrae id y nombre
    //reemplaza a getcombos
    public List<SerieRansa> get_tipo_documento();
    
  //toda la tabla tipopedido extrae id y nombre
  //reemplaza a getcombos
    public List<TipoPedidoRansa> get_tipo_pedido();
    
  //toda la tabla tipopedido extrae id y nombre
  //reemplaza a getcombos
    public List<EstadoPedidoRansa> get_estado_pedido(); 
    
  //lista las areas por cliente
  //reemplaza a getComboArea
    public List<AreaRansa> getListaArea(int idCliente);
    
    //pedido
    //reemplaza a getLisGenerico (se separo en 2)
    //variabla condicion se le envia una algo como and idPedido = 2
    public List<PedidoRansa> get_bus_pedido(String condicion);
    
    //pedido detalle
    //reemplaza a getLisGenerico (se separo en 2)
    public List<PedidoDetalleRansa> get_bus_pedido_detalle(int condicion);
    
    //para davis
    public List<InventarioRansa> get_bus_documento_registro(String idarea, String idserie, String nrodoc);
    
    
}
