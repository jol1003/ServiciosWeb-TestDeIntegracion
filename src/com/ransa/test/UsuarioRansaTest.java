package com.ransa.test;

import org.junit.Assert;
import org.junit.Test;

import com.ransa.service.UsuarioRansaServiceImpl;

public class UsuarioRansaTest {
	
	@Test
    public void logeo() {
        //Proceso
        UsuarioRansaServiceImpl user = new UsuarioRansaServiceImpl();
        //Comprobacion
        Assert.assertTrue(user.iniciarSesion("JONCEBAYL", "123"));
    }
	
	@Test
	public void datosUsuario(){
		UsuarioRansaServiceImpl user = new UsuarioRansaServiceImpl();
		Assert.assertNotNull(user.datosUsuario("JONCEBAYL", "123", "C"));
	}
	
	
	@Test
	public void listArea(){
		UsuarioRansaServiceImpl user = new UsuarioRansaServiceImpl();
		Assert.assertNotNull(user.getListaArea(1));
	}
	
	@Test
	public void insertCabPedido_insertDetPedido(){
		UsuarioRansaServiceImpl user = new UsuarioRansaServiceImpl();
		UsuarioRansaServiceImpl user1 = new UsuarioRansaServiceImpl();
		
		String resultadoCab = user.insertarPedido(1, 1, 2);
		
		Assert.assertNotNull(resultadoCab);
		
		//detalle
		String[] res = resultadoCab.split("-");
		
		String idPedido = res[1];
		System.out.println(res[1]);
		Assert.assertNotNull(user1.insertaPedidoDetalle(Integer.parseInt(idPedido), 325, 605, "DEMO", 1, 2));
		System.out.println(res[1]);
	}
	
	@Test
	public void insertaPedidoMov(){
		UsuarioRansaServiceImpl user = new UsuarioRansaServiceImpl();
		//Assert.assertNotNull(user.insertarPedidoMovimiento(1, 1, 2));
		Assert.assertNotEquals("SQL_EXCEPTION", user.insertarPedidoMovimiento(1, 1, 2));
	}
	
}
