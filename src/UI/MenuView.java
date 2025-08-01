package UI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuView extends JPanel {
    public MenuView() {
        setPreferredSize(new Dimension(600, 400));

        setLayout(new GridLayout(3, 2, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(createMenuItem("Usuarios","usuario.png"));
        add(createMenuItem("Clientes", "cliente.png"));
        add(createMenuItem("Calendario", "calendario.png"));
        add(createMenuItem("Dietas", "dieta.png"));
        add(createMenuItem("Comida", "comida.png"));
        add(createMenuItem("Cerrar Sesion", "cerrar-sesion.png"));
    }

    private JPanel createMenuItem(String text, String Imagen) {

        JPanel container = new JPanel();
        container.setBackground(Color.white);
        container.setBorder(new LineBorder(Color.white, 2, true));
        container.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        container.setPreferredSize(new Dimension(200, 100));
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        ImageIcon icon;
        try {
            icon = new ImageIcon(getClass().getResource("/assets/images/" + Imagen));
        } catch (Exception e){
            icon = new ImageIcon(getClass().getResource("/assets/images/cuenta.png"));
        }

        Image scaledImage = icon.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);

        JLabel iconLabel = new JLabel(new ImageIcon(scaledImage));
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        container.add(Box.createVerticalGlue());
        container.add(iconLabel);
        container.add(Box.createRigidArea(new Dimension(0, 5)));
        container.add(iconLabel);
        container.add(Box.createVerticalGlue());

        container.add(iconLabel);
        JLabel label = new JLabel(text);
        container.add(label);

        container.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Probando...");
            }
        });

        return container;
    }
}
