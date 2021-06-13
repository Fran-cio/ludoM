package elements;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CasillaTest {
    @Test
    void I_testComer() {
        Tablero tablero=new Tablero();
        Jugador player1= new Jugador(4,tablero);
        Jugador player2=new Jugador(2,tablero);
        tablero.Setficha(6,4,player1.getPlayer().getFichas()[2],0);
        tablero.Setficha(6,4,player2.getPlayer().getFichas()[0],0);

        assertTrue(!tablero.tablero[6][4].acumfichas.contains(player1.getPlayer().getFichas()[2])&&tablero.tablero[6][4].acumfichas.contains(player2.getPlayer().getFichas()[0]));
    }

    @Test
    void I_hayGanador() {
        int jugador=2; //Si se cambia el jugador, cambia el color del mensaje en la terminal
        Partida partida=new Partida(4);
        partida.tablero.Setficha((int)partida.arrJugadores[jugador].getPlayer().getFichas()[jugador].getCamino()[57].first(),(int)partida.arrJugadores[jugador].getPlayer().getFichas()[jugador].getCamino()[57].second(),partida.arrJugadores[jugador].getPlayer().getFichas()[0],0);
        partida.tablero.Setficha((int)partida.arrJugadores[jugador].getPlayer().getFichas()[jugador].getCamino()[57].first(),(int)partida.arrJugadores[jugador].getPlayer().getFichas()[jugador].getCamino()[57].second(),partida.arrJugadores[jugador].getPlayer().getFichas()[1],0);
        partida.tablero.Setficha((int)partida.arrJugadores[jugador].getPlayer().getFichas()[jugador].getCamino()[57].first(),(int)partida.arrJugadores[jugador].getPlayer().getFichas()[jugador].getCamino()[57].second(),partida.arrJugadores[jugador].getPlayer().getFichas()[2],0);
        partida.tablero.Setficha((int)partida.arrJugadores[jugador].getPlayer().getFichas()[jugador].getCamino()[57].first(),(int)partida.arrJugadores[jugador].getPlayer().getFichas()[jugador].getCamino()[57].second(),partida.arrJugadores[jugador].getPlayer().getFichas()[3],0);

        assertTrue(partida.terminada);
    }
}