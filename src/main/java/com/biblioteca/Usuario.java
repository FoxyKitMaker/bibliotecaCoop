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
    private String idUsuario;
    private String email;


    public Usuario(String nombre, String apellido, String dni, String idUsuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.idUsuario = idUsuario;
    }

    public String getnombre() {
        return nombre;
    }

    public String getapellido() {
        return apellido;
    }

    public String getdni() {
        return dni;
    }

    public String getidusuario() {
        return idUsuario;
    }
    
    public String getemail() {
        return email;
    }

    public void buscarLibro(Biblioteca biblioteca, String busqueda) {
    // Obtenemos el array para no llamar al getter todo el tiempo
    Libros[] lista = biblioteca.getLibros();
    String b = busqueda.toLowerCase();

    // Recorremos desde 0 hasta la longitud del array
    for (int i = 0; i < lista.length; i++) {
        
        // Accedemos al libro en la posición 'i'
        Libros libroActual = lista[i];

        if (libroActual.getTitulo().toLowerCase().contains(b) || 
            libroActual.getAutor().toLowerCase().contains(b)  ||
            libroActual.getCategoria().toLowerCase().contains(b)) {
            
            System.out.println("Índice [" + i + "] - Encontrado: " + libroActual.getTitulo());
        }
    }
}
}
