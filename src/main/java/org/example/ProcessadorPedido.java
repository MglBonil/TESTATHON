package org.example;

import java.util.Locale;
import java.util.Set;

public class ProcessadorPedido {

    private static final Set<String> CATEGORIAS_VALIDAS = Set.of("bronze", "prata", "ouro");
    private static final double FRETE_PADRAO = 15.0;
    private static final double LIMITE_FRETE_GRATIS = 200.0;

    /**
     * Normaliza e valida a categoria do cliente.
     *
     * @param categoria informada pelo usuário (ex.: " Ouro ")
     * @return a categoria em minúsculas e sem espaços
     * @throws IllegalArgumentException se a categoria for nula ou não for bronze, prata ou ouro
     */
    public String validaCat(String categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("Categoria Inválida");
        }

        String normalizada = categoria.toLowerCase(Locale.ROOT).trim();

        if (!CATEGORIAS_VALIDAS.contains(normalizada)) {
            throw new IllegalArgumentException("Categoria Inválida");
        }

        return normalizada;
    }

    /**
     * Aplica o desconto da categoria sobre o valor da compra.
     *
     * @param categoria     bronze (sem desconto), prata (5%) ou ouro (10%)
     * @param valorCompra   valor total do pedido antes do desconto
     * @return o valor já com o desconto aplicado
     * @throws IllegalArgumentException se a categoria ou o valor forem inválidos
     */
    public Double CategoriaTeste(String categoria, Double valorCompra) {
        String categoriaNormalizada = validaCat(categoria);

        if (valorCompra == null || valorCompra <= 0) {
            throw new IllegalArgumentException("Valor de Compra Inválido");
        }

        return switch (categoriaNormalizada) {
            case "prata" -> valorCompra - (valorCompra * 0.05);
            case "ouro" -> valorCompra - (valorCompra * 0.10);
            default -> valorCompra;
        };
    }

    /**
     * Calcula o valor do pedido já com o frete.
     * Pedidos a partir de R$ 200,00 têm frete grátis; abaixo disso o frete é de R$ 15,00.
     *
     * @param valorTotal valor do pedido já com o desconto
     * @return o valor final com frete incluído
     * @throws IllegalArgumentException se o valor for menor ou igual a zero
     */
    public double Calcfrete(double valorTotal) {
        if (valorTotal <= 0) {
            throw new IllegalArgumentException("Valor do Pedido Inválido");
        }

        if (valorTotal >= LIMITE_FRETE_GRATIS) {
            return valorTotal;
        }

        return valorTotal + FRETE_PADRAO;
    }

    /**
     * Calcula os pontos de fidelidade do cliente.
     * Regras: 1 ponto por real gasto, mais 100 pontos se o valor passar de R$ 300,00
     * e mais 150 pontos extras (250 no total) para categoria ouro acima de R$ 500,00.
     *
     * @param valorTotal valor final do pedido (com frete)
     * @param categoria  bronze, prata ou ouro
     * @return a quantidade de pontos acumulados
     * @throws IllegalArgumentException se a categoria ou o valor forem inválidos
     */
    public int PontosFidelidade(Double valorTotal, String categoria) {
        String categoriaNormalizada = validaCat(categoria);

        if (valorTotal == null || valorTotal <= 0) {
            throw new IllegalArgumentException("Valor do Pedido Inválido");
        }

        int pontos = (int) Math.floor(valorTotal);

        if (categoriaNormalizada.equals("ouro") && valorTotal > 500) {
            pontos += 250;
        } else if (valorTotal > 300) {
            pontos += 100;
        }

        return pontos;
    }
}
