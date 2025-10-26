package actividad14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static actividad14.Exportador.*;

// Clase que gestiona la aplicación completa con menús
public class AplicacionMenu {

    private final Scanner sc = new Scanner(System.in);

    // Listas de datos
    private final List<Estudiante> estudiantes = new ArrayList<>();
    private final List<Libro> libros = new ArrayList<>();
    private final List<Habitacion> habitaciones = new ArrayList<>();
    private final List<Restaurante> restaurantes = new ArrayList<>();

    // Método principal del menú
    public void iniciar() {
        int opcion;
        do {
            System.out.println("\n=== PROYECTO FINAL: EXPORTACIÓN DE DATOS ===");
            System.out.println("1. Gestionar Estudiantes");
            System.out.println("2. Gestionar Libros");
            System.out.println("3. Gestionar Habitaciones");
            System.out.println("4. Gestionar Restaurantes");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leerEntero();

            switch (opcion) {
                case 1 -> menuEstudiantes();
                case 2 -> menuLibros();
                case 3 -> menuHabitaciones();
                case 4 -> menuRestaurante();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    // ---------------------- MENÚ ESTUDIANTES ----------------------
    private void menuEstudiantes() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Estudiantes ---");
            System.out.println("1. Añadir estudiante");
            System.out.println("2. Listar estudiantes");
            System.out.println("3. Exportar estudiantes");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = leerEntero();

            switch (opcion) {
                case 1 -> anadirEstudiante();
                case 2 -> listarEstudiantes();
                case 3 -> exportarEstudiantes();
                case 0 -> {}
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void anadirEstudiante() {
        System.out.println("Introduzca los datos del estudiante:");
        System.out.print("ID: ");
        int id = leerEntero();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = sc.nextLine();
        System.out.print("Edad: ");
        int edad = leerEntero();
        System.out.print("Nota: ");
        double nota = leerDouble();

        estudiantes.add(new Estudiante(id, nombre, apellidos, edad, nota));
        System.out.println("Estudiante añadido correctamente.");
    }

    private void listarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        System.out.println("\nListado de Estudiantes:");
        for (Estudiante e : estudiantes) {
            System.out.println(e.getId() + " - " + e.getNombre() + " " + e.getApellidos() +
                    " | Edad: " + e.getEdad() + " | Nota: " + e.getNota());
        }
    }

    private void exportarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes para exportar.");
            return;
        }
        System.out.println("Seleccione formato de exportación:");
        System.out.println("1. CSV");
        System.out.println("2. XML");
        System.out.println("3. JSON");
        int formato = leerEntero();

        switch (formato) {
            case 1 -> Exportador.exportarEstudiantesCSV(estudiantes, "estudiantes.csv");
            case 2 -> Exportador.exportarEstudiantesXML(estudiantes, "estudiantes.xml");
            case 3 -> Exportador.exportarEstudiantesJSON(estudiantes, "estudiantes.json");
            default -> System.out.println("Formato no válido.");
        }
    }

    // ---------------------- MENÚ LIBROS ----------------------
    private void menuLibros() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Libros ---");
            System.out.println("1. Añadir libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Exportar libros");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = leerEntero();

            switch (opcion) {
                case 1 -> anadirLibro();
                case 2 -> listarLibros();
                case 3 -> exportarLibros();
                case 0 -> {}
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void anadirLibro() {
        System.out.println("Introduzca los datos del libro:");
        System.out.print("ISBN: ");
        String isbn = sc.nextLine();
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        System.out.print("Categoría: ");
        String categoria = sc.nextLine();
        System.out.print("Número de páginas: ");
        int paginas = leerEntero();

        libros.add(new Libro(isbn, titulo, autor, categoria, paginas));
        System.out.println("Libro añadido correctamente.");
    }

    private void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }
        System.out.println("\nListado de Libros:");
        for (Libro l : libros) {
            System.out.println(l.getIsbn() + " - " + l.getTitulo() + " (" + l.getAutor() +
                    ") | " + l.getCategoria() + " | Páginas: " + l.getPaginas());
        }
    }

