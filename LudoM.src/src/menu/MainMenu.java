package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {
    JButton launch;
    boolean tired= false;

    public MainMenu() {
        setLayout(new BorderLayout());
        add(new JLabel("Testigos de Turing", JLabel.CENTER), BorderLayout.CENTER);
        launch = new JButton("Empezar");
        launch.setEnabled(true);
        add(launch, BorderLayout.SOUTH);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);


        //setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==launch){
            System.exit(0);
        }
    }
}

