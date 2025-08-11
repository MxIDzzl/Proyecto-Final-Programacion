package UI;

import controller.UsuariosController;
import model.UsuarioModel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuView extends JPanel {
    public MenuView() {
        setPreferredSize(new Dimension(500, 350));
        setLayout(new GridLayout(3, 2, 15, 15));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        setBackground(new Color(240, 240, 240));

        add(createMenuItem("Usuarios", "usuario.png", "usuarios"));
        add(createMenuItem("Clientes", "cliente.png", "clientes"));
        add(createMenuItem("Calendario", "calendario.png", "calendario"));
        add(createMenuItem("Dietas", "dieta.png", "dietas"));
        add(createMenuItem("Comida", "comida.png", "comida"));
        add(createMenuItem("Cerrar Sesión", "cerrar-sesion.png", "logout"));
    }

    private JPanel createMenuItem(String text, String imagen, String action) {
        JPanel container = new JPanel();
        container.setBackground(Color.WHITE);
        container.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        container.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        ImageIcon icon;
        try {
            icon = new ImageIcon(getClass().getResource("/assets/images/" + imagen));
        } catch (Exception e) {
            icon = new ImageIcon(getClass().getResource("/assets/images/cuenta.png"));
        }

        Image scaledImage = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        JLabel iconLabel = new JLabel(new ImageIcon(scaledImage));
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel textLabel = new JLabel(text);
        textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        textLabel.setFont(new Font("Arial", Font.PLAIN, 12));

        container.add(Box.createVerticalGlue());
        container.add(iconLabel);
        container.add(Box.createRigidArea(new Dimension(0, 8)));
        container.add(textLabel);
        container.add(Box.createVerticalGlue());

        container.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                container.setBackground(new Color(245, 245, 245));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                container.setBackground(Color.WHITE);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if ("usuarios".equals(action)) {
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(container);

                    // Crear modelo y vista
                    model.UsuarioModel usuarioModel = new model.UsuarioModel();
                    UI.UsuariosView usuariosView = new UI.UsuariosView();

                    // Crear controlador y enlazar vista y modelo
                    new UsuariosController(usuarioModel, usuariosView);

                    // Mostrar la vista en el frame
                    frame.setContentPane(usuariosView);
                    frame.revalidate();
                    frame.repaint();
                }
            }
        });

        return container;
    }
}
