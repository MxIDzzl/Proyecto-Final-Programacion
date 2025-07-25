package controller;

import UI.LoginView;

import javax.swing.*;
import java.io.FileReader;

public class RouteController {
        private final JFrame mainFrame;

        //Constructor
        public RouteController(JFrame frame){
            this .mainFrame = frame;
        }

        public void mostrarLogin(){
            LoginController loginController = new LoginController();
            LoginView view = new LoginView();

            mainFrame.setContentPane(view);
            mainFrame.revalidate();
            mainFrame.repaint();

        }
}
