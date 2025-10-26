package actividad14;

// Clase que representa a un estudiante (Nivel 1)
public class Estudiante {
    private int id;
    private String nombre;
    private String apellidos;
    private int edad;
    private double nota;

    // Constructor
    public Estudiante(int id, String nombre, String apellidos, int edad, double nota) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.nota = nota;
    }

    // Métodos getter
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellidos() { return apellidos; }
    public int getEdad() { return edad; }
    public double getNota() { return nota; }
}


