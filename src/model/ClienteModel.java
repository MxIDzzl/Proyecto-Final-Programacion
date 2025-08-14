package model;

import objects.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteModel {
    private List<Cliente> clientes;
    private int contadorID;

    public ClienteModel() {
        clientes = new ArrayList<>();
        contadorID = 1;
    }

    public void agregarCliente(String nombre, String telefono, String email) {
        Cliente nuevoCliente = new Cliente(contadorID++, nombre, telefono, email);
        clientes.add(nuevoCliente);
    }

    public void eliminarCliente(int id) {
        clientes.removeIf(cliente -> cliente.getId() == id);
    }

    public void actualizarCliente(int id, String nombre, String telefono, String email) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                c.setNombre(nombre);
                c.setTelefono(telefono);
                c.setEmail(email);
                break;
            }
        }
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}