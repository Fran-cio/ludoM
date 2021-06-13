package elements;

import org.junit.jupiter.api.Test;
import strategy.status.*;

import static org.junit.jupiter.api.Assertions.*;

class FichaTest {
    @Test
    void U_MoverMoving() {
        Ficha ficha= new Ficha();
        ficha.setStatus(new Moving());

        assertTrue(ficha.status.jugadaposible(0));
    }
    @Test
    void U_OutOfBouds() {
        Ficha ficha= new Ficha();
        ficha.setStatus(new OutOfBounds());

        assertFalse(ficha.status.jugadaposible(0));
    }
    @Test
    void U_Protected() {
        Ficha ficha= new Ficha();
        ficha.setStatus(new Protected());

        assertTrue(ficha.status.jugadaposible(0));
    }
    @Test
    void U_RectaFinal() {
        Ficha ficha= new Ficha();
        ficha.setStatus(new RectaFinal(2));

        assertTrue(ficha.status.jugadaposible(2)&&ficha.status.jugadaposible(1)&&!ficha.status.jugadaposible(3));
    }
    @Test
    void U_Wait() {
        Ficha ficha= new Ficha();
        ficha.setStatus(new Wait());

        assertTrue(ficha.status.jugadaposible(6)&&!ficha.status.jugadaposible(3));
    }
    @Test
    void U_Win() {
        Ficha ficha= new Ficha();
        ficha.setStatus(new Win());

        assertFalse(ficha.status.jugadaposible(0));
    }

}