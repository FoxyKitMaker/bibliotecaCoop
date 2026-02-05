package com.biblioteca;

/**
 * Representa una lógica para guardar los libros existentes y ofrece
 * métodos para que otras clases puedan modificar o consultar el catálogo.
 * Tambien almacena los usuarios existentes
 * 
 * @author Claudio García Camons
 * @version 0.1a
 */

public class Biblioteca {
    private String nombre;
    private Libros [] arrayLibros;
    private Usuario [] arrayUsuarios;
    private int contadorLibros;

    public Biblioteca(String nombre){
        this.nombre = nombre;
        this.arrayLibros = new Libros[0];
        this.arrayUsuarios = new Usuario[0];
    }

    public void agregarLibro(Libros libro){

        if(this.arrayLibros==null){
            this.arrayLibros = new Libros[1];
            this.arrayLibros[0] = libro;
        }else{
            Libros [] arrayNuevo = new Libros[this.arrayLibros.length+1];

            for(int i=0; i<this.arrayLibros.length; i++){
                arrayNuevo[i] = arrayLibros[i];
            }

            arrayNuevo[arrayNuevo.length-1] = libro;
            this.arrayLibros = arrayNuevo;
        }

    }

    public void agregarUsuario(Usuario usuario){
        if(this.arrayUsuarios==null){
            this.arrayLibros = new Libros[1];
            this.arrayUsuarios[0] = usuario;
        }else{
            Usuario [] arrayNuevo = new Usuario[this.arrayUsuarios.length+1];
            
        }
    }
}