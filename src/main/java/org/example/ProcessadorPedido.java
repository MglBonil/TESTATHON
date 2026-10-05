package org.example;

public class ProcessadorPedido {

    public double Calcfrete(double valorTotal){

        if (valorTotal > 200) {
             return valorTotal;
        }

        else {
            return valorTotal = valorTotal + 15;
        }

    }
}
