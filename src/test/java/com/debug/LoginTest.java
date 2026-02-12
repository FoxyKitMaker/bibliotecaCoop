package com.debug;

import org.junit.jupiter.api.Test;

import com.biblioteca.Admin;
import com.biblioteca.Login;
import com.biblioteca.Usuario;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    @Test
    void testLoginAdminExitoso() {
        Login loginSystem = new Login();
        // Admin usa credenciales estáticas definidas en la clase Admin
        Admin admin = new Admin("Admin", "Test", "000", 1, 1, "mail");
        
        // La contraseña hardcodeada en Admin.java es "elPatica69"
        int resultado = loginSystem.login(admin, "elPatica69");
        
        assertEquals(1, resultado, "El login de admin debería devolver 1");
    }

    @Test
    void testLoginUsuarioExitoso() {
        Login loginSystem = new Login();
        Usuario usuario = new Usuario("User", "Test", "111", 2, "user@mail.com", "password123");

        int resultado = loginSystem.login(usuario, "password123");

        assertEquals(2, resultado, "El login de usuario debería devolver 2");
    }

    @Test
    void testLoginFallido() {
        Login loginSystem = new Login();
        Usuario usuario = new Usuario("User", "Test", "111", 2, "user@mail.com", "password123");

        int resultado = loginSystem.login(usuario, "claveIncorrecta");

        assertEquals(-1, resultado, "El login fallido debería devolver -1");
    }
}