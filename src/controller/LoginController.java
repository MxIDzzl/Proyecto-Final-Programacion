package controller;

import model.LoginModel;
import UI.LoginView;
import javax.swing.*;

public class LoginController {
    private final RouteController router;
    private final LoginModel model;
    private final LoginView vista;

    public LoginController(RouteController router, LoginModel model, LoginView vista) {
        this.router = router;
        this.model = model;
        this.vista = vista;
        configurarEventos();
    }

    private void configurarEventos() {
        vista.getBtnLogin().addActionListener(e -> validarLogin(
                vista.getUsuarioField().getText(),
                new String(vista.getPasswordField().getPassword())
        ));
    }

    public void validarLogin(String usuario, String password) {
        if(model.validarUsuario(usuario, password)) {
            router.mostrarMenu();
        } else {
            JOptionPane.showMessageDialog(vista,
                    "Usuario y contraseña incorrectos",
                    "Login incorrecto",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}