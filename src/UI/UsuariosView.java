package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class UsuariosView extends JPanel {
    public JTextField idField;
    public JTextField usuarioField;
    public JTextField passwordField;

    public JButton btnRegistrar;
    public JButton btnEliminar;
    public JButton btnActualizar;

    public JTable tablausuarios;
    public DefaultTableModel modeloTabla;

    public UsuariosView(){
        // Aumentamos la altura para que no se vea tan rectangular
        setPreferredSize(new Dimension(1000, 800));

        JPanel panelPrincipal = new JPanel(new BorderLayout(10,10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Formulario con más espacio vertical
        JPanel formularioPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // más separación entre campos
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel idLabel = new JLabel("ID");
        gbc.gridx = 0; gbc.gridy = 0;
        formularioPanel.add(idLabel, gbc);

        idField = new JTextField(20);
        gbc.gridx = 1; gbc.gridy = 0;
        formularioPanel.add(idField, gbc);

        JLabel usuariolabel = new JLabel("Usuario");
        gbc.gridx = 0; gbc.gridy = 1;
        formularioPanel.add(usuariolabel, gbc);

        usuarioField = new JTextField(20);
        gbc.gridx = 1; gbc.gridy = 1;
        formularioPanel.add(usuarioField, gbc);

        JLabel passwordLabel = new JLabel("Contraseña");
        gbc.gridx = 0; gbc.gridy = 2;
        formularioPanel.add(passwordLabel, gbc);

        passwordField = new JTextField(20);
        gbc.gridx = 1; gbc.gridy = 2;
        formularioPanel.add(passwordField, gbc);

        btnRegistrar = crearBoton("Registrar");
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        formularioPanel.add(btnRegistrar, gbc);

        btnEliminar = crearBoton("Eliminar");
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        formularioPanel.add(btnEliminar, gbc);

        btnActualizar = crearBoton("Actualizar");
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        formularioPanel.add(btnActualizar, gbc);

        // Tabla con altura de filas más grande
        modeloTabla = new DefaultTableModel(new Object[]{"ID","Nombre","Contraseña"},0);
        tablausuarios = new JTable(modeloTabla);
        tablausuarios.setRowHeight(24); // un poquito más alta

        JScrollPane scrollPane = new JScrollPane(tablausuarios);
        scrollPane.setPreferredSize(new Dimension(550, 400)); // tabla más alta

        JPanel registrosPanel = new JPanel(new BorderLayout());
        registrosPanel.setBackground(Color.WHITE);
        registrosPanel.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
        registrosPanel.add(scrollPane, BorderLayout.CENTER);

        panelPrincipal.add(formularioPanel, BorderLayout.NORTH);
        panelPrincipal.add(registrosPanel, BorderLayout.CENTER);

        add(panelPrincipal);
        setVisible(true);
    }

    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setBackground(new Color(72,133,237));
        boton.setForeground(Color.WHITE);
        boton.setContentAreaFilled(true);
        boton.setOpaque(true);
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);
        boton.setPreferredSize(new Dimension(200, 35)); // botones más grandes
        return boton;
    }
}
