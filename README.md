# BibliotecaCoop

Sistema de gestión para una biblioteca cooperativa desarrollado en Java. Este proyecto permite la administración integral de libros, usuarios y préstamos.

## 📋 Características

El sistema está diseñado para cubrir las necesidades de administración de una biblioteca, dividiéndose en los siguientes módulos:

### 1. Gestión de Libros
*   Agregar nuevos libros al catálogo.
*   Eliminar libros existentes.
*   Buscar libros por título, autor o categoría.
*   Listar todos los libros disponibles.
*   **Categorización extensa:** Soporte para una amplia variedad de géneros definidos en `GeneroLib` (Narrativa, Ciencia, Ingeniería, Manga, etc.).

### 2. Gestión de Usuarios
*   Registro de nuevos usuarios (Socios).
*   Consulta de información de usuarios registrados.

### 3. Gestión de Préstamos
*   Realizar préstamos de libros.
*   Devolución de libros prestados.
*   Visualización de libros actualmente prestados.

### 4. Estadísticas y Reportes
*   Visualización del número de préstamos totales y activos.
*   Listado de los libros más prestados.
*   Identificación de usuarios con mayor actividad de préstamos.

## 🛠️ Estructura del Proyecto

El código fuente se encuentra en el paquete `com.biblioteca` y consta de las siguientes clases principales:

*   **Admin**: Clase principal que gestiona la lógica de administración y permisos.
*   **Usuario**: Representa a los clientes/lectores de la biblioteca con sus datos personales.
*   **Libros**: Define el modelo de datos de un libro (Título, Autor, ISBN, Género).
*   **GeneroLib**: Enumerado (`enum`) que contiene el catálogo completo de géneros literarios y categorías académicas.

## 👤 Autores

*   **Raúl** - *Gestión de Libros y Administración*
*   **Manuel Enrique Vargas Béjar** - *Funciones de Usuarios*
