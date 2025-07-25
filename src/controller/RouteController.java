package controller;

import UI.LoginView;
import UI.MenuView;
import com.sun.tools.javac.Main;
import model.LoginModel;

import javax.swing.*;
import java.io.FileReader;

public class RouteController {
        private final JFrame mainFrame;

        //Constructor
        public RouteController(JFrame frame){
            this .mainFrame = frame;
        }

        public void mostrarLogin(){
            LoginModel loginModel = new LoginModel();
            LoginController loginController = new LoginController(this,loginModel);
            LoginView view = new LoginView(loginController);

            mainFrame.setContentPane(view);
            mainFrame.revalidate();
            mainFrame.repaint();

        }
        public void mostrarMenu(){
            MenuView view = new MenuView();
            mainFrame.setContentPane(view);
            mainFrame.repaint();
        }
}
