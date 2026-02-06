package com.biblioteca;

/**
 * Representa una lógica para guardar los libros existentes y ofrece
 * métodos para que otras clases puedan modificar o consultar el catálogo.
 * Tambien almacena los usuarios existentes y los muestra.
 * Puede relizar prestamos de libros
 * 
 * @author Claudio García Camons
 * @version 0.1a
 */

public class Biblioteca {
    private String nombre;
    private Libros [] arrayLibros;
    private Usuario [] arrayUsuarios;
    private Prestamos [] arrayPrestamos;

    public Biblioteca(String nombre){
        this.nombre = nombre;
        this.arrayLibros = new Libros[0];
        this.arrayUsuarios = new Usuario[0];
        this.arrayPrestamos = new Prestamos[0]; 
    }

    public String getNombre(){
        return nombre;
    }

    // Funcion que permite agregar libros al cátalogo
    public void agregarLibro(Libros libroNew){
        this.arrayLibros = Admin.agregarLibros(arrayLibros, libroNew);      // mete en el array de libros el array nuevo que retorna la funcion agregarlibros
    }

    // Mostramos el cátalogo de libros
    public Libros[] getLibros(){
        for (int i = 0; i < arrayLibros.length; i++) {
            if (arrayLibros[i] != null) {
                System.out.println("Título: " + arrayLibros[i].getTitulo() + " | Autor: " + arrayLibros[i].getAutor());
            }
        }

        return arrayLibros;
    }

    // Añadir usuario
    public void agregarUsuario(Usuario usuario){
        this.arrayUsuarios = Admin.agregarUsuario(usuario.getnombre(), usuario.getapellido(), usuario.getdni(), usuario.getcontrasenia());
    }

    public Usuario [] getUsuarios(){
        return arrayUsuarios;
    }



    // temporal
    public void realizarPrestamos(Usuario user, Libros libroPrestamo){
        boolean userEncontrado = false;
        boolean libroEncontrado = false;

        for(int i=0; i<arrayUsuarios.length; i++){      // comprobar que el usuario existe
            if(arrayUsuarios[i]==user){
                userEncontrado=true;
            }
        }
        for(int j=0; j<arrayLibros.length; j++){    //comprobar que existe el libro
            if(arrayLibros[j]==libroPrestamo){
                libroEncontrado=true;
            }
        }

        if(userEncontrado && libroEncontrado){    //si existen las dos cosas, se procede a guardar el libro en el array de prestamos

            if(this.arrayPrestamos==null){
                this.arrayPrestamos = new Prestamos[1];
                this.arrayPrestamos[0] = new Prestamos(user, libroPrestamo);
            }else{
                Prestamos [] arrayNuevo = new Prestamos[arrayPrestamos.length+1];

                for(int n=0; n<arrayPrestamos.length; n++){
                    arrayNuevo[n] = arrayPrestamos [n];
                }

                arrayNuevo [arrayNuevo.length-1] = new Prestamos(user, libroPrestamo);
                this.arrayPrestamos = arrayNuevo;
            }
            System.out.println("Prestamo realizado");
        }else{
            System.out.println("No se ha competado el prestamo. El libro o el usuario no existe");
        }
    }


}