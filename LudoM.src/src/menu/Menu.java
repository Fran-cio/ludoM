package menu;

import javax.swing.*;
import java.awt.*;

public class Menu {

    private static final ImageIcon icono = new ImageIcon("./LudoM.src/recursos/icono/TdeT.png");

    int jug;

    public Menu() {
        MainMenu ventana = new MainMenu();

        ventana.setPreferredSize(new Dimension(480 + 200, 480));
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setIconImage(icono.getImage());
        ventana.setLayout(new BorderLayout());

        JLabel label = new JLabel();
        ImageIcon img2 = new ImageIcon(icono.getImage().getScaledInstance(480 + 200, 480, Image.SCALE_DEFAULT));
        label.setIcon(img2);

        JLabel label1 = new JLabel();
        label1.setText("Inserte numero de jugadores: ");
        label1.setBounds(120 - 60, 200 + 60, 300, 50);
        label.setOpaque(true);
        label1.setForeground(Color.white);

        ventana.add(label1);
        ventana.add(label);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);

        while (ventana.numJugadores == 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ventana.setVisible(false);
        jug = ventana.numJugadores;
    }

    public int getJug() {
        return jug;
    }
}
