package controller;

import model.ComidaModel;
import UI.ComidaView;
import objects.Comida;
import javax.swing.*;

public class ComidaController {
    private ComidaModel modelo;
    private ComidaView vista;
    private RouteController router;

    public ComidaController(ComidaModel modelo, ComidaView vista, RouteController router) {
        this.modelo = modelo;
        this.vista = vista;
        this.router = router;
        configurarListeners();
        actualizarTabla();
    }

    private void configurarListeners() {
        vista.btnAgregar.addActionListener(e -> agregarComida());
        vista.btnEliminar.addActionListener(e -> eliminarComida());
        vista.btnActualizar.addActionListener(e -> actualizarComida());
    }

    private void agregarComida() {
        String nombre = vista.nombreField.getText().trim();
        String tipo = vista.tipoField.getText().trim();
        String caloriasStr = vista.caloriasField.getText().trim();
        String precioStr = vista.precioField.getText().trim();

        if (nombre.isEmpty() || tipo.isEmpty() || caloriasStr.isEmpty() || precioStr.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int calorias = Integer.parseInt(caloriasStr);
            double precio = Double.parseDouble(precioStr);
            modelo.agregarComida(nombre, tipo, calorias, precio);
            actualizarTabla();
            limpiarCampos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Calorías y Precio deben ser números válidos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarComida() {
        try {
            int id = Integer.parseInt(vista.idField.getText());

            if (id <= 0) {
                JOptionPane.showMessageDialog(vista, "ID inválido", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int confirmacion = JOptionPane.showConfirmDialog(vista,
                    "¿Eliminar esta comida?", "Confirmar",
                    JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                modelo.eliminarComida(id);
                actualizarTabla();
                limpiarCampos();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "ID inválido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarComida() {
        try {
            int id = Integer.parseInt(vista.idField.getText());
            String nombre = vista.nombreField.getText().trim();
            String tipo = vista.tipoField.getText().trim();
            String caloriasStr = vista.caloriasField.getText().trim();
            String precioStr = vista.precioField.getText().trim();

            if (id <= 0) {
                JOptionPane.showMessageDialog(vista, "ID inválido", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (nombre.isEmpty() || tipo.isEmpty() || caloriasStr.isEmpty() || precioStr.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int calorias = Integer.parseInt(caloriasStr);
            double precio = Double.parseDouble(precioStr);
            modelo.actualizarComida(id, nombre, tipo, calorias, precio);
            actualizarTabla();
            limpiarCampos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Calorías y Precio deben ser números válidos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarTabla() {
        vista.modeloTabla.setRowCount(0);
        for (Comida c : modelo.getComidas()) {
            vista.modeloTabla.addRow(new Object[]{
                    c.getId(),
                    c.getNombre(),
                    c.getTipo(),
                    c.getCalorias(),
                    String.format("$%.2f", c.getPrecio())
            });
        }
    }

    private void limpiarCampos() {
        vista.idField.setText("");
        vista.nombreField.setText("");
        vista.tipoField.setText("");
        vista.caloriasField.setText("");
        vista.precioField.setText("");
    }
}