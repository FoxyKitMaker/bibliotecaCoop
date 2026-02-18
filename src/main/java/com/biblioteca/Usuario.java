package com.biblioteca;

/**
 * @author Manuel Enrique Vargas Béjar
 * @version 0.1a
 *          Funciones de Usuarios.
 *          1.0 - Buscar libros por título, autor o categoría.
 *          1.1 - Mostrar todos los libros disponibles
 *          1.2 - Realizar préstamos de libros.
 *          1.3 - Devolver libros prestados.
 */

public class Usuario {
    protected String nombre;
    protected String apellido;
    protected String dni;
    private int idUsuario;
    private String email;
    private String contrasenia;

    public Usuario(String nombre, String apellido, String dni, int idUsuario, String email, String contrasenia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.idUsuario = idUsuario;
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public int getIdusuario() {
        return idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasenia() {
        return contrasenia;
    }
    /* crear array de usuario donde alojara los usuarios creados no es posible */

    /**
     * Busca libros en la biblioteca comparando el texto con el título, autor o
     * género.
     * Muestra los resultados por consola e ignora mayúsculas y minúsculas.
     * 
     * @param biblioteca La biblioteca que contiene la lista de libros.
     * @param busqueda   El texto o palabra clave que queremos buscar.
     */
    public void buscarLibro(Biblioteca biblioteca, String busqueda) {

        Libros[] listaLibros = biblioteca.getLibros();

        System.out.println("--- RESULTADOS DE BÚSQUEDA: '" + busqueda + "' ---");
        boolean encontradoAlguno = false; // Para saber si no encontramos nada al final

        for (int i = 0; i < listaLibros.length; i++) {
            Libros libroActual = listaLibros[i];

            if (libroActual != null) {

                boolean coincideTitulo = libroActual.getTitulo().equalsIgnoreCase(busqueda);
                boolean coincideAutor = libroActual.getAutor().equalsIgnoreCase(busqueda);
                boolean coincideGenero = libroActual.getGeneroLib().toString().equalsIgnoreCase(busqueda);

                if (coincideTitulo || coincideAutor || coincideGenero) {
                    System.out.println(
                            "Encontrado: " + libroActual.getTitulo() + " (Autor: " + libroActual.getAutor() + ")");
                    encontradoAlguno = true;
                }
            }
        }

        if (encontradoAlguno == false) {
            System.out.println("No se encontraron libros con ese criterio.");
        }
    }

    public void librosDisponibles(Biblioteca biblioteca) {

        System.out.println("--- CATÁLOGO DE LIBROS DISPONIBLES ---");
        boolean disponible = false;
        Libros[] listaDeLibros = biblioteca.getLibros();

        // 1. Recorremos toda la estantería
        for (int i = 0; i < listaDeLibros.length; i++) {
            Libros libroActual = listaDeLibros[i];

            if (libroActual != null) {

                System.out
                        .println("Id: " + i + " | Título: " + libroActual.getTitulo() + " - " + libroActual.getAutor());
                disponible = true;
            }
        }
        if (!disponible) {
            System.out.println("Lo sentimos, no hay ningun libros disponibles en este momento.");
        }
    }

}
