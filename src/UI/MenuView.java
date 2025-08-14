package UI;

import controller.ClientesController;
import controller.UsuariosController;
import controller.RouteController;
import model.UsuarioModel;
import model.ClienteModel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuView extends JPanel {
    private RouteController router;

    public MenuView(RouteController router) {
        this.router = router;
        initComponents();
    }

    private void initComponents() {
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

        ImageIcon icon = loadIcon(imagen);
        JLabel iconLabel = createIconLabel(icon);
        JLabel textLabel = createTextLabel(text);

        container.add(Box.createVerticalGlue());
        container.add(iconLabel);
        container.add(Box.createRigidArea(new Dimension(0, 8)));
        container.add(textLabel);
        container.add(Box.createVerticalGlue());

        container.addMouseListener(createMouseListener(action));
        return container;
    }

    private ImageIcon loadIcon(String imagen) {
        try {
            return new ImageIcon(getClass().getResource("/assets/images/" + imagen));
        } catch (Exception e) {
            return new ImageIcon(getClass().getResource("/assets/images/cuenta.png"));
        }
    }

    private JLabel createIconLabel(ImageIcon icon) {
        Image scaledImage = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        JLabel label = new JLabel(new ImageIcon(scaledImage));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    private JLabel createTextLabel(String text) {
        JLabel label = new JLabel(text);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setFont(new Font("Arial", Font.PLAIN, 12));
        return label;
    }

    private MouseAdapter createMouseListener(String action) {
        return new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ((JPanel)e.getSource()).setBackground(new Color(245, 245, 245));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ((JPanel)e.getSource()).setBackground(Color.WHITE);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                handleAction(action);
            }
        };
    }

    private void handleAction(String action) {
        switch (action) {
            case "usuarios":
                router.mostrarUsuarios();
                break;
            case "clientes":
                router.mostrarClientes();
                break;
            case "calendario":
                router.mostrarCalendario();
                break;
            case "dietas":
                router.mostrarDietas();
                break;
            case "comida":
                router.mostrarComidas();
                break;
            case "logout":
                confirmarLogout();
                break;
            default:
                JOptionPane.showMessageDialog(this,
                        "Módulo en desarrollo: " + action,
                        "Información",
                        JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void confirmarLogout() {
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea cerrar sesión?",
                "Confirmar cierre de sesión",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacion == JOptionPane.YES_OPTION) {
            router.mostrarLogin();
        }
    }
}