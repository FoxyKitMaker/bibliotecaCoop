package com.biblioteca;

/**
 * Representa la lógica para gestionar la creación y borrado de libros
 * Permite:
 * Crear libros asignandoles: titulo, autor, isbn y un genero 
 * 
 * @author Raúl
 * @version 0.1a
 */

public class Libros {
    private String titulo;
    private String autor;
    private String isbn;
    private GeneroLib generoLib;

    public Libros(String titulo, String autor, String isbn, GeneroLib generoLib) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.generoLib = generoLib;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public GeneroLib getGeneroLib() {
        return generoLib;
    }

}
