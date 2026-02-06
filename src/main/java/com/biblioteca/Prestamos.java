package com.biblioteca;
/**
 * Lógica para gestionar los préstamos de libros a usuarios.
 * Permite registrar qué usuario se lleva qué libros (uno o varios).
 * 
 * @author Raúl Carrera Custodio
 * @version 0.1a
 */
public class Prestamos {
    
    private Libros[] librosPrestados;
    private Usuario usuarioPrestamo;

    /**
     * Constructor para crear un nuevo registro de préstamo con múltiples libros
     * @param usuarioPrestamo El usuario que realiza el préstamo
     * @param librosPrestados Array de libros que se incluyen en este préstamo
     */
    public Prestamos(Usuario usuarioPrestamo, Libros[] librosPrestados) {
        this.librosPrestados = librosPrestados;
        this.usuarioPrestamo = usuarioPrestamo;
    }

    /**
     * Constructor sobrecargado para crear un préstamo de un único libro.
     * Facilita la creación de préstamos sin necesidad de crear un array previo desde fuera.
     * 
     * @param usuarioPrestamo El usuario que realiza el préstamo.
     * @param libroPrestado   El libro individual que se presta.
     */
    public Prestamos(Usuario usuarioPrestamo, Libros libroPrestado) {
        this.usuarioPrestamo = usuarioPrestamo;
        this.librosPrestados = new Libros[] { libroPrestado };
    }

    /**
     * Obtiene los libros asociados al préstamo.
     * @return Array de libros prestados.
     */
    public Libros[] getLibrosPrestados() {
        return librosPrestados;
    }

    /**
     * Obtiene el usuario que realizó el préstamo.
     * @return El usuario del préstamo.
     */
    public Usuario getUsuarioPrestamo() {
        return usuarioPrestamo;
    }
}
