package com.biblioteca;

/**
 * En esta clase, se manejará toda la lógica del login
 * 
 * @author Raúl Carrera Custodio
 * @version 0.1a
 */
public class Login {

    private int comprobador;

    /**
     * La lógica para el login de un usuario/admin, primero comprueba si el ususario
     * introducido por parámetro es un admin:
     * 
     * 1- Si es un admin que pertenece a usuario comprueba si la contraseña introducida
     * por parámetro es igual a la contraseña de admin comprobador devuelve 1.
     * 1.1- Si no es la misma contraseña comprobador devuelve -1
     * 
     * 2- Si el usuario introducido por parámetro no pertence a la clase admin entonces
     * comprueba la contraseña del usuario:
     * 
     * 2.1.- Si la contraseña introducida por parámetro es iguala la contraseña del
     * usuario comprobador devuelve 2.
     * 2.2.- Si no es la misma contraseña comprobador devuelve -1
     * 
     * @param usuario     Un tipo usuario
     * @param contrasenia Un tipo string con la contraseña
     * @return En función al resultado de los if's comprobador devuele un valor u otro
     */
    public int login(Usuario usuario, String contrasenia) {

        if (usuario instanceof Admin) {
            if (Admin.getContraseniaAdmin().equals(contrasenia)) {
                comprobador = 1;
            } else {
                comprobador = -1;
            }
        } else {
            if (usuario.getcontrasenia() == contrasenia) {
                comprobador = 2;
            } else {
                comprobador = -1;
            }
        }

        return comprobador;
    }

    public int getcomprobador() {
        return comprobador;
    }
}
