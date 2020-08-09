package com.mycompany.mensajesapp;

import java.util.Scanner;

public class Inicio {
    public static void main(String args []){
        
        Scanner sc = new Scanner(System.in);
        
        int opcion = 0;
        
        do{
            System.out.println("Menu de Sistema de mensajeria");
            System.out.println("1.- Crear Mensaje");
            System.out.println("2.- Mostrar mensajes");
            System.out.println("3.- Editar mensajes");
            System.out.println("4.- Eliminar mensajes");
            System.out.println("5.- Salir");
            System.out.println("Escoge una opcion: ");
            opcion = sc.nextInt();
            
            switch(opcion){
            
            case 1:
                MensajesService.crearMensaje();
                break;
            case 2:
                MensajesService.mostrarMensajes();
                break;
            case 3:
                MensajesService.editarMensajes();
                break;
            case 4:
                MensajesService.borrarMensajes();
                break;
            default:
                break;
                
            }
        }while(opcion != 5);
           
    }
}
