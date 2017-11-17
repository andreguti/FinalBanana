package com.banana.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.mysql.jdbc.Statement;

import classes.JSONPost;

/**
 * Servlet implementation class conexion
 */
@WebServlet("/conexion")
public class conexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public conexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//response.setContentType("application/json");
		//Construir el mensaje por defecto, por si falla...
		response.setContentType("application/json");

        String jsonResult = "{\"status\":\"error\"}";
        
        
		
	       
       System.out.println(jsonResult);
        
        
            
            //Send request reader and get
        	 JsonObject obtencion = JSONPost.getJsonObject( //obtiene objetos
                     request.getReader() //Aquí está nuestro json
            );
            
            //int     id        = jo.get("id").getAsInt();
            String  nombre= obtencion.get("nnombre").getAsString();
            String  correo = obtencion.get("ccorreo").getAsString();
            String  password = obtencion.get("ppassword").getAsString();
                   
            funciones  conectar = new funciones ();
            
            String mensaje="se  introdujo correctamnete el  usuario";
  
          if(conectar.buscarbd(correo)==true)
          {
                  jsonResult = "{" +
                                 //   "\"id\":\"" + Idusuario +"\"," +
                                 //   "\"content\":\"" + uusuario +"\"," +
                                 //   "\"control\":\"" + correobd +"\"" +
                                    "\"control\":\"" + 0  +"\""
                                + "}";
                  
                    	System.out.println("el usuario  duplicado "+jsonResult);
                    	try (PrintWriter out = response.getWriter()) {
                            /* TODO output your page here. You may use following sample code. */
                      	  System.out.println(jsonResult);
                            out.print(jsonResult);
                            
                            response.setContentType("application/json");
                        }
          }
                   
          else  	
                    {
        	  
        	  
        	  
        	    
              jsonResult = "{" +
                      
                         "\"control\":\"" + 1  +"\""
                     + "}";
       
              
              
              try (PrintWriter out = response.getWriter()) {
                  /* TODO output your page here. You may use following sample code. */
            	  System.out.println(jsonResult);
                  out.print(jsonResult);
                  
                  response.setContentType("application/json");
              }
                
              
       	   String query = "INSERT INTO usuarios(nombre,correo,contrasena) " + 
                   "VALUES('" + nombre+ "',  '" + correo + "', '" + password + "')";
    
    System.out.println(query);
    
    
    //Statement insercion = (Statement) con.createStatement();
    //Insercion
    Connection con = conectar.conectar();
    
    
    Statement insercion;
	try {
		insercion = (Statement) con.createStatement();
		
		insercion.executeUpdate(query);//  esta linea ejecuta   el query en la base de datos
		
		 con.close();
		 
		 System.out.println(mensaje);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Fallo");
	}
             
              	
              }
              
          
                    	///  si no haya  el  dato en la base de datos devuelbe  el  mesaje  ue no se encontro 
                    	
                    
                 
          
       
        
	}
        

        //Escribir el JSON
    
        
	}

	
	
	///  se conecta  a la base de  datos    de manzana  e inserta  los datos   del  registro
	

