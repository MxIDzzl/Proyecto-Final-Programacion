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
        setPreferredSize(new Dimension(500, 650));
        JPanel panelPrincipal = new JPanel(new BorderLayout(10,10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(16,15,15,15));

        JPanel formularioPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel idLabel = new JLabel("ID");
        gbc.gridx = 0; gbc.gridy = 0;
        formularioPanel.add(idLabel);

        idField = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 0;
        formularioPanel.add(idField, gbc);

        JLabel usuariolabel = new JLabel("Usuario");
        gbc.gridx = 0; gbc.gridy = 1;
        formularioPanel.add(usuariolabel, gbc);

        usuarioField = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 1;
        formularioPanel.add(usuarioField, gbc);

        JLabel passwordLabel = new JLabel("Contraseña");
        gbc.gridx = 0; gbc.gridy =2;
        formularioPanel.add(passwordLabel, gbc);

        passwordField = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 2;
        formularioPanel.add(passwordField, gbc);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBackground(new Color(72,133,237));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setContentAreaFilled(true);
        btnRegistrar.setOpaque(true);
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setFocusPainted(false);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        formularioPanel.add(btnRegistrar, gbc);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBackground(new Color(72,133,237));
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setContentAreaFilled(true);
        btnEliminar.setOpaque(true);
        btnEliminar.setBorderPainted(false);
        btnEliminar.setFocusPainted(false);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        formularioPanel.add(btnEliminar, gbc);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBackground(new Color(72,133,237));
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setContentAreaFilled(true);
        btnActualizar.setOpaque(true);
        btnActualizar.setBorderPainted(false);
        btnActualizar.setFocusPainted(false);

        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        formularioPanel.add(btnActualizar, gbc);

        modeloTabla = new DefaultTableModel(new Object[]{"ID","Nombre","Contraseña"},0);
        tablausuarios = new JTable(modeloTabla);
        tablausuarios.setRowHeight(22);

        JScrollPane scrollPane = new JScrollPane(tablausuarios);

        JPanel registrosPanel = new JPanel(new BorderLayout());
        registrosPanel.setBackground(Color.WHITE);
        registrosPanel.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));

        registrosPanel.add(scrollPane, BorderLayout.CENTER);


        panelPrincipal.add(formularioPanel, BorderLayout.NORTH);
        panelPrincipal.add(registrosPanel, BorderLayout.CENTER);

        add(panelPrincipal);

        setVisible(true);

    }

}
