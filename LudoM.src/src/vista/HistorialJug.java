package vista;

import elements.Buzon;
import elements.Partida;
import observer.Observador;
import observer.Sujeto;

import javax.swing.*;
import java.awt.*;

public class HistorialJug extends Canvas implements Observador {
    private Sujeto partida;
    private JLabel label;

    public HistorialJug(Partida partida) {
        partida = partida;
        partida.registrar(this);
        label = new JLabel("Vaya uno a saber...", (int) LEFT_ALIGNMENT);
        label.setPreferredSize(new Dimension(200,480));
    }

    public JLabel getLabel() {
        return label;
    }

    @Override
    public void mostrar(Buzon buzon) {
        String stat = buzon.Jugada;
        label.setText(stat);
    }
}
