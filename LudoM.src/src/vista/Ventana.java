package vista;

import elements.Buzon;
import elements.Casilla;
import elements.Partida;
import observer.Observador;
import vista.control.Teclado;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Ventana extends Canvas implements Runnable, Observador {
    private static final int ANCHO=480;
    private static final int ALTO=480;
    private static final int deBounce=200;
    private static final int puntCasilla=32;

    private static volatile boolean enFuncionamiento=false;

    private static final String NOMBRE="LudoM - Testigos de Turing";

    private static int aps=0;
    private static int fps=0;

    private static JFrame ventana;
    private static Partida partida;
    private static HistorialJug historialJug;

    private static Thread thread;
    private static Teclado teclado;

    private static BufferedImage fondo;
    private static BufferedImage fichaAmarilla;
    private static BufferedImage fichaVerde;
    private static BufferedImage ficharoja;
    private static BufferedImage fichaAzul;
    private static BufferedImage fichaAmarillap;
    private static BufferedImage fichaVerdep;
    private static BufferedImage ficharojap;
    private static BufferedImage fichaAzulp;
    private static BufferedImage Dado1;
    private static BufferedImage Dado2;
    private static BufferedImage Dado3;
    private static BufferedImage Dado4;
    private static BufferedImage Dado5;
    private static BufferedImage Dado6;
    private static BufferedImage placeHolder;

    static {
        try {

            fondo = ImageIO.read(Ventana.class.getResource("/texturas/Ludo_Board_main.png"));
            fichaAmarilla = ImageIO.read(Ventana.class.getResource("/texturas/PiezaAmarilla.png"));
            fichaVerde = ImageIO.read(Ventana.class.getResource("/texturas/PiezaVerde.png"));
            ficharoja = ImageIO.read(Ventana.class.getResource("/texturas/PiezaRoja.png"));
            fichaAzul = ImageIO.read(Ventana.class.getResource("/texturas/PiezaAzul.png"));
            fichaAmarillap = ImageIO.read(Ventana.class.getResource("/texturas/PiezaAmarillaP.png"));
            fichaVerdep = ImageIO.read(Ventana.class.getResource("/texturas/PiezaVerdeP.png"));
            ficharojap = ImageIO.read(Ventana.class.getResource("/texturas/PiezaRojaP.png"));
            fichaAzulp = ImageIO.read(Ventana.class.getResource("/texturas/PiezaAzulP.png"));
            Dado1 = ImageIO.read(Ventana.class.getResource("/texturas/Dado1.png"));
            Dado2 = ImageIO.read(Ventana.class.getResource("/texturas/Dado2.png"));
            Dado3 = ImageIO.read(Ventana.class.getResource("/texturas/Dado3.png"));
            Dado4 = ImageIO.read(Ventana.class.getResource("/texturas/Dado4.png"));
            Dado5 = ImageIO.read(Ventana.class.getResource("/texturas/Dado5.png"));
            Dado6 = ImageIO.read(Ventana.class.getResource("/texturas/Dado6.png"));
            placeHolder = ImageIO.read(Ventana.class.getResource("/texturas/placeholder.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final ImageIcon icono = new ImageIcon(Ventana.class.getResource("/icono/TdeT.png"));

    public Ventana(Partida partida, Teclado tec) throws HeadlessException {
        Ventana.partida = partida;
        partida.registrar(this);
        setPreferredSize(new Dimension(ANCHO,ALTO));

        teclado= tec;
        addKeyListener(teclado);

        historialJug= new HistorialJug(partida);

        ventana= new JFrame(NOMBRE);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setIconImage(icono.getImage());
        ventana.setLayout(new BorderLayout());
        ventana.add(historialJug.getLabel(),BorderLayout.EAST);
        ventana.add(this,BorderLayout.WEST);

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

    public void mostrar(Buzon buzon){
        Casilla[][] casillas= buzon.casillas;
        int valorDado= buzon.valorDado;

        BufferStrategy estrategia = getBufferStrategy();
        String turno= buzon.siguienteJugador;

        if(estrategia == null){
            createBufferStrategy(2);
            return;
        }
        Graphics g = estrategia.getDrawGraphics();
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), null);
        if(valorDado==1){
            g.drawImage(Dado1, 240-16, 240-16 , 32, 32, null);
        }else if(valorDado==2){
            g.drawImage(Dado2, 240-16, 240-16 , 32, 32, null);
        }else if(valorDado==3){
            g.drawImage(Dado3, 240-16, 240-16 , 32, 32, null);
        }else if(valorDado==4){
            g.drawImage(Dado4, 240-16, 240-16 , 32, 32, null);
        }else if(valorDado==5){
            g.drawImage(Dado5, 240-16, 240-16, 32, 32, null);
        }else if(valorDado==6){
            g.drawImage(Dado6, 240-16, 240-16, 32, 32, null);
        }
        switch (turno) {
            case "Amarillo" -> g.drawImage(placeHolder, 5 * puntCasilla, (14 - 5) * puntCasilla, 32, 32, null);
            case "Verde" -> g.drawImage(placeHolder, 5 * puntCasilla, (14 - 9) * puntCasilla, 32, 32, null);
            case "Rojo" -> g.drawImage(placeHolder, 9 * puntCasilla, (14 - 9) * puntCasilla, 32, 32, null);
            case "Azul" -> g.drawImage(placeHolder, 9 * puntCasilla, (14 - 5) * puntCasilla, 32, 32, null);
        }
        for(int i=0; i!=15 ; i++) {
            for (int j = 0; j != 15; j++) {
                if (casillas[i][j].getAcumfichas().size() != 0) {
                    if(casillas[i][j].getAcumfichas().firstElement().getStatus().getState().equals("Wait")){
                        switch (casillas[i][j].getAcumfichas().firstElement().getColorF()) {
                            case "Amarillo":
                                for (int k = 0; k != casillas[i][j].getAcumfichas().size(); k++) {
                                    if (k == 0) {
                                        g.drawImage(fichaAmarilla, i * puntCasilla - 48, (14 - j) * puntCasilla - 16, 32, 32, null);
                                    } else if (k == 1) {
                                        g.drawImage(fichaAmarilla, i * puntCasilla - 48, (14 - j) * puntCasilla - 80, 32, 32, null);
                                    } else if (k == 2) {
                                        g.drawImage(fichaAmarilla, i * puntCasilla - 112, (14 - j) * puntCasilla - 16, 32, 32, null);
                                    } else if (k == 3) {
                                        g.drawImage(fichaAmarilla, i * puntCasilla - 112, (14 - j) * puntCasilla - 80, 32, 32, null);
                                    }
                                }
                                break;
                            case "Verde":
                                for (int k = 0; k != casillas[i][j].getAcumfichas().size(); k++) {
                                    if (k == 0) {
                                        g.drawImage(fichaVerde, i * puntCasilla + 16, (14 - j) * puntCasilla - 48, 32, 32, null);
                                    } else if (k == 1) {
                                        g.drawImage(fichaVerde, i * puntCasilla + 16, (14 - j) * puntCasilla - 112, 32, 32, null);
                                    } else if (k == 2) {
                                        g.drawImage(fichaVerde, i * puntCasilla + 80, (14 - j) * puntCasilla - 48, 32, 32, null);
                                    } else if (k == 3) {
                                        g.drawImage(fichaVerde, i * puntCasilla + 80, (14 - j) * puntCasilla - 112, 32, 32, null);
                                    }
                                }
                                break;
                            case "Rojo":
                                for (int k = 0; k != casillas[i][j].getAcumfichas().size(); k++) {
                                    if (k == 0) {
                                        g.drawImage(ficharoja, i * puntCasilla + 48, (14 - j) * puntCasilla + 16, 32, 32, null);
                                    } else if (k == 1) {
                                        g.drawImage(ficharoja, i * puntCasilla + 48, (14 - j) * puntCasilla + 80, 32, 32, null);
                                    } else if (k == 2) {
                                        g.drawImage(ficharoja, i * puntCasilla + 112, (14 - j) * puntCasilla + 16, 32, 32, null);
                                    } else if (k == 3) {
                                        g.drawImage(ficharoja, i * puntCasilla + 112, (14 - j) * puntCasilla + 80, 32, 32, null);
                                    }
                                }
                                break;
                            case "Azul":
                                for (int k = 0; k != casillas[i][j].getAcumfichas().size(); k++) {
                                    if (k == 0) {
                                        g.drawImage(fichaAzul, i * puntCasilla - 16, (14 - j) * puntCasilla + 48, 32, 32, null);
                                    } else if (k == 1) {
                                        g.drawImage(fichaAzul, i * puntCasilla - 16, (14 - j) * puntCasilla + 112, 32, 32, null);
                                    } else if (k == 2) {
                                        g.drawImage(fichaAzul, i * puntCasilla - 80, (14 - j) * puntCasilla + 48, 32, 32, null);
                                    } else if (k == 3) {
                                        g.drawImage(fichaAzul, i * puntCasilla - 80, (14 - j) * puntCasilla + 112, 32, 32, null);
                                    }
                                }
                                break;
                        }
                    }else if(casillas[i][j].getAcumfichas().firstElement().getStatus().getState().equals("Protected")){
                        for(int k=0; k!=casillas[i][j].getAcumfichas().size(); k++){
                            switch (casillas[i][j].getAcumfichas().get(k).getColorF()) {
                                case "Amarillo" -> g.drawImage(fichaAmarillap, (i * puntCasilla - (2 * casillas[i][j].getAcumfichas().size())) + (32 * k) / casillas[i][j].getAcumfichas().size(), (14 - j) * puntCasilla, 32 / casillas[i][j].getAcumfichas().size(), 32 / casillas[i][j].getAcumfichas().size(), null);
                                case "Verde" -> g.drawImage(fichaVerdep, (i * puntCasilla - (2 * casillas[i][j].getAcumfichas().size())) + (32 * k) / casillas[i][j].getAcumfichas().size(), (14 - j) * puntCasilla, 32 / casillas[i][j].getAcumfichas().size(), 32 / casillas[i][j].getAcumfichas().size(), null);
                                case "Rojo" -> g.drawImage(ficharojap, (i * puntCasilla - (2 * casillas[i][j].getAcumfichas().size())) + (32 * k) / casillas[i][j].getAcumfichas().size(), (14 - j) * puntCasilla, 32 / casillas[i][j].getAcumfichas().size(), 32 / casillas[i][j].getAcumfichas().size(), null);
                                case "Azul" -> g.drawImage(fichaAzulp, (i * puntCasilla - (2 * casillas[i][j].getAcumfichas().size())) + (32 * k) / casillas[i][j].getAcumfichas().size(), (14 - j) * puntCasilla, 32 / casillas[i][j].getAcumfichas().size(), 32 / casillas[i][j].getAcumfichas().size(), null);
                            }
                        }
                    }else{
                        for(int k=0; k!=casillas[i][j].getAcumfichas().size(); k++){
                            switch (casillas[i][j].getAcumfichas().get(k).getColorF()) {
                                case "Amarillo" -> g.drawImage(fichaAmarilla, (i * puntCasilla - (2 * casillas[i][j].getAcumfichas().size())) + (32 * k) / casillas[i][j].getAcumfichas().size(), (14 - j) * puntCasilla, 32 / casillas[i][j].getAcumfichas().size(), 32 / casillas[i][j].getAcumfichas().size(), null);
                                case "Verde" -> g.drawImage(fichaVerde, (i * puntCasilla - (2 * casillas[i][j].getAcumfichas().size())) + (32 * k) / casillas[i][j].getAcumfichas().size(), (14 - j) * puntCasilla, 32 / casillas[i][j].getAcumfichas().size(), 32 / casillas[i][j].getAcumfichas().size(), null);
                                case "Rojo" -> g.drawImage(ficharoja, (i * puntCasilla - (2 * casillas[i][j].getAcumfichas().size())) + (32 * k) / casillas[i][j].getAcumfichas().size(), (14 - j) * puntCasilla, 32 / casillas[i][j].getAcumfichas().size(), 32 / casillas[i][j].getAcumfichas().size(), null);
                                case "Azul" -> g.drawImage(fichaAzul, (i * puntCasilla - (2 * casillas[i][j].getAcumfichas().size())) + (32 * k) / casillas[i][j].getAcumfichas().size(), (14 - j) * puntCasilla, 32 / casillas[i][j].getAcumfichas().size(), 32 / casillas[i][j].getAcumfichas().size(), null);
                            }
                        }
                    }
                }
            }
        }

        g.dispose();

        estrategia.show();

        fps++;
    }

    @Override
    public void run() {
        final int NS_POR_SEGUNDO=1000000000;
        final byte APS_OBJETIVO=60;
        final byte FPS_OBJETIVO=60;
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



            if(System.nanoTime() - referenciaContador > NS_POR_SEGUNDO){
                ventana.setTitle(NOMBRE+" || APS: "+ aps +" || FPS: "+ fps);
                aps=0;
                fps=0;
                referenciaContador = System.nanoTime();
            }
        }
        detener();

    }
}