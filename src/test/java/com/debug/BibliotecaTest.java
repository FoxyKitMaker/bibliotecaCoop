package com.debug;

import org.junit.jupiter.api.Test;

import com.biblioteca.Biblioteca;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {

    @Test
    void testInicializacionBiblioteca() {
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central");

        assertEquals("Biblioteca Central", biblioteca.getNombre());
        
        // Verifica que los arrays se inicializan vacíos y no nulos
        assertNotNull(biblioteca.getLibros());
        assertEquals(0, biblioteca.getLibros().length);
    }
}