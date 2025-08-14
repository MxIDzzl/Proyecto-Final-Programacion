package model;

import objects.Comida;
import java.util.ArrayList;
import java.util.List;

public class ComidaModel {
    private List<Comida> comidas;
    private int contadorID;

    public ComidaModel() {
        comidas = new ArrayList<>();
        contadorID = 1;
    }

    public void agregarComida(String nombre, String tipo, int calorias, double precio) {
        Comida nuevaComida = new Comida(contadorID++, nombre, tipo, calorias, precio);
        comidas.add(nuevaComida);
    }

    public void eliminarComida(int id) {
        comidas.removeIf(comida -> comida.getId() == id);
    }

    public void actualizarComida(int id, String nombre, String tipo, int calorias, double precio) {
        for (Comida c : comidas) {
            if (c.getId() == id) {
                c.setNombre(nombre);
                c.setTipo(tipo);
                c.setCalorias(calorias);
                c.setPrecio(precio);
                break;
            }
        }
    }

    public List<Comida> getComidas() {
        return comidas;
    }
}