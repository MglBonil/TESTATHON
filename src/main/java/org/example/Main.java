package org.example;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ProcessadorPedido processador = new ProcessadorPedido();
        String continuar = "s";


        while (continuar.equalsIgnoreCase("s") || continuar.equalsIgnoreCase("sim")) {

            try {

                String categoria = lerTexto("Digite a categoria (bronze / prata / ouro): ");
                double valorTotal = lerValor("Insira o valor total do pedido: R$ ");


                double valorComDesconto = processador.CategoriaTeste(categoria, valorTotal);


                double valorFinal = processador.Calcfrete(valorComDesconto);
                double frete = valorFinal - valorComDesconto;


                int pontos = processador.PontosFidelidade(valorFinal, categoria);


                System.out.println("------------ PEDIDO ------------");
                System.out.printf("Categoria ........ %s%n", categoria);
                System.out.printf("Valor original ... R$ %.2f%n", valorTotal);
                System.out.printf("Desconto ......... R$ %.2f%n", valorTotal - valorComDesconto);
                System.out.printf("Valor com desconto R$ %.2f%n", valorComDesconto);
                System.out.printf("Frete ............ R$ %.2f%n", frete);
                System.out.printf("Valor final ...... R$ %.2f%n", valorFinal);
                System.out.printf("Pontos fidelidade . %d pontos%n", pontos);
                System.out.println("--------------------------------");

            } catch (IllegalArgumentException e) {
                System.out.println("[ERRO] " + e.getMessage());
            } catch (Exception e) {

                System.out.println("[ERRO] Falha inesperada: " + e.getMessage());
            }

            continuar = lerContinuar();
        }

        System.out.println("Programa encerrado. Obrigado!");
    }


    static String lerTexto(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                String entrada = scanner.next().trim();
                if (entrada.isEmpty()) {
                    throw new IllegalArgumentException("Entrada vazia");
                }
                return entrada;
            } catch (Exception e) {
                System.out.println("[ERRO] Entrada inválida, tente novamente.");
            }
        }
    }


    static double lerValor(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                String entrada = scanner.next().trim();

                String limpo = entrada.replace("R$", "").replace(" ", "");
                if (limpo.contains(",")) {

                    limpo = limpo.replace(".", "").replace(",", ".");
                }

                double valor = Double.parseDouble(limpo);

                if (valor <= 0) {
                    System.out.println("[ERRO] O valor deve ser maior que zero.");
                    continue;
                }
                return valor;

            } catch (NumberFormatException e) {
                System.out.println("[ERRO] Valor inválido! Digite um número, ex: 150,90");
            }
        }
    }


    static String lerContinuar() {
        while (true) {
            try {
                System.out.print("Processar outro pedido? (s/n): ");
                String resposta = scanner.next().trim().toLowerCase(Locale.ROOT);

                if (resposta.equals("s") || resposta.equals("sim") ||
                    resposta.equals("n") || resposta.equals("nao") || resposta.equals("não")) {
                    return resposta;
                }
                System.out.println("[ERRO] Resposta inválida, digite apenas s ou n.");

            } catch (Exception e) {
                System.out.println("[ERRO] Entrada inválida, tente novamente.");
            }
        }
    }
}
