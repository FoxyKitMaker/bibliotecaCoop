package com.debug;

import org.junit.jupiter.api.Test;

import com.biblioteca.Admin;
import com.biblioteca.GeneroLib;
import com.biblioteca.Libros;
import com.biblioteca.Usuario;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    @Test
    void testAgregarLibros() {
        Admin admin = new Admin("Admin", "Super", "0000", 1, 1, "admin@test.com");
        Libros[] inventarioInicial = new Libros[0];
        Libros nuevoLibro = new Libros("Java", "Gosling", "111", GeneroLib.INFORMATICA, "Si", 0);

        Libros[] inventarioActualizado = admin.agregarLibros(inventarioInicial, nuevoLibro);

        assertEquals(1, inventarioActualizado.length);
        assertEquals(nuevoLibro, inventarioActualizado[0]);
    }

    @Test
    void testEliminarLibros() {
        Admin admin = new Admin("Admin", "Super", "0000", 1, 1, "admin@test.com");
        Libros libro1 = new Libros("Libro1", "Autor1", "111", GeneroLib.NARRATIVA, "Si", 0);
        Libros libro2 = new Libros("Libro2", "Autor2", "222", GeneroLib.NARRATIVA, "Si", 0);
        
        Libros[] inventario = { libro1, libro2 };

        // Eliminamos el libro 1
        Libros[] inventarioActualizado = admin.eliminarLibros(inventario, libro1);

        assertEquals(1, inventarioActualizado.length);
        assertEquals("222", inventarioActualizado[0].getIsbn());
    }

    @Test
    void testAdminEsUsuario() {
        Admin admin = new Admin("Raul", "Carrera", "DNI", 1, 1, "email");
        assertTrue(admin instanceof Usuario);
        // Verifica que se asignan las credenciales estáticas de admin
        assertEquals(Admin.getEmailAdmin(), admin.getemail());
        assertEquals(Admin.getContraseniaAdmin(), admin.getcontrasenia());
    }
}