import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.ProcessadorPedido;
import org.junit.jupiter.api.Test;


public class PontosFidelidadeTest {

    @Test
    void deveCalculaPontosFidelidade() {
        ProcessadorPedido processo = new ProcessadorPedido();

        int qtdPontos;

        // Teste 90.99 gastos
        qtdPontos = processo.PontosFidelidade(Double.valueOf(90.99), "bronze");
        assertEquals(90, qtdPontos);

        qtdPontos = processo.PontosFidelidade(Double.valueOf(90.99), "ouro");
        assertEquals(90, qtdPontos);

        // Teste 300 gastos
        qtdPontos = processo.PontosFidelidade(Double.valueOf(300), "bronze");
        assertEquals(300, qtdPontos);

        qtdPontos = processo.PontosFidelidade(Double.valueOf(300), "ouro");
        assertEquals(300, qtdPontos);

        // Teste 300.1 gastos
        qtdPontos = processo.PontosFidelidade(Double.valueOf(300.1), "bronze");
        assertEquals(400, qtdPontos);

        qtdPontos = processo.PontosFidelidade(Double.valueOf(300.1), "ouro");
        assertEquals(400, qtdPontos);

        // Teste 400 gastos
        qtdPontos = processo.PontosFidelidade(Double.valueOf(400), "bronze");
        assertEquals(500, qtdPontos);

        qtdPontos = processo.PontosFidelidade(Double.valueOf(400), "ouro");
        assertEquals(500, qtdPontos);

        // Teste 500 gastos
        qtdPontos = processo.PontosFidelidade(Double.valueOf(500), "bronze");
        assertEquals(600, qtdPontos);

        qtdPontos = processo.PontosFidelidade(Double.valueOf(500), "ouro");
        assertEquals(600, qtdPontos);

        // Teste 500.1 gastos
        qtdPontos = processo.PontosFidelidade(Double.valueOf(500.1), "bronze");
        assertEquals(600, qtdPontos);

        qtdPontos = processo.PontosFidelidade(Double.valueOf(500.1), "ouro");
        assertEquals(750, qtdPontos);

    }
}
