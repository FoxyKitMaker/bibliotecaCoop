package com.debug;

import org.junit.jupiter.api.Test;

import com.biblioteca.GeneroLib;
import com.biblioteca.Libros;

import static org.junit.jupiter.api.Assertions.*;

class LibrosTest {

    @Test
    void testConstructorYGetters() {
        String titulo = "El Quijote";
        String autor = "Cervantes";
        String isbn = "123-456";
        GeneroLib genero = GeneroLib.CLASICOS;
        
        Libros libro = new Libros(titulo, autor, isbn, genero, "Disponible", 0);

        assertEquals(titulo, libro.getTitulo());
        assertEquals(autor, libro.getAutor());
        assertEquals(isbn, libro.getIsbn());
        assertEquals(genero, libro.getGeneroLib());
    }
}