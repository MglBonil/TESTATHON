package org.example;



public class ProcessadorPedido {
    public String validaCat(String categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("Categoria Inválida");
        }

        String minusculo = categoria.toLowerCase();

        if (!minusculo.equals("bronze") && !minusculo.equals("prata") && !minusculo.equals("ouro")) {
            throw new IllegalArgumentException("Categoria Inválida");
        }

        return minusculo;
    }

    public Double CategoriaTeste(String categoria, Double valorCompra) {
        
    String minusculo = validaCat(categoria);

        if (valorCompra == null || valorCompra <= 0) {
            throw new IllegalArgumentException("Valor de Compra Inválido");
        }

        double valorTotal;

        if (minusculo.equals("bronze")) {
            valorTotal = valorCompra;
        } else if (minusculo.equals("prata")) {
            valorTotal = valorCompra - (valorCompra * 0.05);
        } else {
            valorTotal = valorCompra - (valorCompra * 0.10);
        }

        return valorTotal;
    }
}

