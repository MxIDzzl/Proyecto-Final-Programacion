package UI;

import javax.swing.*;
import java.awt.*;

public class MenuView extends JPanel {
    public MenuView(){
        setPreferredSize(new Dimension(600,400));

        //Definir layout
        setLayout(new GridBagLayout());
        //Agregar margen
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    }
}
