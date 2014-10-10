/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ransa.service;

import com.ransa.conexion.ConexionDB;
import com.ransa.modelo.AreaRansa;
import com.ransa.modelo.EstadoPedidoRansa;
import com.ransa.modelo.InventarioDetalleRansa;
import com.ransa.modelo.InventarioRansa;
import com.ransa.modelo.PedidoDetalleRansa;
import com.ransa.modelo.PedidoMovimientoRansa;
import com.ransa.modelo.PedidoRansa;
import com.ransa.modelo.SerieRansa;
import com.ransa.modelo.TipoPedidoRansa;
import com.ransa.modelo.UsuarioRansa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jol
 */
//@WebService(endpointInterface = "com.ransa.service.UsuarioRansaService")
public class UsuarioRansaServiceImpl implements UsuarioRansaService{

    @Override
    public Boolean iniciarSesion(String usuario, String clave) {
        String query = "select IdUsuario, ApellidosUsuario, NombresUsuario, TipoUsuario from usuario "+
				"where CodUsuario=? and Contrasenia=? ";
        
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean resultado = false;
        
        try{
            
            con = ConexionDB.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, usuario);
            stmt.setString(2, clave);
            rs = stmt.executeQuery();
            //ResultSet cantidad = null;
            int codigo = 0;
            if (rs.next()) {
            	codigo = 1;
            }
            
            if(codigo>0){
                resultado = true;
            }else{
                resultado = false;
            }
                
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            resultado = false;
        }
                
