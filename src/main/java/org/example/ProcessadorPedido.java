package org.example;

public class ProcessadorPedido {

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


