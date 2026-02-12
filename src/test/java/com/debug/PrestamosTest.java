package com.debug;

import org.junit.jupiter.api.Test;

import com.biblioteca.GeneroLib;
import com.biblioteca.Libros;
import com.biblioteca.Prestamos;
import com.biblioteca.Usuario;

import static org.junit.jupiter.api.Assertions.*;

class PrestamosTest {

    @Test
    void testCrearPrestamoUnico() {
        Usuario usuario = new Usuario("Ana", "Lopez", "123", 1, "ana@mail.com", "pass");
        Libros libro = new Libros("Libro A", "Autor A", "ISBN1", GeneroLib.TEATRO, "Si", 0);

        Prestamos prestamo = new Prestamos(usuario, libro);

        assertEquals(usuario, prestamo.getUsuarioPrestamo());
        assertNotNull(prestamo.getLibrosPrestados());
        assertEquals(1, prestamo.getLibrosPrestados().length);
        assertEquals(libro, prestamo.getLibrosPrestados()[0]);
    }
}