        return resultado;
       
    }

	@Override
	public UsuarioRansa datosUsuario(String usuario, String clave, String tipo) {
		// TODO Auto-generated method stub
		String query = "";
		
		if(tipo.equals("C")){
			query = "SELECT u.IdUsuario, u.IdCliente, u.ApellidosUsuario, u.NombresUsuario FROM usuario u, cliente c " 
						+ " WHERE u.IdCliente = c.IdCliente " 
						+ " AND  u.CodUsuario =? AND u.Contrasenia =?";
	        
		}else{
			query = "select IdUsuario, IdCliente, ApellidosUsuario, NombresUsuario, TipoUsuario from usuario "+
						   " where CodUsuario=? and Contrasenia=?";
		}
		
		Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        UsuarioRansa vo = new UsuarioRansa();
        
        try{
            
            con = ConexionDB.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, usuario);
            stmt.setString(2, clave);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
            	vo.setIdUsuario(rs.getInt(1));
            	vo.setIdCliente(rs.getInt(2));
            	vo.setApellidosUsuario(rs.getString(3));
            	vo.setNombresUsuario(rs.getString(4));
            }
                        
        }catch(Exception e){
            System.out.println(e.getMessage());
            
        }
        
        return vo;

	}

	@Override
	public List<AreaRansa> getListaArea(int idCliente) {
		List<AreaRansa> lista = new ArrayList<AreaRansa>();
		
		String query = "SELECT  IdArea, NomArea FROM area " 
            + " WHERE   IdCliente =?"
            + " ORDER BY NomArea";
		
		Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            
            con = ConexionDB.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setInt(1, idCliente);
            rs = stmt.executeQuery();
            
	            while (rs.next()) {
	            	AreaRansa vo = new AreaRansa();
	            	vo.setIdArea(rs.getInt(1));
	            	vo.setNomArea(rs.getString(2));
	            	
	            	lista.add(vo);
	            }
        }catch(Exception e){
        	System.out.println(e.getMessage());
        }
		return lista;
	}

	@Override
	public String insertarPedido(int tipoPedido, int idCliente, int idUsuario) {
		// TODO Auto-generated method stub
		String resultado = "";
		int codPedido = -1;
		String resultF = "";
		Connection con = null;
		
		try{
			con = ConexionDB.obtenerConexion();
			java.sql.CallableStatement proc = con.prepareCall("{CALL usp_ins_pedido(?,?,?,?,?)}");
			proc.setInt("pn_IdTipoPedido", tipoPedido);
			proc.setInt("pn_IdCliente", idCliente);
			proc.setInt("pn_IdUsuario", idUsuario);
			
			//parametros de salida
			proc.registerOutParameter("oc_CodPedidoNuevo", java.sql.Types.VARCHAR);
			proc.registerOutParameter("on_IdPedido", java.sql.Types.INTEGER);
			
			//ejecutar
			proc.execute();
			
			resultado = proc.getString("oc_CodPedidoNuevo");
			codPedido = proc.getInt("on_IdPedido");
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		} 
		
		resultF = resultado+"-"+Integer.toString(codPedido);
		
		return resultF;
		
	}

	@Override
	public String insertaPedidoDetalle(int idPedido, int idInventario,
			int idDetalleInv, String desc, int cantCajas, int idUsuario) {
		// TODO Auto-generated method stub
		String resultado = "";
		Connection con = null;
		
		try{
			con = ConexionDB.obtenerConexion();
			java.sql.CallableStatement proc = con.prepareCall("{CALL usp_ins_pedidodetalle(?,?,?,?,?,?,?)}");
			proc.setInt("pn_IdPedido", idPedido);
			proc.setInt("pn_IdInventario", idInventario);
			proc.setInt("pn_IdDetalleInventario", idDetalleInv);
			proc.setString("pc_Descripcion", desc);
			proc.setInt("pn_CantCajas", cantCajas);
			proc.setInt("pn_IdUsuario", idUsuario);
			//parametros de salida
			proc.registerOutParameter("oc_message_error", java.sql.Types.VARCHAR);
			
			//ejecutar
			proc.execute();
			
			resultado = proc.getString("oc_message_error");
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		} 
		
		
		return resultado;
	}

	@Override
	public String insertarPedidoMovimiento(int idPedido, int idEstadoPedido,
			int idUsuario) {
		// TODO Auto-generated method stub
		String resultado = "";
		Connection con = null;
		
		try{
			con = ConexionDB.obtenerConexion();
			java.sql.CallableStatement proc = con.prepareCall("{CALL usp_ins_pedidomovimiento(?,?,?,?)}");
			proc.setInt("pn_IdPedido", idPedido);
			proc.setInt("pn_IdEstadoPedido", idEstadoPedido);
			proc.setInt("pn_IdUsuario", idUsuario);
			//parametros de salida
			proc.registerOutParameter("oc_message_error", java.sql.Types.VARCHAR);
			
			//ejecutar
			proc.execute();
			
			resultado = proc.getString("oc_message_error");
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return resultado;
	}

	@Override
	public List<PedidoMovimientoRansa> getPedidoMovimiento(String idPedido) {
		// TODO Auto-generated method stub
		List<PedidoMovimientoRansa> lista = new ArrayList<PedidoMovimientoRansa>();
		
		Connection con = null;
		ResultSet rs = null;
		
		try{
			con = ConexionDB.obtenerConexion();
			java.sql.CallableStatement proc = con.prepareCall("{CALL usp_lis_pedidomovimientoPorCodPedido(?)}");
			proc.setString("pc_CodPedido", idPedido);
			//ejecutar
			 rs = proc.executeQuery();
			 //proc.execute();
			 
			 while (rs.next()) {
				 
				 PedidoMovimientoRansa pm = new PedidoMovimientoRansa();
				 pm.setIdPedidoMovimiento(rs.getInt(1));
				 pm.setIdPedido(rs.getInt(2));
				 pm.setFecMovimeinto(rs.getDate(3));
				 pm.setIdEstadopedido(rs.getInt(4));
				 pm.setNomEstadoPedido(rs.getString(5));
				 pm.setFecInicio(rs.getDate(6));
				 pm.setFecFin(rs.getDate(7));
				 pm.setStsRegistro(rs.getByte(8));
				 pm.setIdUsuarioCreador(rs.getInt(9));
				 pm.setNomUsuarioCreador(rs.getString(10));
				 pm.setFecCreacion(rs.getDate(11));
				 pm.setIdUsuarioUpdate(rs.getInt(12));
				 pm.setNomUsuarioUpdate(rs.getString(13));
				 pm.setFecUpdate(rs.getDate(14));
				
				 lista.add(pm);
			 }
			
			//resultado = proc.getString("oc_message_error");
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return lista;
	}

	@Override
	public List<InventarioRansa> getBusqueda(String nom) {
		// TODO Auto-generated method stub
		List<InventarioRansa> lista = new ArrayList<InventarioRansa>();
		
		Connection con = null;
		ResultSet rs = null;
		
		try{
			con = ConexionDB.obtenerConexion();
			java.sql.CallableStatement proc = con.prepareCall("{CALL usp_bus_documento(?)}");
			proc.setString("pc_filtro", nom);
			//ejecutar
			 rs = proc.executeQuery();
			 //proc.execute();
			 
			 while (rs.next()) {
				 
				 InventarioRansa pm = new InventarioRansa();
				 //InventarioDetalleRansa pmd = new InventarioDetalleRansa(rs.getInt(1));
				 //pm.setIdPedidoMovimiento(rs.getInt(1));
				 pm.setIdInventario(rs.getInt(1));
				 pm.setFecInventario(rs.getDate(3));
				 //pm.setListaDetalle(pmd);
				 pm.setNroSerie(rs.getString(9));
				 pm.setNroDocumento(rs.getString(10));
				 pm.setDescripcion(rs.getString(11));
				 pm.setObservacion(rs.getString(12));
				 lista.add(pm);
			 }
			
			//resultado = proc.getString("oc_message_error");
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return lista;
	}

	@Override
	public List<Object> getLisGenerico(String tabla, String condicion) {
		List<Object> lista = new ArrayList<Object>();
		//List<PedidoDetalleRansa> listad = new ArrayList<PedidoDetalleRansa>();
		
		Connection con = null;
		ResultSet rs = null;
		
		try{
			con = ConexionDB.obtenerConexion();
			java.sql.CallableStatement proc = con.prepareCall("{CALL usp_lis_generico(?,?)}");
			proc.setString("pc_nom_tabla", tabla);
			proc.setString("pc_condicion", condicion);
			//ejecutar
			 rs = proc.executeQuery();
			 //proc.execute();
			 
			 while (rs.next()) {
				 
				 if(tabla.equals("PEDIDO")){
					 PedidoRansa pm = new PedidoRansa();
					 //InventarioDetalleRansa pmd = new InventarioDetalleRansa(rs.getInt(1));
					 //pm.setIdPedidoMovimiento(rs.getInt(1));
					 pm.setIdPedido(rs.getInt(1));
					 pm.setIdTipoPedido(rs.getInt(2));
					 pm.setCodPedido(rs.getString(3));
					 pm.setFecPedido(rs.getDate(4));
					 pm.setIdCliente(rs.getInt(5));
					 pm.setIdEstadoPedido(rs.getInt(7));
					 pm.setIdUsuarioCreador(rs.getInt(10));
					 
					 lista.add(pm);
				 
				 }else{
					 PedidoDetalleRansa pm = new PedidoDetalleRansa();
					 //InventarioDetalleRansa pmd = new InventarioDetalleRansa(rs.getInt(1));
					 //pm.setIdPedidoMovimiento(rs.getInt(1));
					 pm.setIdPedidoDetalle(rs.getInt(1));
					 pm.setIdPedido(rs.getInt(2));
					 pm.setIdInventario(rs.getInt(3));
					 pm.setIdDetalleInvetario(rs.getInt(4));
					 pm.setFecCreacion(rs.getDate(10));
					 
					 lista.add(pm);
				 }
				 
			 }
			
			//resultado = proc.getString("oc_message_error");
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return lista;
	}

	@Override
	public List<Object> getCombos(String tabla) {
		// TODO Auto-generated method stub
		List<Object> lista = new ArrayList<Object>();
		//List<PedidoDetalleRansa> listad = new ArrayList<PedidoDetalleRansa>();
		
		Connection con = null;
		ResultSet rs = null;
		
		try{
			con = ConexionDB.obtenerConexion();
			java.sql.CallableStatement proc = con.prepareCall("{CALL usp_cargar_cbo_1p(?)}");
			proc.setString("pc_nom_tabla", tabla);
			//ejecutar
			 rs = proc.executeQuery();
			 //proc.execute();
			 
			 while (rs.next()) {
				 
				 if(tabla.equals("TIPO_DOCUMENTO")){
					 SerieRansa pm = new SerieRansa();
					 //InventarioDetalleRansa pmd = new InventarioDetalleRansa(rs.getInt(1));
					 //pm.setIdPedidoMovimiento(rs.getInt(1));
					 pm.setIdSerie(rs.getInt(1));
					 pm.setNomSerie(rs.getString(2));
					 
					 lista.add(pm);
				 
				 }else if(tabla.equals("TIPO_PEDIDO")){
					 TipoPedidoRansa pm = new TipoPedidoRansa();
					 //InventarioDetalleRansa pmd = new InventarioDetalleRansa(rs.getInt(1));
					 //pm.setIdPedidoMovimiento(rs.getInt(1));
					 pm.setIdTipoPedido(rs.getInt(1));
					 pm.setNomTipoPedido(rs.getString(2));
					 lista.add(pm);
				 }else if(tabla.equals("ESTADO_PEDIDO")){
					 EstadoPedidoRansa pm = new EstadoPedidoRansa();
					 //InventarioDetalleRansa pmd = new InventarioDetalleRansa(rs.getInt(1));
					 //pm.setIdPedidoMovimiento(rs.getInt(1));
					 pm.setIdEstadoPedido(rs.getInt(1));
					 pm.setNomEstadoPedido(rs.getString(2));
					 lista.add(pm);
				 }
				 
			 }
			
			//resultado = proc.getString("oc_message_error");
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return lista;
	}

	@Override
	public List<Object> getComboArea(String tabla, int filtro) {
		// TODO Auto-generated method stub
		List<Object> lista = new ArrayList<Object>();
		//List<PedidoDetalleRansa> listad = new ArrayList<PedidoDetalleRansa>();
		
		Connection con = null;
		ResultSet rs = null;
		
		try{
			con = ConexionDB.obtenerConexion();
			java.sql.CallableStatement proc = con.prepareCall("{CALL usp_cargar_cbo_2p(?,?)}");
			proc.setString("pc_nom_tabla", tabla);
			proc.setInt("pc_nom_tabla", filtro);
			//ejecutar
			 rs = proc.executeQuery();
			 while (rs.next()) {
				 if(tabla.equals("AREA")){
					 SerieRansa pm = new SerieRansa();
					 pm.setIdSerie(rs.getInt(1));
					 pm.setNomSerie(rs.getString(2));
					 
					 lista.add(pm);
				 }
			 }
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return lista;
	}

	@Override
	public List<PedidoRansa> getPedido(String codPedido) {
		List<PedidoRansa> lista = new ArrayList<PedidoRansa>();
		
		String query = "SELECT 	p.IdPedido,	p.IdTipoPedido, p.CodPedido, p.FecPedido, "
					+ " p.IdCliente, c.NomCliente, p.IdEstadoPedido,	ep.NomEstadoPedido, "
					+ " p.StsRegistro, p.IdUsuarioCreador, (SELECT u.ApellidosUsuario "
					+ " FROM usuario u  WHERE u.IdUsuario = p.IdUsuarioCreador) AS NomUsuarioCreador, "
					+ " p.FecCreacion, p.IdUsuarioupdate, (SELECT u.ApellidosUsuario "
					+ " FROM usuario u WHERE u.IdUsuario = p.IdUsuarioUpdate) AS NomUsuarioUpdate, "
					+ " p.FecUpdate FROM cliente c "
					+ " INNER JOIN pedido p ON c.IdCliente = p.IdCliente "
					+ " INNER JOIN estadopedido ep ON ep.IdEstadoPedido = p.IdEstadoPedido WHERE p.CodPedido =? ";
        
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            
            con = ConexionDB.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, codPedido);
            rs = stmt.executeQuery();
            
	            while (rs.next()) {
	            	PedidoRansa pm = new PedidoRansa();
					 //InventarioDetalleRansa pmd = new InventarioDetalleRansa(rs.getInt(1));
					 //pm.setIdPedidoMovimiento(rs.getInt(1));
					 pm.setIdPedido(rs.getInt(1));
					 pm.setIdTipoPedido(rs.getInt(2));
					 pm.setCodPedido(rs.getString(3));
					 pm.setFecPedido(rs.getDate(4));
					 pm.setIdCliente(rs.getInt(5));
					 pm.setIdEstadoPedido(rs.getInt(7));
					 pm.setIdUsuarioCreador(rs.getInt(10));
					 pm.setNomCliente(rs.getString(6));
					 pm.setNomEstadoPedido(rs.getString(8));
					 lista.add(pm);
	            }
        }catch(Exception e){
        	System.out.println(e.getMessage());
        }
		return lista;
	}

	@Override
	public List<SerieRansa> get_tipo_documento() {
		// TODO Auto-generated method stub
		List<SerieRansa> lista = new ArrayList<SerieRansa>();
		
		Connection con = null;
		ResultSet rs = null;
		
		try{
			con = ConexionDB.obtenerConexion();
			java.sql.CallableStatement proc = con.prepareCall("{CALL usp_get_tipo_documento()}");
			//ejecutar
			 rs = proc.executeQuery();
			 while (rs.next()) {
				 
				SerieRansa pm = new SerieRansa();
				pm.setIdSerie(rs.getInt(1));
				pm.setNomSerie(rs.getString(2));
					 
				lista.add(pm);
				 
			 }
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return lista;
	}

	@Override
	public List<TipoPedidoRansa> get_tipo_pedido() {
		// TODO Auto-generated method stub
		List<TipoPedidoRansa> lista = new ArrayList<TipoPedidoRansa>();
		Connection con = null;
		ResultSet rs = null;
		
		try{
			con = ConexionDB.obtenerConexion();
			java.sql.CallableStatement proc = con.prepareCall("{CALL usp_get_tipo_pedido()}");
			//ejecutar
			 rs = proc.executeQuery();
			 while (rs.next()) {
				 
				TipoPedidoRansa pm = new TipoPedidoRansa();
				pm.setIdTipoPedido(rs.getInt(1));
				pm.setNomTipoPedido(rs.getString(2));
					 
				lista.add(pm);
				 
			 }
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return lista;
	}

	@Override
	public List<EstadoPedidoRansa> get_estado_pedido() {
		List<EstadoPedidoRansa> lista = new ArrayList<EstadoPedidoRansa>();
		// TODO Auto-generated method stub
		Connection con = null;
		ResultSet rs = null;
		
		try{
			con = ConexionDB.obtenerConexion();
			java.sql.CallableStatement proc = con.prepareCall("{CALL usp_get_estado_pedido()}");
			//ejecutar
			 rs = proc.executeQuery();
			 while (rs.next()) {
				 
				 EstadoPedidoRansa pm = new EstadoPedidoRansa();
				pm.setIdEstadoPedido(rs.getInt(1));
				pm.setNomEstadoPedido(rs.getString(2));
					 
				lista.add(pm);
				 
			 }
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return lista;
		
	}

	@Override
	public List<PedidoRansa> get_bus_pedido(String condicion) {
		// TODO Auto-generated method stub
		List<PedidoRansa> lista = new ArrayList<PedidoRansa>();
		
		Connection con = null;
		ResultSet rs = null;
		
		try{
			con = ConexionDB.obtenerConexion();
			java.sql.CallableStatement proc = con.prepareCall("{CALL usp_bus_pedido(?)}");
			proc.setString("pc_condicion", condicion);
			
			//ejecutar
			 rs = proc.executeQuery();
			 while (rs.next()) {
				 
				 PedidoRansa pm = new PedidoRansa();
				 //InventarioDetalleRansa pmd = new InventarioDetalleRansa(rs.getInt(1));
				 //pm.setIdPedidoMovimiento(rs.getInt(1));
				 pm.setIdPedido(rs.getInt(1));
				 pm.setIdTipoPedido(rs.getInt(2));
				 pm.setCodPedido(rs.getString(3));
				 pm.setFecPedido(rs.getDate(4));
				 pm.setIdCliente(rs.getInt(5));
				 pm.setNomCliente(rs.getString(6));
				 pm.setIdEstadoPedido(rs.getInt(7));
				 pm.setNomEstadoPedido(rs.getString(8));
				 pm.setStsRegistro(rs.getByte(9));
				 pm.setIdUsuarioCreador(rs.getInt(10));
				 pm.setNomUsuarioCreador(rs.getString(11));
				 pm.setFecCreacion(rs.getDate(12));
				 pm.setIdUsuarioupdate(rs.getInt(13));
				 pm.setNomUsuarioUpdate(rs.getString(14));
				 pm.setFecUpdate(rs.getDate(15));
				 	
				 lista.add(pm);
				
			 }
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return lista;
		
	}

	@Override
	public List<PedidoDetalleRansa> get_bus_pedido_detalle(int idpedido) {
		// TODO Auto-generated method stub
		List<PedidoDetalleRansa> lista = new ArrayList<PedidoDetalleRansa>();
		
		Connection con = null;
		ResultSet rs = null;
		
		try{
			con = ConexionDB.obtenerConexion();
			java.sql.CallableStatement proc = con.prepareCall("{CALL usp_bus_pedido_detalle(?)}");
			proc.setInt("pn_idpedido", idpedido);
			
			//ejecutar
			 rs = proc.executeQuery();
			 while (rs.next()) {
				 
				 PedidoDetalleRansa pm = new PedidoDetalleRansa();
				 //InventarioDetalleRansa pmd = new InventarioDetalleRansa(rs.getInt(1));
				 //pm.setIdPedidoMovimiento(rs.getInt(1));
				 pm.setIdPedidoDetalle(rs.getInt(1));
				 pm.setIdPedido(rs.getInt(2));
				 pm.setIdInventario(rs.getInt(3));
				 pm.setIdDetalleInvetario(rs.getInt(4));
				 pm.setFecCreacion(rs.getDate(10));
				 
				 lista.add(pm);
				
				 
			 }
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return lista;
	
	}

	@Override
	public List<InventarioRansa> get_bus_documento_registro(String idarea,
			String idserie, String nrodoc) {
		
		List<InventarioRansa> lista1 = new ArrayList<InventarioRansa>();
		
		Connection con = null;
		ResultSet rs = null;
		
		try{
			con = ConexionDB.obtenerConexion();
			java.sql.CallableStatement proc = con.prepareCall("{CALL usp_bus_documento_registro(?,?,?)}");
			proc.setString("idarea", idarea);
			proc.setString("idserie", idserie);
			proc.setString("nrodoc", nrodoc);
			//ejecutar
			 rs = proc.executeQuery();
			 //proc.execute();
			 
			 while (rs.next()) {
				 
				 InventarioRansa pm = new InventarioRansa();
				 //InventarioDetalleRansa pmd = new InventarioDetalleRansa(rs.getInt(1));
				 //pm.setIdPedidoMovimiento(rs.getInt(1));
				 System.out.println(rs.getInt(1));
				 pm.setIdInventario(rs.getInt(1));
				 pm.setIdDetalleInventario(rs.getInt(2));
				 //pm.setFecInventario(rs.getDate(3));
				 //pm.setListaDetalle(pmd);
				 pm.setNroSerie(rs.getString(9));
				 pm.setNroDocumento(rs.getString(10));
				 pm.setDescripcion(rs.getString(11));
				 pm.setObservacion(rs.getString(12));
				 lista1.add(pm);
			 }
			
			//resultado = proc.getString("oc_message_error");
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return lista1;
	}
    
	
	

	
}
