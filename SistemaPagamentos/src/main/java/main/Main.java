
package main;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import interfaces.EmissorComprovante;
import interfaces.Validador;
import model.Pagamento;
import pagamentos.PagamentoBoleto;
import pagamentos.PagamentoCartao;
import pagamentos.PagamentoPix;
import services.GeradorComprovante;
import services.ValidadorPagamento;
import template.PagamentoTemplate;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Criando os serviços necessários
        Validador validador = new ValidadorPagamento();
        EmissorComprovante emissor = new GeradorComprovante();

        // Criando os processadores de pagamento
        PagamentoPix pix = new PagamentoPix(
            validador, emissor, 1000.00
        );

        PagamentoCartao cartao = new PagamentoCartao(
            validador, emissor, 2000.00
        );

        boolean executando = true;

        while (executando) {

            System.out.println("\n===== SISTEMA DE PAGAMENTOS =====");
            System.out.println("1 - PIX");
            System.out.println("2 - Cartão");
            System.out.println("3 - Boleto");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            if (opcao.equals("4")) {
                executando = false;
                System.out.println("Sistema encerrado!");
                continue;
            }

            try {

                System.out.print("Digite o nome do pagador: ");
                String identificacao = scanner.nextLine();

                System.out.print("Digite o valor do pagamento: R$ ");
                double valor = Double.parseDouble(
                    scanner.nextLine().replace(",", ".")
                );

                Pagamento pagamento = new Pagamento(
                    valor, identificacao
                );

                PagamentoTemplate processador;

                switch (opcao) {

                    case "1":
                        processador = pix;
                        break;

                    case "2":
                        processador = cartao;
                        break;

                    case "3":
                        System.out.print(
                            "Digite a data de vencimento (AAAA-MM-DD): "
                        );

                        LocalDate vencimento = LocalDate.parse(
                            scanner.nextLine()
                        );

                        processador = new PagamentoBoleto(
                            validador, emissor, vencimento
                        );
                        break;

                    default:
                        System.out.println("Opção inválida!");
                        continue;
                }

                // Executa o Template Method
                processador.processarPagamento(pagamento);

            } catch (NumberFormatException e) {
                System.out.println("Erro: informe um valor numérico válido.");

            } catch (DateTimeParseException e) {
                System.out.println("Erro: informe uma data válida no formato AAAA-MM-DD.");

            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Erro no processamento: " + e.getMessage());
            }
        }

        scanner.close();
    }
}






/*

Entendendo o que essa classe faz
1. Cria os serviços: instancia o validador e o gerador de comprovantes.
2. Cria os processadores: prepara os objetos de PIX e cartão com saldos e limites iniciais.
3. Exibe o menu: permite escolher entre PIX, cartão e boleto.
4. Recebe os dados: solicita nome e valor do pagamento.
5. Escolhe a implementação: utiliza o processador correspondente à opção selecionada.
6. Executa o Template Method: chama processarPagamento().

*/

