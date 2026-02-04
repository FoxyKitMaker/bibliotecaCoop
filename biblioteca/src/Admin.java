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
 * @author Raúl
 * @version 0.1a
 */

public class Admin {

    private String nombre;
    private String apellidos;
    private String dni;
    private static String email = "correoAdmin@admin.com";
    private int idAdmin;

    public Admin(String nombre, String apellidos, String dni, String email, int idAdmin) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.email = email;
        this.idAdmin = idAdmin;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public static String getEmail() {
        return email;
    }

    public String getDni() {
        return dni;
    }

    public int getIdAdmin() {
        return idAdmin;
    }
    
}
