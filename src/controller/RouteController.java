package controller;

import model.*;
import UI.*;
import javax.swing.*;

public class RouteController {
    private final JFrame frame;
    private final LoginModel loginModel;
    private final UsuarioModel usuarioModel;
    private final ClienteModel clienteModel;

    public RouteController(JFrame frame) {
        this.frame = frame;
        this.loginModel = new LoginModel();
        this.usuarioModel = new UsuarioModel();
        this.clienteModel = new ClienteModel();
        configurarFrame();
    }

    private void configurarFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public void mostrarLogin() {
        LoginView vista = new LoginView();
        new LoginController(this, loginModel, vista); // Pasamos la vista al controlador
        cambiarVista(vista, 300, 400);
    }

    public void mostrarMenu() {
        MenuView vista = new MenuView(this);
        cambiarVista(vista, 800, 500);
    }

    public void mostrarUsuarios() {
        UsuariosView vista = new UsuariosView();
        new UsuariosController(usuarioModel, vista, this);
        cambiarVista(vista, 1000, 600);
    }

    public void mostrarClientes() {
        ClientesView vista = new ClientesView();
        new ClientesController(clienteModel, vista, this);
        cambiarVista(vista, 1000, 600);
    }
    public void mostrarCalendario() {
        CalendarioView vista = new CalendarioView();
        new CalendarioController(new CalendarioModel(), vista, this);
        cambiarVista(vista, 1000, 600);
    }
    public void mostrarDietas() {
        DietasView vista = new DietasView();
        new DietaController(new DietaModel(), vista, this);
        cambiarVista(vista, 1000, 600);
    }

    private void cambiarVista(JPanel vista, int ancho, int alto) {
        frame.setContentPane(vista);
        frame.setSize(ancho, alto);
        frame.revalidate();
        frame.repaint();
    }
}