package objects;

public class Comida {
    private int id;
    private String nombre;
    private String tipo;
    private int calorias;
    private double precio;

    public Comida(int id, String nombre, String tipo, int calorias, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.calorias = calorias;
        this.precio = precio;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public int getCalorias() { return calorias; }
    public void setCalorias(int calorias) { this.calorias = calorias; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
}