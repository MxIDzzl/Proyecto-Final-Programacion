package controller;

import model.LoginModel;

import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.*;

public class LoginController {
    private RouteController router;
    private LoginModel model;

    public LoginController(RouteController router,LoginModel model){
        this.router = router;
        this.model = model;
    }
    public void validarLogin(String usuario,String password){
        if(model.validarUsuario(usuario,password)){
            router.mostrarMenu();
        } else {
            JOptionPane.showMessageDialog(null,"Login incorrecto","Usuario y contraseña incorrecto",JOptionPane.ERROR_MESSAGE);
        }
    }
}