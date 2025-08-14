package model;

import objects.Dieta;
import java.util.ArrayList;
import java.util.List;

public class DietaModel {
    private List<Dieta> dietas;
    private int contadorID;

    public DietaModel() {
        dietas = new ArrayList<>();
        contadorID = 1;
    }

    public void agregarDieta(String nombre, String descripcion, int calorias) {
        Dieta nuevaDieta = new Dieta(contadorID++, nombre, descripcion, calorias);
        dietas.add(nuevaDieta);
    }

    public void eliminarDieta(int id) {
        dietas.removeIf(dieta -> dieta.getId() == id);
    }

    public void actualizarDieta(int id, String nombre, String descripcion, int calorias) {
        for (Dieta d : dietas) {
            if (d.getId() == id) {
                d.setNombre(nombre);
                d.setDescripcion(descripcion);
                d.setCalorias(calorias);
                break;
            }
        }
    }

    public List<Dieta> getDietas() {
        return dietas;
    }
}