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

    // Instancia de la biblioteca para gestionar los datos
    static Biblioteca biblioteca = new Biblioteca("Biblioteca Cooperativa");

    static Admin admin1 = new Admin("Raúl", "Carrera Custodio", "09215030B", 1, 1, null);
    static Usuario usuario1 = new Admin("Manuel Enrique", "Vargas Béjar", "0911480B", 2, 2, null);
    static Usuario usuario2 = new Usuario("Juan", "Pérez", "12345678Z", 3, "juan@email.com", "1234");

    /**
     * Método principal que gestiona el inicio de sesión y la navegación por los
     * menús.
     */
    public static void menu() {
        biblioteca.agregarUsuario(admin1);
        biblioteca.agregarUsuario(usuario1);
        biblioteca.agregarUsuario(usuario2);

        System.out.println("--- BIENVENIDO A LA BIBLIOTECA ---");
        System.out.println("Introduce el nombre de usuario: ");
        String nombreUsuario = sc.nextLine();

        // Búsqueda simple del usuario para el login
        Usuario usuarioLogueado = null;
        if (admin1.getnombre().equalsIgnoreCase(nombreUsuario)) {
            usuarioLogueado = admin1;
        } else if (usuario1.getnombre().equalsIgnoreCase(nombreUsuario)) {
            usuarioLogueado = usuario1;
        } else if (usuario2.getnombre().equalsIgnoreCase(nombreUsuario)) {
            usuarioLogueado = usuario2;
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
                System.out.println("Inicio de sesión como ADMINISTRADOR.");
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
                    System.out.println("Introduce Título:");
                    String titulo = sc.nextLine();
                    System.out.println("Introduce Autor:");
                    String autor = sc.nextLine();
                    System.out.println("Introduce ISBN:");
                    String isbn = sc.nextLine();
                    // Se crea un libro con valores por defecto para género y disponibilidad por
                    // simplicidad
                    Libros nuevoLibro = new Libros(titulo, autor, isbn, GeneroLib.NARRATIVA, "Disponible", 0);
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
    public static void menuUsuario(Usuario usuario) {
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
