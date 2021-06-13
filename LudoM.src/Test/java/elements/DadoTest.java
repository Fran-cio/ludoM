package elements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DadoTest {

    Dado dado = new Dado();

    @Test
    void U_tirarDado() {
        int a=dado.tirarDado();
        assertTrue(a>0&&a<7);
    }
}