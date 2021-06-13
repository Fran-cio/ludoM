package vista.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class Teclado  implements KeyListener {

    private final static int numeroTeclas = 120;
    private boolean[] teclas = new boolean[numeroTeclas];

    public boolean tirarDado;
    public boolean pieza1;
    public boolean pieza2;
    public boolean pieza3;
    public boolean pieza4;
    public boolean pausa;

    public void actualizar(){
        tirarDado   =   teclas[KeyEvent.VK_ENTER];
        pieza1      =   teclas[KeyEvent.VK_1];
        pieza2      =   teclas[KeyEvent.VK_2];
        pieza3      =   teclas[KeyEvent.VK_3];
        pieza4      =   teclas[KeyEvent.VK_4];
        pausa       =   teclas[KeyEvent.VK_ESCAPE];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        teclas[e.getKeyCode()]=true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        teclas[e.getKeyCode()]=false;
    }
}
