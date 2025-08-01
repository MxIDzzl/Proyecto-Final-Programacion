package UI;

import javax.swing.*;
import java.awt.*;
public class UsuariosView extends JPanel{
    public JTextField usuarioField;
    public JTextField passwordField;
    public UsuariosView() {
        setPreferredSize(new Dimension(500,450));
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        JPanel formularioPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel usuarioLabel = new JLabel("Usuario");
        gbc.gridx = 0; gbc.gridy = 0;
        formularioPanel.add(usuarioLabel,gbc);

        usuarioField = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 0;
        formularioPanel.add(usuarioField,gbc);

        JLabel passwordLabel = new JLabel("Contraseña");
        gbc.gridx = 0; gbc.gridy = 1;
        formularioPanel.add(passwordLabel,gbc);

        passwordField = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 1;
        formularioPanel.add(passwordField,gbc);

        add(formularioPanel);
    }
}
