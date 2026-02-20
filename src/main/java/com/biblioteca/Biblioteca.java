package com.biblioteca;

/**
 * Representa una lógica para guardar los libros existentes y ofrece
 * métodos para que otras clases puedan modificar o consultar el catálogo.
 * Tambien almacena los usuarios existentes y los muestra.
 * Puede relizar prestamos de libros, devolver libros prestados
 * y mostrar libros que han sido prestados
 * * @author Claudio García Camons
 * @version 0.1a
 */

public class Biblioteca {
    private String nombre;
    private Usuario [] arrayUsuarios;
    private Prestamos [] arrayPrestamos;
    private int totalPrestamos;
    private GestionLibros arrayGestion; // Nuevo gestor de libros incorporado

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.arrayUsuarios = new Usuario[0];
        this.arrayPrestamos = new Prestamos[0];
        this.arrayGestion = new GestionLibros();
        this.totalPrestamos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    // Funcion que permite agregar libros al cátalogo usando el gestor
    public void agregarLibro(Libros libroNew) {
        arrayGestion.aniadirLibro(libroNew); 
    }

    // Funcion que permite eliminar libros del cátalogo
    public void eliminarLibros(Libros libroParaEliminar){
        this.arrayGestion.libros = Admin.eliminarLibros(this.arrayGestion.libros, libroParaEliminar);
    }

    // Mostramos el cátalogo de libros usando el método del gestor
    public Libros[] getLibros() {
        arrayGestion.mostrar();
        return arrayGestion.libros; 
    }

    // Añadir usuario
    public void agregarUsuario(Usuario usuario) {
        this.arrayUsuarios = Admin.agregarUsuario(usuario.getNombre(), usuario.getApellido(), usuario.getDni(),
                usuario.getContrasenia(), usuario.getIdusuario(), usuario.getEmail(), this.arrayUsuarios);
    }

    public Usuario[] getUsuarios() {
        Admin.mostrarInfoUsuarios(arrayUsuarios);
        return arrayUsuarios;
    }

    /**
     * Metodo para hacer prestamos
     * * @param user          Recibe el usuario que hará el prestamo
     * @param libroPrestamo recibe el libro que se va a prestar
     */
    public void realizarPrestamos(Usuario user, Libros libroPrestamo) {
        boolean userEncontrado = false;
        boolean libroEncontrado = false;
        // Comprobamos si el libro está disponible para ser prestado
        boolean libroDisponible = libroPrestamo.getdisponibilidad().equalsIgnoreCase("Disponible");

        for (int i = 0; i < arrayUsuarios.length; i++) {
            if (arrayUsuarios[i] == user) {
                userEncontrado = true;
                break;
            }
        }
        
        // Buscamos el libro dentro del array del gestor
        for (int j = 0; j < arrayGestion.libros.length; j++) {
            if (arrayGestion.libros[j] == libroPrestamo) {
                libroEncontrado = true;
                break;
            }
        }

        if (userEncontrado && libroEncontrado && libroDisponible) {
            if (this.arrayPrestamos.length == 0) {
                this.arrayPrestamos = new Prestamos[1];
                this.arrayPrestamos[0] = new Prestamos(user, libroPrestamo);
            } else {
                Prestamos[] nuevoArray = new Prestamos[this.arrayPrestamos.length + 1];
                for (int k = 0; k < this.arrayPrestamos.length; k++) {
                    nuevoArray[k] = this.arrayPrestamos[k];
                }
                nuevoArray[nuevoArray.length - 1] = new Prestamos(user, libroPrestamo);
                this.arrayPrestamos = nuevoArray;
            }
            
            // Actualizamos estados y estadísticas
            System.out.println("Préstamo registrado correctamente.");
            totalPrestamos++;
            libroPrestamo.registrarPrestamo();
            libroPrestamo.setDisponibilidad("No disponible"); // El libro ya no está en la estantería

        } else if (!libroDisponible) {
            System.out.println("Error: El libro ya está prestado actualmente.");
        } else {
            System.out.println("Error: Usuario o libro no encontrados en el sistema.");
        }
    }

    /**
     * Método para que el usuario devuelva un libro que ha sido prestado
     * * @param libro El registro de préstamo que se va a devolver
     */
    public void devolverLibroPrestado(Prestamos libro) {
        boolean encontrado = false;
        int indiceencontrado = 0;

        for (int i = 0; i < this.arrayPrestamos.length; i++) {
            if (arrayPrestamos[i] == libro) {
                encontrado = true;
                indiceencontrado = i;
                break;
            }
        }

        if (encontrado) {
            // Antes de borrar el registro, ponemos el libro como disponible otra vez
            libro.getLibrosPrestados()[0].setDisponibilidad("Disponible");

            Prestamos[] arrayNuevo = new Prestamos[this.arrayPrestamos.length - 1];
            int n = 0;

            for (int j = 0; j < arrayPrestamos.length; j++) {
                if (j != indiceencontrado) {
                    arrayNuevo[n] = arrayPrestamos[j];
                    n++;
                }
            }
            System.out.println("Libro devuelto correctamente. Ya aparece como Disponible.");
            this.arrayPrestamos = arrayNuevo;

        } else {
            System.out.println("No se ha encontrado el registro de préstamo en la biblioteca.");
        }
    }

    // Metodo para mostrar los libros que hayan sido prestados
    public void mostrarLibrosPrestados() {
        if (arrayPrestamos.length > 0) {
            System.out.println("------ LIBROS ACTUALMENTE PRESTADOS: ------");
            for (int i = 0; i < arrayPrestamos.length; i++) {
                Libros libro = arrayPrestamos[i].getLibrosPrestados()[0];
                System.out.println("|| Indice: " + i + " || ISBN: " + libro.getIsbn()
                                + " || Título: " + libro.getTitulo()
                                + " || Autor: " + libro.getAutor());
            }
        } else {
            System.out.println("No hay ningún libro prestado actualmente.");
        }
    }

    // Métodos para reportes y estadísticas
    public int getTotalPrestamos(){
        return totalPrestamos;
    }

    public Prestamos[] getArrayPrestamos(){
        return arrayPrestamos;
    }

    public Libros[] getArrayLibros(){
        return arrayGestion.libros; // Obtenemos los libros desde el gestor
    }

    public Usuario[] getArrayUsuarios(){
        return arrayUsuarios;
    }
}