    private void exportarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros para exportar.");
            return;
        }
        System.out.println("Seleccione formato de exportación:");
        System.out.println("1. CSV");
        System.out.println("2. XML");
        System.out.println("3. JSON");
        int formato = leerEntero();

        switch (formato) {
            case 1 -> Exportador.exportarLibrosCSV(libros, "libros.csv");
            case 2 -> Exportador.exportarLibrosXML(libros, "libros.xml");
            case 3 -> Exportador.exportarLibrosJSON(libros, "libros.json");
            default -> System.out.println("Formato no válido.");
        }
    }

    // ---------------------- MENÚ HABITACIONES ----------------------
    private void menuHabitaciones() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Habitaciones ---");
            System.out.println("1. Añadir habitación");
            System.out.println("2. Listar habitaciones");
            System.out.println("3. Exportar habitaciones");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = leerEntero();

            switch (opcion) {
                case 1 -> anadirHabitacion();
                case 2 -> listarHabitaciones();
                case 3 -> exportarHabitaciones();
                case 0 -> {}
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void anadirHabitacion() {
        System.out.println("Introduzca los datos de la habitación:");
        System.out.print("Número: ");
        int numero = leerEntero();
        System.out.print("Tipo (Simple/Doble/Suite): ");
        String tipo = sc.nextLine();
        System.out.print("¿Está ocupada? (true/false): ");
        boolean ocupada = Boolean.parseBoolean(sc.nextLine());
        System.out.print("Precio por noche: ");
        double precio = leerDouble();

        habitaciones.add(new Habitacion(numero, tipo, ocupada, precio));
        System.out.println("Habitación añadida correctamente.");
    }

    private void listarHabitaciones() {
        if (habitaciones.isEmpty()) {
            System.out.println("No hay habitaciones registradas.");
            return;
        }
        System.out.println("\nListado de Habitaciones:");
        for (Habitacion h : habitaciones) {
            System.out.println("Nº " + h.getNumero() + " | " + h.getTipo() +
                    " | Ocupada: " + (h.isOcupada() ? "Sí" : "No") +
                    " | Precio: " + h.getPrecioPorNoche() + " €");
        }
    }

    private void exportarHabitaciones() {
        if (habitaciones.isEmpty()) {
            System.out.println("No hay habitaciones para exportar.");
            return;
        }
        int opcion;
        do {
            System.out.println("\n--- Exportar Habitaciones ---");
            System.out.println("1. Exportar CSV");
            System.out.println("2. Exportar XML");
            System.out.println("3. Exportar JSON");
            System.out.println("4. Exportar filtradas por estado o cliente");
            System.out.println("5. Comprimir múltiples exportaciones en ZIP");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = leerEntero();

            switch (opcion) {
                case 1 -> exportarHabitacionesCSV(habitaciones, "habitaciones.csv");
                case 2 -> exportarHabitacionesXML(habitaciones, "habitaciones.xml");
                case 3 -> exportarHabitacionesJSON(habitaciones, "habitaciones.json");
                case 4 -> exportarFiltradas();
                case 5 -> exportarMultiplesZip();
                case 0 -> {}
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void exportarMultiplesZip() {
        System.out.println("Exportando habitaciones en múltiples formatos y comprimiendo en ZIP...");

        String csvPath = "habitaciones.csv";
        String xmlPath = "habitaciones.xml";
        String jsonPath = "habitaciones.json";
        String zipPath = "habitaciones_comprimidas.zip";

        exportarHabitacionesCSV(habitaciones, csvPath);
        exportarHabitacionesXML(habitaciones, xmlPath);
        exportarHabitacionesJSON(habitaciones, jsonPath);

        List<String> archivosAComprimir = new ArrayList<>();
        archivosAComprimir.add(csvPath);
        archivosAComprimir.add(xmlPath);
        archivosAComprimir.add(jsonPath);

        Exportador.comprimirEnZip(archivosAComprimir, zipPath);
        System.out.println("Exportación y compresión completadas. Archivo ZIP: " + zipPath);



    }


    private void exportarFiltradas() {
        System.out.println("Seleccione filtro:");
        System.out.println("1. Por estado (ocupada/libre)");
        System.out.println("2. Por cliente (nombre)");
        int filtro = leerEntero();

        List<Habitacion> filtradas = new ArrayList<>();
        switch (filtro) {
            case 1 -> {
                System.out.print("¿Desea habitaciones ocupadas? (true/false): ");
                boolean ocupada = Boolean.parseBoolean(sc.nextLine());
                for (Habitacion h : habitaciones) {
                    if (h.isOcupada() == ocupada) {
                        filtradas.add(h);
                    }
                }
            }
            case 2 -> {
                System.out.print("Introduzca el nombre del cliente: ");
                String cliente = sc.nextLine().toLowerCase();
                // Suponiendo que hay un método para obtener el cliente asociado a la habitación
                for (Habitacion h : habitaciones) {
                    // if (h.getCliente().toLowerCase().contains(cliente)) {
                    //     filtradas.add(h);
                    // }
                }
            }
            default -> {
                System.out.println("Filtro no válido.");
                return;
            }
        }

        if (filtradas.isEmpty()) {
            System.out.println("No hay habitaciones que coincidan con el filtro.");
            return;
        }

        System.out.println("Seleccione formato de exportación:");
        System.out.println("1. CSV");
        System.out.println("2. XML");
        System.out.println("3. JSON");
        int formato = leerEntero();

        switch (formato) {
            case 1 -> exportarHabitacionesCSV(filtradas, "habitaciones_filtradas.csv");
            case 2 -> exportarHabitacionesXML(filtradas, "habitaciones_filtradas.xml");
            case 3 -> exportarHabitacionesJSON(filtradas, "habitaciones_filtradas.json");
            default -> System.out.println("Formato no válido.");
        }
    }

    // ---------------------- UTILIDADES ----------------------
    private int leerEntero() {
        while (true) {
            try {
                int valor = Integer.parseInt(sc.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.print("Número inválido. Intente de nuevo: ");
            }
        }
    }

    private double leerDouble() {
        while (true) {
            try {
                double valor = Double.parseDouble(sc.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.print("Número inválido. Intente de nuevo: ");
            }
        }
    }
    //Menu Restaurante
    private void menuRestaurante() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Restaurantes ---");
            System.out.println("1. Añadir restaurante");
            System.out.println("2. Listar restaurantes");
            System.out.println("3. Exportar restaurantes");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = leerEntero();

            switch (opcion) {
                case 1 -> anadirRestaurante();
                case 2 -> listarRestaurantes();
                case 3 -> exportarRestaurantes();
                case 0 -> {}
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

    }

    private void exportarRestaurantes() {
        if (restaurantes.isEmpty()) {
            System.out.println("No hay restaurantes para exportar.");
            return;
        }
        System.out.println("Seleccione formato de exportación:");
        System.out.println("1. CSV");
        System.out.println("2. XML");
        System.out.println("3. JSON");
        int formato = leerEntero();

        switch (formato) {
            case 1 -> Exportador.exportarRestaurantesCSV(restaurantes, "restaurantes.csv");
            case 2 -> Exportador.exportarRestaurantesXML(restaurantes, "restaurantes.xml");
            case 3 -> Exportador.exportarRestaurantesJSON(restaurantes, "restaurantes.json");
            default -> System.out.println("Formato no válido.");
        }

    }

    private void listarRestaurantes() {
        if (restaurantes.isEmpty()) {
            System.out.println("No hay restaurantes registrados.");
            return;
        }
        System.out.println("\nListado de Restaurantes:");
        for (Restaurante r : restaurantes) {
            System.out.println(r.getId() + " - " + r.getNombre() + " | " + r.getTipoCocina() +
                    " | Calificación: " + r.getCalificacion() + " | Dirección: " + r.getDireccion());
        }
    }

    private void anadirRestaurante() {
        System.out.println("Introduzca los datos del restaurante:");
        System.out.print("ID: ");
        int id = leerEntero();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Tipo de cocina: ");
        String tipoCocina = sc.nextLine();
        System.out.print("Calificación: ");
        double calificacion = leerDouble();
        System.out.print("Dirección: ");
        String direccion = sc.nextLine();

        restaurantes.add(new Restaurante(id, nombre, tipoCocina, calificacion, direccion));
        System.out.println("Restaurante añadido correctamente.");
    }
}

