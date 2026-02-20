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

    static Biblioteca biblioteca = new Biblioteca("Biblioteca Cooperativa");

    static Admin admin1 = new Admin("Raúl", "Carrera Custodio", "09215030B", 1, 1, null);
    /**
     * Método principal que gestiona el inicio de sesión y la navegación por los
     * menús.
     */
    public static void menu() {
        biblioteca.agregarUsuario(admin1);

        System.out.println("--- BIENVENIDO A LA BIBLIOTECA ---");
        System.out.println("Introduce el nombre de usuario: ");
        String nombreUsuario = sc.nextLine();

        
        // Búsqueda simple del usuario para el login
        Usuario usuarioLogueado = null;
        Usuario[] usuarios = biblioteca.getUsuarios();
        for (int i = 0; i < usuarios.length; i++) {
            if (nombreUsuario.equals(usuarios[i].getNombre())) {
                usuarioLogueado = usuarios[i];
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
                menuAdmin();
                break;
            case 2: // Usuario
                System.out.println("Inicio de sesión como USUARIO.");
                menuUsuario(usuarioLogueado);
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
    public static void menuAdmin() {
        boolean salir = false;

        do {
            System.out.println("\n--- MENÚ ADMINISTRADOR ---");
            System.out.println("1. Agregar Libro");
            System.out.println("2. Mostrar todos los libros");
            System.out.println("3. Mostrar usuarios");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    
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
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!salir);
    }

    /**
     * Muestra las opciones disponibles para un usuario estándar.
     * 
     * @param usuario El usuario que está utilizando el sistema.
     */
    public static void menuUsuario(Usuario usuario) {
        boolean salir = false;

        do {
            System.out.println("\n--- MENÚ USUARIO ---");
            System.out.println("1. Ver libros disponibles");
            System.out.println("2. Buscar libro");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = sc.nextInt();

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
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!salir);
    }

}
