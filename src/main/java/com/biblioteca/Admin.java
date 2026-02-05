package com.biblioteca;

/**
 * Representa la lógica para gestionar los roles de administrador de una
 * biblioteca y sus funciones
 * Permite:
 * 1.- Gestión de Libros:
 * 1.1.- Agregar libros nuevos
 * 1.2.- Eliminar libros existentes
 * 1.3.- Buscar libros por título, autor o categoría
 * 1.4.- Mostrar todos los libros disponibles
 * 2.- Gestión de Usuarios:
 * 2.1.- Registrar nuevos usuarios
 * 2.2.- Consultar información de usuarios registrados
 * 3.- Gestión de Préstamos:
 * 3.1.- Realizar préstamos de libros
 * 3.2.- Devolver libros prestados
 * 3.3.- Mostrar libros actualmente prestados
 * 4.- Estadísticas y Reportes:
 * 4.1.- Mostrar número de préstamos totales y activos.
 * 4.2.- Listar los libros más prestados.
 * 4.3.- Mostrar qué usuario tiene más préstamos activos.
 * 
 * @author Raúl Carrera Custodio
 * @version 0.1a
 */

public class Admin extends Usuario {

    private static String email = "correoAdmin@admin.com";
    private int idAdmin;
    private static String contraseña = "elPatica69";

    public Admin(String nombre, String apellidos, String dni, int idAdmin) {
        // Se pasa String.valueOf(idAdmin) para que el idUsuario del padre coincida con el idAdmin
        super(nombre, apellidos, dni, String.valueOf(idAdmin));
        this.idAdmin = idAdmin;
    }

    public String getNombre() {
        return super.getnombre();
    }

    public String getApellidos() {
        return super.getapellido();
    }

    public static String getEmail() {
        return email;
    }

    public String getDni() {
        return super.getdni();
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public static String getContraseña() {
        return contraseña;
    }

    /**
     * Agrega un nuevo libro al array existente creando uno nuevo sin espacios
     * vacíos.
     * 
     * @param inventarioActual El array actual de libros.
     * @param nuevoLibro       El objeto Libro que se desea añadir.
     * @return Un nuevo array de Libros que incluye el nuevo ejemplar.
     */
    public Libros[] agregarLibros(Libros[] librosActuales, Libros nuevoLibro) {
        
        // Crear un nuevo array con una posición más
        Libros[] nuevosLibros = new Libros[librosActuales.length + 1];

        // Copiar los libros actuales al nuevo array
        for(int i = 0; i < librosActuales.length; i++) {
            nuevosLibros[i] = librosActuales[i];
        }

        // Insertar el nuevo libro en la última posición
        nuevosLibros[nuevosLibros.length - 1] = nuevoLibro;

        return nuevosLibros;
    }

    /**
     * Elimina un nuevo libro al array existente creando uno nuevo sin espacios
     * vacíos.
     * 
     * @param inventarioActual El array actual de libros.
     * @param nuevoLibro       El objeto Libro que se desea eliminar.
     * @return Un nuevo array de Libros sin el ejemplar eliminado.
     */
    public Libros[] eliminarLibros(Libros[] librosActuales, Libros libroAEliminar) {
        
        // Crear un nuevo array con una posición más
        Libros[] nuevosLibros = new Libros[librosActuales.length - 1];

        for(int i = 0; i < librosActuales.length; i++) {
            if(librosActuales[i].getIsbn().equals(libroAEliminar.getIsbn())) {
                librosActuales[i] = null;
            }

        }

        // Copiar los libros actuales al nuevo array
        for(int i = 0; i < librosActuales.length; i++) {
            nuevosLibros[i] = librosActuales[i];
        }

        return nuevosLibros;
    }

    /**
     * Usa método buscarLibros de la superclase Ususario, que busca por título, autor o género
     * 
     * @param inventarioActual El array actual de libros.
     * @param nuevoLibro       El objeto Libro que se desea eliminar.
     * @return Un nuevo array de Libros sin el ejemplar eliminado.
     */

    public Libros buscarLibros() {
        return super.buscarLibros();
    }
    
    public Libros mostrarLibros() {
        return super.mostrarLibros();
    }

    
}
