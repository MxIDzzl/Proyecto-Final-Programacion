package controller;

import model.UsuarioModel;
import UI.UsuariosView;
import objects.Usuario;

import javax.swing.*;

public class UsuariosController {
    private UsuarioModel modelo;
    private UsuariosView vista;

    public UsuariosController(UsuarioModel modelo, UsuariosView vista){
        this.modelo = modelo;
        this.vista = vista;

        vista.btnRegistrar.addActionListener(e -> {
            registrarUsuario();
        });

        vista.btnEliminar.addActionListener(e -> {
            eliminarUsuario();
        });

        vista.btnActualizar.addActionListener(e -> {
            actualizarUsuario();
        });

    }
    private void registrarUsuario(){
        String nombre = vista.usuarioField.getText();
        String contraseña = vista.passwordField.getText();

        if (nombre.isBlank() || contraseña.isBlank()) {
            JOptionPane.showMessageDialog(vista,"Por favor completa todos los campos");
            return;
        }

        modelo.agregarUsuario(nombre,contraseña);

        actualizarTabla();
    }

    private void eliminarUsuario(){
        int id = Integer.parseInt(vista.idField.getText());

        if (id < 0){
            JOptionPane.showMessageDialog(vista,"Por favor, ingresa in ID valido");
            return;
        }

        modelo.eliminarUsuario(id);
        actualizarTabla();
    }

    private void actualizarUsuario(){
        int id = Integer.parseInt(vista.idField.getText());
        String usuario = vista.usuarioField.getText();
        String contraseña = vista.passwordField.getText();

        if (id < 0){
            JOptionPane.showMessageDialog(vista,"Por favor, ingresa in ID valido");
            return;
        }
        if (usuario.isBlank() || contraseña.isBlank()){
            JOptionPane.showMessageDialog(vista,"Por favor, completa todos los campos");
            return;
        }
    }
    private void actualizarTabla(){
        //Limpiar tabla
        vista.modeloTabla.setRowCount(0);

        //llenar tabla con usuarios
        for (Usuario u : modelo.getUsuarios()){
            vista.modeloTabla.addRow(new Object[]{u.getId(), u.getusuario(), u.getcontraseña()});

        }
    }
}
