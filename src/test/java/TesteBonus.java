import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.ProcessadorPedido;
import org.junit.jupiter.api.Test;

// Teste banus: toda entrada inválida DEVE dar erro (lançar exceção),
public class TesteBonus {

    ProcessadorPedido calc = new ProcessadorPedido();

    @Test
    void deveDarErroParaCategoriaInvalida() {
        // Categoria que n é bronze / prata / ouro
        assertThrows(IllegalArgumentException.class,
                () -> calc.CategoriaTeste("platina", 100.0));

        assertThrows(IllegalArgumentException.class,
                () -> calc.CategoriaTeste("Ouro Prata", 100.0));

        // Categoria com valor nul
        assertThrows(IllegalArgumentException.class,
                () -> calc.CategoriaTeste(null, 100.0));

        // Chamada direta da validacao
        assertThrows(IllegalArgumentException.class,
                () -> calc.validaCat("diamante"));
    }

    @Test
    void deveDarErroParaValorInvalido() {

        // Valor zerado
        assertThrows(IllegalArgumentException.class,
                () -> calc.CategoriaTeste("bronze", 0.0));

        // Valor negativo
        assertThrows(IllegalArgumentException.class,
                () -> calc.CategoriaTeste("ouro", -50.0));

        // Valor nulo
        assertThrows(IllegalArgumentException.class,
                () -> calc.CategoriaTeste("prata", null));
    }

    @Test
    void naoDeveProcessarPedidoInvalidoComoSucesso() {
        // Um pedido invalido não pode devolver nenhum valor:
        // a exceção é lançada ANTES de aplicar desconto / frete / pontos
        Exception erro = assertThrows(IllegalArgumentException.class,
                () -> calc.CategoriaTeste("platina", 250.0));
        assertEquals("Categoria Inválida", erro.getMessage());

        Exception erro2 = assertThrows(IllegalArgumentException.class,
                () -> calc.CategoriaTeste("ouro", -10.0));
        assertEquals("Valor de Compra Inválido", erro2.getMessage());
    }
}
