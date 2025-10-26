package actividad14;

public class Cliente {
    private int id;
    private String nombre;
    private String email;
    private String telefono;


    // Constructor
    public Cliente(int id, String nombre, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;

    }

    // Métodos getter
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }
}
