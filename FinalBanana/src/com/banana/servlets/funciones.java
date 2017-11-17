package com.banana.servlets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class funciones {
	
	
	
	public Connection conectar()  
    {
        Connection conn1 = null;
        try{
           

        	
        	System.out.println("ya entro");
        	
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            String stringConnection = "jdbc:mysql://localhost:3306/manzana?useSSL=true";
            conn1 = DriverManager.getConnection(stringConnection,"root","");
            
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn1;
    }
	

	
	public boolean  buscarbd(String  correo)
	
	{
		 String  res=""; 
		
		 Connection con = conectar();
		 if (con!= null) {
			
		 try {
			 
 
			 System.out.println("entro");
             //Consulta
             Statement insercion = (Statement) con.createStatement();
             
             String result = "SELECT * FROM usuarios ORDER BY id_usuario ASC  ";
             
            // java.sql.ResultSet rs   =  stmt.executeQuery(queryId);
             ResultSet   bd  =  insercion.executeQuery(result);
             
            // int     Idusuario      = 0;
             //String  uusuario = "";
         
             String  correobd= "";
             
             
             String  passwordbd = "";
             //int     rsControl = 0;
             
             while(bd.next()) {
              //  Idusuario     = bd.getInt("id_usuario");
                // uusuario = bd.getString("uusuario");
                 correobd = bd.getString("correo");
                 passwordbd =bd.getString("contrasena");
                 
                 System.out.println("correobd"+correobd);
                // System.out.println("password"+passwordbd);
           
                 if(correo.contentEquals(correobd ))
                 	
                 {
                 	
                	 System.out.println("correo "+correo);
                	 System.out.println("correobd"+correobd);
                	 
                	 res="true";
                	 
                	 con.close();
                		break;
                 	
                	 
                 
                 	
                 }
                 
                 
                 
                 else
                 	
                 {
                 	///  si no haya  el  dato en la base de datos devuelbe  el  mesaje  ue no se encontro 
                 	
                 	
          
               res="false";
                 String mensaje="se  introdujo correctamnete el  usuario";
                 
                 
                 
                // return  false;  
                 	
                 }
                 
		
                
             }
             //return true;
         	
		 }
		 
		   
         catch (SQLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }

	}
		 
		 
		 
		 if(res.contentEquals("true"))
		 {
			 return true;
		 }
		 
		 else
		 {
		return false;
		
		 }
}
	
	
	




public boolean  buscarbdlog(String  correo  , String password)

{
	 String  res=""; 
	
	 Connection con = conectar();
	 if (con!= null) {
		
	 try {
		 

		 System.out.println("entro");
         //Consulta
         Statement insercion = (Statement) con.createStatement();
         
         String result = "SELECT * FROM usuarios ORDER BY id_usuario ASC  ";
         
        // java.sql.ResultSet rs   =  stmt.executeQuery(queryId);
         ResultSet   bd  =  insercion.executeQuery(result);
         
        // int     Idusuario      = 0;
         //String  uusuario = "";
     
         String  correobd= "";
         
         
         String  passwordbd = "";
         //int     rsControl = 0;
         
         while(bd.next()) {
          //  Idusuario     = bd.getInt("id_usuario");
            // uusuario = bd.getString("uusuario");
             correobd = bd.getString("correo");
             passwordbd =bd.getString("contrasena");
             
             System.out.println("correobd"+correobd);
            // System.out.println("password"+passwordbd);
       
             if(correo.contentEquals(correobd )     &&     password.contentEquals(passwordbd))
             	
             {
             	
            	 System.out.println("correo "+correo);
            	 System.out.println("correobd"+correobd);
            	 
            	 res="true";
            	 
            	 con.close();
            		break;
             	
            	 
             
             	
             }
             
             
             
             else
             	
             {
             	///  si no haya  el  dato en la base de datos devuelbe  el  mesaje  ue no se encontro 
             	
             	
      
           res="false";
             String mensaje="se  introdujo correctamnete el  usuario";
             
             
             
            // return  false;  
             	
             }
             
	
            
         }
         //return true;
     	
	 }
	 
	   
     catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
     }

}
	 
	 
	 
	 if(res.contentEquals("true"))
	 {
		 return true;
	 }
	 
	 else
	 {
	return false;
	
	 }
}



 
}
	
