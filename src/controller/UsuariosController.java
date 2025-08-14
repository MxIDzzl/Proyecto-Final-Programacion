package controller;

import model.UsuarioModel;
import UI.UsuariosView;
import objects.Usuario;

import javax.swing.*;
import java.awt.*;

public class UsuariosController {
    private UsuarioModel modelo;
    private UsuariosView vista;
    private RouteController router;

    public UsuariosController(UsuarioModel modelo, UsuariosView vista, RouteController router){
        this.modelo = modelo;
        this.vista = vista;
        this.router = router;

        configurarListeners();
        actualizarTabla();
    }

    private void configurarListeners(){
        vista.btnRegistrar.addActionListener(e -> {
            registrarUsuario();
        });

        vista.btnEliminar.addActionListener(e -> {
            eliminarUsuario();
        });

        vista.btnActualizar.addActionListener(e -> {
            actualizarUsuario();
        });
        vista.btnRegresar.addActionListener(e -> {
            router.mostrarMenu();
        });

        // Permite hacer clic en la tabla para cargar datos
        vista.tablausuarios.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                cargarUsuarioSeleccionado();
            }
        });
    }

    private void cargarUsuarioSeleccionado(){
        int fila = vista.tablausuarios.getSelectedRow();
        if (fila >= 0) {
            vista.idField.setText(vista.tablausuarios.getValueAt(fila, 0).toString());
            vista.usuarioField.setText(vista.tablausuarios.getValueAt(fila, 1).toString());
            vista.passwordField.setText(vista.tablausuarios.getValueAt(fila, 2).toString());
        }
    }

    private void registrarUsuario(){
        String nombre = vista.usuarioField.getText();
        String contraseña = vista.passwordField.getText();

        if (nombre.isBlank() || contraseña.isBlank()) {
            JOptionPane.showMessageDialog(vista, "Por favor completa todos los campos");
            return;
        }
        modelo.agregarUsuario(nombre, contraseña);
        actualizarTabla();
        limpiarCampos();
    }

    private void eliminarUsuario(){
        try {
            int id = Integer.parseInt(vista.idField.getText());

            if (id <= 0){
                JOptionPane.showMessageDialog(vista, "Por favor, ingresa un ID válido");
                return;
            }

            int confirmacion = JOptionPane.showConfirmDialog(vista,
                    "¿Estás seguro de eliminar este usuario?", "Confirmar",
                    JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                modelo.eliminarUsuario(id);
                actualizarTabla();
                limpiarCampos();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "ID inválido");
        }
    }

    private void actualizarUsuario(){
        try {
            int id = Integer.parseInt(vista.idField.getText());
            String usuario = vista.usuarioField.getText();
            String contraseña = vista.passwordField.getText();

            if (id <= 0){
                JOptionPane.showMessageDialog(vista, "Por favor, ingresa un ID válido");
                return;
            }
            if (usuario.isBlank() || contraseña.isBlank()){
                JOptionPane.showMessageDialog(vista, "Por favor, completa todos los campos");
                return;
            }

            modelo.actualizarUsuario(id, usuario, contraseña);
            actualizarTabla();
            limpiarCampos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "ID inválido");
        }
    }

    private void actualizarTabla(){
        vista.modeloTabla.setRowCount(0);
        for (Usuario u : modelo.getUsuarios()){
            vista.modeloTabla.addRow(new Object[]{u.getId(), u.getusuario(), u.getcontraseña()});
        }
    }

    private void limpiarCampos(){
        vista.idField.setText("");
        vista.usuarioField.setText("");
        vista.passwordField.setText("");
    }
}