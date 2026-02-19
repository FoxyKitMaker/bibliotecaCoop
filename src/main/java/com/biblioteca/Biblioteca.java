package com.biblioteca;

/**
 * Representa una lógica para guardar los libros existentes y ofrece
 * métodos para que otras clases puedan modificar o consultar el catálogo.
 * Tambien almacena los usuarios existentes y los muestra.
 * Puede relizar prestamos de libros, devolver libros prestados
 * y mostrar libros que han sido prestados
 * 
 * @author Claudio García Camons
 * @version 0.1a
 */

public class Biblioteca {
    private String nombre;
    private Libros [] arrayLibros;
    private Usuario [] arrayUsuarios;
    private Prestamos [] arrayPrestamos;
    private int totalPrestamos;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.arrayLibros = new Libros[0];
        this.arrayUsuarios = new Usuario[0];
        this.arrayPrestamos = new Prestamos[0];
    }

    public String getNombre() {
        return nombre;
    }

    // Funcion que permite agregar libros al cátalogo
    public void agregarLibro(Libros libroNew) {
        this.arrayLibros = Admin.agregarLibros(arrayLibros, libroNew); // mete en el array de libros el array nuevo que
                                                                       // retorna la funcion agregarlibros
    }

    // Funcion que permite eliminar libros del cátalogo
    public void eliminarLibros(Biblioteca arrayLibros, Libros libroParaEliminar){
        this.arrayLibros = Admin.eliminarLibros(this.arrayLibros, libroParaEliminar);
    }

    // Mostramos el cátalogo de libros
    public Libros[] getLibros() {
        for (int i = 0; i < arrayLibros.length; i++) {
            if (arrayLibros[i] != null) {
                System.out.println("Título: " + arrayLibros[i].getTitulo() + " | Autor: " + arrayLibros[i].getAutor());
            }
        }

        return arrayLibros;
    }

    // Añadir usuario
    public void agregarUsuario(Usuario usuario) {
        this.arrayUsuarios = Admin.agregarUsuario(usuario.getnombre(), usuario.getapellido(), usuario.getdni(),
                usuario.getcontrasenia(), usuario.getidusuario(), usuario.getemail(), this.arrayUsuarios);
    }

    public Usuario[] getUsuarios() {
        Admin.mostrarInfoUsuarios(arrayUsuarios);
        return arrayUsuarios;
    }

    /**
     * Metodo para hacer prestamos
     * 
     * @param user          Recibe el usuario que hará el prestamo
     * @param libroPrestamo recibe el libro que se va a prestar
     */
    public void realizarPrestamos(Usuario user, Libros libroPrestamo) {
        boolean userEncontrado = false;
        boolean libroEncontrado = false;

        for (int i = 0; i < arrayUsuarios.length; i++) { // comprobar que el usuario existe
            if (arrayUsuarios[i] == user) {
                userEncontrado = true;
            }
        }
        for (int j = 0; j < arrayLibros.length; j++) { // comprobar que existe el libro
            if (arrayLibros[j] == libroPrestamo) {
                libroEncontrado = true;
            }
        }

        if (userEncontrado && libroEncontrado) { // si existen las dos cosas, se procede a guardar el libro en el array
                                                 // de prestamos

            if (this.arrayPrestamos.length == 0) {
                this.arrayPrestamos = new Prestamos[1];
                this.arrayPrestamos[0] = new Prestamos(user, libroPrestamo);
            } else {

                Prestamos[] nuevoArray = new Prestamos[this.arrayPrestamos.length + 1]; // nuevo array temp

                for (int k = 0; k < this.arrayPrestamos.length; k++) {
                    nuevoArray[k] = this.arrayPrestamos[k]; // copiamos al nuevo array
                }

                nuevoArray[nuevoArray.length - 1] = new Prestamos(user, libroPrestamo); // se añade el libro

                this.arrayPrestamos = nuevoArray; // se le asigna el nuevo array al original
            }
            System.out.println("Préstamo registrado correctamente.");
            totalPrestamos++;   // se suma un prestamo al registro del historial de prestamos totales
            libroPrestamo.registrarPrestamo();  //se registra un nuevo prestamo de ese libro
        }else {
        System.out.println("Error: Usuario o libro no encontrados en el sistema.");
        }

    }

    /**
     * Método para que el usuario devuelva un libro que ha sido prestado
     * 
     * @param libro El libro que se va a devolver
     */
    public void devolverLibroPrestado(Prestamos libro) {
        boolean encontrado = false;
        int indiceencontrado = 0; // indice de la posicion donde esta el libro prestado

        for (int i = 0; i < this.arrayPrestamos.length; i++) {
            if (arrayPrestamos[i] == libro) {
                encontrado = true;
                indiceencontrado = i;
                break;
            }
        }

        if (encontrado) {
            Prestamos[] arrayNuevo = new Prestamos[this.arrayPrestamos.length - 1]; // nuevo array temporal
            int n = 0; // variable para controlar las posiciones del arrayNuevo en el bucle for

            for (int j = 0; j < arrayPrestamos.length; j++) { // se recorre todo el array viejo porque 1 posicion se
                                                              // saltará asi que tendra la misma longitud que el
                                                              // arrayNuevo
                if (j != indiceencontrado) { // omitimos la posicion donde esta el libro prestado
                    arrayNuevo[n] = arrayPrestamos[j]; // y vamos copiando lo del array viejo al nuevo
                    n++;
                }
            }
            System.out.println("Libro devuelto correctamente");
            this.arrayPrestamos = arrayNuevo; // por ultimo actualizamos el array original

        } else {
            System.out.println("No se ha encuentrado el libro en la biblioteca");
        }

    }

    // Metodo para mostrar los libros que hayan sido prestados
    public void mostrarLibrosPrestados() {

        if (arrayPrestamos.length > 0) {
            System.out.println("------ LIBROS ACTUALMENTE PRESTADOS: ------");

            for (int i = 0; i < arrayPrestamos.length; i++) {
                System.out
                        .println("|| Indice: " + i + " || ISBN: " + arrayPrestamos[i].getLibrosPrestados()[0].getIsbn()
                                + " || Título: " + arrayPrestamos[i].getLibrosPrestados()[0].getTitulo()
                                + " || Autor: " + arrayPrestamos[i].getLibrosPrestados()[0].getAutor());
            }
        } else {
            System.out.println("Error. No hay existencias de libros prestados");
        }
    }

    //Metodos que dan datos para quien haga las estadisticas y reportes

    public int getTotalPrestamos(){
        return totalPrestamos;
    }

    public Prestamos[] getArrayPrestamos(){
        return arrayPrestamos;
    }

    public Libros[] getArrayLibros(){
        return arrayLibros;
    }

    public Usuario[] getArrayUsuarios(){
        return arrayUsuarios;
    }

}