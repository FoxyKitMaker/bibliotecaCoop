package com.biblioteca;

/**
 * Representa la lógica para gestionar la creación y borrado de libros
 * Permite:
 * Crear libros asignandoles: titulo, autor, isbn y un genero
 * 
 * @author Manuel Enrique Vargas Béjar
 * @version 0.1a
 */

public class Libros {
    private String titulo;
    private String autor;
    private String isbn;
    private GeneroLib generoLib;
    private String disponibilidad;
    private int nPrestamos;

    public Libros(String titulo, String autor, String isbn, GeneroLib generoLib, String disponibilidad,int nPrestamos) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.generoLib = generoLib;
        this.disponibilidad = disponibilidad;
        this.nPrestamos = nPrestamos;
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

    public String getdisponibilidad() {
        return disponibilidad;
    }

    public int getnPrestamos(){
        return nPrestamos;
    }

    public void registrarPrestamo(){
        nPrestamos++;
    }
    
}
