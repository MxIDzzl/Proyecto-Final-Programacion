package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class DietasView extends JPanel {
    public JTextField idField;
    public JTextField nombreField;
    public JTextField descripcionField;
    public JTextField caloriasField;

    public JButton btnAgregar;
    public JButton btnEliminar;
    public JButton btnActualizar;
    public JButton btnRegresar;

    public JTable tablaDietas;
    public DefaultTableModel modeloTabla;

    public DietasView() {
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
        agregarCampo(formularioPanel, gbc, "Descripción", descripcionField = new JTextField(20), 2);
        agregarCampo(formularioPanel, gbc, "Calorías", caloriasField = new JTextField(20), 3);

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
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        formularioPanel.add(botonesPanel, gbc);

        // Tabla
        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Nombre", "Descripción", "Calorías"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaDietas = new JTable(modeloTabla);
        tablaDietas.setRowHeight(30);
        tablaDietas.setSelectionBackground(new Color(52, 152, 219));
        tablaDietas.setSelectionForeground(Color.WHITE);
        tablaDietas.setFont(new Font("Arial", Font.PLAIN, 14));

        // Listener para selección de filas
        tablaDietas.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int fila = tablaDietas.getSelectedRow();
                if (fila >= 0) {
                    idField.setText(tablaDietas.getValueAt(fila, 0).toString());
                    nombreField.setText(tablaDietas.getValueAt(fila, 1).toString());
                    descripcionField.setText(tablaDietas.getValueAt(fila, 2).toString());
                    caloriasField.setText(tablaDietas.getValueAt(fila, 3).toString());
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(tablaDietas);
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