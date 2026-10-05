# TESTATHON

Sistema de processamento de pedidos desenvolvido durante o Hackathon realizado em 05/10/2026
na ETEC Philadelpho Gouvêa Netto.

Aplicação de linha de comando que calcula desconto por categoria, frete e pontos de fidelidade
de um pedido, validando todas as entradas do usuário.

## Regras de negócio

### Desconto por categoria

| Categoria | Desconto |
|-----------|----------|
| Bronze    | 0%       |
| Prata     | 5%       |
| Ouro      | 10%      |

### Frete

- Pedidos a partir de **R$ 200,00** (valor já com desconto): **frete grátis**.
- Pedidos abaixo de R$ 200,00: frete fixo de **R$ 15,00**.

### Pontos de fidelidade

- 1 ponto por real gasto (valor truncado).
- +100 pontos quando o valor final for **acima de R$ 300,00**.
- +150 pontos extras (250 no total) para a categoria **ouro** acima de R$ 500,00.

Entradas inválidas (categoria inexistente, valor zerado/negativo/nulo) lançam
`IllegalArgumentException` e são reportadas ao usuário sem processar o pedido.

## Requisitos

- JDK 21 ou superior
- Maven 3.9+

## Como executar

```bash
# Rodar os testes
mvn clean test

# Gerar o .jar
mvn clean package

# Iniciar a aplicação
java -jar target/testathon-1.0-SNAPSHOT.jar
```

> Se os acentos aparecerem corrompidos no terminal Windows, execute com
> `java -Dstdout.encoding=UTF-8 -jar target/testathon-1.0-SNAPSHOT.jar`.

## Estrutura

```
src/main/java/org/example/Main.java             -> interface de linha de comando
src/main/java/org/example/ProcessadorPedido.java -> regras de desconto, frete e pontos
src/test/java/org/example/                       -> testes JUnit 5
```
