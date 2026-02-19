package com.biblioteca;

/**
 * Representa la lógica para gestionar los roles de administrador de una
 * biblioteca y sus funciones
 * Permite:
 * 1.- Gestión de Libros:
 * 1.1.- Agregar libros nuevos
 * 1.2.- Eliminar libros existentes
 * 1.3.- Buscar libros por título, autor o categoría
 * 1.4.- Mostrar todos los libros disponibles
 * 2.- Gestión de Usuarios:
 * 2.1.- Registrar nuevos usuarios
 * 2.2.- Consultar información de usuarios registrados
 * 3.- Gestión de Préstamos:
 * 3.1.- Realizar préstamos de libros
 * 3.2.- Devolver libros prestados
 * 3.3.- Mostrar libros actualmente prestados
 * 4.- Estadísticas y Reportes:
 * 4.1.- Mostrar número de préstamos totales y activos.
 * 4.2.- Listar los libros más prestados.
 * 4.3.- Mostrar qué usuario tiene más préstamos activos.
 * 
 * @author Raúl Carrera Custodio
 * @version 0.1a
 */

public class Admin extends Usuario {

    private static String emailAdmin = "correoAdmin@admin.com";
    private int idAdmin;
    private static String contraseniaAdmin = "elPatica69";

    public Admin(String nombre, String apellidos, String dni, int idAdmin, int idUsuario, String email) {
        super(nombre, apellidos, dni, idUsuario, emailAdmin, contraseniaAdmin);
        this.idAdmin = idAdmin;
    }

    public String getNombre() {
        return super.getNombre();
    }

    public String getApellidos() {
        return super.getApellido();
    }

    public static String getEmailAdmin() {
        return emailAdmin;
    }

    public String getDni() {
        return super.getDni();
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public static String getContraseniaAdmin() {
        return contraseniaAdmin;
    }

    /**
     * Agrega un nuevo libro al array existente creando uno nuevo sin espacios
     * vacíos.
     * 
     * @param inventarioActual El array actual de libros.
     * @param nuevoLibro       El objeto Libro que se desea añadir.
     * @return Un nuevo array de Libros que incluye el nuevo ejemplar.
     */
    public static Libros[] agregarLibros(Libros[] librosActuales, Libros nuevoLibro) {
        
        // Crear un nuevo array con una posición más
        Libros[] nuevosLibros = new Libros[librosActuales.length + 1];

        // Copiar los libros actuales al nuevo array
        for(int i = 0; i < librosActuales.length; i++) {
            nuevosLibros[i] = librosActuales[i];
        }

        // Insertar el nuevo libro en la última posición
        nuevosLibros[nuevosLibros.length - 1] = nuevoLibro;

        return nuevosLibros;
    }

    /**
     * Elimina un nuevo libro al array existente creando uno nuevo sin espacios
     * vacíos.
     * 
     * @param inventarioActual El array actual de libros.
     * @param nuevoLibro       El objeto Libro que se desea eliminar.
     * @return Un nuevo array de Libros sin el ejemplar eliminado.
     */
    public static Libros[] eliminarLibros(Libros[] librosActuales, Libros libroAEliminar) {
        
        // Crear un nuevo array con una posición menos
        Libros[] nuevosLibros = new Libros[librosActuales.length - 1];
        int j = 0;
        boolean encontrado = false;

        for(int i = 0; i < librosActuales.length; i++) {
            // Si encontramos el libro por ISBN nos lo saltamos
            if(!encontrado && librosActuales[i].getIsbn().equals(libroAEliminar.getIsbn())) {
                encontrado = true;
                continue; 
            }
            // Si no es el libro a borrar y hay espacio copiamos
            if (j < nuevosLibros.length) {
                nuevosLibros[j++] = librosActuales[i];
            }
        }

        // Si no se encontró el libro, devolvemos el original para evitar errores
        if (!encontrado) return librosActuales;

        return nuevosLibros;
    }

    /**
     * Usa método buscarLibro de la superclase Usuario.
     * Se ha corregido la firma para coincidir con la clase padre.
     */
    @Override
    public void buscarLibro(Biblioteca biblioteca, String busqueda) {
        super.buscarLibro(biblioteca, busqueda);
    }

    /** 
     * Muestra todos los libros disponibles.
     * (La clase Usuario no tenía este método implementado, se añade aquí la lógica).
     * @param Libro[] Array de los libros
     */
    public static void mostrarLibros(Libros[] libros) {
        for (Libros libro : libros) {
            if (libro != null) {
                System.out.println("Título: " + libro.getTitulo() + " | Autor: " + libro.getAutor());
            }
        }
    }

    /**
     * Lógica para agregar usuarios
     * @param nombre El nombre del usuario
     * @param apellidos Los apellidos del usuario
     * @param dni El dni del ususario
     * @param contrasenia La contraseña provisional que se le asigna al usuario
     * @param idUsuario El identificador del usuario
     * @param email El email del usuario
     * @param usuariosActuales[] Array con los usuarios actuales
     * 
     */

    public static Usuario[] agregarUsuario (String nombre, String apellidos, String dni, String contrasenia, int idUsuario, String email, Usuario[] usuariosActuales) {

        // El constructor de Usuario pide (nombre, apellido, dni, idUsuario).
        // No acepta email ni contraseña en el constructor actual, se usa el DNI como ID provisional.
        Usuario nuevoUsuario = new Usuario(nombre, apellidos, dni, idUsuario, email, contrasenia);
        
        Usuario[] nuevoArrayUsuarios = new Usuario[usuariosActuales.length + 1];

        for(int i = 0; i < usuariosActuales.length; i++) {
            nuevoArrayUsuarios[i] = usuariosActuales[i];
        }

        nuevoArrayUsuarios[nuevoArrayUsuarios.length - 1] = nuevoUsuario;
        return nuevoArrayUsuarios;
    }

    /**
     * Lógica para recorrer el array con los usuarios y mostrar su información
     * @param nuevoArrayUsuarios[] Array de los usuarios
     */

    public static void mostrarInfoUsuarios(Usuario nuevoArrayUsuarios[]) {

        for(int i = 0; i < nuevoArrayUsuarios.length; i++) {
            
            System.out.println(nuevoArrayUsuarios[i].getNombre() + " " + nuevoArrayUsuarios[i].getApellido());
            System.out.println(nuevoArrayUsuarios[i].getDni());
            System.out.println(nuevoArrayUsuarios[i].getEmail());
        }
    }
}
