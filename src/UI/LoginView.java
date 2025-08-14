package UI;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JPanel {
    private JTextField usuarioField;
    private JPasswordField passwordField;
    private JButton btnLogin;
    private JLabel imagenLabel;

    public LoginView() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Panel para la imagen (arriba)
        JPanel panelImagen = new JPanel();
        imagenLabel = new JLabel();
        cargarImagen("/assets/images/cuenta.png"); // Ruta a tu imagen
        panelImagen.add(imagenLabel);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(panelImagen, gbc);

        // Campos de texto
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        add(new JLabel("Usuario:"), gbc);

        gbc.gridx = 1;
        usuarioField = new JTextField(15);
        add(usuarioField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Contraseña:"), gbc);

        gbc.gridx = 1;
        passwordField = new JPasswordField(15);
        add(passwordField, gbc);

        // Botón
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        btnLogin = new JButton("Iniciar Sesión");
        add(btnLogin, gbc);
    }

    private void cargarImagen(String ruta) {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource(ruta));
            Image imagen = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            imagenLabel.setIcon(new ImageIcon(imagen));
        } catch (Exception e) {
            // Si falla la carga, mostrar icono por defecto
            System.err.println("Error al cargar imagen: " + e.getMessage());
            imagenLabel.setIcon(UIManager.getIcon("OptionPane.informationIcon"));
        }
    }

    // Getters
    public JButton getBtnLogin() {
        return btnLogin;
    }

    public JTextField getUsuarioField() {
        return usuarioField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }
}