package elements;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CasillaTest {
    @Test
    void testComer() {
        Tablero tablero=new Tablero();
        Jugador player1= new Jugador(4,tablero);
        Jugador player2=new Jugador(2,tablero);
        tablero.Setficha(6,4,player1.getPlayer().getFichas()[2],0);
        tablero.Setficha(6,4,player2.getPlayer().getFichas()[0],0);

        assertTrue(!tablero.tablero[6][4].acumfichas.contains(player1.getPlayer().getFichas()[2])&&tablero.tablero[6][4].acumfichas.contains(player2.getPlayer().getFichas()[0]));
    }

}