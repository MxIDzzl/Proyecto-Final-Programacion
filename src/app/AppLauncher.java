package app;

import UI.LoginView;
import controller.RouteController;

import javax.swing.*;

public class AppLauncher {
    public static void main(String[] args){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e){
            throw new RuntimeException(e);
        }

        SwingUtilities.invokeLater(() ->{
            //Configuracion del frame
            JFrame frame = new JFrame("LoginApp");
            frame.setSize(300, 400);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);

            //Nueva instancia
            RouteController router = new RouteController(frame);
            router.mostrarLogin();

            frame.setVisible(true);
        });
    }
}
