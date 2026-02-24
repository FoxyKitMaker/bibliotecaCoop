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
    /**
     * Método principal que gestiona el inicio de sesión y la navegación por los
     * menús.
     */
    public static void menu(Biblioteca biblioteca) {
        biblioteca.agregarUsuario(admin1);

        System.out.println("--- BIENVENIDO A LA BIBLIOTECA ---");
        System.out.println("Introduce el nombre de usuario: ");
        String nombreUsuario = sc.nextLine();

        
        // Búsqueda simple del usuario para el login
        Usuario usuarioLogueado = null;
        for(Usuario u : biblioteca.getArrayUsuarios()) {
            if (u.getNombre().equalsIgnoreCase(nombreUsuario)) {
                usuarioLogueado = u;
                break;
            }
        }

        if (usuarioLogueado == null) {
            System.out.println("Error: El usuario no existe.");
            return;
        }

        System.out.println("Introduce la contraseña: ");
        String contrasenia = sc.nextLine();

        Login loginSystem = new Login();
        int comprobador = loginSystem.login(usuarioLogueado, contrasenia);

        switch (comprobador) {
            case 1: // Administrador
                System.out.println("Inicio de sesión como ADMINSTRADOR.");
                menuAdmin(biblioteca);
                break;
            case 2: // Usuario
                System.out.println("Inicio de sesión como USUARIO.");
                menuUsuario(usuarioLogueado, biblioteca);
                break;
            case -1:
            default:
                System.out.println("Error: Contraseña incorrecta.");
                break;
        }
    }

    /**
     * Muestra las opciones disponibles para el administrador.
     */
    public static void menuAdmin(Biblioteca biblioteca) {
        int opcion = 0;
        do {
            System.out.println("\n--- MENÚ ADMINISTRADOR ---");
            System.out.println("1. Agregar Libro");
            System.out.println("2. Mostrar todos los libros");
            System.out.println("3. Mostrar usuarios");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            String entrada = sc.nextLine();
            if (entrada.equals("1") || entrada.equals("2") || entrada.equals("3") || entrada.equals("4")) {
                opcion = Integer.parseInt(entrada);
            } else {
                opcion = 0;
                System.out.println("Error: Debes introducir un número válido.");
            }

            switch (opcion) {
                case 1:
                    System.out.println("Introduce el título del libro:");
                    String titulo = sc.nextLine();
                    System.out.println("Introduce el autor:");
                    String autor = sc.nextLine();
                    System.out.println("Introduce el ISBN:");
                    String isbn = sc.nextLine();
                    System.out.println("Introduce el género (ej. NARRATIVA, TERROR, CIENCIA...):");
                    String generoStr = sc.nextLine().toUpperCase();
                    
                    GeneroLib genero;
                    try {
                        genero = GeneroLib.valueOf(generoStr);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Género no reconocido. Se asignará NARRATIVA por defecto.");
                        genero = GeneroLib.NARRATIVA;
                    }

                    Libros nuevoLibro = new Libros(titulo, autor, isbn, genero, "Disponible", 0);
                    biblioteca.agregarLibro(nuevoLibro);
                    System.out.println("Libro agregado correctamente.");
                    break;
                case 2:
                    biblioteca.getLibros();
                    break;
                case 3:
                    biblioteca.getUsuarios();
                    break;
                case 4:
                    System.out.println("Cerrando sesión de administrador...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    /**
     * Muestra las opciones disponibles para un usuario estándar.
     * 
     * @param usuario El usuario que está utilizando el sistema.
     */
    public static void menuUsuario(Usuario usuario, Biblioteca biblioteca) {
        int opcion = 0;
        do {
            System.out.println("\n--- MENÚ USUARIO ---");
            System.out.println("1. Ver libros disponibles");
            System.out.println("2. Buscar libro");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            String entrada = sc.nextLine();
            if (entrada.equals("1") || entrada.equals("2") || entrada.equals("3")) {
                opcion = Integer.parseInt(entrada);
            } else {
                opcion = 0;
                System.out.println("Error: Debes introducir un número válido.");
            }

            switch (opcion) {
                case 1:
                    usuario.librosDisponibles(biblioteca);
                    break;
                case 2:
                    System.out.println("Introduce el título, autor o género a buscar:");
                    String busqueda = sc.nextLine();
                    usuario.buscarLibro(biblioteca, busqueda);
                    break;
                case 3:
                    System.out.println("Cerrando sesión de usuario...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }

}
