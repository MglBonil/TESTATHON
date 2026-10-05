import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import org.example.*;

public class TestePedido {
    @Test
    void Calcfrete(){

        ProcessadorPedido calc = new ProcessadorPedido();

        double teste1 = calc.Calcfrete(200);
        assertEquals(215, teste1);

        double teste2 = calc.Calcfrete(150);
        assertEquals(165, teste2);

        double teste3 = calc.Calcfrete(200.1);
        assertEquals(200.1, teste3);

        double teste4 = calc.Calcfrete(199.99);
        assertEquals(214.99, teste4);

    }
}