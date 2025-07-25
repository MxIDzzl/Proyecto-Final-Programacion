package UI;
import controller.LoginController;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JPanel {
    private final JTextField txtUsuario;
    private final JPasswordField txtPassword;
    private final LoginController loginController;

    public LoginView() {
        //creando una instancia del controlador
        loginController = new LoginController();
        //Configuracion basica de la ventana
        setSize(300, 400);
        setLayout(new GridBagLayout());

        //configuracion del layout para gestionar la posicion de
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets( 5,  5,  5,  5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        ImageIcon image = new ImageIcon(getClass().getResource("/assets/images/cuenta.png"));
        Image scaledImage = image.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        JLabel icon = new JLabel(new ImageIcon(scaledImage));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(icon, gbc);

        gbc.gridwidth = 1;

        JLabel lblUsuario = new JLabel("Usuario");
        gbc.gridx = 0; gbc.gridy = 1;
        add(lblUsuario, gbc);

        txtUsuario = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 1;
        add(txtUsuario, gbc);

        JLabel lblPassword = new JLabel("Password");
        gbc.gridx = 0; gbc.gridy = 2;
        add(lblPassword, gbc);

        txtPassword = new JPasswordField(15);
        gbc.gridx = 1; gbc.gridy = 2;
        add(txtPassword, gbc);

        JButton btnIngreso = new JButton("Ingresar");
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        add(btnIngreso, gbc);

        JButton btnRegistrar = new JButton("Registrar");
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        add(btnRegistrar, gbc);
        btnIngreso.addActionListener(e -> {
            if (loginController.validarUsuario(txtUsuario.getText(), new String(txtPassword.getPassword()))) {
                System.out.println("El usuario es correcto");
            } else {
                System.out.println("El usuario es incorrecto");
            }
        });
    }
}
