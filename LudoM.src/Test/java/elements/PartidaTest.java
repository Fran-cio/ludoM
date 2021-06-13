package elements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartidaTest {
    @Test
    void I_MoverPieza() {
        int jugador=3; //Si cambiamos el player cambia la casilla de salida, notarlo en la terminal
        Partida partida= new Partida(4);
        partida.arrJugadores[jugador].player.getFichas()[0].status.mover(partida.tablero, partida.arrJugadores[jugador].player.getFichas()[0],6);
        assertTrue(partida.tablero.tablero[(int)partida.arrJugadores[jugador].player.getFichas()[0].getCamino()[1].first()]
                                          [(int)partida.arrJugadores[jugador].player.getFichas()[0].getCamino()[1].second()]
                                           .acumfichas.contains(partida.arrJugadores[jugador].player.getFichas()[0]));
    }
}