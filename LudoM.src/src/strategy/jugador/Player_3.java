package strategy.jugador;

import elements.Ficha;
import elements.Tablero;
import org.testng.internal.collections.Pair;

public class Player_3 implements Player{
    private Ficha[]     arrFicha;
    private final int   idJ=3;
    private final String color="Rojo";
    public static final String ANSI = "\u001B[31m";

    public Player_3(Tablero tablero) {
        arrFicha= new Ficha[4];
        for(int i=0; i!=4 ;i++) {
            arrFicha[i]= new Ficha(color,i);
            tablero.Setficha(9,13,arrFicha[i],0);
        }
        genFichas();
    }

    @Override
    public String getANSI() {
        return ANSI;
    }

    @Override
    public Ficha[] getFichas() {
        return arrFicha;
    }

    @Override
    public int getIdJ() {
        return idJ;
    }

    @Override
    public void genFichas() {
        Pair[] aux= new Pair[58];
        aux[0]=new Pair<>(9,13);
        aux[1]= new Pair<>(8,13);
        aux[2]= new Pair<>(8,12);
        aux[3]= new Pair<>(8,11);
        aux[4]= new Pair<>(8,10);
        aux[5]= new Pair<>(8,9);

        aux[6]= new Pair<>(9,8);
        aux[7]= new Pair<>(10,8);
        aux[8]= new Pair<>(11,8);
        aux[9]= new Pair<>(12,8);
        aux[10]= new Pair<>(13,8);
        aux[11]= new Pair<>(14,8);
        aux[12]= new Pair<>(14,7);
        aux[13]= new Pair<>(14,6);
        aux[14]= new Pair<>(13,6);
        aux[15]= new Pair<>(12,6);
        aux[16]= new Pair<>(11,6);
        aux[17]= new Pair<>(10,6);
        aux[18]= new Pair<>(9,6);

        aux[19]= new Pair<>(8,5);
        aux[20]= new Pair<>(8,4);
        aux[21]= new Pair<>(8,3);
        aux[22]= new Pair<>(8,2);
        aux[23]= new Pair<>(8,1);
        aux[24]= new Pair<>(8,0);
        aux[25]= new Pair<>(7,0);
        aux[26]= new Pair<>(6,0);
        aux[27]= new Pair<>(6,1);
        aux[28]= new Pair<>(6,2);
        aux[29]= new Pair<>(6,3);
        aux[30]= new Pair<>(6,4);
        aux[31]= new Pair<>(6,5);

        aux[32]= new Pair<>(5,6);
        aux[33]= new Pair<>(4,6);
        aux[34]= new Pair<>(3,6);
        aux[35]= new Pair<>(2,6);
        aux[36]= new Pair<>(1,6);
        aux[37]= new Pair<>(0,6);
        aux[38]= new Pair<>(0,7);
        aux[39]= new Pair<>(0,8);
        aux[40]= new Pair<>(1,8);
        aux[41]= new Pair<>(2,8);
        aux[42]= new Pair<>(3,8);
        aux[43]= new Pair<>(4,8);
        aux[44]= new Pair<>(5,8);

        aux[45]= new Pair<>(6,9);
        aux[46]= new Pair<>(6,10);
        aux[47]= new Pair<>(6,11);
        aux[48]= new Pair<>(6,12);
        aux[49]= new Pair<>(6,13);
        aux[50]= new Pair<>(6,14);
        aux[51]= new Pair<>(7,14);

        aux[52]= new Pair<>(7,13);
        aux[53]= new Pair<>(7,12);
        aux[54]= new Pair<>(7,11);
        aux[55]= new Pair<>(7,10);
        aux[56]= new Pair<>(7,9);
        aux[57]= new Pair<>(7,8);

        for(int i=0; i!=4 ;i++) {
            arrFicha[i].setCamino(aux);
        }
    }
    public String getColor() {
        return color;
    }

}
