package actividad14;


// Clase que representa una habitación (Nivel 3)
public class Habitacion {
    private int numero;
    private String tipo;
    private boolean ocupada;
    private double precioPorNoche;

    // Constructor
    public Habitacion(int numero, String tipo, boolean ocupada, double precioPorNoche) {
        this.numero = numero;
        this.tipo = tipo;
        this.ocupada = ocupada;
        this.precioPorNoche = precioPorNoche;
    }

    // Métodos getter
    public int getNumero() { return numero; }
    public String getTipo() { return tipo; }
    public boolean isOcupada() { return ocupada; }
    public double getPrecioPorNoche() { return precioPorNoche; }
}


