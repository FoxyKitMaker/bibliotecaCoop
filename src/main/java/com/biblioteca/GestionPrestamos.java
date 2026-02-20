package com.biblioteca;

import java.util.Arrays;

public class GestionPrestamos {
    Prestamos[] prestamos;

    public GestionPrestamos(){
        prestamos = new Prestamos[0];
    }

    public void aniadirPrestamo(Prestamos prestamo){
        prestamos = Arrays.copyOf(prestamos, prestamos.length+1);
        prestamos[prestamos.length-1] = prestamo;
    }

    public Prestamos buscarPrestamo(String dniUsuario){
        for (Prestamos prestamo : prestamos) {
            if(prestamo.getUsuarioPrestamo().getDni().equals(dniUsuario)){
                return prestamo;
            }
        }
        return null;
    }

    public void mostrar(){
        for (Prestamos prestamo : prestamos) {
            System.out.println(prestamo);
        }
    }
}
