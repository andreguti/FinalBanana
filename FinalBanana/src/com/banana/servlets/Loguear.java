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
 * Servlet implementation class loguearusuario
 */
@WebServlet("/Loguear")
public class Loguear extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loguear() {
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
		
	//doGet(request, response);
		
		
		response.setContentType("application/json");

        String jsonResult = "{\"status\":\"error\"}";
        
      System.out.println(jsonResult);
       
        funciones conecta =  new  funciones();
  
        
        
        
        JsonObject obtencion = JSONPost.getJsonObject( //obtiene objetos
                request.getReader() //Aquí está nuestro json
       );
       
       //int     id        = jo.get("id").getAsInt();
       //String  nombre= obtencion.get("nnombre").getAsString();
       String  correo = obtencion.get("ccorreo").getAsString();
       String  password = obtencion.get("ppass").getAsString();
       
       
        if(conecta.buscarbdlog(correo,password)==true)
        {
                jsonResult = "{" +
                       
                                  "\"control\":\"" + 0  +"\""
                              + "}";
                
                  	System.out.println("el usuario   fui encontrado "+jsonResult);
                  	
                  	
                  	try (PrintWriter out = response.getWriter()) {
                          /* TODO output your page here. You may use following sample code. */
                    	  System.out.println(jsonResult);
                          out.print(jsonResult);
                          
                          response.setContentType("application/json");
                      }
        }
                
                          	
                    
                    
                    
                    
                    else
                    	
                    {
                    	///  si no haya  el  dato en la base de datos devuelbe  el  mesaje  ue no se encontro 
                    	
                   	    jsonResult = "{" +
                            
                                "\"control\":\"" + 0 +"\""
                            + "}";
                 	
                   	try (PrintWriter out = response.getWriter()) {
                           /* TODO output your page here. You may use following sample code. */
                     	  System.out.println(jsonResult);
                           out.print(jsonResult);
                           
                           response.setContentType("application/json");
                           
                      	}     
                   
                    
                }
          
      
	}


	
	
}
