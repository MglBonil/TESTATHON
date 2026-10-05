import org.example.ProcessadorPedido;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class CalculadoraDescontoTest {

    @Test
void deveMostrarDescontoCorreto() {
    ProcessadorPedido calc = new ProcessadorPedido();

    // Pedido de R$ 50
    assertEquals(50.0, calc.CategoriaTeste("bronze", 50.0));
    assertEquals(47.5, calc.CategoriaTeste("prata", 50.0));
    assertEquals(45.0, calc.CategoriaTeste("ouro", 50.0));

    // Pedido de R$ 100
    assertEquals(100.0, calc.CategoriaTeste("bronze", 100.0));
    assertEquals(95.0, calc.CategoriaTeste("prata", 100.0));
    assertEquals(90.0, calc.CategoriaTeste("ouro", 100.0));

    // Pedido de R$ 150
    assertEquals(150.0, calc.CategoriaTeste("bronze", 150.0));
    assertEquals(142.5, calc.CategoriaTeste("prata", 150.0));
    assertEquals(135.0, calc.CategoriaTeste("ouro", 150.0));
}


    
}