package controller;

import model.ClienteModel;
import UI.ClientesView;
import objects.Cliente;

import javax.swing.*;

public class ClientesController {
    private ClienteModel modelo;
    private ClientesView vista;
    private RouteController router;

    public ClientesController(ClienteModel modelo, ClientesView vista, RouteController router) {
        this.modelo = modelo;
        this.vista = vista;
        this.router = router;

        configurarListeners();
        actualizarTabla();
    }

    private void configurarListeners() {
        vista.btnRegistrar.addActionListener(e -> registrarCliente());
        vista.btnEliminar.addActionListener(e -> eliminarCliente());
        vista.btnActualizar.addActionListener(e -> actualizarCliente());
        vista.setRegresarListener(e -> { router.mostrarMenu();
        });
    }

    private void registrarCliente() {
        String nombre = vista.nombreField.getText().trim();
        String telefono = vista.telefonoField.getText().trim();
        String email = vista.emailField.getText().trim();

        if (nombre.isEmpty() || telefono.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        modelo.agregarCliente(nombre, telefono, email);
        actualizarTabla();
        limpiarCampos();
    }

    private void eliminarCliente() {
        try {
            int id = Integer.parseInt(vista.idField.getText());

            if (id <= 0) {
                JOptionPane.showMessageDialog(vista, "ID inválido", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int confirmacion = JOptionPane.showConfirmDialog(vista,
                    "¿Estás seguro de eliminar este cliente?", "Confirmar",
                    JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                modelo.eliminarCliente(id);
                actualizarTabla();
                limpiarCampos();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "ID inválido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarCliente() {
        try {
            int id = Integer.parseInt(vista.idField.getText());
            String nombre = vista.nombreField.getText().trim();
            String telefono = vista.telefonoField.getText().trim();
            String email = vista.emailField.getText().trim();

            if (id <= 0) {
                JOptionPane.showMessageDialog(vista, "ID inválido", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (nombre.isEmpty() || telefono.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            modelo.actualizarCliente(id, nombre, telefono, email);
            actualizarTabla();
            limpiarCampos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "ID inválido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarTabla() {
        vista.modeloTabla.setRowCount(0);
        for (Cliente c : modelo.getClientes()) {
            vista.modeloTabla.addRow(new Object[]{
                    c.getId(),
                    c.getNombre(),
                    c.getTelefono(),
                    c.getEmail()
            });
        }
    }

    private void limpiarCampos() {
        vista.idField.setText("");
        vista.nombreField.setText("");
        vista.telefonoField.setText("");
        vista.emailField.setText("");
    }

}