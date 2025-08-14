package objects;

public class Evento {
    private int id;
    private String fecha;
    private String nombreEvento;
    private String descripcion;

    public Evento(int id, String fecha, String nombreEvento, String descripcion) {
        this.id = id;
        this.fecha = fecha;
        this.nombreEvento = nombreEvento;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public String getNombreEvento() { return nombreEvento; }
    public void setNombreEvento(String nombreEvento) { this.nombreEvento = nombreEvento; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}