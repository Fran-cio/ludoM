package elements;

import org.junit.jupiter.api.Test;
import strategy.status.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TableroTest {

    @Test
    void U_ArrancarTablero() {
        Tablero tab= new Tablero();
        Casilla[][] casillasTest =tab.getTablero();

        Status a= new Moving();
        Status b= new OutOfBounds();
        Status c= new RectaFinal(2);
        Status d= new Win();
        Status e= new Wait();

        assertTrue(casillasTest[10][6].getStatus().getState().equals(a.getState()) &&
                casillasTest[6][6].getStatus().getState().equals(b.getState()) &&
                casillasTest[7][4].getStatus().getState().equals(c.getState()) &&
                casillasTest[7][6].getStatus().getState().equals(d.getState()) &&
                casillasTest[5][4].getStatus().getState().equals(e.getState()));
    }

    @Test
    void U_CheckResto(){
        Tablero tab= new Tablero();
        Casilla[][] casillasTest =tab.getTablero();

        Status c= new RectaFinal(2);
        assertEquals(2,casillasTest[4][7].getStatus().getResto());
    }

}