package com.ransa.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ransa.modelo.PedidoMovimientoRansa;
import com.ransa.service.UsuarioRansaServiceImpl;
/**
 * Servlet implementation class DemoServlet
 */
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String txtIdPedido = request.getParameter("txt1");
		String txtIdCliente = request.getParameter("txt2");
		String txtIdUsuario = request.getParameter("txtIdUsuario");
		
		/*
		UsuarioRansaServiceImpl us = new UsuarioRansaServiceImpl();
		try{
			List<List<String>> cadena = us.getCargo(txtIdPedido);
			System.out.println(cadena.get(0));
			request.setAttribute("listado", cadena);
			String url = "/index.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(url);
			System.out.println("paso");
			rd.forward(request, response);
			//System.out.println("paso");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		*/
	}

}
