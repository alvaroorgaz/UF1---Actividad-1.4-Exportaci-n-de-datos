package actividad14;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

// Clase que contiene todos los métodos de exportación para los tres niveles
public class Exportador {

    // ----------------------------------------------------------
    // MÉTODOS AUXILIARES
    // ----------------------------------------------------------

    // Escapa caracteres especiales para evitar errores en XML
    private static String escapar(String texto) {
        if (texto == null) return "";
        return texto.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&apos;");
    }

    // ----------------------------------------------------------
    // NIVEL 1: EXPORTAR ESTUDIANTES
    // ----------------------------------------------------------

    // Exporta lista de estudiantes a CSV
    public static void exportarEstudiantesCSV(List<Estudiante> lista, String ruta) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            bw.write("ID;Nombre;Apellidos;Edad;Nota");
            bw.newLine();

            double suma = 0;
            for (Estudiante e : lista) {
                bw.write(e.getId() + ";" + e.getNombre() + ";" + e.getApellidos() + ";" +
                        e.getEdad() + ";" + e.getNota());
                bw.newLine();
                suma += e.getNota();
            }

            // Añade línea resumen con la nota media
            bw.write("# Nota media;" + (suma / lista.size()));
            System.out.println("CSV estudiantes exportado: " + ruta);
        } catch (IOException e) {
            System.out.println("Error CSV estudiantes: " + e.getMessage());
        }
    }

    // Exporta lista de estudiantes a XML
    public static void exportarEstudiantesXML(List<Estudiante> lista, String ruta) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            bw.write("<clase fecha=\"" + LocalDate.now() + "\">\n");

            double suma = 0, max = 0, min = 10;

            for (Estudiante e : lista) {
                bw.write("  <estudiante id=\"" + e.getId() + "\">\n");
                bw.write("    <nombre>" + escapar(e.getNombre()) + "</nombre>\n");
                bw.write("    <apellidos>" + escapar(e.getApellidos()) + "</apellidos>\n");
                bw.write("    <edad>" + e.getEdad() + "</edad>\n");
                bw.write("    <nota>" + e.getNota() + "</nota>\n");
                bw.write("  </estudiante>\n");

                suma += e.getNota();
                max = Math.max(max, e.getNota());
                min = Math.min(min, e.getNota());
            }

            double media = suma / lista.size();
            bw.write("  <resumen media=\"" + media + "\" max=\"" + max + "\" min=\"" + min + "\"/>\n");
            bw.write("</clase>");
            System.out.println("XML estudiantes exportado: " + ruta);
        } catch (IOException e) {
            System.out.println("Error XML estudiantes: " + e.getMessage());
        }
    }

    // Exporta lista de estudiantes a JSON
    public static void exportarEstudiantesJSON(List<Estudiante> lista, String ruta) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            double suma = 0, max = 0, min = 10;

            bw.write("{\n  \"estudiantes\": [\n");
            for (int i = 0; i < lista.size(); i++) {
                Estudiante e = lista.get(i);
                bw.write("    {\"id\": " + e.getId() + ", \"nombre\": \"" + e.getNombre() + "\", " +
                        "\"apellidos\": \"" + e.getApellidos() + "\", \"edad\": " + e.getEdad() +
                        ", \"nota\": " + e.getNota() + "}");
                if (i < lista.size() - 1) bw.write(",");
                bw.newLine();

                suma += e.getNota();
                max = Math.max(max, e.getNota());
                min = Math.min(min, e.getNota());
            }

            double media = suma / lista.size();
            bw.write("  ],\n  \"resumen\": {\"media\": " + media + ", \"max\": " + max + ", \"min\": " + min + "}\n}");
            System.out.println("JSON estudiantes exportado: " + ruta);
        } catch (IOException e) {
            System.out.println("Error JSON estudiantes: " + e.getMessage());
        }
    }

    // ----------------------------------------------------------
    // NIVEL 2: EXPORTAR LIBROS
    // ----------------------------------------------------------

    // Exporta lista de libros a CSV
    public static void exportarLibrosCSV(List<Libro> lista, String ruta) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            bw.write("ISBN;Título;Autor;Categoría;Páginas");
            bw.newLine();

            int total = 0;
            for (Libro l : lista) {
                bw.write(l.getIsbn() + ";" + l.getTitulo() + ";" + l.getAutor() + ";" +
                        l.getCategoria() + ";" + l.getPaginas());
                bw.newLine();
                total += l.getPaginas();
            }

            // Línea resumen con total de páginas
            bw.write("# Páginas totales;" + total);
            System.out.println("CSV libros exportado: " + ruta);
        } catch (IOException e) {
            System.out.println("Error CSV libros: " + e.getMessage());
        }
    }

    // Exporta lista de libros a XML
    public static void exportarLibrosXML(List<Libro> lista, String ruta) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            bw.write("<biblioteca fecha=\"" + LocalDate.now() + "\">\n");

            int totalPaginas = 0;

            for (Libro l : lista) {
                bw.write("  <libro isbn=\"" + escapar(l.getIsbn()) + "\">\n");
                bw.write("    <titulo>" + escapar(l.getTitulo()) + "</titulo>\n");
                bw.write("    <autor>" + escapar(l.getAutor()) + "</autor>\n");
                bw.write("    <categoria>" + escapar(l.getCategoria()) + "</categoria>\n");
                bw.write("    <paginas>" + l.getPaginas() + "</paginas>\n");
                bw.write("  </libro>\n");
                totalPaginas += l.getPaginas();
            }

            bw.write("  <resumen totalPaginas=\"" + totalPaginas + "\" totalLibros=\"" + lista.size() + "\"/>\n");
            bw.write("</biblioteca>");
            System.out.println("XML libros exportado: " + ruta);
        } catch (IOException e) {
            System.out.println("Error XML libros: " + e.getMessage());
        }
    }

    // Exporta lista de libros a JSON
    public static void exportarLibrosJSON(List<Libro> lista, String ruta) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            int totalPaginas = 0;

            bw.write("{\n  \"libros\": [\n");
            for (int i = 0; i < lista.size(); i++) {
                Libro l = lista.get(i);
                bw.write("    {\"isbn\": \"" + l.getIsbn() + "\", \"titulo\": \"" + l.getTitulo() + "\", " +
                        "\"autor\": \"" + l.getAutor() + "\", \"categoria\": \"" + l.getCategoria() + "\", " +
                        "\"paginas\": " + l.getPaginas() + "}");
                if (i < lista.size() - 1) bw.write(",");
                bw.newLine();
                totalPaginas += l.getPaginas();
            }

            bw.write("  ],\n  \"resumen\": {\"totalLibros\": " + lista.size() + ", \"totalPaginas\": " + totalPaginas + "}\n}");
            System.out.println("JSON libros exportado: " + ruta);
        } catch (IOException e) {
            System.out.println("Error JSON libros: " + e.getMessage());
        }
    }

    // ----------------------------------------------------------
    // NIVEL 3: EXPORTAR HABITACIONES
    // ----------------------------------------------------------

    // Exporta lista de habitaciones a CSV
    public static void exportarHabitacionesCSV(List<Habitacion> lista, String ruta) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            bw.write("Número;Tipo;Ocupada;Precio/noche");
            bw.newLine();

            int ocupadas = 0;
            double total = 0;

            for (Habitacion h : lista) {
                bw.write(h.getNumero() + ";" + h.getTipo() + ";" +
                        (h.isOcupada() ? "Sí" : "No") + ";" + h.getPrecioPorNoche());
                bw.newLine();
                if (h.isOcupada()) ocupadas++;
                total += h.getPrecioPorNoche();
            }

            // Línea resumen
            double media = total / lista.size();
            bw.write("# Ocupadas;" + ocupadas + ";Precio medio;" + media);
            System.out.println("CSV habitaciones exportado: " + ruta);
        } catch (IOException e) {
            System.out.println("Error CSV habitaciones: " + e.getMessage());
        }
    }

    // Exporta lista de habitaciones a XML
    public static void exportarHabitacionesXML(List<Habitacion> lista, String ruta) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            bw.write("<hotel fecha=\"" + LocalDate.now() + "\">\n");

            int ocupadas = 0;
            double total = 0;

            for (Habitacion h : lista) {
                bw.write("  <habitacion numero=\"" + h.getNumero() + "\">\n");
                bw.write("    <tipo>" + escapar(h.getTipo()) + "</tipo>\n");
                bw.write("    <ocupada>" + (h.isOcupada() ? "true" : "false") + "</ocupada>\n");
                bw.write("    <precioPorNoche>" + h.getPrecioPorNoche() + "</precioPorNoche>\n");
                bw.write("  </habitacion>\n");

                if (h.isOcupada()) ocupadas++;
                total += h.getPrecioPorNoche();
            }

            double media = total / lista.size();
            bw.write("  <resumen ocupadas=\"" + ocupadas + "\" precioMedio=\"" + media + "\"/>\n");
            bw.write("</hotel>");
            System.out.println("XML habitaciones exportado: " + ruta);
        } catch (IOException e) {
            System.out.println("Error XML habitaciones: " + e.getMessage());
        }
    }

    // Exporta lista de habitaciones a JSON
    public static void exportarHabitacionesJSON(List<Habitacion> lista, String ruta) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            int ocupadas = 0;
            double total = 0;

            bw.write("{\n  \"habitaciones\": [\n");
            for (int i = 0; i < lista.size(); i++) {
                Habitacion h = lista.get(i);
                bw.write("    {\"numero\": " + h.getNumero() + ", \"tipo\": \"" + h.getTipo() + "\", " +
                        "\"ocupada\": " + h.isOcupada() + ", \"precioPorNoche\": " + h.getPrecioPorNoche() + "}");
                if (i < lista.size() - 1) bw.write(",");
                bw.newLine();

                if (h.isOcupada()) ocupadas++;
                total += h.getPrecioPorNoche();
            }

            double media = total / lista.size();
            bw.write("  ],\n  \"resumen\": {\"ocupadas\": " + ocupadas + ", \"precioMedio\": " + media + "}\n}");
            System.out.println("JSON habitaciones exportado: " + ruta);
        } catch (IOException e) {
            System.out.println("Error JSON habitaciones: " + e.getMessage());
        }
    }
    //Exportador restaurante
    // Exporta lista de restaurantes a CSV
    public static void exportarRestaurantesCSV(List<Restaurante> lista, String ruta) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            bw.write("ID;Nombre;Tipo Cocina;Calificación;Dirección");
            bw.newLine();

            double totalCalificacion = 0;

            for (Restaurante r : lista) {
                bw.write(r.getId() + ";" + r.getNombre() + ";" + r.getTipoCocina() + ";" +
                        r.getCalificacion() + ";" + r.getDireccion());
                bw.newLine();
                totalCalificacion += r.getCalificacion();
            }

            // Línea resumen
            double media = totalCalificacion / lista.size();
            bw.write("# Total restaurantes;" + lista.size() + ";Calificación media;" + media);
            System.out.println("CSV restaurantes exportado: " + ruta);
        } catch (IOException e) {
            System.out.println("Error CSV restaurantes: " + e.getMessage());
        }
    }

    // Exporta lista de restaurantes a XML
    public static void exportarRestaurantesXML(List<Restaurante> lista, String ruta) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            bw.write("<restaurantes fecha=\"" + LocalDate.now() + "\">\n");

            double totalCalificacion = 0;

            for (Restaurante r : lista) {
                bw.write("  <restaurante id=\"" + r.getId() + "\">\n");
                bw.write("    <nombre>" + escapar(r.getNombre()) + "</nombre>\n");
                bw.write("    <tipoCocina>" + escapar(r.getTipoCocina()) + "</tipoCocina>\n");
                bw.write("    <calificacion>" + r.getCalificacion() + "</calificacion>\n");
                bw.write("    <direccion>" + escapar(r.getDireccion()) + "</direccion>\n");
                bw.write("  </restaurante>\n");

                totalCalificacion += r.getCalificacion();
            }

            double media = totalCalificacion / lista.size();
            bw.write("  <resumen total=\"" + lista.size() + "\" calificacionMedia=\"" + media + "\"/>\n");
            bw.write("</restaurantes>");
            System.out.println("XML restaurantes exportado: " + ruta);
        } catch (IOException e) {
            System.out.println("Error XML restaurantes: " + e.getMessage());
        }
    }

    // Exporta lista de restaurantes a JSON
    public static void exportarRestaurantesJSON(List<Restaurante> lista, String ruta) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            double totalCalificacion = 0;

            bw.write("{\n  \"restaurantes\": [\n");
            for (int i = 0; i < lista.size(); i++) {
                Restaurante r = lista.get(i);
                bw.write("    {\"id\": " + r.getId() + ", \"nombre\": \"" + r.getNombre() + "\", " +
                        "\"tipoCocina\": \"" + r.getTipoCocina() + "\", " +
                        "\"calificacion\": " + r.getCalificacion() + ", " +
                        "\"direccion\": \"" + r.getDireccion() + "\"}");
                if (i < lista.size() - 1) bw.write(",");
                bw.newLine();

                totalCalificacion += r.getCalificacion();
            }

            double media = totalCalificacion / lista.size();
            bw.write("  ],\n  \"resumen\": {\"total\": " + lista.size() + ", \"calificacionMedia\": " + media + "}\n}");
            System.out.println("JSON restaurantes exportado: " + ruta);
        } catch (IOException e) {
            System.out.println("Error JSON restaurantes: " + e.getMessage());
        }
    }

    public static void comprimirEnZip(List<String> archivosAComprimir, String zipPath) {
        try (java.util.zip.ZipOutputStream zipOut = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(zipPath))) {
            for (String archivo : archivosAComprimir) {
                java.io.File fileToZip = new java.io.File(archivo);
                try (java.io.FileInputStream fis = new java.io.FileInputStream(fileToZip)) {
                    java.util.zip.ZipEntry zipEntry = new java.util.zip.ZipEntry(fileToZip.getName());
                    zipOut.putNextEntry(zipEntry);

                    byte[] bytes = new byte[1024];
                    int length;
                    while ((length = fis.read(bytes)) >= 0) {
                        zipOut.write(bytes, 0, length);
                    }
                }
            }
            System.out.println("Archivos comprimidos en: " + zipPath);
        } catch (IOException e) {
            System.out.println("Error al comprimir archivos: " + e.getMessage());
        }
    }
}
