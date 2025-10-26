package actividad14;

public class Restaurante {
    private int id;
    private String nombre;
    private String tipoCocina;
    private double calificacion;
    private String direccion;

    // Constructor
    public Restaurante(int id, String nombre, String tipoCocina, double calificacion, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.tipoCocina = tipoCocina;
        this.calificacion = calificacion;
        this.direccion = direccion;
    }

    // Métodos getter
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTipoCocina() { return tipoCocina; }
    public double getCalificacion() { return calificacion; }
    public String getDireccion() { return direccion; }
}
