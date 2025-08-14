package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class ComidaView extends JPanel {
    public JTextField idField;
    public JTextField nombreField;
    public JTextField tipoField;
    public JTextField caloriasField;
    public JTextField precioField;

    public JButton btnAgregar;
    public JButton btnEliminar;
    public JButton btnActualizar;
    public JButton btnRegresar;

    public JTable tablaComidas;
    public DefaultTableModel modeloTabla;

    public ComidaView() {
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
        idField.setEditable(false);
        idField.setBackground(new Color(230, 230, 230));

        agregarCampo(formularioPanel, gbc, "Nombre", nombreField = new JTextField(20), 1);
        agregarCampo(formularioPanel, gbc, "Tipo", tipoField = new JTextField(20), 2);
        agregarCampo(formularioPanel, gbc, "Calorías", caloriasField = new JTextField(20), 3);
        agregarCampo(formularioPanel, gbc, "Precio", precioField = new JTextField(20), 4);

        // Botones
        btnAgregar = new JButton("Agregar");
        btnEliminar = new JButton("Eliminar");
        btnActualizar = new JButton("Actualizar");
        btnRegresar = new JButton("Regresar");

        JPanel botonesPanel = new JPanel(new GridLayout(1, 4, 10, 0));
        botonesPanel.add(btnAgregar);
        botonesPanel.add(btnActualizar);
        botonesPanel.add(btnEliminar);
        botonesPanel.add(btnRegresar);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        formularioPanel.add(botonesPanel, gbc);

        // Tabla
        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Nombre", "Tipo", "Calorías", "Precio"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaComidas = new JTable(modeloTabla);
        tablaComidas.setRowHeight(30);
        tablaComidas.setSelectionBackground(new Color(52, 152, 219));
        tablaComidas.setSelectionForeground(Color.WHITE);
        tablaComidas.setFont(new Font("Arial", Font.PLAIN, 14));

        // Listener para selección de filas
        tablaComidas.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int fila = tablaComidas.getSelectedRow();
                if (fila >= 0) {
                    idField.setText(tablaComidas.getValueAt(fila, 0).toString());
                    nombreField.setText(tablaComidas.getValueAt(fila, 1).toString());
                    tipoField.setText(tablaComidas.getValueAt(fila, 2).toString());
                    caloriasField.setText(tablaComidas.getValueAt(fila, 3).toString());
                    precioField.setText(tablaComidas.getValueAt(fila, 4).toString());
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(tablaComidas);
        scrollPane.setPreferredSize(new Dimension(700, 400));
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