package actividad14;


// Clase que representa un libro (Nivel 2)
public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private String categoria;
    private int paginas;

    // Constructor
    public Libro(String isbn, String titulo, String autor, String categoria, int paginas) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.paginas = paginas;
    }

    // Métodos getter
    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getCategoria() { return categoria; }
    public int getPaginas() { return paginas; }
}


