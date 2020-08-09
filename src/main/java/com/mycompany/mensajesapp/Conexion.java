package com.mycompany.mensajesapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    public final String driver = "com.mysql.jdbc.Driver"; 
        
    public Connection getConnection(){
        Connection conection = null;
       
        try{
            
          //  Class.forName(driver);
            
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app", "root", "");
           
            if(conection != null){
                System.out.println("Conexion exitosa");
                
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return conection;
    }
}
