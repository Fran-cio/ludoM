package vista;

import elements.Partida;
import vista.control.Teclado;

import javax.swing.*;
import java.awt.*;

public class Ventana extends Canvas implements Runnable{
    private static final int ANCHO=800;
    private static final int ALTO=600;
    private static final int deBounce=100;

    private static volatile boolean enFuncionamiento=false;

    private static final String NOMBRE="LudoM - Testigos de Turing";

    private static int aps=0;
    private static int fps=0;

    private static JFrame ventana;
    private static ViewTablero tablero;
    private static Partida  partida;

    private static Thread thread;
    private static Teclado teclado;

    public Ventana(Partida partida) throws HeadlessException {
        Ventana.partida = partida;
        setPreferredSize(new Dimension(ANCHO,ALTO));

        teclado=new Teclado();
        addKeyListener(teclado);

        ventana= new JFrame(NOMBRE);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLayout(new BorderLayout());
        ventana.add(this,BorderLayout.CENTER);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);

        iniciar();
    }
    private synchronized void iniciar(){
        enFuncionamiento=true;

        thread=new Thread(this,"Graficos");
        thread.start();
    }
    private synchronized void detener(){
        enFuncionamiento=false;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void actualizar(){
        synchronized (partida.thread) {
        teclado.actualizar();
            if (teclado.pieza1) {
                    System.out.println("1");
                    partida.setNum(1);
                try {
                    Thread.sleep(deBounce);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                partida.thread.notifyAll();
            } else if (teclado.pieza2) {
                    System.out.println("2");
                    partida.setNum(2);
                try {
                    Thread.sleep(deBounce);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                    partida.thread.notifyAll();
            } else if (teclado.pieza3) {
                    System.out.println("3");
                    partida.setNum(3);
                try {
                    Thread.sleep(deBounce);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                    partida.thread.notifyAll();
            } else if (teclado.pieza4) {
                    System.out.println("4");
                    partida.setNum(4);
                try {
                    Thread.sleep(deBounce);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                    partida.thread.notifyAll();
            }
        }
        aps++;
    }

    private void mostrar(){
        fps++;
    }

    @Override
    public void run() {
        final int NS_POR_SEGUNDO=1000000000;
        final byte APS_OBJETIVO=60;
        final double NS_POR_ACTUALIZACION  =NS_POR_SEGUNDO / APS_OBJETIVO;

        long referenciaActualizacion = System.nanoTime();
        long referenciaContador=System.nanoTime();

        double tiempoTranscurrido;
        double delta=0;

        requestFocus();

        while(enFuncionamiento){
            final long inicioBucle =System.nanoTime();

            tiempoTranscurrido = inicioBucle - referenciaActualizacion;
            referenciaActualizacion = inicioBucle;

            delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;

            while (delta>=1){
                actualizar();
                delta--;
            }

            mostrar();

            if(System.nanoTime() - referenciaContador > NS_POR_SEGUNDO){
                ventana.setTitle(NOMBRE+" || APS: "+aps+" || FPS: "+fps);
                aps=0;
                fps=0;
                referenciaContador = System.nanoTime();
            }
        }

    }
}
