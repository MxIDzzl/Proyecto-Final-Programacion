package controller;

import model.LoginModel;
import model.UsuarioModel;
import UI.LoginView;
import UI.MenuView;
import UI.UsuariosView;

import javax.swing.*;
public class RouteController {
    private final JFrame mainFrame;

    //Constructor
    public RouteController(JFrame frame){
        this.mainFrame = frame;
    }
    public void mostrarLogin(){
        LoginModel loginModel = new LoginModel();
        LoginController loginController = new LoginController(this,loginModel);
        LoginView view = new LoginView(loginController);

        mainFrame.setContentPane(view);
        mainFrame.revalidate();
        mainFrame.repaint();

    }
    public void mostrarMenu() {
        MenuView view = new MenuView();

        mainFrame.setContentPane(view);
        mainFrame.revalidate();
        mainFrame.repaint();
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);

    }
    public void mostrarUsuarios(){
        UsuariosView view = new UsuariosView();
        UsuarioModel model = new UsuarioModel();
        UsuariosController controller = new UsuariosController(model, view);
        mainFrame.setContentPane(view);
        mainFrame.revalidate();
        mainFrame.repaint();
        mainFrame.pack();

    }
}