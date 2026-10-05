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



    //Método para o calculo do frete
    public double Calcfrete(double valorTotal){

        // Se o valor da compra com o desconto for maior que 200, não terá frete
        if (valorTotal > 200) {
             return valorTotal;
        }
        // Se o valor da compra com o desconto for menor ou igual á 200, o frete valerá 15 reais
        else {
            return valorTotal = valorTotal + 15;
        }


    }
    //Método para calculo de pontos fidelidade
    public int PontosFidelidade(Double valorTotal, String categoria){

        //Sanitizção de dados
        categoria = categoria.toLowerCase();
        //Variavel que armazena qtd de pontos do cliente
        int quantidadeDePontos = 0;

        //Se a categira do cliente é ouro
        if (categoria == "ouro") {

            if (valorTotal > 500) {

                quantidadeDePontos +=250;

            } else if (valorTotal > 300) {

                quantidadeDePontos += 100;

            }
        //Se a categoria é diferente de Ouro
        } else if (valorTotal > 300){

            quantidadeDePontos += 100;

        }

        //Soma os pontos com base no valor da compra
        quantidadeDePontos += (int)Math.floor(valorTotal);



        return quantidadeDePontos;
    }

}
