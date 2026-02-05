package com.biblioteca;

/**
 * Representa una lógica para guardar los libros existentes y ofrece
 * métodos para que otras clases puedan modificar o consultar el catálogo
 * 
 * @author Claudio García Camons
 * @version 0.1a
 */

public class Biblioteca {
    private String nombre;
    private Libros [] arrayLibros;
    private int contadorLibros;

    public Biblioteca(String nombre){
        this.nombre = nombre;
        this.arrayLibros = new Libros[100];
        this.contadorLibros = 0;
    }

    public void agregarLibro(Libros libro){

        if(i=contador)
        for(int i=0; i<contadorLibros; i++){
            if(arrayLibros[i]==null){
                arrayLibros[i]=libro;
            }
        }
    }
}