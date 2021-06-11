import org.junit.jupiter.api.Test;
import com.company.*;
import static org.junit.jupiter.api.Assertions.*;

class DadoTest {

    @Test
    void tirarDado() {
        Dado dado = new Dado();
        int a=dado.tirarDado();
        assertTrue(a>0&&a<7);
    }
}