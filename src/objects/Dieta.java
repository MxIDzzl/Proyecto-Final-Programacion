package objects;

public class Dieta {
    private int id;
    private String nombre;
    private String descripcion;
    private int calorias;

    public Dieta(int id, String nombre, String descripcion, int calorias) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.calorias = calorias;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public int getCalorias() { return calorias; }
    public void setCalorias(int calorias) { this.calorias = calorias; }
}