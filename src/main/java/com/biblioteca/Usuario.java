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
    private String nombre;
    private String apellido;
    private String dni;
    private String idUsuario;

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

}
