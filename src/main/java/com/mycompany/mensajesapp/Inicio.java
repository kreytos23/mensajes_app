package com.mycompany.mensajesapp;

import java.sql.Connection;

public class Inicio {
    public static void main(String args []){
        
        Conexion conexion = new Conexion();
        
        try(Connection cnx = conexion.getConnection()){
            
        }catch(Exception e){
            System.out.println("ESta mal aqui");
        }
    }
}
