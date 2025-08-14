package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class ClientesView extends JPanel {
    public JTextField idField;
    public JTextField nombreField;
    public JTextField telefonoField;
    public JTextField emailField;

    public JButton btnRegistrar;
    public JButton btnEliminar;
    public JButton btnActualizar;
    public JButton btnRegresar;

    public JTable tablaClientes;
    public DefaultTableModel modeloTabla;

    public ClientesView() {
        setLayout(new BorderLayout());
        setBackground(new Color(240, 240, 240));

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelPrincipal.setBackground(new Color(240, 240, 240));

        // Formulario
        JPanel formularioPanel = new JPanel(new GridBagLayout());
        formularioPanel.setBackground(new Color(240, 240, 240));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Campos del formulario
        agregarCampo(formularioPanel, gbc, "ID", idField = new JTextField(20), 0);
        idField.setBackground(new Color(230, 230, 230));

        agregarCampo(formularioPanel, gbc, "Nombre", nombreField = new JTextField(20), 1);
        agregarCampo(formularioPanel, gbc, "Teléfono", telefonoField = new JTextField(20), 2);
        agregarCampo(formularioPanel, gbc, "Email", emailField = new JTextField(20), 3);

        // Botones estándar sin estilos personalizados
        btnRegistrar = new JButton("Registrar");
        btnEliminar = new JButton("Eliminar");
        btnActualizar = new JButton("Actualizar");
        btnRegresar = new JButton("Regresar");

        JPanel botonesPanel = new JPanel(new GridLayout(1, 4, 10, 0));
        botonesPanel.add(btnRegistrar);
        botonesPanel.add(btnActualizar);
        botonesPanel.add(btnEliminar);
        botonesPanel.add(btnRegresar);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        formularioPanel.add(botonesPanel, gbc);

        // Tabla
        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Nombre", "Teléfono", "Email"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaClientes = new JTable(modeloTabla);
        tablaClientes.setRowHeight(30);
        tablaClientes.setSelectionBackground(new Color(52, 152, 219));
        tablaClientes.setSelectionForeground(Color.WHITE);
        tablaClientes.setFont(new Font("Arial", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(tablaClientes);
        scrollPane.setPreferredSize(new Dimension(600, 400));
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        panelPrincipal.add(formularioPanel, BorderLayout.NORTH);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);

        add(panelPrincipal);
    }

    private void agregarCampo(JPanel panel, GridBagConstraints gbc, String label, JTextField field, int row) {
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel lbl = new JLabel(label);
        lbl.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(lbl, gbc);

        gbc.gridx = 1;
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(field, gbc);
    }

    public void setRegresarListener(ActionListener listener) {
        btnRegresar.addActionListener(listener);
    }
}
