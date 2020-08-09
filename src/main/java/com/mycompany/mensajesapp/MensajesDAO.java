/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajesapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajesDAO {
    
    public static void crearMensajeDB(Mensajes mensajes){
        Conexion db_connect = new Conexion();
        
        try(Connection conexion = db_connect.getConnection()){
            
            PreparedStatement ps = null;
            try{
                String query = "INSERT INTO mensajes (mensajes, autor_mensajes) VALUES (?,?)";
                
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensajes.getMensaje());
                ps.setString(2, mensajes.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("mensaje creado");    
            
            }catch(SQLException e){
                System.out.println(e);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void mostrarMensajesDB(){
        Conexion db_connect = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try(Connection conexion = db_connect.getConnection()){
            String query = "SELECT * FROM mensajes";    
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                System.out.println("Numero de ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje: " + rs.getString("mensajes"));
                System.out.println("Autor: " + rs.getString("autor_mensajes"));
                System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                System.out.println("\n");
            }
          
        }catch(SQLException ex){
                System.out.println(ex);
                System.out.println("No se pudo leer los mensajes");
            }
    }
    
    public static void borrarMensajesDB(int id_mensajes){
        
    }
    
    public static void editarMensajesDB(Mensajes mensaje){
        
    }
}
