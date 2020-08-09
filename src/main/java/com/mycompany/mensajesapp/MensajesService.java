/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajesapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MensajesService {

    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        Mensajes registro = new Mensajes();
        
        System.out.println("Porfavor escribe tu mensaje:");
        String mensaje =  sc.nextLine();
        
        System.out.println("Escribe tu nombre:");
        String nombre = sc.nextLine();
        
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        
        MensajesDAO.crearMensajeDB(registro);
    }
    
    public static void mostrarMensajes(){
        MensajesDAO.mostrarMensajesDB();
    }
    
    public static void borrarMensajes(){
        
    }
    
    public static void editarMensajes(){
        
    }
}
