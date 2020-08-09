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
                String query = "INSERT INTO mensajes (contenido, autor_mensajes) VALUES (?,?)";
                
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
                System.out.println("Mensaje: " + rs.getString("contenido"));
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
        Conexion db_connect = new Conexion();
        PreparedStatement ps = null;
        
         try(Connection conexion = db_connect.getConnection()){
            String query = "DELETE FROM mensajes WHERE id_mensaje = ?";    
            ps = conexion.prepareStatement(query);
            ps.setInt(1, id_mensajes);
            ps.executeUpdate();
            System.out.println("Mensaje borrado exitosamente");
             
         }catch(SQLException e){
             System.out.println("No se ha podido borrar el mensaje " + e);
         }
    }
    
    public static void editarMensajesDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        PreparedStatement ps = null;
        
         try(Connection conexion = db_connect.getConnection()){
            String query = "UPDATE mensajes SET contenido = ? WHERE id_mensaje = ?"; 
            ps = conexion.prepareStatement(query);
            ps.setString(1, mensaje.getMensaje());
            ps.setInt(2, mensaje.getId_mensaje());
            ps.executeUpdate();
            
            System.out.println("Mensaje actualizado");
         }catch(SQLException e){
             System.out.println(e);
         }
    }
}
