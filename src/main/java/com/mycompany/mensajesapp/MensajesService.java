package com.mycompany.mensajesapp;

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
         Scanner sc = new Scanner(System.in);
         int indice = 0;
         
         System.out.println("Introduce el ID del mensaje a eliminar: ");
         indice = sc.nextInt();
         
         MensajesDAO.borrarMensajesDB(indice);
    }
    
    public static void editarMensajes(){
         Mensajes nuevo = new Mensajes();
         Scanner sc = new Scanner(System.in);
         
         System.out.println("Escribe el mensaje: ");
         nuevo.setMensaje(sc.nextLine());
         
         System.out.println("Escribe el ID del mensaje a editar:");
         nuevo.setId_mensaje(sc.nextInt());
         
         MensajesDAO.editarMensajesDB(nuevo);
    }
}
