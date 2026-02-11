package com.biblioteca;

import java.util.Scanner;

/**
 * En esta clase, se manejará toda la lógica del menú
 * 
 * @author Raúl Carrera Custodio
 * @version 0.1a
 */

public class Menu {

    public static Scanner sc = new Scanner(System.in);

    static Admin admin1 = new Admin("Raúl", "Carrera Custodio", "09215030B", 1, 1, null);
    static Usuario usuario1 = new Admin("Manuel Enrique", "Vargas Béjar", "0911480B", 2, 2, null);

    public static void menu() {

        System.out.println("Introduce el usuario: ");
        String usuario = sc.nextLine();
        System.out.println("Introduce la contraseña: ");
        String contrasenia = sc.nextLine();

        int comprobador = 0;

        switch (comprobador) {
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 5:
                
                break;
        
            default:
                break;
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
