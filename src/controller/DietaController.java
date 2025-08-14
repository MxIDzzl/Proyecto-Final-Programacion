package controller;

import model.DietaModel;
import UI.DietasView;
import objects.Dieta;
import javax.swing.*;

public class DietaController {
    private DietaModel modelo;
    private DietasView vista;
    private RouteController router;

    public DietaController(DietaModel modelo, DietasView vista, RouteController router) {
        this.modelo = modelo;
        this.vista = vista;
        this.router = router;
        configurarListeners();
        actualizarTabla();
    }

    private void configurarListeners() {
        vista.btnAgregar.addActionListener(e -> agregarDieta());
        vista.btnEliminar.addActionListener(e -> eliminarDieta());
        vista.btnActualizar.addActionListener(e -> actualizarDieta());
        vista.btnRegresar.addActionListener(e -> {
            router.mostrarMenu();
        });
    }

    private void agregarDieta() {
        String nombre = vista.nombreField.getText().trim();
        String descripcion = vista.descripcionField.getText().trim();
        String caloriasStr = vista.caloriasField.getText().trim();

        if (nombre.isEmpty() || caloriasStr.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Nombre y Calorías son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int calorias = Integer.parseInt(caloriasStr);
            modelo.agregarDieta(nombre, descripcion, calorias);
            actualizarTabla();
            limpiarCampos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Calorías debe ser un número", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarDieta() {
        try {
            int id = Integer.parseInt(vista.idField.getText());

            if (id <= 0) {
                JOptionPane.showMessageDialog(vista, "ID inválido", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int confirmacion = JOptionPane.showConfirmDialog(vista,
                    "¿Eliminar esta dieta?", "Confirmar",
                    JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                modelo.eliminarDieta(id);
                actualizarTabla();
                limpiarCampos();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "ID inválido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarDieta() {
        try {
            int id = Integer.parseInt(vista.idField.getText());
            String nombre = vista.nombreField.getText().trim();
            String descripcion = vista.descripcionField.getText().trim();
            String caloriasStr = vista.caloriasField.getText().trim();

            if (id <= 0) {
                JOptionPane.showMessageDialog(vista, "ID inválido", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (nombre.isEmpty() || caloriasStr.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Nombre y Calorías son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int calorias = Integer.parseInt(caloriasStr);
            modelo.actualizarDieta(id, nombre, descripcion, calorias);
            actualizarTabla();
            limpiarCampos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Calorías debe ser un número", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarTabla() {
        vista.modeloTabla.setRowCount(0);
        for (Dieta d : modelo.getDietas()) {
            vista.modeloTabla.addRow(new Object[]{
                    d.getId(),
                    d.getNombre(),
                    d.getDescripcion(),
                    d.getCalorias()
            });
        }
    }

    private void limpiarCampos() {
        vista.idField.setText("");
        vista.nombreField.setText("");
        vista.descripcionField.setText("");
        vista.caloriasField.setText("");
    }
}