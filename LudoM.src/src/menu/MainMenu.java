package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainMenu extends JFrame implements ActionListener {

        JButton     boton1;
        JButton     boton2;
        JButton     boton3;

        public      int     numJugadores;

        public MainMenu() {
            numJugadores=0;
            setTitle("Testigos de Turing - TP final");
            setLayout(null);
            boton1=new JButton("2 Jugadores");
            boton1.setBounds(440+60,200+100,120,50);

            boton2=new JButton("3 Jugadores");
            boton2.setBounds(280,200+100,120,50);

            boton3=new JButton("4 Jugadores");
            boton3.setBounds(120-60,200+100,120,50);

            add( boton1 , BorderLayout.CENTER );
            add( boton2 , BorderLayout.CENTER );
            add( boton3 , BorderLayout.CENTER );

            boton1.addActionListener(this);
            boton2.addActionListener(this);
            boton3.addActionListener(this);

        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==boton1) {
                numJugadores=2;
            }
            if (e.getSource()==boton2) {
                numJugadores=3;
            }
            if (e.getSource()==boton3) {
                numJugadores=4;
            }
        }
    }


