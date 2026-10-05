import org.example.ProcessadorPedido;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TesteBonus {
    @Test
    void deveMostrarDescontoCorreto() {
    ProcessadorPedido calc = new ProcessadorPedido();

    // Pedido de R$ 0 (obs: esperado que de erro)
    assertEquals(0.0, calc.CategoriaTeste("bronze", 0.0), 0.001);
    assertEquals(0.0, calc.CategoriaTeste("prata", 0.0), 0.001);
    assertEquals(0.0, calc.CategoriaTeste("ouro", 0.0), 0.001);

    assertEquals(100.0, calc.CategoriaTeste("cobre", 100.0), 0.001);
}
}
