package com.biblioteca;
import java.util.Arrays;

public class GestionLibros {
    Libros[] libros;

    public GestionLibros(){
        libros = new Libros[0];
    }

    public void aniadirLibro(Libros libro){
        libros = Arrays.copyOf(libros, libros.length+1);
        libros[libros.length-1] = libro;
    }

    public Libros buscarLibro(String isbn){
        for (Libros libro : libros) {
            if(libro.getIsbn().equals(isbn)){
                return libro;
            }
        }
        return null;
    }

    public void mostrar(){
        for (Libros libro : libros) {
            System.out.println(libro);
        }
    }
    
}
