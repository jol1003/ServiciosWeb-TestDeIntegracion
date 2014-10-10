/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ransa.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author jol
 */
public class ConexionDB {
    public static Connection obtenerConexion() throws SQLException {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//con = DriverManager.getConnection("jdbc:mysql://10.3.1.3/ajrn",
				//	"userran", "ransa123456");
			con = DriverManager.getConnection("jdbc:mysql://localhost/bd_ransanet",
					"root", "123456");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();  
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return con;
	}
}
