package controller;

import model.CalendarioModel;
import UI.CalendarioView;
import objects.Evento;
import javax.swing.*;

public class CalendarioController {
    private CalendarioModel modelo;
    private CalendarioView vista;
    private RouteController router;

    public CalendarioController(CalendarioModel modelo, CalendarioView vista, RouteController router) {
        this.modelo = modelo;
        this.vista = vista;
        this.router = router;
        configurarListeners();
        actualizarTabla();
    }

    private void configurarListeners() {
        vista.btnAgregar.addActionListener(e -> agregarEvento());
        vista.btnEliminar.addActionListener(e -> eliminarEvento());
        vista.btnActualizar.addActionListener(e -> actualizarEvento());
        vista.btnRegresar.addActionListener(e -> {
            router.mostrarMenu();
        });
    }

    private void agregarEvento() {
        String fecha = vista.fechaField.getText().trim();
        String evento = vista.eventoField.getText().trim();
        String descripcion = vista.descripcionField.getText().trim();

        if (fecha.isEmpty() || evento.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Fecha y Evento son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        modelo.agregarEvento(fecha, evento, descripcion);
        actualizarTabla();
        limpiarCampos();
    }

    private void eliminarEvento() {
        try {
            int id = Integer.parseInt(vista.idField.getText());

            if (id <= 0) {
                JOptionPane.showMessageDialog(vista, "ID inválido", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int confirmacion = JOptionPane.showConfirmDialog(vista,
                    "¿Eliminar este evento?", "Confirmar",
                    JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                modelo.eliminarEvento(id);
                actualizarTabla();
                limpiarCampos();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "ID inválido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarEvento() {
        try {
            int id = Integer.parseInt(vista.idField.getText());
            String fecha = vista.fechaField.getText().trim();
            String evento = vista.eventoField.getText().trim();
            String descripcion = vista.descripcionField.getText().trim();

            if (id <= 0) {
                JOptionPane.showMessageDialog(vista, "ID inválido", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (fecha.isEmpty() || evento.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Fecha y Evento son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            modelo.actualizarEvento(id, fecha, evento, descripcion);
            actualizarTabla();
            limpiarCampos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "ID inválido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarTabla() {
        vista.modeloTabla.setRowCount(0);
        for (Evento e : modelo.getEventos()) {
            vista.modeloTabla.addRow(new Object[]{
                    e.getId(),
                    e.getFecha(),
                    e.getNombreEvento(),
                    e.getDescripcion()
            });
        }
    }

    private void limpiarCampos() {
        vista.idField.setText("");
        vista.fechaField.setText("");
        vista.eventoField.setText("");
        vista.descripcionField.setText("");
    }
}