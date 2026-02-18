package com.debug;

import org.junit.jupiter.api.Test;

import com.biblioteca.Usuario;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void testCreacionUsuario() {
        Usuario usuario = new Usuario("Juan", "Perez", "12345678A", 100, "juan@email.com", "pass123");

        assertEquals("Juan", usuario.getnombre());
        assertEquals("Perez", usuario.getapellido());
        assertEquals("12345678A", usuario.getdni());
        assertEquals(100, usuario.getidusuario());
        assertEquals("juan@email.com", usuario.getemail());
        assertEquals("pass123", usuario.getcontrasenia());
    }
}