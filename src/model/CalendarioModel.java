package model;

import objects.Evento;
import java.util.ArrayList;
import java.util.List;

public class CalendarioModel {
    private List<Evento> eventos;
    private int contadorID;

    public CalendarioModel() {
        eventos = new ArrayList<>();
        contadorID = 1;
    }

    public void agregarEvento(String fecha, String nombreEvento, String descripcion) {
        Evento nuevoEvento = new Evento(contadorID++, fecha, nombreEvento, descripcion);
        eventos.add(nuevoEvento);
    }

    public void eliminarEvento(int id) {
        eventos.removeIf(evento -> evento.getId() == id);
    }

    public void actualizarEvento(int id, String fecha, String nombreEvento, String descripcion) {
        for (Evento e : eventos) {
            if (e.getId() == id) {
                e.setFecha(fecha);
                e.setNombreEvento(nombreEvento);
                e.setDescripcion(descripcion);
                break;
            }
        }
    }

    public List<Evento> getEventos() {
        return eventos;
    }
}